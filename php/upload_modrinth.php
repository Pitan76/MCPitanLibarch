<?php
define('VERSION', '1.6.8');
define('CHANGE_LOG', '');

define('DIRS', array(
//	'common' => './common/build/libs/',
	'fabric' => './fabric/build/libs/',
	'forge' => './forge/build/libs/',
));

define('GAME_VERSIONS', array(
	'1.16.5' => '"1.16.4", "1.16.5"', 
	'1.17.1' => '"1.17", "1.17.1"', 
	'1.18.2' => '"1.18", "1.18.1", "1.18.2"', 
	'1.19.2' => '"1.19", "1.19.1", "1.19.2"',
	'1.19.3' => '"1.19.3"',
	'1.19.4' => '"1.19.4"',
	'1.20.1' => '"1.20", "1.20.1"',
));

define('PLATFORM_FILE_MARK', array(
//	'common' => '',
	'fabric' => '-fabric',
	'forge' => '-forge',
));

$postData = array();

$CHANGE_LOG = CHANGE_LOG;
$VERSION = VERSION;

foreach (DIRS as $type => $dir) {
	
	foreach (GAME_VERSIONS as $file_ver => $ver) {
		$postData = array();
		
		$releaseType = "release";
		$fabric_api = '';
		if ($type == 'fabric') {
$fabric_api = <<<EOD
        	{
        	    "project_id": "P7dR8mSH",
        	    "dependency_type": "required"
        	},
EOD;
		}
		
		if ($file_ver === '1.16.5') {
			$releaseType = 'alpha';
		}
		
		$file = $dir . 'mcpitanlibarch-' . VERSION . '-' . $file_ver . PLATFORM_FILE_MARK[$type] . '.jar';
		
		//$basename = basename("../" . $file);

		$postData['data'] = <<<EOD
{
    "name": "[{$type}-{$file_ver}]MCPitanLibarch-{$VERSION}",
    "version_number": "{$VERSION}+{$file_ver}-{$type}",
    "changelog": "{$CHANGE_LOG}",
    "game_versions": [{$ver}],
    "loaders": ["{$type}"],
    "featured": false,
    "version_type": "{$releaseType}",
    "project_id": "uNRoUnGT",
    "dependencies": [
{$fabric_api}
        {
            "project_id": "lhGA9TYQ",
            "dependency_type": "required"
        }
    ],
    "file_parts": ["file"],
    "primary_file": "file"
}
EOD;

		$postData['file'] = curl_file_create(
				realpath("../" . $file),
				mime_content_type("../" . $file),
				basename("../" . $file)
		);
		
		$ch = curl_init('https://api.modrinth.com/v2/version');
		curl_setopt($ch, CURLOPT_POST, true);
		curl_setopt($ch, CURLOPT_POSTFIELDS, $postData);
		curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
		curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
		curl_setopt($ch, CURLOPT_HTTPHEADER, array('Authorization: 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'));
		
		$result = curl_exec($ch);
		
		if ($result === false) {
			error_log(curl_error($ch));
		}
		curl_close($ch);
		/*
		echo "create version.\n" . $result . "\n";
		
		$postData = array();
		
		$postData['id'] = "uNRoUnGT";
		$postData['data'] = curl_file_create(
				realpath("../" . $file),
				mime_content_type("../" . $file),
				basename("../" . $file)
		);
		
		$ch = curl_init('https://api.modrinth.com/v2/version');
		curl_setopt($ch, CURLOPT_POST, true);
		curl_setopt($ch, CURLOPT_POSTFIELDS, $postData);
		curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
		curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
		curl_setopt($ch, CURLOPT_HTTPHEADER, array('Authorization: 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'));
		
		$result = curl_exec($ch);
		
		if ($result === false) {
			error_log(curl_error($ch));
		}
		curl_close($ch);
		*/
		echo "uploaded file.\n" . $result . "\n";
	}
}


