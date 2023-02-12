package ml.pkom.mcpitanlibarch.api.network;

import dev.architectury.networking.NetworkManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

import static dev.architectury.networking.NetworkManager.Side.S2C;

public class ClientNetwork {
    public static void send(Identifier identifier, PacketByteBuf buf) {
        NetworkManager.sendToServer(identifier, buf);
    }

    public static void registerReceiver(Identifier identifier, ClientNetworkHandler handler) {
        NetworkManager.registerReceiver(S2C, identifier, ((buf, context) -> handler.receive(MinecraftClient.getInstance(), MinecraftClient.getInstance().player, buf)));
    }

    @FunctionalInterface
    public interface ClientNetworkHandler {
        void receive(MinecraftClient client, ClientPlayerEntity player, PacketByteBuf buf);
    }
}
