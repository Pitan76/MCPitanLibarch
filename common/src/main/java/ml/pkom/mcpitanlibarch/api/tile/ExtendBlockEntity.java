package ml.pkom.mcpitanlibarch.api.tile;

import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import ml.pkom.mcpitanlibarch.api.packet.UpdatePacketType;
import ml.pkom.mcpitanlibarch.api.world.ExtendWorld;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ExtendBlockEntity extends BlockEntity {
    public ExtendWorld world;
    public ExtendBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public ExtendBlockEntity(BlockEntityType<?> type, TileCreateEvent event) {
        this(type, event.getBlockPos(), event.getBlockState());
    }

    @Override
    @Deprecated
    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        switch (getUpdatePacketType().name) {
            case "BLOCK_ENTITY_UPDATE_S2C":
                NbtCompound nbt = new NbtCompound();
                writeNbtOverride(nbt);
                return new BlockEntityUpdateS2CPacket(getPos(), 1, nbt);
        }
        return super.toUpdatePacket();
    }

    public UpdatePacketType getUpdatePacketType() {
        return UpdatePacketType.NONE;
    }

    public void writeNbtOverride(NbtCompound nbt) {
        super.writeNbt(nbt);
    }

    public void readNbtOverride(NbtCompound nbt) {
        super.readNbt(nbt);
    }

    @Deprecated
    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        writeNbtOverride(nbt);
        return nbt;
    }

    @Deprecated
    @Override
    public void readNbt(NbtCompound nbt) {
        readNbtOverride(nbt);
    }

    @Override
    public void setWorld(World world) {
        super.setWorld(world);
        this.world = new ExtendWorld(world);
    }
}
