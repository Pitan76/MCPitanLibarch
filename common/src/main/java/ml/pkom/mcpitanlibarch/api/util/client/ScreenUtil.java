package ml.pkom.mcpitanlibarch.api.util.client;

import ml.pkom.mcpitanlibarch.api.client.gui.widget.RedrawableTexturedButtonWidget;
import ml.pkom.mcpitanlibarch.api.util.TextUtil;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ScreenUtil {
    public static void setBackground(Identifier GUI, float f, float g, float h, float i) {
        RenderUtil.setShaderToPositionTexProgram();
        RenderUtil.setShaderColor(f, g, h, i);
        RenderUtil.setShaderTexture(0, GUI);

        // GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        // MinecraftClient.getInstance().getTextureManager().bindTexture(GUI);
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

    public static TexturedButtonWidget createTexturedButtonWidget(int x, int y, int width, int height, int u, int v, Identifier texture, ButtonWidget.PressAction pressAction) {
        return createTexturedButtonWidget(x, y, width, height, u, v, height, texture, pressAction);
    }

    public static TexturedButtonWidget createTexturedButtonWidget(int x, int y, int width, int height, int u, int v, int hoveredVOffset, Identifier texture, ButtonWidget.PressAction pressAction) {
        return createTexturedButtonWidget(x, y, width, height, u, v, hoveredVOffset, texture, 256, 256, pressAction);
    }

    public static TexturedButtonWidget createTexturedButtonWidget(int x, int y, int width, int height, int u, int v, int hoveredVOffset, Identifier texture, int textureWidth, int textureHeight, ButtonWidget.PressAction pressAction) {
        return createTexturedButtonWidget(x, y, width, height, u, v, hoveredVOffset, texture, textureWidth, textureHeight, pressAction, Texts.empty());
    }

    public static TexturedButtonWidget createTexturedButtonWidget(int x, int y, int width, int height, int u, int v, int hoveredVOffset, Identifier texture, int textureWidth, int textureHeight, ButtonWidget.PressAction pressAction, Text message) {
        return new TexturedButtonWidget(x, y, width, height, u, v, hoveredVOffset, texture, textureWidth, textureHeight, pressAction, message);
    }

    public static RedrawableTexturedButtonWidget createRedrawableTexturedButtonWidget(int x, int y, int width, int height, int u, int v, Identifier texture, ButtonWidget.PressAction pressAction) {
        return createRedrawableTexturedButtonWidget(x, y, width, height, u, v, height, texture, pressAction);
    }

    public static RedrawableTexturedButtonWidget createRedrawableTexturedButtonWidget(int x, int y, int width, int height, int u, int v, int hoveredVOffset, Identifier texture, ButtonWidget.PressAction pressAction) {
        return createRedrawableTexturedButtonWidget(x, y, width, height, u, v, hoveredVOffset, texture, 256, 256, pressAction);
    }

    public static RedrawableTexturedButtonWidget createRedrawableTexturedButtonWidget(int x, int y, int width, int height, int u, int v, int hoveredVOffset, Identifier texture, int textureWidth, int textureHeight, ButtonWidget.PressAction pressAction) {
        return createRedrawableTexturedButtonWidget(x, y, width, height, u, v, hoveredVOffset, texture, textureWidth, textureHeight, pressAction, Texts.empty());
    }

    public static RedrawableTexturedButtonWidget createRedrawableTexturedButtonWidget(int x, int y, int width, int height, int u, int v, int hoveredVOffset, Identifier texture, int textureWidth, int textureHeight, ButtonWidget.PressAction pressAction, Text message) {
        return new RedrawableTexturedButtonWidget(x, y, width, height, u, v, hoveredVOffset, texture, textureWidth, textureHeight, pressAction, message);
    }



    public static class Texts {
        public static Text empty() {
            return TextUtil.empty();
        }
    }

    public static class TextFieldUtil {
        public static void setFocused(TextFieldWidget widget, boolean focused) {
            widget.setTextFieldFocused(focused);
        }
    }
}
