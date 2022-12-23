package ml.pkom.mcpitanlibarch.api.item;

import net.minecraft.item.ItemGroup;

public class DefaultItemGroups {

    public static final ItemGroup BUILDING_BLOCKS;
    public static final ItemGroup COLORED_BLOCKS;
    public static final ItemGroup NATURAL;
    public static final ItemGroup FUNCTIONAL;
    public static final ItemGroup REDSTONE;
    public static final ItemGroup HOTBAR;
    public static final ItemGroup SEARCH;
    public static final ItemGroup TOOLS;
    public static final ItemGroup COMBAT;
    public static final ItemGroup FOOD_AND_DRINK;
    public static final ItemGroup INGREDIENTS;
    public static final ItemGroup SPAWN_EGGS;
    public static final ItemGroup OPERATOR;
    public static final ItemGroup INVENTORY;

    // ～1.19.2 Item Group
    public static final ItemGroup BREWING; // if version is 1.19.3, FOOD_AND_DRINK
    public static final ItemGroup TRANSPORTATION; // if version is 1.19.3, FUNCTIONAL
    public static final ItemGroup DECORATIONS; // if version is 1.19.3, NATURAL
    public static final ItemGroup MISC; // if version is 1.19.3, INGREDIENTS
    
    static {
        BUILDING_BLOCKS = ItemGroup.BUILDING_BLOCKS;
        COLORED_BLOCKS = ItemGroup.BUILDING_BLOCKS;
        NATURAL = ItemGroup.DECORATIONS;
        FUNCTIONAL = ItemGroup.TRANSPORTATION;
        REDSTONE = ItemGroup.REDSTONE;

        ItemGroup HOTBAR_TMP;
        try {
            HOTBAR_TMP = ItemGroup.HOTBAR;
        } catch (Exception ignored) {
            HOTBAR_TMP = null;
        }

        HOTBAR = HOTBAR_TMP;

        ItemGroup SEARCH_TMP;
        try {
            SEARCH_TMP = ItemGroup.SEARCH;
        } catch (Exception ignored) {
            SEARCH_TMP = null;
        }
        SEARCH = SEARCH_TMP;
        TOOLS = ItemGroup.TOOLS;
        COMBAT = ItemGroup.COMBAT;
        FOOD_AND_DRINK = ItemGroup.FOOD;
        INGREDIENTS = ItemGroup.MISC;
        SPAWN_EGGS = ItemGroup.MISC;
        OPERATOR = ItemGroup.MISC;

        ItemGroup INVENTORY_TMP;
        try {
            INVENTORY_TMP = ItemGroup.INVENTORY;
        } catch (Exception ignored) {
            INVENTORY_TMP = null;
        }
        INVENTORY = INVENTORY_TMP;
        BREWING = ItemGroup.BREWING;
        TRANSPORTATION = ItemGroup.TRANSPORTATION; 
        DECORATIONS = ItemGroup.DECORATIONS; 
        MISC = ItemGroup.MISC; 
    }
}
