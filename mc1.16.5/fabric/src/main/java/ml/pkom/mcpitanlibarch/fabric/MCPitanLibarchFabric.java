package ml.pkom.mcpitanlibarch.fabric;

import ml.pkom.mcpitanlibarch.MCPitanLibarch;
import net.fabricmc.api.ModInitializer;

public class MCPitanLibarchFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        MCPitanLibarch.init();
        /*
        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT)
            if (FabricLoader.getInstance().isDevelopmentEnvironment())
                ExampleModClient.init();

         */
    }
}