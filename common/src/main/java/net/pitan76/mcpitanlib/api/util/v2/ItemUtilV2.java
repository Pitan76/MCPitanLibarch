package net.pitan76.mcpitanlib.api.util.v2;

import ml.pkom.mcpitanlibarch.api.tag.TagKey;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.pitan76.mcpitanlib.api.util.ItemUtil;

import java.util.ArrayList;
import java.util.List;

public class ItemUtilV2 {
    /**
     * Get all items in the tag.
     * @param tagKey TagKey of the tag.
     * @return List of items in the tag.
     */
    public static List<Item> getItems(TagKey<Item> tagKey) {
        return getItems(tagKey, ItemUtil.getAllItems());
    }

    /**
     * Get given the list of items in the tag.
     * @param tagKey TagKey of the tag.
     * @param items List of items to search.
     * @return List of items in the tag.
     */
    public static List<Item> getItems(TagKey<Item> tagKey, List<Item> items) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (!ItemUtil.isIn(item, tagKey)) continue;
            result.add(item);
        }
        return result;
    }

    /**
     * Get all items in the tag.
     * @param identifier Identifier of the tag.
     * @return List of items in the tag.
     */
    public static List<Item> getItems(Identifier identifier) {
        return getItems((TagKey<Item>) TagKey.create(TagKey.Type.ITEM, identifier));
    }

    /**
     * Get given the list of items in the tag.
     * @param identifier Identifier of the tag.
     * @param items List of items to search.
     * @return List of items in the tag.
     */
    public static List<Item> getItems(Identifier identifier, List<Item> items) {
        return getItems((TagKey<Item>) TagKey.create(TagKey.Type.ITEM, identifier), items);
    }

    /**
     * Get all items in the tag.
     * @param id String of the tag.
     * @return List of items in the tag.
     */
    public static List<Item> getItems(String id) {
        return getItems(new Identifier(id));
    }

    /**
     * Get given the list of items in the tag.
     * @param id String of the tag.
     * @param items List of items to search.
     * @return List of items in the tag.
     */
    public static List<Item> getItems(String id, List<Item> items) {
        return getItems(new Identifier(id), items);
    }
}
