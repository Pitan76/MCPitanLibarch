package ml.pkom.mcpitanlibarch.api.event.block;

import ml.pkom.mcpitanlibarch.api.entity.Player;
import ml.pkom.mcpitanlibarch.api.event.BaseEvent;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockUseEvent extends BaseEvent {
    public BlockState state;
    public World world;
    public BlockPos pos;
    public Player player;
    public Hand hand;
    public BlockHitResult hit;

    public BlockUseEvent(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        this.state = state;
        this.world = world;
        this.pos = pos;
        this.player = new Player(player);
        this.hand = hand;
        this.hit = hit;
    }
}
