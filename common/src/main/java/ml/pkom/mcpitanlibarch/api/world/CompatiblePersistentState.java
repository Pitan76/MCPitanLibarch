package ml.pkom.mcpitanlibarch.api.world;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.PersistentState;

public abstract class CompatiblePersistentState extends PersistentState {
    // 1.16
    public CompatiblePersistentState(String key) {
        super();
    }

    public CompatiblePersistentState() {
        super();
    }

    // 1.16
    public abstract void readNbt(NbtCompound tag);
}
