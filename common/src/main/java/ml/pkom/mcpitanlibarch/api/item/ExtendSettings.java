package ml.pkom.mcpitanlibarch.api.item;

import dev.architectury.registry.CreativeTabRegistry;
import ml.pkom.mcpitanlibarch.api.util.ItemUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ExtendSettings extends Item.Settings {

    public ExtendSettings addGroup(ItemGroup itemGroup) {
        return this;
    }

    // Support 1.19.3～
    // identifier: Item ID
    public ExtendSettings addGroup(ItemGroup itemGroup, Identifier identifier) {
        CreativeTabManager.addItem(itemGroup, identifier);
        return this;
    }


}
