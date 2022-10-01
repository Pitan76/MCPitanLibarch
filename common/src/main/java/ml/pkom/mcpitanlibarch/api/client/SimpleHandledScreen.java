package ml.pkom.mcpitanlibarch.api.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
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

    protected <T extends ClickableWidget> T addDrawableChild_compatibility(T drawableElement) {
        return super.addButton(drawableElement);
    }
}
