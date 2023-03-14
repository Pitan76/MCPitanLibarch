package ml.pkom.mcpitanlibarch.forge;

import dev.architectury.platform.forge.EventBuses;
import ml.pkom.mcpitanlibarch.MCPitanLibarch;
import ml.pkom.mcpitanlibarch.api.util.PlatformUtil;
import ml.pkom.mcpitanlibarch.test.ExampleMod;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MCPitanLibarch.MOD_ID)
public class MCPitanLibarchForge {
    public MCPitanLibarchForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(MCPitanLibarch.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        if (PlatformUtil.isDevelopmentEnvironment())
            EventBuses.registerModEventBus(ExampleMod.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        MCPitanLibarch.init();

        /*
        if (Platform.getEnv().isClient())
            FMLJavaModLoadingContext.get().getModEventBus().addListener(MCPitanLibarchForgeClient::clientInit);

         */
    }
}