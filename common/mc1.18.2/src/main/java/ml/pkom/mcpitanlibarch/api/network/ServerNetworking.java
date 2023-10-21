package ml.pkom.mcpitanlibarch.api.network;

import dev.architectury.networking.NetworkManager;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import static dev.architectury.networking.NetworkManager.Side.C2S;

public class ServerNetworking {
    public static void send(ServerPlayerEntity player, Identifier identifier, PacketByteBuf buf) {
        NetworkManager.sendToPlayer(player, identifier, buf);
    }

    public static void send(Iterable<ServerPlayerEntity> players, Identifier identifier, PacketByteBuf buf) {
        NetworkManager.sendToPlayers(players, identifier, buf);
    }


    public static void sendAll(MinecraftServer server, Identifier identifier, PacketByteBuf buf) {
        send(server.getPlayerManager().getPlayerList(), identifier, buf);
    }

    public static void registerReceiver(Identifier identifier, ServerNetworkHandler handler) {
        NetworkManager.registerReceiver(C2S, identifier, ((buf, context) -> handler.receive(context.getPlayer().getServer(), (ServerPlayerEntity) context.getPlayer(), buf)));
    }

    @FunctionalInterface
    public interface ServerNetworkHandler {
        void receive(MinecraftServer server, ServerPlayerEntity player, PacketByteBuf buf);
    }
}
