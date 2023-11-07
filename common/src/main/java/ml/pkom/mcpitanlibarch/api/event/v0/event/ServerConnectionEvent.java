package ml.pkom.mcpitanlibarch.api.event.v0.event;

import dev.architectury.event.events.common.PlayerEvent;
import ml.pkom.mcpitanlibarch.api.event.v0.EventRegistry;

public class ServerConnectionEvent {
    // Architectury: PlayerEvent
    public static void join(EventRegistry.ServerConnection.PlayerJoin state) {
        PlayerEvent.PLAYER_JOIN.register(state::join);
    }

    public static void quit(EventRegistry.ServerConnection.PlayerQuit state) {
        PlayerEvent.PLAYER_QUIT.register(state::quit);
    }
}
