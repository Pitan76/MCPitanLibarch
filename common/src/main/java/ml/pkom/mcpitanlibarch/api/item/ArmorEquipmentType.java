package ml.pkom.mcpitanlibarch.api.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import org.jetbrains.annotations.Nullable;

public class ArmorEquipmentType {

    public static ArmorEquipmentType HEAD = new ArmorEquipmentType(EquipmentSlot.HEAD, ArmorItem.Type.HELMET);
    public static ArmorEquipmentType CHEST = new ArmorEquipmentType(EquipmentSlot.CHEST, ArmorItem.Type.CHESTPLATE);
    public static ArmorEquipmentType LEGS = new ArmorEquipmentType(EquipmentSlot.LEGS, ArmorItem.Type.LEGGINGS);
    public static ArmorEquipmentType FEET = new ArmorEquipmentType(EquipmentSlot.FEET, ArmorItem.Type.BOOTS);

    protected final EquipmentSlot slot;
    protected final ArmorItem.Type type;

    protected ArmorEquipmentType(EquipmentSlot slot, ArmorItem.Type type) {
        this.slot = slot;
        this.type = type;
    }

    @Deprecated
    public EquipmentSlot getSlot() {
        return slot;
    }

    @Deprecated
    public ArmorItem.Type getType() {
        return type;
    }

    @Nullable
    public static ArmorEquipmentType of(EquipmentSlot slot) {
        switch (slot) {
            case HEAD -> {
                return HEAD;
            }
            case CHEST -> {
                return CHEST;
            }
            case LEGS -> {
                return LEGS;
            }
            case FEET -> {
                return FEET;
            }
            default -> {
                return null;
            }
        }
    }

    @Nullable
    public static ArmorEquipmentType of(ArmorItem.Type type) {
        switch (type) {
            case HELMET -> {
                return HEAD;
            }
            case CHESTPLATE -> {
                return CHEST;
            }
            case LEGGINGS -> {
                return LEGS;
            }
            case BOOTS -> {
                return FEET;
            }
            default -> {
                return null;
            }
        }
    }
}
