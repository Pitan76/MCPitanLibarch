package ml.pkom.mcpitanlibarch.api.text;

import ml.pkom.mcpitanlibarch.api.util.TextUtil;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

import org.jetbrains.annotations.Nullable;

public class TextComponent {

    private Text text;

    public TextComponent() {
        this(TextUtil.empty());
    }

    public TextComponent(Text text) {
        this.text = text;
    }

    public TextComponent(String string) {
        this(TextUtil.literal(string));
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public MutableText asMutableText() {
        return (MutableText) text;
    }

    public VariableTextComponent asVariableTextComponent() {
        return new VariableTextComponent(this);
    }

    @Nullable
    public MutableText asMutableTextOrNull() {
        if (text instanceof MutableText) {
            return asMutableText();
        }
        return null;
    }

    public static TextComponent literal(String string) {
        return new TextComponent(string);
    }

    public static TextComponent of(String string) {
        return TextComponent.literal(string);
    }

    public static TextComponent translatable(String key) {
        return new TextComponent(TextUtil.translatable(key));
    }

    public static TextComponent translatable(String key, Object... args) {
        return new TextComponent(TextUtil.translatable(key, args));
    }

    @Override
    public String toString() {
        return getString();
    }

    public String getString() {
        return TextUtil.txt2str(getText());
    }

    public String superToString() {
        return super.toString();
    }

    public TextComponent copy() {
        return new TextComponent(getText());
    }
}