package ml.pkom.mcpitanlibarch.api.util;

import ml.pkom.mcpitanlibarch.api.item.CompatibleItemSettings;
import ml.pkom.mcpitanlibarch.api.tag.TagKey;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import java.util.List;

@Deprecated
public class ItemUtil {
    private static net.pitan76.mcpitanlib.api.util.ItemUtil newItemUtil = new net.pitan76.mcpitanlib.api.util.ItemUtil();

    public static Item item(Identifier id) {
        return newItemUtil.item(id);
    }

    public static boolean isEqual(Item item, Item item2) {
        return newItemUtil.isEqual(item, item2);
    }

    public static boolean isOf(ItemStack stack, Item item) {
        return newItemUtil.isOf(stack, item);
    }

    public static boolean isIn(ItemStack stack, TagKey<Item> tagKey) {
        return newItemUtil.isIn(stack, tagKey);
    }

    public static boolean isIn(Item item, TagKey<Item> tagKey) {
        return newItemUtil.isIn(item, tagKey);
    }

    public static boolean isExist(Identifier identifier) {
        return newItemUtil.isExist(identifier);
    }
    public static Identifier toID(Item item) {
        return newItemUtil.toID(item);
    }

    public static Item fromId(Identifier identifier) {
        return newItemUtil.fromId(identifier);
    }

    @Deprecated
    public static BlockItem ofBlock(Block block, Item.Settings settings) {
        return newItemUtil.ofBlock(block, settings);
    }

    public static BlockItem ofBlock(Block block, CompatibleItemSettings settings) {
        return newItemUtil.ofBlock(block, settings);
    }

    @Deprecated
    public static Item of(Item.Settings settings) {
        return newItemUtil.of(settings);
    }

    public static Item of(CompatibleItemSettings settings) {
        return newItemUtil.of(settings);
    }

    public static List<Item> getAllItems() {
        return newItemUtil.getAllItems();
    }

    public static int getRawId(Item item) {
        return newItemUtil.getRawId(item);
    }

    public static Item fromIndex(int index) {
        return newItemUtil.fromIndex(index);
    }
}
