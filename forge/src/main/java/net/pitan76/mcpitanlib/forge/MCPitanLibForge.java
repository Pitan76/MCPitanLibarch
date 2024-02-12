package net.pitan76.mcpitanlib.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.pitan76.mcpitanlib.MCPitanLib;

@Mod(MCPitanLib.MOD_ID)
public class MCPitanLibForge {
    public MCPitanLibForge() {
        EventBuses.registerModEventBus(MCPitanLib.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        MCPitanLib.init();
    }
}