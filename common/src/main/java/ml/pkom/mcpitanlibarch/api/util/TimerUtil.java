package ml.pkom.mcpitanlibarch.api.util;

import ml.pkom.mcpitanlibarch.api.timer.MinecraftServerTimerAccess;
import ml.pkom.mcpitanlibarch.api.timer.ServerWorldTimerAccess;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;

import java.util.function.Supplier;

public class TimerUtil {
    public static void addTimer(ServerWorld world, long ticksUntilSomething, Supplier<Boolean> supplier) {
        ((ServerWorldTimerAccess) world).addTimer(ticksUntilSomething, supplier);
    }

    public static void addTimer(MinecraftServer server, long ticksUntilSomething, Supplier<Boolean> supplier) {
        ((MinecraftServerTimerAccess) server).addTimer(ticksUntilSomething, supplier);
    }
}
