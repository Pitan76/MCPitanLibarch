package ml.pkom.mcpitanlibarch.neoforge;

import dev.architectury.platform.Platform;
import net.pitan76.mcpitanlib.MCPitanLib;
import ml.pkom.mcpitanlibarch.neoforge.client.MCPitanLibarchNeoForgeClient;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MCPitanLib.MOD_ID)
public class MCPitanLibarchNeoForge {
    public MCPitanLibarchNeoForge() {
        // Submit our event bus to let architectury register our content on the right time
        //EventBuses.registerModEventBus(MCPitanLibarch.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        //if (PlatformUtil.isDevelopmentEnvironment())
        //    EventBuses.registerModEventBus(ExampleMod.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        MCPitanLib.init();

        if (Platform.getEnv().isClient())
            FMLJavaModLoadingContext.get().getModEventBus().addListener(MCPitanLibarchNeoForgeClient::clientInit);
    }
}