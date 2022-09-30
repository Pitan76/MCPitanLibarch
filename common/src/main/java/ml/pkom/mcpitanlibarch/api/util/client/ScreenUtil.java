package ml.pkom.mcpitanlibarch.api.util.client;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;

public class ScreenUtil {
    public static void setBackground(Identifier GUI, float f, float g, float h, float i) {
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        MinecraftClient.getInstance().getTextureManager().bindTexture(GUI);
    }

    public static void setBackground(Identifier GUI) {
        setBackground(GUI, 1.0F, 1.0F, 1.0F, 1.0F);
    }
}
