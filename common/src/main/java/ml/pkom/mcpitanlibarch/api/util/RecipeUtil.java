package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;

public class RecipeUtil {
    public static ShapelessRecipe createShapelessRecipe(Identifier id, String group, CompatibilityCraftingRecipeCategory category, ItemStack output, DefaultedList<Ingredient> input) {
        return new ShapelessRecipe(id, group, CraftingRecipeCategory.valueOf(category.name()), output, input);
    }

    public static ShapelessRecipe createShapelessRecipe(Identifier id, String group, ItemStack output, DefaultedList<Ingredient> input) {
        return createShapelessRecipe(id, group, CompatibilityCraftingRecipeCategory.MISC, output, input);
    }

    public enum CompatibilityCraftingRecipeCategory {
        BUILDING,
        REDSTONE,
        EQUIPMENT,
        MISC;
    }
}
