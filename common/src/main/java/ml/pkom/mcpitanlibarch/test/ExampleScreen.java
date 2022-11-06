package ml.pkom.mcpitanlibarch.test;

import ml.pkom.mcpitanlibarch.api.client.SimpleHandledScreen;
import ml.pkom.mcpitanlibarch.api.util.client.ScreenUtil;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ExampleScreen extends SimpleHandledScreen {

    public static Identifier GUI = new Identifier("textures/gui/container/blast_furnace.png");

    public ExampleScreen(ScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    public void initOverride() {
        super.initOverride();
        System.out.println("hogehogehoge1111");
        this.addDrawableChild_compatibility(new TexturedButtonWidget(0,  0, 30, 30, 0, 0, 16, GUI, (buttonWidget) -> {
            System.out.println("hogehoge");
        }));
    }

    @Override
    public void drawBackgroundOverride(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        ScreenUtil.setBackground(GUI);
        callDrawTexture(matrices, x, y, 0, 0, this.backgroundWidth, this.backgroundHeight);
    }

    @Override
    public void renderOverride(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.callRenderBackground(matrices);
        super.renderOverride(matrices, mouseX, mouseY, delta);
        this.callDrawMouseoverTooltip(matrices, mouseX, mouseY);
    }
}
