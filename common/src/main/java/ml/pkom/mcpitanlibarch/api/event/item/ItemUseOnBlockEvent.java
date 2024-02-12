package ml.pkom.mcpitanlibarch.api.event.item;

import ml.pkom.mcpitanlibarch.api.entity.Player;
import ml.pkom.mcpitanlibarch.api.event.BaseEvent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ItemUseOnBlockEvent extends BaseEvent {
    public Player player;
    public Hand hand;
    public BlockHitResult hit;
    public ItemStack stack;
    public World world;
    public BlockPos blockPos;

    public ItemUseOnBlockEvent(PlayerEntity player, Hand hand, BlockHitResult hit) {
        this(player.world, player, hand, player.getStackInHand(hand), hit);
    }

    public ItemUseOnBlockEvent(World world, @Nullable PlayerEntity player, Hand hand, ItemStack stack, BlockHitResult hit) {
        if (player != null)
            this.player = new Player(player);
        this.hand = hand;
        this.hit = hit;
        this.stack = stack;
        this.world = world;
        this.blockPos = hit.getBlockPos();
    }

    public ItemUsageContext toIUC() {
        return new ItemUsageContext(player.getPlayerEntity(), hand, hit);
    }

    public boolean isClient() {
        return world.isClient();
    }

    public Player getPlayer() {
        return player;
    }

    public World getWorld() {
        return world;
    }

    public BlockHitResult getHit() {
        return hit;
    }

    public BlockPos getBlockPos() {
        return blockPos;
    }

    public Hand getHand() {
        return hand;
    }

    public ItemStack getStack() {
        return stack;
    }

    public ActionResult success() {
        return ActionResult.SUCCESS;
    }

    public ActionResult fail() {
        return ActionResult.FAIL;
    }

    public ActionResult pass() {
        return ActionResult.PASS;
    }

    public ActionResult consume() {
        return ActionResult.CONSUME;
    }
}
