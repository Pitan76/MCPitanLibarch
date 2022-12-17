package ml.pkom.mcpitanlibarch.api.util.client;

import com.mojang.blaze3d.platform.GlStateManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ScreenUtil {
    public static void setBackground(Identifier GUI, float f, float g, float h, float i) {
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        MinecraftClient.getInstance().getTextureManager().bindTexture(GUI);
    }

    public static void setBackground(Identifier GUI) {
        setBackground(GUI, 1.0F, 1.0F, 1.0F, 1.0F);
    }

    // ～1.19.2
    public static void setRepeatEvents(boolean isRepeatEvents) {
        MinecraftClient.getInstance().keyboard.setRepeatEvents(isRepeatEvents);
    }

    public static ButtonWidget createButtonWidget(int x, int y, int width, int height, Text message, ButtonWidget.PressAction onPress) {
        return createButtonWidget(x, y, width, height, message, onPress, ButtonWidget.EMPTY);
    }

    public static ButtonWidget createButtonWidget(int x, int y, int width, int height, Text message, ButtonWidget.PressAction onPress, ButtonWidget.TooltipSupplier tooltipSupplier) {
        return new ButtonWidget(x, y, width , height, message, onPress, tooltipSupplier);
    }
}
