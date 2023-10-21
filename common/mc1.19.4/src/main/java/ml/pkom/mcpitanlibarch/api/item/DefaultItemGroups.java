package ml.pkom.mcpitanlibarch.api.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;

public class DefaultItemGroups {
    public static final ItemGroup BUILDING_BLOCKS = ItemGroups.BUILDING_BLOCKS;
    public static final ItemGroup COLORED_BLOCKS = ItemGroups.COLORED_BLOCKS; // if 1.19.2 and below, BUILDING_BLOCKS
    public static final ItemGroup NATURAL = ItemGroups.NATURAL; // if 1.19.2 and below, DECORATIONS
    public static final ItemGroup FUNCTIONAL = ItemGroups.FUNCTIONAL; // if 1.19.2 and below, TRANSPORTATION
    public static final ItemGroup REDSTONE = ItemGroups.REDSTONE;
    public static final ItemGroup HOTBAR = ItemGroups.HOTBAR;
    public static final ItemGroup SEARCH = ItemGroups.SEARCH;
    public static final ItemGroup TOOLS = ItemGroups.TOOLS;
    public static final ItemGroup COMBAT = ItemGroups.COMBAT;
    public static final ItemGroup FOOD_AND_DRINK = ItemGroups.FOOD_AND_DRINK; // if 1.19.2 and below, FOOD
    public static final ItemGroup INGREDIENTS = ItemGroups.INGREDIENTS; // if 1.19.2 and below, MISC
    public static final ItemGroup SPAWN_EGGS = ItemGroups.SPAWN_EGGS; // if 1.19.2 and below, MISC
    public static final ItemGroup OPERATOR = ItemGroups.OPERATOR; // if 1.19.2 and below, MISC
    public static final ItemGroup INVENTORY = ItemGroups.INVENTORY;

    // ～1.19.2 Item Group
    public static final ItemGroup BREWING = FOOD_AND_DRINK;
    public static final ItemGroup TRANSPORTATION = FUNCTIONAL;
    public static final ItemGroup DECORATIONS = NATURAL;
    public static final ItemGroup MISC = INGREDIENTS;
}