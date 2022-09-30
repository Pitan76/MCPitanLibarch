package dev.architectury.registry.menu;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.ScreenHandlerProvider;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.text.Text;

public class MenuRegistry {
    public static <H extends ScreenHandler, S extends Screen & ScreenHandlerProvider<H>> void registerScreenFactory(ScreenHandlerType<? extends H> type, ScreenFactory<H, S> factory) {
        me.shedaniel.architectury.registry.MenuRegistry.registerScreenFactory(type, factoryConvert(factory));
    }

    public interface ScreenFactory<H extends ScreenHandler, S extends Screen & ScreenHandlerProvider<H>> {
        S create(H containerMenu, PlayerInventory inventory, Text component);
    }

    private static <H extends ScreenHandler, S extends Screen & ScreenHandlerProvider<H>> me.shedaniel.architectury.registry.MenuRegistry.ScreenFactory<H, S> factoryConvert(ScreenFactory<H, S> factory) {
        return factory::create;
    }
}
