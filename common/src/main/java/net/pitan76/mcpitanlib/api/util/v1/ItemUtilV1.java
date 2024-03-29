package net.pitan76.mcpitanlib.api.util.v1;

import ml.pkom.mcpitanlibarch.api.item.CompatibleItemSettings;
import ml.pkom.mcpitanlibarch.api.tag.TagKey;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ItemUtilV1 {
    public static Item item(Identifier id) {
        return Registries.ITEM.get(id);
    }

    public static boolean isEqual(Item item, Item item2) {
        return item == item2;
    }

    public static boolean isOf(ItemStack stack, Item item) {
        return stack.isOf(item);
    }

    public static boolean isIn(ItemStack stack, TagKey<Item> tagKey) {
        return isIn(stack.getItem(), tagKey);
    }

    public static boolean isIn(Item item, TagKey<Item> tagKey) {
        if (item.getRegistryEntry().isIn(tagKey.getTagKey())) return true;
        return tagKey.isOf(item);
    }

    public static boolean isExist(Identifier identifier) {
        return Registries.ITEM.containsId(identifier);
    }
    public static Identifier toID(Item item) {
        return Registries.ITEM.getId(item);
    }

    public static Item fromId(Identifier identifier) {
        return Registries.ITEM.get(identifier);
    }

    @Deprecated
    public static BlockItem ofBlock(Block block, Item.Settings settings) {
        return new BlockItem(block, settings);
    }

    public static BlockItem ofBlock(Block block, CompatibleItemSettings settings) {
        return ofBlock(block, settings.build());
    }

    @Deprecated
    public static Item of(Item.Settings settings) {
        return new Item(settings);
    }

    public static Item of(CompatibleItemSettings settings) {
        return of(settings.build());
    }

    public static List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        for (Item item : Registries.ITEM) {
            items.add(item);
        }
        return items;
    }

    public static int getRawId(Item item) {
        return Registries.ITEM.getRawId(item);
    }

    public static Item fromIndex(int index) {
        return Registries.ITEM.get(index);
    }
}
