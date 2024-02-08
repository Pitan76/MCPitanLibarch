package ml.pkom.mcpitanlibarch.api.block;

import ml.pkom.mcpitanlibarch.api.event.block.*;
import ml.pkom.mcpitanlibarch.api.util.TextUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class ExtendBlock extends Block {
    public ExtendBlock(Settings settings) {
        super(settings);
    }

    public ExtendBlock(CompatibleBlockSettings settings) {
        super(settings.build());
    }

    public VoxelShape getOutlineShape(OutlineShapeEvent event) {
        return super.getOutlineShape(event.state, event.world, event.pos, event.context);
    }

    @Deprecated
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return getOutlineShape(new OutlineShapeEvent(state, world, pos, context));
    }

    public void scheduledTick(BlockScheduledTickEvent event) {
        super.scheduledTick(event.state, event.world, event.pos, event.random);
    }

    @Override
    @Deprecated
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        scheduledTick(new BlockScheduledTickEvent(state, world, pos, random));
    }

    @Override
    @Deprecated
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        return onRightClick(new BlockUseEvent(state, world, pos, player, hand, hit));
    }

    /**
     * block right click event
     * @param event ActionResultType
     * @return BlockUseEvent
     */
    public ActionResult onRightClick(BlockUseEvent event) {
        return super.onUse(event.state, event.world, event.pos, event.player.getPlayerEntity(), event.hand, event.hit);
    }

    @Nullable
    @Override
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory((syncId, inventory, player) ->
                createScreenHandler(new ScreenHandlerCreateEvent(state, world, pos, syncId, inventory, player)), getScreenTitle()
        );
    }

    @Nullable
    public ScreenHandler createScreenHandler(ScreenHandlerCreateEvent event) {
        return null;
    }

    @Nullable
    public Text getScreenTitle() {
        return TextUtil.literal("");
    }

    @Override
    @Deprecated
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        onPlaced(new BlockPlacedEvent(world, pos, state, placer, itemStack));
    }

    public void onPlaced(BlockPlacedEvent event) {
        super.onPlaced(event.world, event.pos, event.state, event.placer, event.stack);
    }

    @Override
    @Deprecated
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        onBreak(new BlockBreakEvent(world, pos, state, player));
    }

    public BlockState onBreak(BlockBreakEvent event) {
        super.onBreak(event.world, event.pos, event.state, event.getPlayerEntity());
        return event.state;
    }

    @Override
    @Deprecated
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return getPickStack(new PickStackEvent(world, pos, state));
    }

    public ItemStack getPickStack(PickStackEvent event) {
        return super.getPickStack(event.blockView, event.pos, event.state);
    }

    @Override
    @Deprecated
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        onStateReplaced(new StateReplacedEvent(state, world, pos, newState, moved));
    }

    public void onStateReplaced(StateReplacedEvent event) {
        super.onStateReplaced(event.state, event.world, event.pos, event.newState, event.moved);
    }
}
