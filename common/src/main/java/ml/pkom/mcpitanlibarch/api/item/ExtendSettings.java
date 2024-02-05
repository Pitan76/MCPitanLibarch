package ml.pkom.mcpitanlibarch.api.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class ExtendSettings extends Item.Settings {

    // ～1.19.2
    @Deprecated
    public ExtendSettings addGroup(ItemGroup itemGroup) {
        super.group(itemGroup);
        return this;
    }

    // 1.19.3～
    // identifier: Item ID
    @Deprecated
    public ExtendSettings addGroup(ItemGroup itemGroup, Identifier identifier) {
        //CreativeTabRegistry.append(itemGroup, ItemUtil.fromId(identifier));
        return addGroup(itemGroup);
    }

    public ExtendSettings addGroup(Supplier<ItemGroup> itemGroup, Identifier identifier) {
        addGroup(itemGroup.get());
        return this;
    }
}
