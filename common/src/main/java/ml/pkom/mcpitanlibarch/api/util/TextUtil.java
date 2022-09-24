package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.text.*;

public class TextUtil {
    public static MutableText literal(String string) {
        //return Text.literal(string);
        return new LiteralText(string);
    }

    public static MutableText translatable(String key) {
        //return Text.translatable(key);
        return new TranslatableText(key);
    }

    public static MutableText translatable(String key, Object... args) {
        //return Text.translatable(key, args);
        return new TranslatableText(key, args);
    }

    public static MutableText empty() {
        //return Text.empty();
        return literal("");
    }

    public static MutableText keybind(String string) {
        //return Text.keybind(string);
        return new KeybindText(string);
    }

    public static String txt2str(Text text) {
        return text.getString();
    }
}