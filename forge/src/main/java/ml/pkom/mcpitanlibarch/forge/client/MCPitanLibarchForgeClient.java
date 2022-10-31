package ml.pkom.mcpitanlibarch.forge.client;

import ml.pkom.mcpitanlibarch.api.util.PlatformUtil;
import ml.pkom.mcpitanlibarch.test.ExampleModClient;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class MCPitanLibarchForgeClient {
    public static void clientInit(FMLClientSetupEvent event) {
        if (PlatformUtil.isDevelopmentEnvironment())
            ExampleModClient.init();
    }
}
