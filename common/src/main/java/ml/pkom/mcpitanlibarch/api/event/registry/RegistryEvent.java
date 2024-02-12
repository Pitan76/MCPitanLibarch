package ml.pkom.mcpitanlibarch.api.event.registry;

import dev.architectury.registry.registries.RegistrySupplier;

public class RegistryEvent<T> extends RegistryResult<T> {
    public RegistryEvent(RegistrySupplier<T> supplier) {
        super(supplier);
    }
}
