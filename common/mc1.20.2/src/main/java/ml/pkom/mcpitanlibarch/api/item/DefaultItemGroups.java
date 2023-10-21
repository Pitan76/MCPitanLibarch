package ml.pkom.mcpitanlibarch.api.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;

public class DefaultItemGroups {
    public static final ItemGroup BUILDING_BLOCKS = Registries.ITEM_GROUP.get(ItemGroups.BUILDING_BLOCKS);
    public static final ItemGroup COLORED_BLOCKS = Registries.ITEM_GROUP.get(ItemGroups.COLORED_BLOCKS); // if 1.19.2 and below, BUILDING_BLOCKS
    public static final ItemGroup NATURAL = Registries.ITEM_GROUP.get(ItemGroups.NATURAL); // if 1.19.2 and below, DECORATIONS
    public static final ItemGroup FUNCTIONAL = Registries.ITEM_GROUP.get(ItemGroups.FUNCTIONAL); // if 1.19.2 and below, TRANSPORTATION
    public static final ItemGroup REDSTONE = Registries.ITEM_GROUP.get(ItemGroups.REDSTONE);
    public static final ItemGroup HOTBAR = Registries.ITEM_GROUP.get(ItemGroups.HOTBAR);
    public static final ItemGroup SEARCH = Registries.ITEM_GROUP.get(ItemGroups.SEARCH);
    public static final ItemGroup TOOLS = Registries.ITEM_GROUP.get(ItemGroups.TOOLS);
    public static final ItemGroup COMBAT = Registries.ITEM_GROUP.get(ItemGroups.COMBAT);
    public static final ItemGroup FOOD_AND_DRINK = Registries.ITEM_GROUP.get(ItemGroups.FOOD_AND_DRINK); // if 1.19.2 and below, FOOD
    public static final ItemGroup INGREDIENTS = Registries.ITEM_GROUP.get(ItemGroups.INGREDIENTS); // if 1.19.2 and below, MISC
    public static final ItemGroup SPAWN_EGGS = Registries.ITEM_GROUP.get(ItemGroups.SPAWN_EGGS); // if 1.19.2 and below, MISC
    public static final ItemGroup OPERATOR = Registries.ITEM_GROUP.get(ItemGroups.OPERATOR); // if 1.19.2 and below, MISC
    public static final ItemGroup INVENTORY = Registries.ITEM_GROUP.get(ItemGroups.INVENTORY);

    // ～1.19.2 Item Group
    public static final ItemGroup BREWING = FOOD_AND_DRINK;
    public static final ItemGroup TRANSPORTATION = FUNCTIONAL;
    public static final ItemGroup DECORATIONS = NATURAL;
    public static final ItemGroup MISC = INGREDIENTS;
}