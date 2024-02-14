# MCPitanLib
## 日本語
MCPitanLibはライブラリです。 1つのjarで複数のMCバージョンを対応させるためのものです。 <br />
開発中であるため、予告なく仕様が変更されることがあったり、不具合があるかもしれません。 <br />
私専用につくっているため、他の方が使うことをあまり想定していません。 <br />

### 前提MOD
- MODローダー
  - [FabricMC](https://fabricmc.net/)
  - [Minecraft Forge](https://files.minecraftforge.net/)
  - [NeoForge](https://neoforged.net/)
- [Architectury API (CurseForge)](https://www.curseforge.com/minecraft/mc-mods/architectury-api)

### ダウンロード
[CurseForge](https://www.curseforge.com/minecraft/mc-mods/mcpitanlibarch)
[Modrinth](https://modrinth.com/mod/mcpitanlibarch)

### 使い方
`build.gradle`に以下のように記述してください。
```groovy
repositories {
    maven {
        url = "https://maven.pitan76.net/"
    }
}

dependencies {
    // FabricMC
    modImplementation "net.pitan76:mcpitanlib-fabric:${rootProject.mcpitanlib_version}"
    
    // Minecraft Forge
    //modImplementation "net.pitan76:mcpitanlib-forge:${rootProject.mcpitanlib_version}"
    
    // NeoForge
    //modImplementation "net.pitan76:mcpitanlib-neoforge:${rootProject.mcpitanlib_version}"
}
```

`gradle.properties`に以下のように記述してください。
```properties
mcpitanlib_version=x.x.x
```

バージョンは[maven.pitan76.net](https://maven.pitan76.net/net/pitan76/)で確認してください。

## English
MCPitanLib is a library. It is for supporting multiple MC versions with one jar. <br />
It is under development, so the specification may change without notice, and there may be bugs. <br />
I am creating it for my own use, so I don't expect others to use it much. <br />

### Required MOD
- MOD Loader
  - [FabricMC](https://fabricmc.net/)
  - [Minecraft Forge](https://files.minecraftforge.net/)
  - [NeoForge](https://neoforged.net/)
- [Architectury API (CurseForge)](https://www.curseforge.com/minecraft/mc-mods/architectury-api)

### Download
[CurseForge](https://www.curseforge.com/minecraft/mc-mods/mcpitanlibarch)
[Modrinth](https://modrinth.com/mod/mcpitanlibarch)

### How to use
Write as follows in `build.gradle`.
```groovy
repositories {
    maven {
        url = "https://maven.pitan76.net/"
    }
}

dependencies {
    // FabricMC
    modImplementation "net.pitan76:mcpitanlib-fabric${rootProject.mcpitanlib_version}"
    
    // Minecraft Forge
    //modImplementation "net.pitan76:mcpitanlib-forge${rootProject.mcpitanlib_version}"
    
    // NeoForge
    //modImplementation "net.pitan76:mcpitanlib-neoforge${rootProject.mcpitanlib_version}"
}
```

Write as follows in `gradle.properties`.
```properties
# Example: mcpitanlib_version=+1.18.2:1.9.5
mcpitanlib_version=+x.x.x:x.x.x
```

Please check the version at [maven.pitan76.net](https://maven.pitan76.net/net/pitan76/).
