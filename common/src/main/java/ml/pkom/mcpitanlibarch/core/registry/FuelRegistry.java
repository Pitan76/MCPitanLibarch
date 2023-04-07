package ml.pkom.mcpitanlibarch.core.registry;

import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;

public class FuelRegistry {
    private FuelRegistry() {

    }

    public static void register(int time, ItemConvertible... item) {
        me.shedaniel.architectury.registry.fuel.FuelRegistry.register(time, item);
    }
    public static int get(ItemStack stack) {
        return me.shedaniel.architectury.registry.fuel.FuelRegistry.get(stack);
    }
}
