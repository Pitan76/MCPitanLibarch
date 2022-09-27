package ml.pkom.mcpitanlibarch.api.registry;

import com.google.common.base.Suppliers;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.Registries;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class ArchRegistry {

    public Supplier<Registries> REGISTRIES;

    public Registrar<Item> ITEMS;
    public Registrar<Block> BLOCKS;
    public Registrar<ScreenHandlerType<?>> SCREEN_HANDLER_TYPE;
    public Registrar<BlockEntityType<?>> BLOCK_ENTITY_TYPE;
    public Registrar<EntityType<?>> ENTITY_TYPE;

    public ArchRegistry(String MOD_ID) {
        REGISTRIES = Suppliers.memoize(() -> Registries.get(MOD_ID));

        ITEMS = REGISTRIES.get().get(Registry.ITEM_KEY);
        BLOCKS = REGISTRIES.get().get(Registry.BLOCK_KEY);
        SCREEN_HANDLER_TYPE = REGISTRIES.get().get(Registry.MENU_KEY);
        BLOCK_ENTITY_TYPE = REGISTRIES.get().get(Registry.BLOCK_ENTITY_TYPE_KEY);
        ENTITY_TYPE = REGISTRIES.get().get(Registry.ENTITY_TYPE_KEY);

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

    public RegistrySupplier<ScreenHandlerType<?>> registerScreenHandlerType(Identifier id, Supplier<ScreenHandlerType<?>> supplier) {
        return SCREEN_HANDLER_TYPE.register(id, supplier);
    }

    public RegistrySupplier<ScreenHandlerType<?>> registerMenu(Identifier id, Supplier<ScreenHandlerType<?>> supplier) {
        return registerScreenHandlerType(id, supplier);
    }

    public RegistrySupplier<BlockEntityType<?>> registerBlockEntityType(Identifier id, Supplier<BlockEntityType<?>> supplier) {
        return BLOCK_ENTITY_TYPE.register(id, supplier);
    }

    public RegistrySupplier<EntityType<?>> registerEntity(Identifier id, Supplier<EntityType<?>> supplier) {
        return ENTITY_TYPE.register(id, supplier);
    }
}
