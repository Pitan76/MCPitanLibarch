cd "../"

git fetch origin
git checkout 1.19.4
gradlew build
gradlew generatePomFileForMavenCommonPublication
gradlew generatePomFileForMavenForgePublication
gradlew generatePomFileForMavenFabricPublication

git fetch origin
git checkout 1.19.3
gradlew build
gradlew generatePomFileForMavenCommonPublication
gradlew generatePomFileForMavenForgePublication
gradlew generatePomFileForMavenFabricPublication

git fetch origin
git checkout 1.19.2
gradlew build
gradlew generatePomFileForMavenCommonPublication
gradlew generatePomFileForMavenForgePublication
gradlew generatePomFileForMavenFabricPublication

git fetch origin
git checkout 1.18.2
gradlew build
gradlew generatePomFileForMavenCommonPublication
gradlew generatePomFileForMavenForgePublication
gradlew generatePomFileForMavenFabricPublication

git fetch origin
git checkout 1.17.1
gradlew build
gradlew generatePomFileForMavenCommonPublication
gradlew generatePomFileForMavenForgePublication
gradlew generatePomFileForMavenFabricPublication

git fetch origin
git checkout 1.16.5
gradlew build
gradlew generatePomFileForMavenCommonPublication
gradlew generatePomFileForMavenForgePublication
gradlew generatePomFileForMavenFabricPublication

git fetch origin
git checkout 1.16.5

cd "./php"

start "./upload_maven.bat"
start "./upload_curseforge.bat"
start "./upload_modrinth.bat"
pause