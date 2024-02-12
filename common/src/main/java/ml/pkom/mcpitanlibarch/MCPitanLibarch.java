package ml.pkom.mcpitanlibarch;

import ml.pkom.easyapi.config.Config;
import ml.pkom.easyapi.config.JsonConfig;
import ml.pkom.mcpitanlibarch.api.registry.ArchRegistry;
import ml.pkom.mcpitanlibarch.api.util.PlatformUtil;
import ml.pkom.mcpitanlibarch.debug.DebugTool;
import net.minecraft.util.Identifier;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MCPitanLibarch {
    public static final String MOD_ID = "mcpitanlibarch";

    private static final File configFile = new File(PlatformUtil.getConfigFolder().toFile(), MOD_ID + "/blacklist.json");

    public static Config config = new JsonConfig();
    private static boolean configLoaded = false;

    public static List<String> itemBlackList = new ArrayList<>();
    public static List<String> blockBlackList = new ArrayList<>();

    // MCPitanLibのアイテム、ブロック、タイルエンティティの登録
    public static ArchRegistry registry = ArchRegistry.createRegistry(MOD_ID);

    /**
     * MCPitanLibの初期化
     */
    public static void init() {
        configInit();

        if (PlatformUtil.isDevelopmentEnvironment() || (config.has("debugMode") && config.getBoolean("debugMode"))) {
            System.out.println("MCPitanLib: Debug Mode");
            DebugTool.register();
            registry.allRegister();
            /*
            ExampleMod.init();
            */
        }
    }

    /**
     * Configの初期化
     */
    public static void configInit() {
        try {
            if (configLoaded) return;
            configLoaded = true;
            if (!configFile.getParentFile().exists())
                if (!configFile.getParentFile().mkdirs())
                    return;

            config.setString("item", "examplemod:hogehoge_item,examplemod:fuga_item");
            config.setString("block", "examplemod:hogehoge_block,examplemod:fuga_block");
            config.setBoolean("debugMode", false);

            if (configFile.exists())
                config.load(configFile);

            if (!config.has("debugMode"))
                config.setBoolean("debugMode", false);

            if (config.has("item"))
                itemBlackList.addAll(Arrays.asList(config.getString("item").split(",")));

            if (config.has("block"))
                blockBlackList.addAll(Arrays.asList(config.getString("block").split(",")));

            config.save(configFile);
        } catch (Exception e) {
            System.out.println("MCPitanLib: Cannot save config file");
        }
    }

    /**
     * Identifierを生成
     * @param path パス
     * @return Identifier
     */
    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }

    public static boolean isItemBlackListed(Identifier id) {
        try {
            return itemBlackList.contains(id.toString());
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isBlockBlackListed(Identifier id) {
        try {
            return blockBlackList.contains(id.toString());
        } catch (Exception e) {
            return false;
        }
    }
}