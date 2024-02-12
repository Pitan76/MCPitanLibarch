package ml.pkom.mcpitanlibarch.api.registry;

import ml.pkom.mcpitanlibarch.api.event.registry.RegistryEvent;
import ml.pkom.mcpitanlibarch.api.gui.ExtendedScreenHandlerTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.particle.ParticleType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.pitan76.mcpitanlib.api.registry.CompatRegistry;
import net.pitan76.mcpitanlib.core.registry.MCPLRegistry;
import net.pitan76.mcpitanlib.core.registry.MCPLRegistry1_20;

import java.util.function.Supplier;

@Deprecated
public class ArchRegistry {

    private final CompatRegistry compatRegistry;
    private final MCPLRegistry mcplr;
    private final MCPLRegistry1_20 mcplr1_20;

    public ArchRegistry(String MOD_ID) {
        compatRegistry = new CompatRegistry(MOD_ID);
        mcplr = compatRegistry.getMcplr();
        mcplr1_20 = compatRegistry.getMcplr1_20();
    }

    public static ArchRegistry createRegistry(String MOD_ID) {
        return new ArchRegistry(MOD_ID);
    }

    public RegistryEvent<Item> registerItem(Identifier id, Supplier<Item> supplier) {
        return new RegistryEvent<>(compatRegistry.registerItem(id, supplier).supplier);
    }

    public RegistryEvent<Block> registerBlock(Identifier id, Supplier<Block> supplier) {
        return new RegistryEvent<>(compatRegistry.registerBlock(id, supplier).supplier);
    }

    public RegistryEvent<ScreenHandlerType<?>> registerScreenHandlerType(Identifier id, Supplier<ScreenHandlerType<?>> supplier) {
        return new RegistryEvent<>(compatRegistry.registerScreenHandlerType(id, supplier).supplier);
    }

    @Deprecated
    public RegistryEvent<ScreenHandlerType<?>> registerExtendedScreenHandlerType(Identifier id, Supplier<ExtendedScreenHandlerTypeBuilder<?>> supplier) {
        return registerScreenHandlerType(id, () -> supplier.get().build());
    }

    public RegistryEvent<ScreenHandlerType<?>> registerMenu(Identifier id, Supplier<ScreenHandlerType<?>> supplier) {
        return registerScreenHandlerType(id, supplier);
    }

    public RegistryEvent<BlockEntityType<?>> registerBlockEntityType(Identifier id, Supplier<BlockEntityType<?>> supplier) {
        return new RegistryEvent<>(compatRegistry.registerBlockEntityType(id, supplier).supplier);
    }

    public RegistryEvent<EntityType<?>> registerEntity(Identifier id, Supplier<EntityType<?>> supplier) {
        return new RegistryEvent<>(compatRegistry.registerEntity(id, supplier).supplier);
    }

    @Deprecated
    public RegistryEvent<SoundEvent> registerSoundEvent(Identifier id, Supplier<SoundEvent> supplier) {
        return new RegistryEvent<>(compatRegistry.registerSoundEvent(id, supplier).supplier);
    }

    public RegistryEvent<SoundEvent> registerSoundEvent(Identifier id) {
        return registerSoundEvent(id, () -> SoundEvent.of(id));
    }

    public RegistryEvent<SoundEvent> registerSoundEvent(Identifier id, float distanceToTravel) {
        return registerSoundEvent(id, () -> SoundEvent.of(id, distanceToTravel));
    }

    public RegistryEvent<Fluid> registerFluid(Identifier id, Supplier<Fluid> supplier) {
        return new RegistryEvent<>(compatRegistry.registerFluid(id, supplier).supplier);
    }

    public RegistryEvent<ParticleType<?>> registerParticleType(Identifier id, Supplier<ParticleType<?>> supplier) {
        return new RegistryEvent<>(compatRegistry.registerParticleType(id, supplier).supplier);
    }

    public RegistryEvent<ItemGroup> registerItemGroup(Identifier id, Supplier<ItemGroup> supplier) {
        return new RegistryEvent<>(compatRegistry.registerItemGroup(id, supplier).supplier);
    }

    public static void registerFuel(int time, ItemConvertible... item) {
        CompatRegistry.registerFuel(time, item);
    }

    public void allRegister() {
        compatRegistry.allRegister();
    }
}
