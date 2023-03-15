package ml.pkom.mcpitanlibarch.api.util.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.util.Identifier;

public class RenderUtil {
    public static void setShaderToPositionTexProgram() {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
    }

    public static void setShaderColor(float red, float green, float blue, float alpha) {
        RenderSystem.setShaderColor(red, green, blue, alpha);
    }

    public static void setShaderTexture(int texture, Identifier id) {
        RenderSystem.setShaderTexture(texture, id);
    }

    public static void enableDepthTest() {
        RenderSystem.enableDepthTest();
    }

    public static void enableTexture() {
        // ～1.19.2
    }

    public static void disableTexture() {
        // ～1.19.2
    }
}