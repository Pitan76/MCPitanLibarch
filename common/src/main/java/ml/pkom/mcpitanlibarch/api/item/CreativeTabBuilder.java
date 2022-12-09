package ml.pkom.mcpitanlibarch.api.item;

import me.shedaniel.architectury.registry.CreativeTabs;
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

    public CreativeTabBuilder(Identifier identifier) {
        this.identifier = identifier;
    }

    public CreativeTabBuilder create(Identifier identifier) {
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
        /*
        CreativeTabRegistry tabSupplier = CreativeTabRegistry.create(identifier, (builder -> {
            if (displayName != null) builder.displayName(displayName);
            if (iconSupplier != null) builder.icon(iconSupplier);
            if (noRenderedName) builder.noRenderedName();
            if (noScrollbar) builder.noScrollbar();
            if (special) builder.special();
            if (texture != null) builder.texture(texture);
        }));
        return tabSupplier.get();

         */
        ItemGroup itemGroup = CreativeTabs.create(identifier, iconSupplier);
        if (displayName != null) itemGroup.setName(displayName.getString());
        if (noRenderedName) itemGroup.setName("");
        if (noScrollbar) itemGroup.setNoScrollbar();
        if (special) itemGroup.isSpecial();
        if (texture != null) itemGroup.setTexture(texture);
        return itemGroup;
    }
}
