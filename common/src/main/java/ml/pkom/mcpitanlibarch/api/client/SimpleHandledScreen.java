package ml.pkom.mcpitanlibarch.api.client;

import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.Selectable;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;

public abstract class SimpleHandledScreen extends HandledScreen<ScreenHandler> {
    public SimpleHandledScreen(ScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    protected <T extends Element & Drawable & Selectable> T addDrawableChild_compatibility(T drawableElement) {
        return super.addDrawableChild(drawableElement);
        // addButton
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        drawBackgroundOverride(matrices, delta, mouseX, mouseY);
    }

    public abstract void drawBackgroundOverride(MatrixStack matrices, float delta, int mouseX, int mouseY);
}
