package ml.pkom.mcpitanlibarch.api.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

public interface CompatibleArmorMaterial extends ArmorMaterial {
    int getDurability(ArmorEquipmentType type);

    int getProtection(ArmorEquipmentType type);

    @Override
    @Deprecated
    default int getDurability(EquipmentSlot slot) {
        return getDurability(ArmorEquipmentType.of(slot));
    }

    @Override
    @Deprecated
    default int getProtectionAmount(EquipmentSlot slot) {
        return getProtection(ArmorEquipmentType.of(slot));
    }

    int getEnchantability();

    SoundEvent getEquipSound();

    Ingredient getRepairIngredient();

    String getName();

    float getToughness();

    float getKnockbackResistance();
}
