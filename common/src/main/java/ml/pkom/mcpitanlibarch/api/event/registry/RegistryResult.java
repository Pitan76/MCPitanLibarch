package ml.pkom.mcpitanlibarch.api.event.registry;

import me.shedaniel.architectury.registry.RegistrySupplier;
import ml.pkom.mcpitanlibarch.api.event.BaseEvent;
import org.jetbrains.annotations.Nullable;

public class RegistryResult<T> extends BaseEvent {
    public RegistrySupplier<T> supplier;

    public RegistryResult(RegistrySupplier<T> supplier) {
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
