package ml.pkom.mcpitanlibarch.api.event.block;

import ml.pkom.mcpitanlibarch.api.event.BaseEvent;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class BlockScheduledTickEvent extends BaseEvent {
    public BlockState state;
    public ServerWorld world;
    public BlockPos pos;
    public Random random;

    public BlockScheduledTickEvent(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.state = state;
        this.world = world;
        this.pos = pos;
        this.random = random;
    }
}
