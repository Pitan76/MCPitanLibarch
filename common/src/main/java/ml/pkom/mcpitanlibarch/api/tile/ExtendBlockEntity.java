package ml.pkom.mcpitanlibarch.api.tile;

import ml.pkom.mcpitanlibarch.api.block.ExtendBlockEntityProvider;
import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import ml.pkom.mcpitanlibarch.api.event.tile.TileTickEvent;
import ml.pkom.mcpitanlibarch.api.packet.UpdatePacketType;
import ml.pkom.mcpitanlibarch.api.world.ExtendWorld;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.util.Tickable;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ExtendBlockEntity extends BlockEntity implements Tickable {
    ExtendWorld world;
    public ExtendBlockEntity(BlockEntityType<?> type) {
        super(type);
    }

    public ExtendBlockEntity(BlockEntityType<?> type, TileCreateEvent event) {
        this(type);
    }

    public void setWorld(World world) {
        super.setLocation(world, pos);
        this.world = new ExtendWorld(world);
    }

    @Nullable
    @Override
    @Deprecated
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        switch (getUpdatePacketType().name) {
            case "BLOCK_ENTITY_UPDATE_S2C":
                return BlockEntityUpdateS2CPacket.create(this);
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
        super.fromTag(getCachedState(), nbt);
    }

    @Deprecated
    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        writeNbtOverride(nbt);
        return nbt;
    }

    @Deprecated
    @Override
    public void fromTag(BlockState state, NbtCompound nbt) {
        readNbtOverride(nbt);
    }

    @Override
    public void setLocation(World world, BlockPos pos) {
        super.setLocation(world, pos);
        this.world = new ExtendWorld(world);
    }

    @Override
    public void tick() {
        if (this instanceof ExtendBlockEntityTicker) {
            Block block = world.getMinecraftWorld().getBlockState(pos).getBlock();
            if (block instanceof ExtendBlockEntityProvider && ((ExtendBlockEntityProvider) block).isTick()) {

                ExtendBlockEntityTicker<?> ticker = (ExtendBlockEntityTicker<?>) this;
                ticker.tick(new TileTickEvent(world.getMinecraftWorld(), pos, getCachedState(), this));
            }
        }
    }
}
