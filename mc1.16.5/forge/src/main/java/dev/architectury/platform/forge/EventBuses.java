package dev.architectury.platform.forge;

import net.minecraftforge.eventbus.api.IEventBus;

import java.util.Optional;
import java.util.function.Consumer;

public class EventBuses {
    public static void registerModEventBus(String modId, IEventBus bus) {
        me.shedaniel.architectury.platform.forge.EventBuses.registerModEventBus(modId, bus);
    }

    public static void onRegistered(String modId, Consumer<IEventBus> busConsumer) {
        me.shedaniel.architectury.platform.forge.EventBuses.onRegistered(modId, busConsumer);
    }

    public static Optional<IEventBus> getModEventBus(String modId) {
        return me.shedaniel.architectury.platform.forge.EventBuses.getModEventBus(modId);
    }
}
