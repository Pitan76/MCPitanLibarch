package ml.pkom.mcpitanlibarch.api.item;

import dev.architectury.registry.CreativeTabRegistry;
import ml.pkom.mcpitanlibarch.api.util.ItemUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;

public class ExtendSettings extends Item.Settings {
    public ExtendSettings addGroup(ItemGroup itemGroup) {
        return this;
    }

    // Support 1.19.3～
    // identifier: Item ID
    public ExtendSettings addGroup(ItemGroup itemGroup, Identifier identifier) {
        CreativeTabRegistry.append(itemGroup, ItemUtil.fromId(identifier));
        return this;
    }
}
