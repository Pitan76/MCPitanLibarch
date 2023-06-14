package ml.pkom.mcpitanlibarch.api.util.client;

import ml.pkom.mcpitanlibarch.api.client.gui.widget.RedrawableTexturedButtonWidget;
import ml.pkom.mcpitanlibarch.api.client.render.DrawObjectDM;
import ml.pkom.mcpitanlibarch.api.client.render.handledscreen.RenderArgs;
import ml.pkom.mcpitanlibarch.api.util.TextUtil;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import javax.annotation.Nullable;

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
    }

    public static ButtonWidget createButtonWidget(int x, int y, int width, int height, Text message, ButtonWidget.PressAction onPress) {
        return createButtonWidget(x, y, width, height, message, onPress, null);
    }

    public static ButtonWidget createButtonWidget(int x, int y, int width, int height, Text message, ButtonWidget.PressAction onPress, @Nullable ButtonWidget.NarrationSupplier tooltipSupplier) {
        ButtonWidget.Builder builder = ButtonWidget.builder(message, onPress).dimensions(x, y, width , height);
        if (tooltipSupplier != null)
            builder.narrationSupplier(tooltipSupplier);

        return builder.build();
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
            return ScreenTexts.EMPTY;
        }
    }

    public static class TextFieldUtil {
        public static void setFocused(TextFieldWidget widget, boolean focused) {
            widget.setFocused(focused);
        }

        public static void render(TextFieldWidget widget, RenderArgs args) {
            widget.render(args.drawObjectDM.getStack(), args.mouseX, args.mouseY, args.delta);
        }
    }

    public static class ClickableWidgetUtil {
        public static void render(ClickableWidget widget, RenderArgs args) {
            widget.render(args.drawObjectDM.getStack(), args.mouseX, args.mouseY, args.delta);
        }
    }

    public static class RendererUtil {
        public static int drawText(TextRenderer renderer, DrawObjectDM drawObjectDM, Text text, int x, int y, int color) {
            return renderer.draw(drawObjectDM.getStack(), text, x, y, color);
        }

        public static int drawText(TextRenderer renderer, DrawObjectDM drawObjectDM, String text, int x, int y, int color) {
            return renderer.draw(drawObjectDM.getStack(), text, x, y, color);
        }

        public static int drawText(TextRenderer renderer, DrawObjectDM drawObjectDM, OrderedText text, int x, int y, int color) {
            return renderer.draw(drawObjectDM.getStack(), text, x, y, color);
        }

        public static void drawTexture(DrawObjectDM drawObjectDM, Identifier texture, int x, int y, float u, float v, int width, int height, int textureWidth, int textureHeight) {
            RenderUtil.setShaderTexture(0, texture);
            DrawableHelper.drawTexture(drawObjectDM.getStack(), x, y, u, v, width, height, textureWidth, textureHeight);
        }

        public static void drawTexture(DrawObjectDM drawObjectDM, Identifier texture, int x, int y, float u, float v, int width, int height) {
            RenderUtil.setShaderTexture(0, texture);
            DrawableHelper.drawTexture(drawObjectDM.getStack(), x, y, u, v, width, height, 256, 256);
        }
    }
}
