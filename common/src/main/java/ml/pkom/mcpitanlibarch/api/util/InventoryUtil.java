package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

import java.util.Objects;

public class InventoryUtil {
    public static boolean insertItem(ItemStack insertStack, DefaultedList<ItemStack> inventory) {
        return insertItem(insertStack, inventory, false);
    }

    public static boolean insertItem(ItemStack insertStack, DefaultedList<ItemStack> inventory, boolean test) {
        boolean isInserted = false;
        for (int i = 0; i < inventory.size(); i++) {
            ItemStack stack = inventory.get(i);
            if (stack.isEmpty()) {
                if (!test) inventory.set(i, insertStack);
                isInserted = true;
                break;
            } else if (canMergeItems(stack, insertStack)) {
                int j = insertStack.getCount();
                if (!test) stack.increment(j);
                isInserted = j > 0;
                break;
            }
        }
        return isInserted;

    }

    public static boolean canMergeItems(ItemStack first, ItemStack second) {
        if (!first.isOf(second.getItem())) {
            return false;
        }
        if (first.getDamage() != second.getDamage()) {
            return false;
        }
        if (first.getCount() + second.getCount() > first.getMaxCount()) {
            return false;
        }
        return ItemStackUtil.areNbtEqual(first, second);
    }
}
