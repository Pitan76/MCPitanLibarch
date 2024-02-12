package ml.pkom.mcpitanlibarch.api.recipe;

import ml.pkom.mcpitanlibarch.api.util.RecipeUtil;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class CompatibleRecipeEntry {
    private final RecipeEntry<?> entry;

    public String group = "";
    public RecipeUtil.CompatibilityCraftingRecipeCategory category = null;

    @Deprecated
    public CompatibleRecipeEntry(RecipeEntry<?> entry) {
        this.entry = entry;
    }

    public CompatibleRecipeEntry(Identifier id, String group, RecipeUtil.CompatibilityCraftingRecipeCategory category, ShapelessRecipe shapelessRecipe) {
        this.entry = new RecipeEntry<>(id, shapelessRecipe);
        this.group = group;
        this.category = category;
    }

    @Deprecated
    public RecipeEntry<?> getRecipeEntry() {
        return entry;
    }

    public Recipe<?> getRecipe() {
        Object object = entry.value();
        if (object instanceof Recipe<?>) {
            return (Recipe<?>) object;
        }
        return null;
    }

    public Identifier getId() {
        return entry.id();
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
