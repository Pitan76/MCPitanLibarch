package ml.pkom.mcpitanlibarch.api.event.registry;

import me.shedaniel.architectury.registry.RegistrySupplier;
import ml.pkom.mcpitanlibarch.api.event.BaseEvent;

import javax.annotation.Nullable;

public class RegistryEvent<T> extends BaseEvent {
    public RegistrySupplier<T> supplier;

    public RegistryEvent(RegistrySupplier<T> supplier) {
        this.supplier = supplier;
    }

    public T get() {
        return supplier.get();
    }

    @Nullable
    public T getOrNull() {
        return supplier.getOrNull();
    }
}
