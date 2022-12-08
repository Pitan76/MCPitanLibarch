package ml.pkom.mcpitanlibarch.test;

import ml.pkom.mcpitanlibarch.api.gui.SimpleScreenHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;

public class ExampleScreenHandler extends SimpleScreenHandler {

    public ExampleScreenHandler(int i, PlayerInventory playerInventory) {
        super(ExampleMod.supplierEXAMPLE_SCREENHANDLER.getOrNull(), i);

    }

    @Override
    public ItemStack quickMoveOverride(PlayerEntity player, int slot) {
        return null;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
}
