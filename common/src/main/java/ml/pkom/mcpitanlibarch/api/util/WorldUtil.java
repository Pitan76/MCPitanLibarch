package ml.pkom.mcpitanlibarch.api.util;

import ml.pkom.mcpitanlibarch.api.entity.Player;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ChunkTicketType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
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
        world.scheduleBlockTick(pos, block, delay);
    }

    public static void scheduleFluidTick(World world, BlockPos pos, Fluid fluid, int delay) {
        world.scheduleFluidTick(pos, fluid, delay);
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
        spawnExperienceOrb(world, pos.toCenterPos(), amount);
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

    public static BlockPos getSpawnPos(World world) {
        return world.getSpawnPos();
    }

    public static World getWorld(World world, Identifier worldId) {
        if (isClient(world)) return null;
        return getWorld(world.getServer(), worldId);
    }

    public static World getOverworld(MinecraftServer server) {
        return server.getWorld(World.OVERWORLD);
    }

    public static World getNether(MinecraftServer server) {
        return server.getWorld(World.NETHER);
    }

    public static World getEnd(MinecraftServer server) {
        return server.getWorld(World.END);
    }

    public static World getWorld(MinecraftServer server, Identifier worldId) {
        return server.getWorld(RegistryKey.of(RegistryKeys.WORLD, worldId));
    }

    public static Identifier getWorldId(World world) {
        return world.getRegistryKey().getValue();
    }

    public static boolean equals(World world, World world2) {
        return Objects.equals(getWorldId(world), getWorldId(world2));
    }

    public static <T> void addTicket(ServerWorld world, ChunkTicketType<T> type, ChunkPos pos, int radius, T argument) {
        world.getChunkManager().addTicket(type, pos, radius, argument);
    }

    public static <T> void removeTicket(ServerWorld world, ChunkTicketType<T> type, ChunkPos pos, int radius, T argument) {
        world.getChunkManager().removeTicket(type, pos, radius, argument);
    }

    public static boolean isReceivingRedstonePower(World world, BlockPos pos) {
        return world.isReceivingRedstonePower(pos);
    }

    public static int getBottomY(World world) {
        return world.getBottomY();
    }

    public static int getTopY(World world) {
        return world.getTopY();
    }

    public static int getDimensionHeight(World world) {
        return world.getDimension().height();
    }
}
