package ml.pkom.mcpitanlibarch.api.item;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class CompatibleItemSettings {
    private final ExtendSettings settings = new ExtendSettings();

    public static CompatibleItemSettings of() {
        return new CompatibleItemSettings();
    }

    // ～1.19.2
    public CompatibleItemSettings addGroup(ItemGroup itemGroup) {
        settings.addGroup(itemGroup);
        return this;
    }

    // 1.19.3～
    // identifier: Item ID
    public CompatibleItemSettings addGroup(ItemGroup itemGroup, Identifier identifier) {
        settings.addGroup(itemGroup, identifier);
        return this;
    }

    public CompatibleItemSettings maxCount(int maxCount) {
        settings.maxCount(maxCount);
        return this;
    }

    public CompatibleItemSettings maxDamage(int maxDamage) {
        settings.maxDamage(maxDamage);
        return this;
    }

    public CompatibleItemSettings maxDamageIfAbsent(int maxDamage) {
        settings.maxDamageIfAbsent(maxDamage);
        return this;
    }

    public CompatibleItemSettings food(FoodComponent foodComponent) {
        settings.food(foodComponent);
        return this;
    }

    public CompatibleItemSettings rarity(Rarity rarity) {
        settings.rarity(rarity);
        return this;
    }

    public CompatibleItemSettings recipeRemainder(Item recipeRemainder) {
        settings.recipeRemainder(recipeRemainder);
        return this;
    }

    public ExtendSettings build() {
        return settings;

    }
}
