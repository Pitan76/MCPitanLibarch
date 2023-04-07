package ml.pkom.mcpitanlibarch.core.registry;

import com.google.common.base.Suppliers;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrarManager;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

@Deprecated
public class MCPLRegistry {

    public Supplier<RegistrarManager> REGISTRIES;

    public Registrar<Item> ITEMS;
    public Registrar<Block> BLOCKS;
    public Registrar<ScreenHandlerType<?>> SCREEN_HANDLER_TYPE;
    public Registrar<BlockEntityType<?>> BLOCK_ENTITY_TYPE;
    public Registrar<EntityType<?>> ENTITY_TYPE;
    public Registrar<SoundEvent> SOUND_EVENT;
    public Registrar<Fluid> FLUID;
    public Registrar<ParticleType<?>> PARTICLE_TYPE;

    public MCPLRegistry(String MOD_ID) {
        REGISTRIES = Suppliers.memoize(() -> RegistrarManager.get(MOD_ID));

        ITEMS = REGISTRIES.get().get(RegistryKeys.ITEM);
        BLOCKS = REGISTRIES.get().get(RegistryKeys.BLOCK);
        SCREEN_HANDLER_TYPE = REGISTRIES.get().get(RegistryKeys.SCREEN_HANDLER);
        BLOCK_ENTITY_TYPE = REGISTRIES.get().get(RegistryKeys.BLOCK_ENTITY_TYPE);
        ENTITY_TYPE = REGISTRIES.get().get(RegistryKeys.ENTITY_TYPE);
        SOUND_EVENT = REGISTRIES.get().get(RegistryKeys.SOUND_EVENT);
        FLUID = REGISTRIES.get().get(RegistryKeys.FLUID);
        PARTICLE_TYPE = REGISTRIES.get().get(RegistryKeys.PARTICLE_TYPE);
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

    }
}
