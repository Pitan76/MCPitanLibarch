package ml.pkom.mcpitanlibarch.api.item;

import net.minecraft.item.ItemGroup;

public class DefaultItemGroups {
    public static final ItemGroup BUILDING_BLOCKS = ItemGroup.BUILDING_BLOCKS;
    public static final ItemGroup COLORED_BLOCKS = ItemGroup.BUILDING_BLOCKS;
    public static final ItemGroup NATURAL = ItemGroup.DECORATIONS;
    public static final ItemGroup FUNCTIONAL = ItemGroup.TRANSPORTATION;
    public static final ItemGroup REDSTONE = ItemGroup.REDSTONE;
    public static final ItemGroup HOTBAR = ItemGroup.HOTBAR;
    public static final ItemGroup SEARCH = ItemGroup.SEARCH;
    public static final ItemGroup TOOLS = ItemGroup.TOOLS;
    public static final ItemGroup COMBAT = ItemGroup.COMBAT;
    public static final ItemGroup FOOD_AND_DRINK = ItemGroup.FOOD;
    public static final ItemGroup INGREDIENTS = ItemGroup.MISC;
    public static final ItemGroup SPAWN_EGGS = ItemGroup.MISC;
    public static final ItemGroup OPERATOR = ItemGroup.MISC;
    public static final ItemGroup INVENTORY = ItemGroup.INVENTORY;

    // ～1.19.2 Item Group
    public static final ItemGroup BREWING = ItemGroup.BREWING; // if version is 1.19.3, FOOD_AND_DRINK
    public static final ItemGroup TRANSPORTATION = ItemGroup.TRANSPORTATION; // if version is 1.19.3, FUNCTIONAL
    public static final ItemGroup DECORATIONS = ItemGroup.DECORATIONS; // if version is 1.19.3, NATURAL
    public static final ItemGroup MISC = ItemGroup.MISC; // if version is 1.19.3, INGREDIENTS
}
