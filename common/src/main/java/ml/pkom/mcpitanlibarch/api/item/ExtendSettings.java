package ml.pkom.mcpitanlibarch.api.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;

public class ExtendSettings extends Item.Settings {
    public ExtendSettings addGroup(ItemGroup itemGroup) {
        super.group(itemGroup);
        return this;
    }

    // Support 1.19.3～
    // identifier: Item ID
    // ～1.19.2 setGroup...
    public ExtendSettings addGroup(ItemGroup itemGroup, Identifier identifier) {
        //CreativeTabRegistry.append(itemGroup, ItemUtil.fromId(identifier));
        return addGroup(itemGroup);
    }
}
