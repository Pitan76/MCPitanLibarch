package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.text.*;

public class TextUtil {
    public static MutableText literal(String string) {
        return Text.literal(string);
    }

    public static MutableText translatable(String key) {
        return Text.translatable(key);
    }

    public static MutableText translatable(String key, Object... args) {
        return Text.translatable(key, args);
    }

    public static MutableText empty() {
        //return Text.empty();
        return literal("");
    }

    public static MutableText keybind(String string) {
        return Text.keybind(string);
    }

    public static String txt2str(Text text) {
        return text.getString();
    }
}