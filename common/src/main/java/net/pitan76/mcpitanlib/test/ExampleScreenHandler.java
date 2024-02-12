package net.pitan76.mcpitanlib.test;

import ml.pkom.mcpitanlibarch.api.entity.Player;
import ml.pkom.mcpitanlibarch.api.gui.SimpleScreenHandler;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;

public class ExampleScreenHandler extends SimpleScreenHandler {

    public ExampleScreenHandler(int i, PlayerInventory playerInventory) {
        super(ExampleMod.supplierEXAMPLE_SCREENHANDLER.getOrNull(), i);

    }

    @Override
    public ItemStack quickMoveOverride(Player player, int slot) {
        return null;
    }

    @Override
    public boolean canUse(Player player) {
        return true;
    }
}
