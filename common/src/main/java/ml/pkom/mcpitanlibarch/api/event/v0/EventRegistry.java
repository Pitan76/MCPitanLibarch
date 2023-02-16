package ml.pkom.mcpitanlibarch.api.event.v0;

import dev.architectury.event.events.common.LifecycleEvent;
import dev.architectury.event.events.common.PlayerEvent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class EventRegistry {

    public static class ServerConnection {
        // Architectury: PlayerEvent
        public static void join(PlayerJoin state) {
            PlayerEvent.PLAYER_JOIN.register(state::join);
        }

        public static void quit(PlayerQuit state) {
            PlayerEvent.PLAYER_QUIT.register(state::quit);
        }

        interface PlayerJoin {
            void join(ServerPlayerEntity player);
        }

        interface PlayerQuit {
            void quit(ServerPlayerEntity player);
        }
    }

    public static class ServerLifecycle {
        // Architectury: LifecycleEvent
        public static void serverStarted(ServerState state) {
            LifecycleEvent.SERVER_STARTED.register(state::stateChanged);
        }

        public static void serverStarting(ServerState state) {
            LifecycleEvent.SERVER_STARTING.register(state::stateChanged);
        }

        public static void serverStopped(ServerState state) {
            LifecycleEvent.SERVER_STOPPED.register(state::stateChanged);
        }

        public static void serverStopping(ServerState state) {
            LifecycleEvent.SERVER_STOPPING.register(state::stateChanged);
        }

        public static void serverWorldLoad(ServerWorldState state) {
            LifecycleEvent.SERVER_LEVEL_LOAD.register(state::act);
        }

        public static void serverWorldSave(ServerWorldState state) {
            LifecycleEvent.SERVER_LEVEL_SAVE.register(state::act);
        }

        public static void serverWorldUnload(ServerWorldState state) {
            LifecycleEvent.SERVER_LEVEL_UNLOAD.register(state::act);
        }

        interface ServerState extends InstanceState<MinecraftServer> {
        }

        interface InstanceState<T> {
            void stateChanged(T instance);
        }

        interface WorldState<T extends World> {
            void act(T world);
        }

        interface ServerWorldState extends WorldState<ServerWorld> {
        }
    }
}
