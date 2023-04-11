package ml.pkom.mcpitanlibarch.api.util;

import ml.pkom.mcpitanlibarch.api.item.ArmorEquipmentType;
import ml.pkom.mcpitanlibarch.api.item.CompatibleArmorMaterial;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

public class EquipMaterialUtil {
    public static ToolMaterial createToolMaterial(int durability, float miningSpeedMultiplier, float attackDamage, int miningLevel, int enchantability, Ingredient repairIngredient) {
        return new ToolMaterial() {
            @Override
            public int getDurability() {
                return durability;
            }

            @Override
            public float getMiningSpeedMultiplier() {
                return miningSpeedMultiplier;
            }

            @Override
            public float getAttackDamage() {
                return attackDamage;
            }

            @Override
            public int getMiningLevel() {
                return miningLevel;
            }

            @Override
            public int getEnchantability() {
                return enchantability;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return repairIngredient;
            }
        };
    }

    public static int toInt(ArmorEquipmentType type) {
        switch (type.getSlot()) {
            case HEAD:
                return 0;
            case CHEST:
                return 1;
            case LEGS:
                return 2;
            case FEET:
                return 3;
            default:
                return 0;
        }
    }

    public static CompatibleArmorMaterial createArmorMaterial(int[] durability, int[] protection, int enchantability, SoundEvent equipSound, Ingredient repairIngredient, String name, float toughness, float knockbackResistance) {

        return new CompatibleArmorMaterial() {
            @Override
            public int getDurability(ArmorEquipmentType type) {
                return durability[toInt(type)];
            }

            @Override
            public int getProtection(ArmorEquipmentType type) {
                return protection[toInt(type)];
            }

            @Override
            public int getEnchantability() {
                return enchantability;
            }

            @Override
            public SoundEvent getEquipSound() {
                return equipSound;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return repairIngredient;
            }

            @Override
            public String getName() {
                return name;
            }

            @Override
            public float getToughness() {
                return toughness;
            }

            @Override
            public float getKnockbackResistance() {
                return knockbackResistance;
            }
        };
    }
}
