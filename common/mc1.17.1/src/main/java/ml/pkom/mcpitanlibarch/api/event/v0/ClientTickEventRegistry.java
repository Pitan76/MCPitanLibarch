package ml.pkom.mcpitanlibarch.api.event.v0;

import dev.architectury.event.events.client.ClientTickEvent;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;

public class ClientTickEventRegistry {
    public static void registerPost(Client client) {
        ClientTickEvent.CLIENT_POST.register(client::tick);
    }

    public static void registerPre(Client client) {
        ClientTickEvent.CLIENT_PRE.register(client::tick);
    }

    public static void registerLevelPost(ClientLevel world) {
        ClientTickEvent.CLIENT_LEVEL_POST.register(world::tick);
    }

    public static void registerLevelPre(ClientLevel world) {
        ClientTickEvent.CLIENT_LEVEL_PRE.register(world::tick);
    }

    @Environment(EnvType.CLIENT)
    public interface Client {
        void tick(MinecraftClient instance);
    }

    @Environment(EnvType.CLIENT)
    public interface ClientLevel {
        void tick(ClientWorld instance);
    }
}
