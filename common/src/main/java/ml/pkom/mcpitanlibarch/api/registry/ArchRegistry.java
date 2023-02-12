package ml.pkom.mcpitanlibarch.api.registry;

import me.shedaniel.architectury.registry.DeferredRegister;
import me.shedaniel.architectury.registry.MenuRegistry;
import me.shedaniel.architectury.registry.RegistrySupplier;
import ml.pkom.mcpitanlibarch.MCPitanLibarch;
import ml.pkom.mcpitanlibarch.api.event.registry.RegistryEvent;
import ml.pkom.mcpitanlibarch.api.gui.ExtendedScreenHandler;
import ml.pkom.mcpitanlibarch.api.gui.ExtendedScreenHandlerType;
import ml.pkom.mcpitanlibarch.api.item.CreativeTabManager;
import ml.pkom.mcpitanlibarch.api.item.ExtendSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class ArchRegistry {

    public DeferredRegister<Item> ITEMS;
    public DeferredRegister<Block> BLOCKS;
    public DeferredRegister<ScreenHandlerType<?>> SCREEN_HANDLER_TYPE;
    public DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPE;
    public DeferredRegister<EntityType<?>> ENTITY_TYPE;
    public DeferredRegister<SoundEvent> SOUND_EVENT;
    public DeferredRegister<Fluid> FLUID;

    public ArchRegistry(String MOD_ID) {
        ITEMS = DeferredRegister.create(MOD_ID, Registry.ITEM_KEY);
        BLOCKS = DeferredRegister.create(MOD_ID, Registry.BLOCK_KEY);
        SCREEN_HANDLER_TYPE = DeferredRegister.create(MOD_ID, Registry.MENU_KEY);
        BLOCK_ENTITY_TYPE = DeferredRegister.create(MOD_ID, Registry.BLOCK_ENTITY_TYPE_KEY);
        ENTITY_TYPE = DeferredRegister.create(MOD_ID, Registry.ENTITY_TYPE_KEY);
        SOUND_EVENT = DeferredRegister.create(MOD_ID, Registry.SOUND_EVENT_KEY);
        FLUID = DeferredRegister.create(MOD_ID, Registry.FLUID_KEY);
    }

    public static ArchRegistry createRegistry(String MOD_ID) {
        return new ArchRegistry(MOD_ID);
    }

    public RegistryEvent<Item> registerItem(Identifier id, Supplier<Item> supplier) {
        if (MCPitanLibarch.itemBlackList.contains(id.toString())) supplier = () -> new Item(new ExtendSettings());
        RegistrySupplier<Item> registrySupplier = ITEMS.register(id, supplier);
        CreativeTabManager.register(id);
        return new RegistryEvent<>(registrySupplier);
    }

    public RegistryEvent<Block> registerBlock(Identifier id, Supplier<Block> supplier) {
        if (MCPitanLibarch.blockBlackList.contains(id.toString())) supplier = () -> new Block(AbstractBlock.Settings.of(Material.STONE));
        return new RegistryEvent<>(BLOCKS.register(id, supplier));
    }

    public RegistryEvent<ScreenHandlerType<?>> registerScreenHandlerType(Identifier id, Supplier<ScreenHandlerType<?>> supplier) {
        return new RegistryEvent<>(SCREEN_HANDLER_TYPE.register(id, supplier));
    }

    public RegistryEvent<ScreenHandlerType<?>> registerExtendedScreenHandlerType(Identifier id, Supplier<ExtendedScreenHandlerType<?>> supplier) {
        return registerScreenHandlerType(id, () -> MenuRegistry.ofExtended((id1, inventory, buf) -> supplier.get().create(id1, inventory, buf)));
    }

    public RegistryEvent<ScreenHandlerType<?>> registerMenu(Identifier id, Supplier<ScreenHandlerType<?>> supplier) {
        return registerScreenHandlerType(id, supplier);
    }

    public RegistryEvent<BlockEntityType<?>> registerBlockEntityType(Identifier id, Supplier<BlockEntityType<?>> supplier) {
        return new RegistryEvent<>(BLOCK_ENTITY_TYPE.register(id, supplier));
    }

    public RegistryEvent<EntityType<?>> registerEntity(Identifier id, Supplier<EntityType<?>> supplier) {
        return new RegistryEvent<>(ENTITY_TYPE.register(id, supplier));
    }

    @Deprecated
    public RegistryEvent<SoundEvent> registerSoundEvent(Identifier id, Supplier<SoundEvent> supplier) {
        return new RegistryEvent<>(SOUND_EVENT.register(id, supplier));
    }

    public RegistryEvent<SoundEvent> registerSoundEvent(Identifier id) {
        return registerSoundEvent(id, () -> new SoundEvent(id));
    }

    public RegistryEvent<SoundEvent> registerSoundEvent(Identifier id, float distanceToTravel) {
        return registerSoundEvent(id);
    }

    public RegistryEvent<Fluid> registerFluid(Identifier id, Supplier<Fluid> supplier) {
        return new RegistryEvent<>(FLUID.register(id, supplier));
    }

    public void allRegister() {
        BLOCKS.register();
        ITEMS.register();
        SCREEN_HANDLER_TYPE.register();
        BLOCK_ENTITY_TYPE.register();
        ENTITY_TYPE.register();
        SOUND_EVENT.register();
        FLUID.register();
    }
}
