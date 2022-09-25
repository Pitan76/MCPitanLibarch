package ml.pkom.mcpitanlibarch.api.registry;

import com.google.common.base.Suppliers;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.Registries;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class ArchRegistry {

    public Supplier<Registries> REGISTRIES;

    public Registrar<Item> ITEMS;
    public Registrar<Block> BLOCKS;

    public ArchRegistry(String MOD_ID) {
        REGISTRIES = Suppliers.memoize(() -> Registries.get(MOD_ID));

        ITEMS = REGISTRIES.get().get(Registry.ITEM_KEY);
        BLOCKS = REGISTRIES.get().get(Registry.BLOCK_KEY);

    }

    public static ArchRegistry createRegistry(String MOD_ID) {
        return new ArchRegistry(MOD_ID);
    }

    public RegistrySupplier<Item> registerItem(Identifier id, Supplier<Item> supplier) {
        return ITEMS.register(id, supplier);
    }

    public RegistrySupplier<Block> registerBlock(Identifier id, Supplier<Block> supplier) {
        return BLOCKS.register(id, supplier);
    }
}
