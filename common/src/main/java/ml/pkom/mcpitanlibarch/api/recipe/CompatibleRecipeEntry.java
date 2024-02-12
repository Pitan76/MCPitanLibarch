package ml.pkom.mcpitanlibarch.api.recipe;

import ml.pkom.mcpitanlibarch.api.util.RecipeUtil;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class CompatibleRecipeEntry {
    private final Recipe<?> recipe;

    private Identifier id;

    public String group = "";
    public RecipeUtil.CompatibilityCraftingRecipeCategory category = null;

    @Deprecated
    public CompatibleRecipeEntry(Recipe<?> recipe) {
        this.recipe = recipe;
    }

    public CompatibleRecipeEntry(Identifier id, String group, RecipeUtil.CompatibilityCraftingRecipeCategory category, ShapelessRecipe shapelessRecipe) {
        this.recipe = shapelessRecipe;
        this.id = id;
        this.group = group;
        this.category = category;
    }

    public Recipe<?> getRecipe() {
        return recipe;
    }

    public Identifier getId() {
        return id;
    }

    public RecipeType<?> getType() {
        Recipe<?> recipe = getRecipe();
        if (recipe == null) return null;

        return recipe.getType();
    }

    public RecipeSerializer<?> getSerializer() {
        Recipe<?> recipe = getRecipe();
        if (recipe == null) return null;

        return recipe.getSerializer();
    }

    @Nullable
    public RecipeUtil.CompatibilityCraftingRecipeCategory getCategory() {
        return category;
    }

    public String getGroup() {
        return group;
    }
}
