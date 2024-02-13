package net.pitan76.mcpitanlib.test;

import ml.pkom.mcpitanlibarch.api.block.CompatibleBlockSettings;
import ml.pkom.mcpitanlibarch.api.block.CompatibleMaterial;
import ml.pkom.mcpitanlibarch.api.block.ExtendBlock;
import ml.pkom.mcpitanlibarch.api.command.CommandRegistry;
import ml.pkom.mcpitanlibarch.api.gui.SimpleScreenHandlerTypeBuilder;
import ml.pkom.mcpitanlibarch.api.item.CompatibleItemSettings;
import ml.pkom.mcpitanlibarch.api.item.DefaultItemGroups;
import ml.pkom.mcpitanlibarch.api.item.ExtendItem;
import ml.pkom.mcpitanlibarch.api.registry.ArchRegistry;
import ml.pkom.mcpitanlibarch.api.util.ItemUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.pitan76.mcpitanlib.api.registry.result.RegistryResult;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExampleMod {
    public static final String MOD_ID = "examplemod";
    public static final String MOD_NAME = "ExampleMod";

    public static Logger LOGGER = LogManager.getLogger();
    public static void log(Level level, String message){
        LOGGER.log(level, "[" + MOD_NAME + "] " + message);
    }

    public static Identifier id(String id) {
        return new Identifier(MOD_ID, id);
    }

    public static ArchRegistry registry = ArchRegistry.createRegistry(MOD_ID);

    public static RegistryResult<ScreenHandlerType<?>> supplierEXAMPLE_SCREENHANDLER = registry.registerScreenHandlerType(id("example_gui"), () -> new SimpleScreenHandlerTypeBuilder<>(ExampleScreenHandler::new).build());

    public static RegistryResult<Item> EXAMPLE_ITEM_SUPPLIER;
    public static RegistryResult<Block> EXAMPLE_BLOCK_SUPPLIER;
    public static RegistryResult<Item> EXAMPLE_BLOCK_ITEM_SUPPLIER;
    public static RegistryResult<Item> EXAMPLE_GUI_ITEM_SUPPLIER;
    public static RegistryResult<Block> EXAMPLE_GUI_BLOCK_SUPPLIER;
    public static RegistryResult<Item> EXAMPLE_GUI_BLOCK_ITEM_SUPPLIER;

    public static void init() {
        EXAMPLE_ITEM_SUPPLIER = registry.registerItem(id("example_item"), () -> new ExtendItem(new CompatibleItemSettings().addGroup(() -> DefaultItemGroups.INGREDIENTS, id("example_item"))));
        EXAMPLE_BLOCK_SUPPLIER = registry.registerBlock(id("example_block"), () -> new ExtendBlock(CompatibleBlockSettings.of(CompatibleMaterial.STONE)));
        EXAMPLE_BLOCK_ITEM_SUPPLIER = registry.registerItem(id("example_block"), () -> ItemUtil.ofBlock(EXAMPLE_BLOCK_SUPPLIER.supplier.get(), new CompatibleItemSettings().addGroup(() -> DefaultItemGroups.INGREDIENTS, id("example_block"))));

        EXAMPLE_GUI_ITEM_SUPPLIER = registry.registerItem(id("example_gui_item"), () -> new ExampleGuiItem(new CompatibleItemSettings().addGroup(() -> DefaultItemGroups.INGREDIENTS, id("example_gui_item"))));

        EXAMPLE_GUI_BLOCK_SUPPLIER = registry.registerBlock(id("example_gui_block"), () -> new ExampleGuiBlock(CompatibleBlockSettings.of(CompatibleMaterial.STONE).build()));
        EXAMPLE_GUI_BLOCK_ITEM_SUPPLIER = registry.registerItem(id("example_gui_block"), () -> ItemUtil.ofBlock(EXAMPLE_GUI_BLOCK_SUPPLIER.supplier.get(), new CompatibleItemSettings().addGroup(() -> DefaultItemGroups.INGREDIENTS, id("example_gui_block"))));

        registry.allRegister();

        CommandRegistry.register("mpla", new ExampleCommand());
    }
}