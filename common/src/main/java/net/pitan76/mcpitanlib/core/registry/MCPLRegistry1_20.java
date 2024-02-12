package net.pitan76.mcpitanlib.core.registry;

import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

@Deprecated
public class MCPLRegistry1_20 {
    private final MCPLRegistry mcplr;

    //public Registrar<ItemGroup> ITEM_GROUP;


    public MCPLRegistry1_20(MCPLRegistry mcplr) {
        this.mcplr = mcplr;
        //ITEM_GROUP = mcplr.REGISTRIES.get().get(RegistryKeys.ITEM_GROUP);
    }

    public RegistrySupplier<ItemGroup> registryItemGroup(Identifier id, Supplier<ItemGroup> supplier) {
        return null;
    }
}
