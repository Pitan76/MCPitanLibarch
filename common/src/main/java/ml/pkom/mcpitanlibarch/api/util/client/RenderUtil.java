package ml.pkom.mcpitanlibarch.api.util.client;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.util.Identifier;

public class RenderUtil {
    public static void setShaderToPositionTexProgram() {
        //
    }

    public static void setShaderColor(float red, float green, float blue, float alpha) {
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public static void setShaderTexture(int texture, Identifier id) {
        MinecraftClient.getInstance().getTextureManager().bindTexture(id);
    }

    public static void enableDepthTest() {
        RenderSystem.enableDepthTest();
    }

    public static void enableTexture() {
        RenderSystem.enableTexture();
    }

    public static void disableTexture() {
        RenderSystem.disableTexture();
    }
}