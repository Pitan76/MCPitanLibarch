<?php
define('VERSION', '1.0.10');

define('DIRS', array(
	'common' => './common/build/libs/',
	'fabric' => './fabric/build/libs/',
	'forge' => './forge/build/libs/',
));

define('GAME_VERSIONS', array(
	'1.16.5' => '1.16', 
	'1.17' => '1.17', 
	'1.18' => '1.18', 
	'1.19' => '1.19',
));

define('PLATFORM_FILE_MARK', array(
	'common' => '',
	'fabric' => '-fabric',
	'forge' => '-forge',
));

foreach (DIRS as $type => $dir) {
	
	foreach (GAME_VERSIONS as $file_ver => $ver) {
		
		$postData = array();
		
		$postData['group_id'] = 'ml.pkom';
		$postData['artifact_id'] = 'mcpitanlibarch-' . $type . '+' . $ver;
		$postData['version'] = VERSION;
		
		$files = array(
			$dir . 'mcpitanlibarch-' . VERSION . '-' . $file_ver . PLATFORM_FILE_MARK[$type] . '.jar',
			$dir . 'mcpitanlibarch-' . VERSION . '-' . $file_ver . PLATFORM_FILE_MARK[$type] . '-sources.jar',
		);
		
		foreach ($files as $index => $file) {
			$postData['upload[' . $index . ']'] = curl_file_create(
				realpath($file),
				mime_content_type($file),
				basename($file)
			);
			echo "Uploading '" . $file . "'\n";
		}
		
		$request = curl_init('http://localhost/maven/maven.php');
		curl_setopt($request, CURLOPT_POST, true);
		curl_setopt($request, CURLOPT_POSTFIELDS, $postData);
		curl_setopt($request, CURLOPT_RETURNTRANSFER, true);
		$result = curl_exec($request);
		
		if ($result === false) {
			error_log(curl_error($request));
		}
		curl_close($request);
	}
}


