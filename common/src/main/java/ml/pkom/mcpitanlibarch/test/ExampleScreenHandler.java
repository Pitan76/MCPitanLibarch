package ml.pkom.mcpitanlibarch.test;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;

public class ExampleScreenHandler extends ScreenHandler {

    public ExampleScreenHandler(int i, PlayerInventory playerInventory) {
        super(ExampleMod.supplierEXAMPLE_SCREENHANDLER.getOrNull(), i);

    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
}
