package ml.pkom.mcpitanlibarch.api.util;

import ml.pkom.mcpitanlibarch.api.tag.TagKey;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemUtil {
    public static Item item(Identifier id) {
        return Registry.ITEM.get(id);
    }

    public static boolean isEqual(Item item, Item item2) {
        return item == item2;
    }

    public static boolean isOf(ItemStack stack, Item item) {
        return stack.getItem().equals(item);
    }

    public static boolean isIn(ItemStack stack, TagKey<Item> tagKey) {
        return isIn(stack.getItem(), tagKey);
    }

    public static boolean isIn(Item item, TagKey<Item> tagKey) {
        return tagKey.isOf(item);
    }
}
