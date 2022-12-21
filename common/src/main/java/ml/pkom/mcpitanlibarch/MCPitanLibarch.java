package ml.pkom.mcpitanlibarch;

import ml.pkom.easyapi.config.Config;
import ml.pkom.easyapi.config.YamlConfig;
import ml.pkom.mcpitanlibarch.api.util.PlatformUtil;
import ml.pkom.mcpitanlibarch.test.ExampleMod;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MCPitanLibarch {
    public static final String MOD_ID = "mcpitanlibarch";

    private static File configFile = new File(PlatformUtil.getConfigFolder().toFile(), MOD_ID + "/blacklist.json");

    public static Config config = new YamlConfig();
    private static boolean configLoaded = false;

    public static List<String> itemBlackList = new ArrayList<>();
    public static List<String> blockBlackList = new ArrayList<>();

    public static void init() {
        configInit();
        if (PlatformUtil.isDevelopmentEnvironment()) {
            ExampleMod.init();
        }
    }

    public static void configInit() {
        if (configLoaded) return;
        configLoaded = true;
        config.setString("item", "examplemod:hogehoge_item,examplemod:fuga_item");
        config.setString("block", "examplemod:hogehoge_block,examplemod:fuga_block");

        config.load(configFile);

        itemBlackList.addAll(Arrays.asList(config.getString("item").split(",")));
        blockBlackList.addAll(Arrays.asList(config.getString("block").split(",")));

        config.save(configFile);

    }

}