package ml.pkom.mcpitanlibarch.api.entity;

import ml.pkom.mcpitanlibarch.api.nbt.NbtTag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.world.World;

public class ExtendEntity extends Entity {
    public ExtendEntity(EntityType<?> type, World world) {
        super(type, world);
    }

    public void initDataTracker() {
    }

    public void readCustomDataFromNbt(NbtCompound nbt) {

    }

    public void writeCustomDataToNbt(NbtCompound nbt) {

    }

    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return null;
    }

    // 互換性用 (NbtTag型をOverrideすること)
    public void writeNbt(NbtTag nbt) {
        super.writeNbt(nbt);
    }

    public void readNbt(NbtTag nbt) {
        super.readNbt(nbt);
    }

    // 1.18
    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        this.writeNbt(NbtTag.from(nbt));
        return nbt;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        this.readNbt(NbtTag.from(nbt));
    }

    // 1.14
    public NbtCompound toTag(NbtCompound nbt) {
        this.writeNbt(NbtTag.from(nbt));
        return nbt;
    }

    public NbtCompound fromTag(NbtCompound nbt) {
        this.readNbt(NbtTag.from(nbt));
        return nbt;
    }
}