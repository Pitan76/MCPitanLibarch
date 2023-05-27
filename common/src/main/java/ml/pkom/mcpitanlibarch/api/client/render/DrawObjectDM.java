package ml.pkom.mcpitanlibarch.api.client.render;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.math.MatrixStack;

public class DrawObjectDM {
    private MatrixStack stack;
    private DrawContext context;

    public DrawObjectDM(DrawContext context) {
        this.context = context;
    }

    public DrawObjectDM(MatrixStack stack) {
        this.stack = stack;
    }

    public DrawContext getContext() {
        return context;
    }

    public MatrixStack getStack() {
        return stack;
    }

    public void setContext(DrawContext context) {
        this.context = context;
    }

    public void setStack(MatrixStack stack) {
        this.stack = stack;
    }
}
