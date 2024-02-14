package ml.pkom.mcpitanlibarch.api.event.block;

import ml.pkom.mcpitanlibarch.api.event.BaseEvent;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class StateReplacedEvent extends BaseEvent {

    public BlockState state;
    public World world;
    public BlockPos pos;
    public BlockState newState;
    public boolean moved;

    public StateReplacedEvent(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        this.state = state;
        this.world = world;
        this.pos = pos;
        this.newState = newState;
        this.moved = moved;
    }

    public BlockState getState() {
        return state;
    }

    public World getWorld() {
        return world;
    }

    public BlockPos getPos() {
        return pos;
    }

    public BlockState getNewState() {
        return newState;
    }

    public boolean isMoved() {
        return moved;
    }

    public boolean isClient() {
        return world.isClient();
    }

    /**
     * check if the block is the same state
     * @return boolean
     */
    public boolean isSameState() {
        return state.isOf(newState.getBlock());
    }

    /**
     * check if the block has a block entity
     * @return BlockEntity
     */
    public boolean hasBlockEntity() {
        return world.getBlockEntity(pos) != null;
    }

    /**
     * get the block entity
     * @return BlockEntity
     */
    public BlockEntity getBlockEntity() {
        return world.getBlockEntity(pos);
    }

    /**
     * spawn the drops in the container
     */
    public void spawnDropsInContainer() {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof Inventory) {
            Inventory inventory = (Inventory) blockEntity;
            ItemScatterer.spawn(world, pos, inventory);
        }
    }

    /**
     * update the comparators
     */
    public void updateComparators() {
        world.updateComparators(pos, state.getBlock());
    }
}
