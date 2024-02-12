package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.text.*;

@Deprecated
public class TextUtil {
    public static MutableText literal(String string) {
        return net.pitan76.mcpitanlib.api.util.TextUtil.literal(string);
    }

    public static MutableText translatable(String key) {
        return net.pitan76.mcpitanlib.api.util.TextUtil.translatable(key);
    }

    public static MutableText translatable(String key, Object... args) {
        return net.pitan76.mcpitanlib.api.util.TextUtil.translatable(key, args);
    }

    public static MutableText empty() {
        return net.pitan76.mcpitanlib.api.util.TextUtil.empty();
    }

    public static MutableText keybind(String string) {
        return net.pitan76.mcpitanlib.api.util.TextUtil.keybind(string);
    }

    public static String txt2str(Text text) {
        return net.pitan76.mcpitanlib.api.util.TextUtil.txt2str(text);
    }
}