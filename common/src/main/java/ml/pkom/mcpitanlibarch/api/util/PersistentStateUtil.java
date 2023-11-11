package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.datafixer.DataFixTypes;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateManager;
import net.minecraft.world.World;

import java.util.function.Function;
import java.util.function.Supplier;

public class PersistentStateUtil {
    public static <T extends PersistentState> T getOrCreate(PersistentStateManager manager, String id, Supplier<T> supplier, Function<NbtCompound, T> function) {
        PersistentState.Type<T> type = new PersistentState.Type<>(supplier, function, DataFixTypes.LEVEL);
        return manager.getOrCreate(type, id);
    }

    public static PersistentStateManager getManagerFromServer(MinecraftServer server) {
        return server.getWorld(World.OVERWORLD).getPersistentStateManager();
    }

    public static PersistentStateManager getManagerFromWorld(ServerWorld world) {
        return world.getPersistentStateManager();
    }
}