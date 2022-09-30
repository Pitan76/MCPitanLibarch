package ml.pkom.mcpitanlibarch.api.nbt;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtType;

public class NbtTag extends NbtCompound {
    public NbtTag() {
        super();
    }

    /**
     * Create NbtTag instance
     * @return NbtTag instance
     */
    public static NbtTag create() {
        return new NbtTag();
    }

    /**
     * Cast to NbtTag
     * @param nbt Nbt Object
     * @return NbtTag
     */
    public static NbtTag from(Object nbt) {
        if (nbt instanceof NbtCompound) {
            return (NbtTag) nbt;
        }
        return (NbtTag) nbt;
    }

    /**
     * Check item stack nbt
     * @param stack Item stack
     * @return boolean
     */
    public static boolean hasNbt(ItemStack stack) {
        return stack.hasTag();
    }

    /**
     * Get nbt from item stack
     * @param stack Item stack
     * @return NbtTag
     */
    public static NbtTag getNbt(ItemStack stack) {
        return from(stack.getTag());
    }

    /**
     * Set nbt to item stack
     * @param stack Item stack
     * @param nbt NbtTag
     */
    public static void setNbt(ItemStack stack, NbtTag nbt) {
        stack.setTag(nbt);
    }

    public boolean contains(String key) {
        return super.contains(key);
    }

    public NbtType<NbtCompound> getNbtType() {
        return super.getNbtType();
    }
}