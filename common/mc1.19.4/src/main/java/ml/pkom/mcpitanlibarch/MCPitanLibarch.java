package ml.pkom.mcpitanlibarch;

import ml.pkom.easyapi.config.Config;
import ml.pkom.easyapi.config.JsonConfig;
import ml.pkom.mcpitanlibarch.api.util.PlatformUtil;

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

    public static void init() {
        configInit();
        /*
        if (PlatformUtil.isDevelopmentEnvironment()) {
            ExampleMod.init();
        }
         */
    }

    public static void configInit() {
        try {
            if (configLoaded) return;
            configLoaded = true;
            if (!configFile.getParentFile().exists())
                if (!configFile.getParentFile().mkdirs())
                    return;

            config.setString("item", "examplemod:hogehoge_item,examplemod:fuga_item");
            config.setString("block", "examplemod:hogehoge_block,examplemod:fuga_block");

            if (configFile.exists())
                config.load(configFile);

            if (config.configMap.containsKey("item"))
                itemBlackList.addAll(Arrays.asList(config.getString("item").split(",")));

            if (config.configMap.containsKey("block"))
                blockBlackList.addAll(Arrays.asList(config.getString("block").split(",")));

            config.save(configFile);
        } catch (Exception e) {
            System.out.println("MCPitanLib: Cannot save config file");
        }
    }

}