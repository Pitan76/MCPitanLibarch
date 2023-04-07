package ml.pkom.mcpitanlibarch.core.registry;

import me.shedaniel.architectury.registry.DeferredRegister;
import me.shedaniel.architectury.registry.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

@Deprecated
public class MCPLRegistry {

    public DeferredRegister<Item> ITEMS;
    public DeferredRegister<Block> BLOCKS;
    public DeferredRegister<ScreenHandlerType<?>> SCREEN_HANDLER_TYPE;
    public DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPE;
    public DeferredRegister<EntityType<?>> ENTITY_TYPE;
    public DeferredRegister<SoundEvent> SOUND_EVENT;
    public DeferredRegister<Fluid> FLUID;
    public DeferredRegister<ParticleType<?>> PARTICLE_TYPE;

    public MCPLRegistry(String MOD_ID) {
        ITEMS = DeferredRegister.create(MOD_ID, Registry.ITEM_KEY);
        BLOCKS = DeferredRegister.create(MOD_ID, Registry.BLOCK_KEY);
        SCREEN_HANDLER_TYPE = DeferredRegister.create(MOD_ID, Registry.MENU_KEY);
        BLOCK_ENTITY_TYPE = DeferredRegister.create(MOD_ID, Registry.BLOCK_ENTITY_TYPE_KEY);
        ENTITY_TYPE = DeferredRegister.create(MOD_ID, Registry.ENTITY_TYPE_KEY);
        SOUND_EVENT = DeferredRegister.create(MOD_ID, Registry.SOUND_EVENT_KEY);
        FLUID = DeferredRegister.create(MOD_ID, Registry.FLUID_KEY);
        PARTICLE_TYPE = DeferredRegister.create(MOD_ID, Registry.PARTICLE_TYPE_KEY);
    }

    public RegistrySupplier<Item> registryItem(Identifier id, Supplier<Item> supplier) {
        return ITEMS.register(id, supplier);
    }

    public RegistrySupplier<Block> registryBlock(Identifier id, Supplier<Block> supplier) {
        return BLOCKS.register(id, supplier);
    }

    public RegistrySupplier<ScreenHandlerType<?>> registryScreenHandlerType(Identifier id, Supplier<ScreenHandlerType<?>> supplier) {
        return SCREEN_HANDLER_TYPE.register(id, supplier);
    }

    public RegistrySupplier<BlockEntityType<?>> registryBlockEntityType(Identifier id, Supplier<BlockEntityType<?>> supplier) {
        return BLOCK_ENTITY_TYPE.register(id, supplier);
    }

    public RegistrySupplier<EntityType<?>> registryEntityType(Identifier id, Supplier<EntityType<?>> supplier) {
        return ENTITY_TYPE.register(id, supplier);
    }

    public RegistrySupplier<SoundEvent> registrySoundEvent(Identifier id, Supplier<SoundEvent> supplier) {
        return SOUND_EVENT.register(id, supplier);
    }

    public RegistrySupplier<Fluid> registryFluid(Identifier id, Supplier<Fluid> supplier) {
        return FLUID.register(id, supplier);
    }

    public RegistrySupplier<ParticleType<?>> registryParticleType(Identifier id, Supplier<ParticleType<?>> supplier) {
        return PARTICLE_TYPE.register(id, supplier);
    }

    public void allRegister1_16() {
        BLOCKS.register();
        ITEMS.register();
        SCREEN_HANDLER_TYPE.register();
        BLOCK_ENTITY_TYPE.register();
        ENTITY_TYPE.register();
        SOUND_EVENT.register();
        FLUID.register();
        PARTICLE_TYPE.register();
    }
}
