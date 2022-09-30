package ml.pkom.mcpitanlibarch.api.registry;

import me.shedaniel.architectury.registry.DeferredRegister;
import me.shedaniel.architectury.registry.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class ArchRegistry {

    public DeferredRegister<Item> ITEMS;
    public DeferredRegister<Block> BLOCKS;
    public DeferredRegister<ScreenHandlerType<?>> SCREEN_HANDLER_TYPE;
    public DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPE;
    public DeferredRegister<EntityType<?>> ENTITY_TYPE;

    public ArchRegistry(String MOD_ID) {
        ITEMS = DeferredRegister.create(MOD_ID, Registry.ITEM_KEY);
        BLOCKS = DeferredRegister.create(MOD_ID, Registry.BLOCK_KEY);
        SCREEN_HANDLER_TYPE = DeferredRegister.create(MOD_ID, Registry.MENU_KEY);
        BLOCK_ENTITY_TYPE = DeferredRegister.create(MOD_ID, Registry.BLOCK_ENTITY_TYPE_KEY);
        ENTITY_TYPE = DeferredRegister.create(MOD_ID, Registry.ENTITY_TYPE_KEY);
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
