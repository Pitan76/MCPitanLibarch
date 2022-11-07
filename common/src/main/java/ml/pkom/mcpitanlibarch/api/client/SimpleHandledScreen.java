package ml.pkom.mcpitanlibarch.api.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.Selectable;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;

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

    protected <T extends Element & Drawable & Selectable> T addDrawableChild_compatibility(T drawableElement) {
        return super.addDrawableChild(drawableElement);
        // addButton
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        drawBackgroundOverride(matrices, delta, mouseX, mouseY);
    }

    public abstract void drawBackgroundOverride(MatrixStack matrices, float delta, int mouseX, int mouseY);

    @Override
    protected void drawForeground(MatrixStack matrices, int mouseX, int mouseY) {
        drawForegroundOverride(matrices, mouseX, mouseY);
    }

    protected void drawForegroundOverride(MatrixStack matrices, int mouseX, int mouseY) {
        super.drawForeground(matrices, mouseX, mouseY);
    }

    public void callDrawTexture(MatrixStack matrices, int x, int y, int u, int v, int width, int height) {
        super.drawTexture(matrices, x, y, u, v, width, height);
    }

    public void callRenderBackground(MatrixStack matrices) {
        super.renderBackground(matrices);
    }

    public void callDrawMouseoverTooltip(MatrixStack matrices, int x, int y) {
        super.drawMouseoverTooltip(matrices, x, y);
    }

    public void renderOverride(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        super.render(matrices, mouseX, mouseY, delta);
    }

    public void resizeOverride(MinecraftClient client, int width, int height) {
        super.resize(client, width, height);
    }

    public void initOverride() {
        super.init();
    }

    @Override
    protected void init() {
        initOverride();
        fixScreen();
    }

    @Override
    public void resize(MinecraftClient client, int width, int height) {
        resizeOverride(client, width, height);
        fixScreen();
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

    public int getBackgroundWidth() {
        return super.backgroundWidth;
    }

    public int getBackgroundHeight() {
        return super.backgroundHeight;
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderOverride(matrices, mouseX, mouseY, delta);
    }
}
