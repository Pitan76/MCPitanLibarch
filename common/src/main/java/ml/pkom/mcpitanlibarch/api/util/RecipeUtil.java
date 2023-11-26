package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RecipeUtil {
    public static ShapelessRecipe createShapelessRecipe(Identifier id, String group, CompatibilityCraftingRecipeCategory category, ItemStack output, DefaultedList<Ingredient> input) {
        return new ShapelessRecipe(group, CraftingRecipeCategory.valueOf(category.name()), output, input);
    }

    public static ShapelessRecipe createShapelessRecipe(Identifier id, String group, ItemStack output, DefaultedList<Ingredient> input) {
        return createShapelessRecipe(id, group, CompatibilityCraftingRecipeCategory.MISC, output, input);
    }

    public static <C extends Inventory> ItemStack craft(Recipe<C> recipe, C inventory, World world) {
        return recipe.craft(inventory, world.getRegistryManager());
    }

    public static <C extends Inventory> ItemStack getOutput(Recipe<C> recipe, World world) {
        return recipe.getResult(world.getRegistryManager());
    }

    public static List<Recipe<?>> getAllRecipes(World world) {
        Collection<RecipeEntry<?>> recipes = world.getRecipeManager().values();
        List<Recipe<?>> outRecipes = new ArrayList<>();
        for (Object recipeEntryObj : recipes) {
            if (recipeEntryObj instanceof RecipeEntry) {
                RecipeEntry<?> recipeEntry = (RecipeEntry<?>) recipeEntryObj;
                if (recipeEntry.value() instanceof Recipe) {
                    outRecipes.add(recipeEntry.value());
                }
            }
        }
        return outRecipes;
    }

    public static RecipeType<?> getType(Recipe<?> recipe) {
        return recipe.getType();
    }

    public static Identifier getId(Recipe<?> recipe) {
        return new Identifier(recipe.getClass().hashCode() + "");
    }

    public enum CompatibilityCraftingRecipeCategory {
        BUILDING,
        REDSTONE,
        EQUIPMENT,
        MISC;
    }
}
