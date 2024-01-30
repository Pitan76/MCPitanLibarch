package ml.pkom.mcpitanlibarch.api.world;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.PersistentState;

public abstract class CompatiblePersistentState extends PersistentState {

    public static int count = 1;

    // 1.16
    public CompatiblePersistentState(String key) {
        super(key);
    }

    public CompatiblePersistentState() {
        this("mcpitanlibarch_" + count);
        count++;
    }

    // 1.16
    public abstract void readNbt(NbtCompound tag);

    @Override
    public void fromTag(NbtCompound tag) {
        readNbt(tag);
    }
}
