package ml.pkom.mcpitanlibarch.api.client.registry;

import dev.architectury.registry.client.keymappings.KeyMappingRegistry;
import ml.pkom.mcpitanlibarch.api.event.v0.ClientTickEventRegistry;
import ml.pkom.mcpitanlibarch.api.network.ClientNetworking;
import ml.pkom.mcpitanlibarch.api.network.PacketByteUtil;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.util.Identifier;

public class KeybindingRegistry {
    public static void register(KeyBinding keyBinding) {
        KeyMappingRegistry.register(keyBinding);
    }

    public static void register(KeyBinding keyBinding, ClientTickEventRegistry.Client client) {
        register(keyBinding);
        ClientTickEventRegistry.registerPost(client);
    }

    public static void registerOnLevel(KeyBinding keyBinding, ClientTickEventRegistry.ClientLevel level) {
        register(keyBinding);
        ClientTickEventRegistry.registerLevelPost(level);
    }

    public static void registerWithNetwork(KeyBinding keyBinding, Identifier identifier) {
        register(keyBinding, client -> {
            if (keyBinding.wasPressed())
                ClientNetworking.send(identifier, PacketByteUtil.create());
        });
    }

    public static void registerOnLevelWithNetwork(KeyBinding keyBinding, Identifier identifier) {
        registerOnLevel(keyBinding, client -> {
            if (keyBinding.wasPressed())
                ClientNetworking.send(identifier, PacketByteUtil.create());
        });
    }
}
