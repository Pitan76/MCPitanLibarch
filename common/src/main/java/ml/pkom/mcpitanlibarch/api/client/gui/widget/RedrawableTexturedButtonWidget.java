package ml.pkom.mcpitanlibarch.api.client.gui.widget;

import ml.pkom.mcpitanlibarch.api.util.client.RenderUtil;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class RedrawableTexturedButtonWidget extends CompatibleTexturedButtonWidget {
    public Identifier texture;
    public int u;
    public int v;
    public int hoveredVOffset;
    public int textureWidth;
    public int textureHeight;

    public RedrawableTexturedButtonWidget(int x, int y, int width, int height, int u, int v, int hoveredVOffset, Identifier texture, int textureWidth, int textureHeight, PressAction pressAction, Text message) {
        super(x, y, width, height, u, v, hoveredVOffset, texture, textureWidth, textureHeight, pressAction, message);
        this.textureWidth = textureWidth;
        this.textureHeight = textureHeight;
        this.u = u;
        this.v = v;
        this.hoveredVOffset = hoveredVOffset;
        this.texture = texture;
    }

    public void renderButton(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        RenderUtil.setShaderToPositionTexProgram();
        RenderUtil.setShaderTexture(0, this.texture);
        int i = this.v;
        if (!this.isNarratable()) {
            i += this.hoveredVOffset * 2;
        } else if (this.isHovered()) {
            i += this.hoveredVOffset;
        }

        RenderUtil.enableDepthTest();
        drawTexture(matrices, this.getX(), this.getY(), (float)this.u, (float)i, this.width, this.height, this.textureWidth, this.textureHeight);
    }

    public void setTexture(Identifier texture) {
        this.texture = texture;
    }

    public void setU(int u) {
        this.u = u;
    }

    public void setV(int v) {
        this.v = v;
    }

    public void setHoveredVOffset(int hoveredVOffset) {
        this.hoveredVOffset = hoveredVOffset;
    }

    public void setTextureWidth(int textureWidth) {
        this.textureWidth = textureWidth;
    }

    public void setTextureHeight(int textureHeight) {
        this.textureHeight = textureHeight;
    }
}
