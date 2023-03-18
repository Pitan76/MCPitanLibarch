package ml.pkom.mcpitanlibarch.api.gui.slot;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class CompatibleSlot extends Slot {
    public CompatibleSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    public void callSetStack(ItemStack stack) {
        super.setStack(stack);
    }

    public void callSetStackNoCallbacks(ItemStack stack) {
        super.setStackNoCallbacks(stack);
    }

    public ItemStack callGetStack() {
        return super.getStack();
    }

    public ItemStack callTakeStack(int amount) {
        return super.takeStack(amount);
    }

    public boolean callHasStack() {
        return super.hasStack();
    }

    @Deprecated
    @Override
    public void setStack(ItemStack stack) {
       callSetStack(stack);
    }

    @Deprecated
    @Override
    public void setStackNoCallbacks(ItemStack stack) {
        callSetStackNoCallbacks(stack);
    }

    @Deprecated
    @Override
    public ItemStack getStack() {
        return callGetStack();
    }

    @Deprecated
    @Override
    public ItemStack takeStack(int amount) {
        return callTakeStack(amount);
    }

    @Deprecated
    @Override
    public boolean hasStack() {
        return callHasStack();
    }
}
