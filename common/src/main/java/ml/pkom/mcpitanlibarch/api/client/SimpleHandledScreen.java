package ml.pkom.mcpitanlibarch.api.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public abstract class SimpleHandledScreen extends HandledScreen<ScreenHandler> {
    public SimpleHandledScreen(ScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    protected <T extends Element & Drawable> T addDrawableChild_compatibility(T drawableElement) {
        if (drawableElement instanceof ClickableWidget)
            return (T) super.addButton((ClickableWidget) drawableElement);
        else
            return super.addChild(drawableElement);
    }
}
