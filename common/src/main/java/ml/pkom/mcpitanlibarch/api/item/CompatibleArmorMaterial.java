package ml.pkom.mcpitanlibarch.api.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

public interface CompatibleArmorMaterial extends ArmorMaterial {
    int getDurability(ArmorEquipmentType type);

    int getProtection(ArmorEquipmentType type);

    @Override
    @Deprecated
    default int getDurability(ArmorItem.Type type) {
        return getDurability(ArmorEquipmentType.of(type));
    }

    @Override
    @Deprecated
    default int getProtection(ArmorItem.Type type) {
        return getProtection(ArmorEquipmentType.of(type));
    }

    int getEnchantability();

    SoundEvent getEquipSound();

    Ingredient getRepairIngredient();

    String getName();

    float getToughness();

    float getKnockbackResistance();
}
