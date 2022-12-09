package ml.pkom.mcpitanlibarch.api.registry;

import com.google.common.base.Suppliers;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.Registries;
import dev.architectury.registry.registries.RegistrySupplier;
import ml.pkom.mcpitanlibarch.api.event.registry.RegistryEvent;
import ml.pkom.mcpitanlibarch.api.item.CreativeTabManager;
import net.minecraft.block.Block;
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

    public Supplier<Registries> REGISTRIES;

    public Registrar<Item> ITEMS;
    public Registrar<Block> BLOCKS;
    public Registrar<ScreenHandlerType<?>> SCREEN_HANDLER_TYPE;
    public Registrar<BlockEntityType<?>> BLOCK_ENTITY_TYPE;
    public Registrar<EntityType<?>> ENTITY_TYPE;
    public Registrar<SoundEvent> SOUND_EVENT;
    public Registrar<Fluid> FLUID;

    public ArchRegistry(String MOD_ID) {
        REGISTRIES = Suppliers.memoize(() -> Registries.get(MOD_ID));

        ITEMS = REGISTRIES.get().get(Registry.ITEM_KEY);
        BLOCKS = REGISTRIES.get().get(Registry.BLOCK_KEY);
        SCREEN_HANDLER_TYPE = REGISTRIES.get().get(Registry.MENU_KEY);
        BLOCK_ENTITY_TYPE = REGISTRIES.get().get(Registry.BLOCK_ENTITY_TYPE_KEY);
        ENTITY_TYPE = REGISTRIES.get().get(Registry.ENTITY_TYPE_KEY);
        SOUND_EVENT = REGISTRIES.get().get(Registry.SOUND_EVENT_KEY);
        FLUID = REGISTRIES.get().get(Registry.FLUID_KEY);
    }

    public static ArchRegistry createRegistry(String MOD_ID) {
        return new ArchRegistry(MOD_ID);
    }

    public RegistryEvent<Item> registerItem(Identifier id, Supplier<Item> supplier) {
        RegistrySupplier<Item> registrySupplier = ITEMS.register(id, supplier);
        CreativeTabManager.register(id);
        return new RegistryEvent<>(registrySupplier);
    }

    public RegistryEvent<Block> registerBlock(Identifier id, Supplier<Block> supplier) {
        return new RegistryEvent<>(BLOCKS.register(id, supplier));
    }

    public RegistryEvent<ScreenHandlerType<?>> registerScreenHandlerType(Identifier id, Supplier<ScreenHandlerType<?>> supplier) {
        return new RegistryEvent<>(SCREEN_HANDLER_TYPE.register(id, supplier));
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
        return registerSoundEvent(id, () -> new SoundEvent(id, distanceToTravel));
    }

    public RegistryEvent<Fluid> registerFluid(Identifier id, Supplier<Fluid> supplier) {
        return new RegistryEvent<>(FLUID.register(id, supplier));
    }

    public void allRegister() {
        // 1.16 Register
    }
}
