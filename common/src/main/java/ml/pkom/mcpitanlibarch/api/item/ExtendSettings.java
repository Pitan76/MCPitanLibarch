package ml.pkom.mcpitanlibarch.api.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class ExtendSettings extends Item.Settings {

    // ～1.19.2
    @Deprecated
    public ExtendSettings addGroup(ItemGroup itemGroup) {
        return this;
    }

    // 1.19.3～
    // identifier: Item ID
    @Deprecated
    public ExtendSettings addGroup(ItemGroup itemGroup, Identifier identifier) {
        CreativeTabManager.addItem(itemGroup, identifier);
        return this;
    }

    public ExtendSettings addGroup(Supplier<ItemGroup> itemGroup, Identifier identifier) {
        CreativeTabManager.addItem(itemGroup, identifier);
        return this;
    }
}
