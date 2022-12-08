package ml.pkom.mcpitanlibarch.api.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;

public class DefaultItemGroups {
    public static final ItemGroup BUILDING_BLOCKS = ItemGroups.getGroups().get(0);
    public static final ItemGroup COLORED_BLOCKS = ItemGroups.getGroups().get(1); // if 1.19.2 and below, BUILDING_BLOCKS
    public static final ItemGroup NATURAL = ItemGroups.getGroups().get(2); // if 1.19.2 and below, DECORATIONS
    public static final ItemGroup FUNCTIONAL = ItemGroups.getGroups().get(3); // if 1.19.2 and below, TRANSPORTATION
    public static final ItemGroup REDSTONE = ItemGroups.getGroups().get(4);
    public static final ItemGroup HOTBAR = ItemGroups.getGroups().get(5);
    public static final ItemGroup SEARCH = ItemGroups.getGroups().get(6);
    public static final ItemGroup TOOLS = ItemGroups.getGroups().get(7);
    public static final ItemGroup COMBAT = ItemGroups.getGroups().get(8);
    public static final ItemGroup FOOD_AND_DRINK = ItemGroups.getGroups().get(9); // if 1.19.2 and below, FOOD
    public static final ItemGroup INGREDIENTS = ItemGroups.getGroups().get(10); // if 1.19.2 and below, MISC
    public static final ItemGroup SPAWN_EGGS = ItemGroups.getGroups().get(11); // if 1.19.2 and below, MISC
    public static final ItemGroup OPERATOR = ItemGroups.getGroups().get(12); // if 1.19.2 and below, MISC
    public static final ItemGroup INVENTORY = ItemGroups.getGroups().get(13);

    // ～1.19.2 Item Group
    public static final ItemGroup BREWING = FOOD_AND_DRINK;
    public static final ItemGroup TRANSPORTATION = FUNCTIONAL;
    public static final ItemGroup DECORATIONS = NATURAL;
    public static final ItemGroup MISC = INGREDIENTS;
}