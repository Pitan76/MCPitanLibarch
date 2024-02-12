package net.pitan76.mcpitanlib.api.registry.result;

import dev.architectury.registry.registries.RegistrySupplier;
import org.jetbrains.annotations.Nullable;

public class RegistryResult<T> {
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
