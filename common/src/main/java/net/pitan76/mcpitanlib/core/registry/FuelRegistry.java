package net.pitan76.mcpitanlib.core.registry;

import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;

public class FuelRegistry {
    private FuelRegistry() {

    }

    public static void register(int time, ItemConvertible... item) {
        dev.architectury.registry.fuel.FuelRegistry.register(time, item);
    }
    public static int get(ItemStack stack) {
        return dev.architectury.registry.fuel.FuelRegistry.get(stack);
    }
}
