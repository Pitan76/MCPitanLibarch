package ml.pkom.mcpitanlibarch.api.util;

import ml.pkom.mcpitanlibarch.api.entity.Player;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class WorldUtil {
    public static boolean hasSkyLight(World world) {
        return world.getDimension().hasSkyLight();
    }

    public static boolean isThundering(World world) {
        return world.isThundering();
    }

    public static boolean isRaining(World world) {
        return world.isRaining();
    }

    public static boolean isNight(World world) {
        return world.isNight();
    }

    public static boolean isDay(World world) {
        return world.isDay();
    }

    public static boolean isSkyVisible(World world, BlockPos pos) {
        return world.isSkyVisible(pos);
    }

    public static boolean isClient(World world) {
        return world.isClient();
    }

    public static void scheduleBlockTick(World world, BlockPos pos, Block block, int delay) {
        world.getBlockTickScheduler().schedule(pos, block, delay);
    }

    public static void scheduleFluidTick(World world, BlockPos pos, Fluid fluid, int delay) {
        world.getFluidTickScheduler().schedule(pos, fluid, delay);
    }

    public static boolean isServer(World world) {
        return !isClient(world);
    }

    public static void spawnStack(World world, BlockPos pos, ItemStack stack) {
        spawnEntity(world, new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack));
    }

    public static void spawnExperienceOrb(World world, Vec3d pos, int amount) {
        if (world instanceof ServerWorld)
            ExperienceOrbEntity.spawn((ServerWorld) world, pos, amount);
    }

    public static void spawnExperienceOrb(World world, BlockPos pos, int amount) {
        spawnExperienceOrb(world, Vec3d.ofCenter(pos), amount);
    }

    public static void spawnEntity(World world, Entity entity) {
        world.spawnEntity(entity);
    }

    public static void playSound(World world, @Nullable Player player, BlockPos pos, SoundEvent sound, SoundCategory category, float volume, float pitch) {
        PlayerEntity entity = player == null ? null : player.getEntity();
        world.playSound(entity, pos, sound, category, volume, pitch);
    }

    public static void sendEntityStatus(World world, Entity entity, byte status) {
        world.sendEntityStatus(entity, status);
    }
}
