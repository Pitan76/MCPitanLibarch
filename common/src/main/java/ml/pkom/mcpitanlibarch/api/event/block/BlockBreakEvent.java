package ml.pkom.mcpitanlibarch.api.event.block;

import ml.pkom.mcpitanlibarch.api.entity.Player;
import ml.pkom.mcpitanlibarch.api.event.BaseEvent;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockBreakEvent extends BaseEvent {
    public World world;
    public BlockPos pos;
    public BlockState state;
    public Player player;

    public BlockBreakEvent(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        this.world = world;
        this.pos = pos;
        this.state = state;
        this.player = new Player(player);
    }

    public BlockPos getPos() {
        return pos;
    }

    public BlockState getState() {
        return state;
    }

    public Player getPlayer() {
        return player;
    }

    public PlayerEntity getPlayerEntity() {
        return player.getPlayerEntity();
    }

    public World getWorld() {
        return world;
    }

    public boolean isClient() {
        return world.isClient();
    }
}
