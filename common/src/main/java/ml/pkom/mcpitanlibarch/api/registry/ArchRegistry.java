package ml.pkom.mcpitanlibarch.api.registry;

import dev.architectury.registry.registries.RegistrySupplier;
import ml.pkom.mcpitanlibarch.MCPitanLibarch;
import ml.pkom.mcpitanlibarch.api.block.CompatibleBlockSettings;
import ml.pkom.mcpitanlibarch.api.event.registry.RegistryEvent;
import ml.pkom.mcpitanlibarch.api.gui.ExtendedScreenHandlerTypeBuilder;
import ml.pkom.mcpitanlibarch.api.item.CompatibleItemSettings;
import ml.pkom.mcpitanlibarch.api.item.CreativeTabManager;
import ml.pkom.mcpitanlibarch.api.util.BlockUtil;
import ml.pkom.mcpitanlibarch.api.util.ItemUtil;
import ml.pkom.mcpitanlibarch.core.registry.FuelRegistry;
import ml.pkom.mcpitanlibarch.core.registry.MCPLRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.particle.ParticleType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class ArchRegistry {

    private final MCPLRegistry mcplr;

    public ArchRegistry(String MOD_ID) {
        mcplr = new MCPLRegistry(MOD_ID);
    }

    public static ArchRegistry createRegistry(String MOD_ID) {
        return new ArchRegistry(MOD_ID);
    }

    public RegistryEvent<Item> registerItem(Identifier id, Supplier<Item> supplier) {
        if (MCPitanLibarch.itemBlackList.contains(id.toString())) supplier = () -> ItemUtil.of(CompatibleItemSettings.of());
        RegistrySupplier<Item> registrySupplier = mcplr.registryItem(id, supplier);
        CreativeTabManager.register(id);
        return new RegistryEvent<>(registrySupplier);
    }

    public RegistryEvent<Block> registerBlock(Identifier id, Supplier<Block> supplier) {
        if (MCPitanLibarch.blockBlackList.contains(id.toString())) supplier = () -> BlockUtil.of(CompatibleBlockSettings.of(Material.STONE));
        return new RegistryEvent<>(mcplr.registryBlock(id, supplier));
    }

    public RegistryEvent<ScreenHandlerType<?>> registerScreenHandlerType(Identifier id, Supplier<ScreenHandlerType<?>> supplier) {
        return new RegistryEvent<>(mcplr.registryScreenHandlerType(id, supplier));
    }

    @Deprecated
    public RegistryEvent<ScreenHandlerType<?>> registerExtendedScreenHandlerType(Identifier id, Supplier<ExtendedScreenHandlerTypeBuilder<?>> supplier) {
        return registerScreenHandlerType(id, () -> supplier.get().build());
    }

    public RegistryEvent<ScreenHandlerType<?>> registerMenu(Identifier id, Supplier<ScreenHandlerType<?>> supplier) {
        return registerScreenHandlerType(id, supplier);
    }

    public RegistryEvent<BlockEntityType<?>> registerBlockEntityType(Identifier id, Supplier<BlockEntityType<?>> supplier) {
        return new RegistryEvent<>(mcplr.registryBlockEntityType(id, supplier));
    }

    public RegistryEvent<EntityType<?>> registerEntity(Identifier id, Supplier<EntityType<?>> supplier) {
        return new RegistryEvent<>(mcplr.registryEntityType(id, supplier));
    }

    @Deprecated
    public RegistryEvent<SoundEvent> registerSoundEvent(Identifier id, Supplier<SoundEvent> supplier) {
        return new RegistryEvent<>(mcplr.registrySoundEvent(id, supplier));
    }

    public RegistryEvent<SoundEvent> registerSoundEvent(Identifier id) {
        return registerSoundEvent(id, () -> SoundEvent.of(id));
    }

    public RegistryEvent<SoundEvent> registerSoundEvent(Identifier id, float distanceToTravel) {
        return registerSoundEvent(id, () -> SoundEvent.of(id, distanceToTravel));
    }

    public RegistryEvent<Fluid> registerFluid(Identifier id, Supplier<Fluid> supplier) {
        return new RegistryEvent<>(mcplr.registryFluid(id, supplier));
    }

    public RegistryEvent<ParticleType<?>> registerParticleType(Identifier id, Supplier<ParticleType<?>> supplier) {
        return new RegistryEvent<>(mcplr.registryParticleType(id, supplier));
    }

    public static void registerFuel(int time, ItemConvertible... item) {
        FuelRegistry.register(time, item);
    }

    public void allRegister() {
        // 1.16 Register
        mcplr.allRegister1_16();

        // ItemGroup
        CreativeTabManager.allRegister();
    }
}
