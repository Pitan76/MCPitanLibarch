package ml.pkom.mcpitanlibarch.api.event;

import ml.pkom.mcpitanlibarch.api.entity.Player;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ScreenHandlerCreateEvent {

    public BlockState state;
    public World world;
    public BlockPos pos;
    public int syncId;
    public PlayerInventory inventory;
    public Player player;

    public ScreenHandlerCreateEvent(BlockState state, World world, BlockPos pos, int syncId, PlayerInventory inventory, PlayerEntity player) {
        this.state = state;
        this.world = world;
        this.pos = pos;
        this.syncId = syncId;
        this.inventory = inventory;
        this.player = new Player(player);
    }
}
