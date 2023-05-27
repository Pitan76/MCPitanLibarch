package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.item.ItemStack;

import java.util.Objects;

public class ItemStackUtil {
    public static ItemStack copy(ItemStack stack) {
        return stack.copy();
    }

    public static ItemStack copyWithCount(ItemStack stack, int count) {
        return stack.copyWithCount(count);
    }

    public static boolean areItemsEqual(ItemStack left, ItemStack right) {
        return ItemStack.areItemsEqual(left, right);
    }

    public static boolean areNbtEqual(ItemStack left, ItemStack right) {
        return Objects.equals(left.getNbt(), right.getNbt());
    }
}
