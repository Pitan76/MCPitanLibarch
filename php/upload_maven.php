<?php
define('VERSION', '1.6.8');

define('DIRS', array(
	'common' => 'common/build/',
	'fabric' => 'fabric/build/',
	'forge' => 'forge/build/',
));

define('GAME_VERSIONS', array(
	'1.16.5' => '1.16.5', 
	'1.17.1' => '1.17.1', 
	'1.18.2' => '1.18.2', 
	'1.19.2' => '1.19.2',
	'1.19.3' => '1.19.3',
	'1.19.4' => '1.19.4',
	'1.20.1' => '1.20.1',
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
			$dir . 'libs/mcpitanlibarch-' . VERSION . '-' . $file_ver . PLATFORM_FILE_MARK[$type] . '.jar',
			$dir . 'libs/mcpitanlibarch-' . VERSION . '-' . $file_ver . PLATFORM_FILE_MARK[$type] . '-sources.jar',
			$dir . 'publications/maven' .  ucfirst($type) . '/mcpitanlibarch-' . $file_ver . '.pom',
		);
		
		$pom = '../' . $dir . 'publications/maven' .  ucfirst($type) . '/mcpitanlibarch-' . $file_ver . '.pom';
		
		$pom_str = file_get_contents($pom);
		$pom_str = preg_replace('/' . preg_quote(VERSION . '-' . $file_ver . PLATFORM_FILE_MARK[$type] . '</version>', '/'). '/', VERSION . '</version>', $pom_str, 1);
		$pom_str = preg_replace('/' . preg_quote('mcpitanlibarch' . PLATFORM_FILE_MARK[$type]  . '</artifactId>', '/') . '/', 'mcpitanlibarch' .  ($type == "common" ? '-common' : PLATFORM_FILE_MARK[$type]) . '+' . $file_ver . '</artifactId>', $pom_str, 1);
		
		file_put_contents($pom, $pom_str);
		
		foreach ($files as $index => $file) {
			$postData['upload[' . $index . ']'] = curl_file_create(
				realpath("../" . $file),
				mime_content_type("../" . $file),
				basename("../" . $file)
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


