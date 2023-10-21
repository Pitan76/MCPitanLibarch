package ml.pkom.mcpitanlibarch.api.client.render;

import net.minecraft.client.util.math.MatrixStack;

public class DrawObjectDM {
    private MatrixStack stack;

    public DrawObjectDM(MatrixStack stack) {
        this.stack = stack;
    }

    public MatrixStack getStack() {
        return stack;
    }
    
    public void setStack(MatrixStack stack) {
        this.stack = stack;
    }
}
