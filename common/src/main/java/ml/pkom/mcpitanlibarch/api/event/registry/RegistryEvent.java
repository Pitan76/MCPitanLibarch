package ml.pkom.mcpitanlibarch.api.event.registry;

import me.shedaniel.architectury.registry.RegistrySupplier;

public class RegistryEvent<T> extends RegistryResult<T> {
    public RegistryEvent(RegistrySupplier<T> supplier) {
        super(supplier);
    }
}
