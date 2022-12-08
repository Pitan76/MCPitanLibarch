package ml.pkom.mcpitanlibarch.api.util.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ScreenUtil {
    public static void setBackground(Identifier GUI, float f, float g, float h, float i) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(f, g, h, i);
        RenderSystem.setShaderTexture(0, GUI);

        // GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        // MinecraftClient.getInstance().getTextureManager().bindTexture(GUI);
    }

    public static void setBackground(Identifier GUI) {
        setBackground(GUI, 1.0F, 1.0F, 1.0F, 1.0F);
    }
}
