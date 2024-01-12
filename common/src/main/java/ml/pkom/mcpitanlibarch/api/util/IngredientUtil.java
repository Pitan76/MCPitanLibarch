package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.recipe.Ingredient;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.Identifier;

public class IngredientUtil {
    public static Ingredient fromTagByIdentifier(Identifier id) {
        return Ingredient.fromTag(ItemTags.getTagGroup().getTagOrEmpty(id));
    }

    public static Ingredient fromTagByString(String id) {
        return fromTagByIdentifier(new Identifier(id));
    }
}
