package ml.pkom.mcpitanlibarch;

import ml.pkom.mcpitanlibarch.api.util.PlatformUtil;
import ml.pkom.mcpitanlibarch.test.ExampleMod;

public class MCPitanLibarch {
    public static final String MOD_ID = "mcpitanlibarch";

    public static void init() {
        if (PlatformUtil.isDevelopmentEnvironment()) {
            ExampleMod.init();
        }
    }
}