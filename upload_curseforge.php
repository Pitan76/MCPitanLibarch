<?php

define('VERSION', '1.1.2');
define('CHANGE_LOG', '');

define('DIRS', array(
//	'common' => './common/build/libs/',
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
//	'common' => '',
	'fabric' => '-fabric',
	'forge' => '-forge',
));

$postData = array();

$ch = curl_init('https://minecraft.curseforge.com/api/game/version-types');

curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'GET');
curl_setopt($ch, CURLOPT_POSTFIELDS, $postData);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/json', 'X-Api-Token: 788ae0f4-ae9a-405f-be51-7988574a533a'));
curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
$result = curl_exec($ch);

$game_version_types_data = json_decode($result, true);

curl_close($ch);

//file_put_contents('curse_forge_game_version_types.json', json_encode($game_version_json, JSON_UNESCAPED_UNICODE | JSON_PRETTY_PRINT));


$postData = array();

$ch = curl_init('https://minecraft.curseforge.com/api/game/versions');

curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'GET');
curl_setopt($ch, CURLOPT_POSTFIELDS, $postData);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/json', 'X-Api-Token: 788ae0f4-ae9a-405f-be51-7988574a533a'));
curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
$result = curl_exec($ch);

$game_versions_data = json_decode($result, true);

curl_close($ch);

//file_put_contents('curse_forge_game_versions.json', json_encode($game_version_json, JSON_UNESCAPED_UNICODE | JSON_PRETTY_PRINT));

$CHANGE_LOG = CHANGE_LOG;

foreach (DIRS as $type => $dir) {
	
	foreach (GAME_VERSIONS as $file_ver => $ver) {
		$typeId = 0;
		foreach ($game_version_types_data as $data) {
			if ($data['name'] == 'Minecraft ' . $ver) {
				$typeId = $data['id'];
			}
		}
		
		$version_id_list = array();
		foreach ($game_versions_data as $data) {
			if ($data['gameVersionTypeID'] == $typeId) {
				if (!str_ends_with($data['slug'], 'snapshot')) {
					$version_id_list[] = $data['id'];
				}
			}
		}
		
		$postData = array();
		
		$releaseType = ($type === "fabric" ? 'release' : 'beta');
		$fabric_api = '';
		if ($type == 'fabric') {
$fabric_api = <<<EOD
        	{
        	    slug: "fabric-api",
        	    type: "requiredDependency"
        	},
EOD;
			$version_id_list[] = '7499';
		}
		if ($type == 'forge') {
			$version_id_list[] = '7498';
		}
		
		if ($ver === '1.16') {
			$releaseType = 'alpha';
		}
		
		$version_ids_str = implode(', ', $version_id_list);
		
		$postData['metadata'] = <<<EOD
{
    changelog: "{$CHANGE_LOG}",
    gameVersions: [{$version_ids_str}],
    releaseType: "{$releaseType}", // One of "alpha", "beta", "release".
    relations: {
        projects: [
{$fabric_api}
        	{
        	    slug: "architectury-api",
        	    type: "requiredDependency"
        	}
        ]
    }
}
EOD;
		
		$file = $dir . 'mcpitanlibarch-' . VERSION . '-' . $file_ver . PLATFORM_FILE_MARK[$type] . '.jar';
		
		$postData['file'] = curl_file_create(
				realpath($file),
				mime_content_type($file),
				basename($file)
		);
		
		$ch = curl_init('https://minecraft.curseforge.com/api/projects/682213/upload-file');
		curl_setopt($ch, CURLOPT_POST, true);
		curl_setopt($ch, CURLOPT_POSTFIELDS, $postData);
		curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
		curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
		curl_setopt($ch, CURLOPT_HTTPHEADER, array('X-Api-Token: 788ae0f4-ae9a-405f-be51-7988574a533a'));
		$result = curl_exec($ch);
		
		if ($result === false) {
			error_log(curl_error($ch));
		}
		curl_close($ch);
		echo "uploaded file.\n" . $result . "\n";
	}
}


