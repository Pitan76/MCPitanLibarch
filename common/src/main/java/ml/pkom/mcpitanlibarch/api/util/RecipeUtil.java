package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RecipeUtil {
    public static ShapelessRecipe createShapelessRecipe(Identifier id, String group, CompatibilityCraftingRecipeCategory category, ItemStack output, DefaultedList<Ingredient> input) {
        return new ShapelessRecipe(id, group, CraftingRecipeCategory.valueOf(category.name()), output, input);
    }

    public static ShapelessRecipe createShapelessRecipe(Identifier id, String group, ItemStack output, DefaultedList<Ingredient> input) {
        return createShapelessRecipe(id, group, CompatibilityCraftingRecipeCategory.MISC, output, input);
    }

    public static <C extends Inventory> ItemStack craft(Recipe<C> recipe, C inventory, World world) {
        return recipe.craft(inventory);
    }

    public static <C extends Inventory> ItemStack getOutput(Recipe<C> recipe, World world) {
        return recipe.getOutput();
    }

    public static List<Recipe<?>> getAllRecipes(World world) {
        Collection<RecipeEntry<?>> recipes = world.getRecipeManager().values();
        List<Recipe<?>> outRecipes = new ArrayList<>();
        for (RecipeEntry<?> recipeEntry : recipes) {
            Recipe<?> recipe = recipeEntry.value();
            outRecipes.add(recipe);
        }
        return outRecipes;
    }

    public enum CompatibilityCraftingRecipeCategory {
        BUILDING,
        REDSTONE,
        EQUIPMENT,
        MISC;
    }
}
