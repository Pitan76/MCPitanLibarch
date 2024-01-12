package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

public class SimpleInventoryUtil {
    public static DefaultedList<ItemStack> getHeldStacks(SimpleInventory inventory) {
        DefaultedList<ItemStack> stacks = DefaultedList.ofSize(inventory.size(), ItemStack.EMPTY);
        for (int i = 0; i < inventory.size(); i++) {
            stacks.add(i, inventory.getStack(i));
        }
        return stacks;
    }
}
