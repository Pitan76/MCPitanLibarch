package net.pitan76.mcpitanlib.test;

import ml.pkom.mcpitanlibarch.api.client.SimpleHandledScreen;
import ml.pkom.mcpitanlibarch.api.client.render.handledscreen.DrawBackgroundArgs;
import ml.pkom.mcpitanlibarch.api.client.render.handledscreen.DrawMouseoverTooltipArgs;
import ml.pkom.mcpitanlibarch.api.client.render.handledscreen.RenderArgs;
import net.minecraft.client.gui.screen.ButtonTextures;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
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
        this.addDrawableChild_compatibility(new TexturedButtonWidget(0,  0, 30, 30, new ButtonTextures(GUI, GUI), (buttonWidget) -> {
            System.out.println("hogehoge");
        }));
    }

    @Override
    public void drawBackgroundOverride(DrawBackgroundArgs args) {
        callDrawTexture(args.drawObjectDM, GUI, x, y, 0, 0, this.backgroundWidth, this.backgroundHeight);
    }

    @Override
    public void renderOverride(RenderArgs args) {
        this.callRenderBackground(args);
        super.renderOverride(args);
        this.callDrawMouseoverTooltip(new DrawMouseoverTooltipArgs(args.drawObjectDM, args.mouseX, args.mouseY));
    }
}
