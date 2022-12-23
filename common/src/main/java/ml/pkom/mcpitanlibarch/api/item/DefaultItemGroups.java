package ml.pkom.mcpitanlibarch.api.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;

public class DefaultItemGroups {
    public static final ItemGroup BUILDING_BLOCKS = getGroup(0);
    public static final ItemGroup COLORED_BLOCKS = getGroup(1); // if 1.19.2 and below, BUILDING_BLOCKS
    public static final ItemGroup NATURAL = getGroup(2); // if 1.19.2 and below, DECORATIONS
    public static final ItemGroup FUNCTIONAL = getGroup(3); // if 1.19.2 and below, TRANSPORTATION
    public static final ItemGroup REDSTONE = getGroup(4);
    public static final ItemGroup HOTBAR = getGroup(5);
    public static final ItemGroup SEARCH = getGroup(6);
    public static final ItemGroup TOOLS = getGroup(7);
    public static final ItemGroup COMBAT = getGroup(8);
    public static final ItemGroup FOOD_AND_DRINK = getGroup(9); // if 1.19.2 and below, FOOD
    public static final ItemGroup INGREDIENTS = getGroup(10); // if 1.19.2 and below, MISC
    public static final ItemGroup SPAWN_EGGS = getGroup(11); // if 1.19.2 and below, MISC
    public static final ItemGroup OPERATOR = getGroup(12); // if 1.19.2 and below, MISC
    public static final ItemGroup INVENTORY = getGroup(13);

    // ～1.19.2 Item Group
    public static final ItemGroup BREWING = FOOD_AND_DRINK;
    public static final ItemGroup TRANSPORTATION = FUNCTIONAL;
    public static final ItemGroup DECORATIONS = NATURAL;
    public static final ItemGroup MISC = INGREDIENTS;

    private static ItemGroup getGroup(int index) {
        try {
            return ItemGroups.getGroups().get(index);
        } catch (Exception ignored) {
            return null;
        }
    }
}