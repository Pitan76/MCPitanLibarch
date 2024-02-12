package net.pitan76.mcpitanlib.fabric;

import net.pitan76.mcpitanlib.MCPitanLib;
import net.fabricmc.api.ModInitializer;

public class MCPitanLibFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        MCPitanLib.init();
        /*
        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT)
            if (FabricLoader.getInstance().isDevelopmentEnvironment())
                ExampleModClient.init();

         */
    }
}