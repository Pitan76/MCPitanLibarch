package net.pitan76.mcpitanlib.neoforge;

import net.neoforged.fml.common.Mod;
import net.pitan76.mcpitanlib.MCPitanLib;

@Mod(MCPitanLib.MOD_ID)
public class MCPitanLibNeoForge {
    public MCPitanLibNeoForge() {
        //EventBuses.registerModEventBus(MCPitanLibarch.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        MCPitanLib.init();

        //if (Platform.getEnv().isClient())
        //    FMLJavaModLoadingContext.get().getModEventBus().addListener(MCPitanLibarchNeoForgeClient::clientInit);
    }
}