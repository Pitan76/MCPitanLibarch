package ml.pkom.mcpitanlibarch.api.registry;

import me.shedaniel.architectury.registry.RegistrySupplier;
import ml.pkom.mcpitanlibarch.MCPitanLibarch;
import ml.pkom.mcpitanlibarch.api.block.CompatibleBlockSettings;
import ml.pkom.mcpitanlibarch.api.block.CompatibleMaterial;
import ml.pkom.mcpitanlibarch.api.event.registry.RegistryResult;
import ml.pkom.mcpitanlibarch.api.gui.ExtendedScreenHandlerTypeBuilder;
import ml.pkom.mcpitanlibarch.api.item.CompatibleItemSettings;
import ml.pkom.mcpitanlibarch.api.item.CreativeTabManager;
import ml.pkom.mcpitanlibarch.api.util.BlockUtil;
import ml.pkom.mcpitanlibarch.api.util.ItemUtil;
import ml.pkom.mcpitanlibarch.core.registry.FuelRegistry;
import ml.pkom.mcpitanlibarch.core.registry.MCPLRegistry;
import ml.pkom.mcpitanlibarch.core.registry.MCPLRegistry1_20;
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

import java.util.function.Supplier;

public class ArchRegistry {

    private final MCPLRegistry mcplr;
    private final MCPLRegistry1_20 mcplr1_20;

    public ArchRegistry(String MOD_ID) {
        mcplr = new MCPLRegistry(MOD_ID);
        mcplr1_20 = new MCPLRegistry1_20(mcplr);
    }

    public static ArchRegistry createRegistry(String MOD_ID) {
        return new ArchRegistry(MOD_ID);
    }

    public RegistryResult<Item> registerItem(Identifier id, Supplier<Item> supplier) {
        if (MCPitanLibarch.isItemBlackListed(id)) supplier = () -> ItemUtil.of(CompatibleItemSettings.of());
        RegistrySupplier<Item> registrySupplier = mcplr.registryItem(id, supplier);
        CreativeTabManager.register(id);
        return new RegistryResult<>(registrySupplier);
    }

    public RegistryResult<Block> registerBlock(Identifier id, Supplier<Block> supplier) {
        if (MCPitanLibarch.isBlockBlackListed(id)) supplier = () -> BlockUtil.of(CompatibleBlockSettings.of(CompatibleMaterial.STONE));
        return new RegistryResult<>(mcplr.registryBlock(id, supplier));
    }

    public RegistryResult<ScreenHandlerType<?>> registerScreenHandlerType(Identifier id, Supplier<ScreenHandlerType<?>> supplier) {
        return new RegistryResult<>(mcplr.registryScreenHandlerType(id, supplier));
    }

    @Deprecated
    public RegistryResult<ScreenHandlerType<?>> registerExtendedScreenHandlerType(Identifier id, Supplier<ExtendedScreenHandlerTypeBuilder<?>> supplier) {
        return registerScreenHandlerType(id, () -> supplier.get().build());
    }

    public RegistryResult<ScreenHandlerType<?>> registerMenu(Identifier id, Supplier<ScreenHandlerType<?>> supplier) {
        return registerScreenHandlerType(id, supplier);
    }

    public RegistryResult<BlockEntityType<?>> registerBlockEntityType(Identifier id, Supplier<BlockEntityType<?>> supplier) {
        return new RegistryResult<>(mcplr.registryBlockEntityType(id, supplier));
    }

    public RegistryResult<EntityType<?>> registerEntity(Identifier id, Supplier<EntityType<?>> supplier) {
        return new RegistryResult<>(mcplr.registryEntityType(id, supplier));
    }

    @Deprecated
    public RegistryResult<SoundEvent> registerSoundEvent(Identifier id, Supplier<SoundEvent> supplier) {
        return new RegistryResult<>(mcplr.registrySoundEvent(id, supplier));
    }

    public RegistryResult<SoundEvent> registerSoundEvent(Identifier id) {
        return registerSoundEvent(id, () -> new SoundEvent(id));
    }

    public RegistryResult<SoundEvent> registerSoundEvent(Identifier id, float distanceToTravel) {
        return registerSoundEvent(id);
    }

    public RegistryResult<Fluid> registerFluid(Identifier id, Supplier<Fluid> supplier) {
        return new RegistryResult<>(mcplr.registryFluid(id, supplier));
    }

    public RegistryResult<ParticleType<?>> registerParticleType(Identifier id, Supplier<ParticleType<?>> supplier) {
        return new RegistryResult<>(mcplr.registryParticleType(id, supplier));
    }

    public RegistryResult<ItemGroup> registerItemGroup(Identifier id, Supplier<ItemGroup> supplier) {
        return new RegistryResult<>(null);
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
