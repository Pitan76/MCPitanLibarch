package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

public class SimpleInventoryUtil {
    public static DefaultedList<ItemStack> getHeldStacks(SimpleInventory inventory) {
        return inventory.getHeldStacks();
    }
}
