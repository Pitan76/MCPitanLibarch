package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class SlotUtil {
    public static void setStack(Slot slot, ItemStack stack) {
        slot.setStack(stack);
    }

    public static ItemStack getStack(Slot slot) {
        return slot.getStack();
    }

    public static void takeStack(Slot slot, int amount) {
        slot.takeStack(amount);
    }
}
