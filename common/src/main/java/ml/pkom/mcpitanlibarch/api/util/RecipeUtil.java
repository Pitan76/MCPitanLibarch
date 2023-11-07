package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RecipeUtil {
    public static ShapelessRecipe createShapelessRecipe(Identifier id, String group, CompatibilityCraftingRecipeCategory category, ItemStack output, DefaultedList<Ingredient> input) {
        return createShapelessRecipe(id, group, output, input);
    }

    public static ShapelessRecipe createShapelessRecipe(Identifier id, String group, ItemStack output, DefaultedList<Ingredient> input) {
        return new ShapelessRecipe(id, group, output, input);
    }

    public static <C extends Inventory> ItemStack craft(Recipe<C> recipe, C inventory, World world) {
        return recipe.craft(inventory);
    }

    public static <C extends Inventory> ItemStack getOutput(Recipe<C> recipe, World world) {
        return recipe.getOutput();
    }

    public static List<Recipe<?>> getAllRecipes(World world) {
        Collection<Recipe<?>> recipes = world.getRecipeManager().values();
        return recipes.stream().toList();
    }

    public enum CompatibilityCraftingRecipeCategory {
        BUILDING,
        REDSTONE,
        EQUIPMENT,
        MISC;
    }
}
