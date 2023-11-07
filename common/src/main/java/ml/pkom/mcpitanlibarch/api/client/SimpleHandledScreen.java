package ml.pkom.mcpitanlibarch.api.client;

import ml.pkom.mcpitanlibarch.api.client.gui.widget.CompatibleTexturedButtonWidget;
import ml.pkom.mcpitanlibarch.api.client.render.DrawObjectDM;
import ml.pkom.mcpitanlibarch.api.util.client.ScreenUtil;
import ml.pkom.mcpitanlibarch.api.client.render.handledscreen.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public abstract class SimpleHandledScreen extends HandledScreen<ScreenHandler> {

    public int width, height, backgroundWidth, backgroundHeight, x, y;
    public ScreenHandler handler;
    public TextRenderer textRenderer;
    public ItemRenderer itemRenderer;

    public SimpleHandledScreen(ScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        fixScreen();
        this.handler = handler;
    }

    public <T extends Element & Drawable> T addDrawableChild_compatibility(T drawableElement) {
        if (drawableElement instanceof ClickableWidget)
            return (T) super.addButton((ClickableWidget) drawableElement);
        else
            return super.addChild(drawableElement);
    }

    public CompatibleTexturedButtonWidget addDrawableCTBW(CompatibleTexturedButtonWidget widget) {
        return addDrawableChild_compatibility(widget);
    }

    @Deprecated
    @Override
    protected void drawBackground(MatrixStack stack, float delta, int mouseX, int mouseY) {
        DrawObjectDM drawObjectDM = new DrawObjectDM(stack);
        drawBackgroundOverride(new DrawBackgroundArgs(drawObjectDM, delta, mouseX, mouseY));
    }

    public abstract void drawBackgroundOverride(DrawBackgroundArgs args);

    @Deprecated
    @Override
    protected void drawForeground(MatrixStack stack, int mouseX, int mouseY) {
        DrawObjectDM drawObjectDM = new DrawObjectDM(stack);
        drawForegroundOverride(new DrawForegroundArgs(drawObjectDM, mouseX, mouseY));
    }

    protected void drawForegroundOverride(DrawForegroundArgs args) {
        super.drawForeground(args.drawObjectDM.getStack(), args.mouseX, args.mouseY);
    }

    public void callDrawTexture(DrawObjectDM drawObjectDM, Identifier texture, int x, int y, int u, int v, int width, int height) {
        ScreenUtil.setBackground(texture);
        drawTexture(drawObjectDM.getStack(), x, y, u, v, width, height);
    }

    @Deprecated
    public void callRenderBackground(DrawObjectDM drawObjectDM) {
        super.renderBackground(drawObjectDM.getStack());
        callRenderBackground(new RenderArgs(drawObjectDM, 0, 0, 0));
    }


    public void callRenderBackground(RenderArgs args) {
        super.renderBackground(args.drawObjectDM.getStack());
    }

    public void callDrawMouseoverTooltip(DrawMouseoverTooltipArgs args) {
        super.drawMouseoverTooltip(args.drawObjectDM.getStack(), args.mouseX, args.mouseY);
    }

    public void renderOverride(RenderArgs args) {
        super.render(args.drawObjectDM.getStack(), args.mouseX, args.mouseY, args.delta);
    }

    public void resizeOverride(MinecraftClient client, int width, int height) {
    }

    public void initOverride() {
    }

    @Deprecated
    @Override
    protected void init() {
        super.init();
        fixScreen();
        initOverride();
    }

    @Deprecated
    @Override
    public void resize(MinecraftClient client, int width, int height) {
        super.resize(client, width, height);
        fixScreen();
        resizeOverride(client, width, height);
    }

    public void fixScreen() {
        this.backgroundWidth = getBackgroundWidth();
        this.backgroundHeight = getBackgroundHeight();
        this.x = super.x; //(this.width - this.backgroundWidth) / 2;
        this.y = super.y; //(this.height - this.backgroundHeight) / 2;
        this.textRenderer = super.textRenderer;
        this.itemRenderer = super.itemRenderer;
        this.width = super.width;
        this.height = super.height;
    }

    public void setX(int x) {
        this.x = x;
        super.x = x;
    }

    public void setY(int y) {
        this.y = y;
        super.y = y;
    }

    public void setTextRenderer(TextRenderer textRenderer) {
        this.textRenderer = textRenderer;
        super.textRenderer = textRenderer;
    }

    public void setItemRenderer(ItemRenderer itemRenderer) {
        this.itemRenderer = itemRenderer;
        super.itemRenderer = itemRenderer;
    }

    public void setWidth(int width) {
        this.width = width;
        super.width = width;
    }

    public void setBackgroundWidth(int backgroundWidth) {
        this.backgroundWidth = backgroundWidth;
        super.backgroundWidth = backgroundWidth;
    }

    public void setBackgroundHeight(int backgroundHeight) {
        this.backgroundHeight = backgroundHeight;
        super.backgroundHeight = backgroundHeight;
    }

    public void setHeight(int height) {
        this.height = height;
        super.height = height;
    }

    public int getBackgroundWidth() {
        return super.backgroundWidth;
    }

    public int getBackgroundHeight() {
        return super.backgroundHeight;
    }

    @Deprecated
    @Override
    public void render(MatrixStack stack, int mouseX, int mouseY, float delta) {
        DrawObjectDM drawObjectDM = new DrawObjectDM(stack);
        renderOverride(new RenderArgs(drawObjectDM, mouseX, mouseY, delta));
    }

    public boolean keyReleased(KeyEventArgs args) {
        return super.keyReleased(args.keyCode, args.scanCode, args.modifiers);
    }

    public boolean keyPressed(KeyEventArgs args) {
        return super.keyPressed(args.keyCode, args.scanCode, args.modifiers);
    }

    @Deprecated
    @Override
    public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
        return this.keyReleased(new KeyEventArgs(keyCode, scanCode, modifiers));
    }

    @Deprecated
    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        return this.keyPressed(new KeyEventArgs(keyCode, scanCode, modifiers));
    }
}
