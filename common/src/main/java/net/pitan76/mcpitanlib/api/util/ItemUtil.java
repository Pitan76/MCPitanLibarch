package net.pitan76.mcpitanlib.api.util;

import ml.pkom.mcpitanlibarch.api.item.CompatibleItemSettings;
import ml.pkom.mcpitanlibarch.api.tag.TagKey;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.pitan76.mcpitanlib.api.util.v1.ItemUtilV1;
import net.pitan76.mcpitanlib.api.util.v2.ItemUtilV2;

import java.util.List;

public class ItemUtil {

    /**
     * Get item from Identifier.
     * @param id Identifier of the item.
     * @return Item of the Identifier.
     */
    public static Item item(Identifier id) {
        return ItemUtilV1.item(id);
    }

    /**
     * Check if two items are equal.
     * @param item Item to compare.
     * @param item2 Item to compare.
     * @return If two items are equal.
     */
    public static boolean isEqual(Item item, Item item2) {
        return ItemUtilV1.isEqual(item, item2);
    }

    /**
     * Check if the item is of the given item.
     * @param stack ItemStack to check.
     * @param item Item to check.
     * @return If the item is of the given item.
     */
    public static boolean isOf(ItemStack stack, Item item) {
        return ItemUtilV1.isOf(stack, item);
    }

    /**
     * Check if the item is in the tag. (MCPitanLib TagKey)
     * @param stack ItemStack to check.
     * @param tagKey TagKey of the tag.
     * @return If the item is in the tag.
     */
    public static boolean isIn(ItemStack stack, TagKey<Item> tagKey) {
        return ItemUtilV1.isIn(stack, tagKey);
    }

    /**
     * Check if the item is in the tag. (MCPitanLib TagKey)
     * @param item Item to check.
     * @param tagKey TagKey of the tag.
     * @return If the item is in the tag.
     */
    public static boolean isIn(Item item, TagKey<Item> tagKey) {
        return ItemUtilV1.isIn(item, tagKey);
    }

    /**
     * Check if the item is existed.
     * @param identifier Identifier of the item.
     * @return If the item is existed.
     */
    public static boolean isExist(Identifier identifier) {
        return ItemUtilV1.isExist(identifier);
    }

    /**
     * Get Identifier from Item.
     * @param item Item to get Identifier.
     * @return Identifier of the Item.
     */
    public static Identifier toID(Item item) {
        return ItemUtilV1.toID(item);
    }

    /**
     * Get item from Identifier.
     * @param identifier Identifier of the item.
     * @return Item of the Identifier.
     */
    public static Item fromId(Identifier identifier) {
        return ItemUtilV1.fromId(identifier);
    }

    /**
     * Create BlockItem from Block and Item.Settings.
     * @param block Block to create BlockItem.
     * @param settings Item.Settings to create BlockItem.
     * @return BlockItem created from Block and Item.Settings.
     */
    @Deprecated
    public static BlockItem ofBlock(Block block, Item.Settings settings) {
        return ItemUtilV1.ofBlock(block, settings);
    }

    /**
     * Create BlockItem from Block and CompatibleItemSettings.
     * @param block Block to create BlockItem.
     * @param settings CompatibleItemSettings to create BlockItem.
     * @return BlockItem created from Block and CompatibleItemSettings.
     */
    public static BlockItem ofBlock(Block block, CompatibleItemSettings settings) {
        return ItemUtilV1.ofBlock(block, settings);
    }

    /**
     * Create Item from Item.Settings.
     * @param settings Item.Settings to create Item.
     * @return Item created from Item.Settings.
     */
    @Deprecated
    public static Item of(Item.Settings settings) {
        return ItemUtilV1.of(settings);
    }

    /**
     * Create Item from CompatibleItemSettings.
     * @param settings CompatibleItemSettings to create Item.
     * @return Item created from CompatibleItemSettings.
     */
    public static Item of(CompatibleItemSettings settings) {
        return ItemUtilV1.of(settings);
    }

    /**
     * Get all items.
     * @return List of all items.
     */
    public static List<Item> getAllItems() {
        return ItemUtilV1.getAllItems();
    }

    /**
     * Get raw id of the item.
     * @param item Item to get raw id.
     * @return Raw id of the item.
     */
    public static int getRawId(Item item) {
        return ItemUtilV1.getRawId(item);
    }

    /**
     * Get item from index.
     * @param index Index of the item.
     * @return Item of the index.
     */
    public static Item fromIndex(int index) {
        return ItemUtilV1.fromIndex(index);
    }

    /**
     * Get all items in the tag. (MCPitanLib TagKey)
     * @param tagKey TagKey of the tag.
     * @return List of items in the tag.
     */
    public static List<Item> getItems(TagKey<Item> tagKey) {
        return ItemUtilV2.getItems(tagKey);
    }

    /**
     * Get given the list of items in the tag. (MCPitanLib TagKey)
     * @param tagKey TagKey of the tag.
     * @param items List of items to search.
     * @return List of items in the tag.
     */
    public static List<Item> getItems(TagKey<Item> tagKey, List<Item> items) {
        return ItemUtilV2.getItems(tagKey, items);
    }

    /**
     * Get all items in the tag.
     * @param identifier Identifier of the tag.
     * @return List of items in the tag.
     */
    public static List<Item> getItems(Identifier identifier) {
        return ItemUtilV2.getItems(identifier);
    }

    /**
     * Get given the list of items in the tag.
     * @param identifier Identifier of the tag.
     * @param items List of items to search.
     * @return List of items in the tag.
     */
    public static List<Item> getItems(Identifier identifier, List<Item> items) {
        return ItemUtilV2.getItems(identifier, items);
    }

    /**
     * Get all items in the tag.
     * @param id String of the tag.
     * @return List of items in the tag.
     */
    public static List<Item> getItems(String id) {
        return ItemUtilV2.getItems(id);
    }

    /**
     * Get given the list of items in the tag.
     * @param id String of the tag.
     * @param items List of items to search.
     * @return List of items in the tag.
     */
    public static List<Item> getItems(String id, List<Item> items) {
        return ItemUtilV2.getItems(id, items);
    }
}
