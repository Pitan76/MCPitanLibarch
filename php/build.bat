cd "..\"

git fetch origin
git checkout 1.20
call gradlew.bat build
call gradlew.bat generatePomFileForMavenCommonPublication
call gradlew.bat generatePomFileForMavenForgePublication
call gradlew.bat generatePomFileForMavenFabricPublication
copy /y ".\common\build\publications\mavenCommon\pom-default.xml" ".\common\build\publications\mavenCommon\mcpitanlibarch-1.20-rc1.pom"
copy /y ".\fabric\build\publications\mavenFabric\pom-default.xml" ".\fabric\build\publications\mavenFabric\mcpitanlibarch-1.20-rc1.pom"

git fetch origin
git checkout 1.19.4
call gradlew.bat build
call gradlew.bat generatePomFileForMavenCommonPublication
call gradlew.bat generatePomFileForMavenForgePublication
call gradlew.bat generatePomFileForMavenFabricPublication
copy /y ".\common\build\publications\mavenCommon\pom-default.xml" ".\common\build\publications\mavenCommon\mcpitanlibarch-1.19.4.pom"
copy /y ".\fabric\build\publications\mavenFabric\pom-default.xml" ".\fabric\build\publications\mavenFabric\mcpitanlibarch-1.19.4.pom"
copy /y ".\forge\build\publications\mavenForge\pom-default.xml" ".\forge\build\publications\mavenForge\mcpitanlibarch-1.20.pom"

git fetch origin
git checkout 1.19.3
call gradlew.bat build
call gradlew.bat generatePomFileForMavenCommonPublication
call gradlew.bat generatePomFileForMavenForgePublication
call gradlew.bat generatePomFileForMavenFabricPublication
copy /y ".\common\build\publications\mavenCommon\pom-default.xml" ".\common\build\publications\mavenCommon\mcpitanlibarch-1.19.3.pom"
copy /y ".\fabric\build\publications\mavenFabric\pom-default.xml" ".\fabric\build\publications\mavenFabric\mcpitanlibarch-1.19.3.pom"
copy /y ".\forge\build\publications\mavenForge\pom-default.xml" ".\forge\build\publications\mavenForge\mcpitanlibarch-1.19.3.pom"

git fetch origin
git checkout 1.19.2
call gradlew.bat build
call gradlew.bat generatePomFileForMavenCommonPublication
call gradlew.bat generatePomFileForMavenForgePublication
call gradlew.bat generatePomFileForMavenFabricPublication
copy /y ".\common\build\publications\mavenCommon\pom-default.xml" ".\common\build\publications\mavenCommon\mcpitanlibarch-1.19.2.pom"
copy /y ".\fabric\build\publications\mavenFabric\pom-default.xml" ".\fabric\build\publications\mavenFabric\mcpitanlibarch-1.19.2.pom"
copy /y ".\forge\build\publications\mavenForge\pom-default.xml" ".\forge\build\publications\mavenForge\mcpitanlibarch-1.19.2.pom"

git fetch origin
git checkout 1.18.2
call gradlew.bat build
call gradlew.bat generatePomFileForMavenCommonPublication
call gradlew.bat generatePomFileForMavenForgePublication
call gradlew.bat generatePomFileForMavenFabricPublication
copy /y ".\common\build\publications\mavenCommon\pom-default.xml" ".\common\build\publications\mavenCommon\mcpitanlibarch-1.18.2.pom"
copy /y ".\fabric\build\publications\mavenFabric\pom-default.xml" ".\fabric\build\publications\mavenFabric\mcpitanlibarch-1.18.2.pom"
copy /y ".\forge\build\publications\mavenForge\pom-default.xml" ".\forge\build\publications\mavenForge\mcpitanlibarch-1.18.2.pom"

git fetch origin
git checkout 1.17.1
call gradlew.bat build
call gradlew.bat generatePomFileForMavenCommonPublication
call gradlew.bat generatePomFileForMavenForgePublication
call gradlew.bat generatePomFileForMavenFabricPublication
copy /y ".\common\build\publications\mavenCommon\pom-default.xml" ".\common\build\publications\mavenCommon\mcpitanlibarch-1.17.1.pom"
copy /y ".\fabric\build\publications\mavenFabric\pom-default.xml" ".\fabric\build\publications\mavenFabric\mcpitanlibarch-1.17.1.pom"
copy /y ".\forge\build\publications\mavenForge\pom-default.xml" ".\forge\build\publications\mavenForge\mcpitanlibarch-1.17.1.pom"

git fetch origin
git checkout 1.16.5
call gradlew.bat build
call gradlew.bat generatePomFileForMavenCommonPublication
call gradlew.bat generatePomFileForMavenForgePublication
call gradlew.bat generatePomFileForMavenFabricPublication
copy /y ".\common\build\publications\mavenCommon\pom-default.xml" ".\common\build\publications\mavenCommon\mcpitanlibarch-1.16.5.pom"
copy /y ".\fabric\build\publications\mavenFabric\pom-default.xml" ".\fabric\build\publications\mavenFabric\mcpitanlibarch-1.16.5.pom"
copy /y ".\forge\build\publications\mavenForge\pom-default.xml" ".\forge\build\publications\mavenForge\mcpitanlibarch-1.16.5.pom"

git fetch origin
git checkout 1.19.4

cd ".\php"

copy /y "C:\Users\ptms76\Documents\php\*.bat" ".\"
copy /y "C:\Users\ptms76\Documents\php\*.php" ".\"

start upload_maven.bat
pause