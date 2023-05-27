package ml.pkom.mcpitanlibarch.api.item;

import dev.architectury.registry.CreativeTabRegistry;
import ml.pkom.mcpitanlibarch.api.util.TextUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class CreativeTabBuilder {

    private final Identifier identifier;
    private Text displayName = null;
    private Supplier<ItemStack> iconSupplier = null;
    private boolean noRenderedName = false;
    private boolean noScrollbar = false;
    private boolean special = false;
    private String texture;

    @Deprecated
    // Recommend: create(identifier)
    public CreativeTabBuilder(Identifier identifier) {
        this.identifier = identifier;
    }

    public static CreativeTabBuilder create(Identifier identifier) {
        return new CreativeTabBuilder(identifier);
    }

    public CreativeTabBuilder setDisplayName(Text text) {
        this.displayName = text;
        return this;
    }

    public CreativeTabBuilder setIcon(Supplier<ItemStack> iconSupplier) {
        this.iconSupplier = iconSupplier;
        return this;
    }

    public CreativeTabBuilder setIcon(Item item) {
        return setIcon(() -> new ItemStack(item));
    }

    public void noRenderedName() {
        this.noRenderedName = true;
    }

    public void noScrollbar() {
        this.noScrollbar = true;
    }

    public void special() {
        this.special = true;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public ItemGroup build() {
        return CreativeTabRegistry.create((builder -> {
            if (displayName != null) builder.displayName(displayName);
            else builder.displayName(TextUtil.translatable("itemGroup." + identifier.getNamespace() + "." + identifier.getPath()));

            if (iconSupplier != null) builder.icon(iconSupplier);
            if (noRenderedName) builder.noRenderedName();
            if (noScrollbar) builder.noScrollbar();
            if (special) builder.special();
            if (texture != null) builder.texture(texture);
        }));
    }
}
