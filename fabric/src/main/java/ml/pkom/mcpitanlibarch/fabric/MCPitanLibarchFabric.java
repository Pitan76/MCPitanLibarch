package ml.pkom.mcpitanlibarch.fabric;

import ml.pkom.mcpitanlibarch.MCPitanLibarch;
import ml.pkom.mcpitanlibarch.test.ExampleModClient;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class MCPitanLibarchFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        MCPitanLibarch.init();
        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT)
            if (FabricLoader.getInstance().isDevelopmentEnvironment())
                ExampleModClient.init();
    }
}