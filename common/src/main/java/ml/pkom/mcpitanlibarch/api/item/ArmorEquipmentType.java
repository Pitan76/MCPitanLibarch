package ml.pkom.mcpitanlibarch.api.item;

import net.minecraft.entity.EquipmentSlot;
import org.jetbrains.annotations.Nullable;

public class ArmorEquipmentType {
    // 1.19.4～ ArmorItem.Type

    public static ArmorEquipmentType HEAD = new ArmorEquipmentType(EquipmentSlot.HEAD);
    public static ArmorEquipmentType CHEST = new ArmorEquipmentType(EquipmentSlot.CHEST);
    public static ArmorEquipmentType LEGS = new ArmorEquipmentType(EquipmentSlot.LEGS);
    public static ArmorEquipmentType FEET = new ArmorEquipmentType(EquipmentSlot.FEET);

    protected final EquipmentSlot slot;

    protected ArmorEquipmentType(EquipmentSlot slot) {
        this.slot = slot;
    }

    @Deprecated
    public EquipmentSlot getSlot() {
        return slot;
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
}
