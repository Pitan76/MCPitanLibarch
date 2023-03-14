package ml.pkom.mcpitanlibarch.quilt;

import ml.pkom.mcpitanlibarch.MCPitanLibarch;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class MCPitanLibarchQuilt implements ModInitializer {

    @Override
    public void onInitialize(ModContainer mod) {
        MCPitanLibarch.init();
    }
}