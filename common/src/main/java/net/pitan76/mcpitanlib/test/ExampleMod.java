package net.pitan76.mcpitanlib.test;

import ml.pkom.mcpitanlibarch.api.block.CompatibleBlockSettings;
import ml.pkom.mcpitanlibarch.api.block.CompatibleMaterial;
import ml.pkom.mcpitanlibarch.api.block.ExtendBlock;
import ml.pkom.mcpitanlibarch.api.command.CommandRegistry;
import ml.pkom.mcpitanlibarch.api.gui.SimpleScreenHandlerTypeBuilder;
import ml.pkom.mcpitanlibarch.api.item.CompatibleItemSettings;
import ml.pkom.mcpitanlibarch.api.item.DefaultItemGroups;
import ml.pkom.mcpitanlibarch.api.item.ExtendItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.pitan76.mcpitanlib.api.registry.CompatRegistry;
import net.pitan76.mcpitanlib.api.registry.result.RegistryResult;
import net.pitan76.mcpitanlib.api.util.ItemUtil;
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

    // en: Create a CompatRegistry instance. , ja: CompatRegistryインスタンスを作成します。
    public static CompatRegistry registry = CompatRegistry.createRegistry(MOD_ID);

    public static RegistryResult<ScreenHandlerType<?>> EXAMPLE_SCREENHANDLER;

    public static RegistryResult<Item> EXAMPLE_ITEM;
    public static RegistryResult<Block> EXAMPLE_BLOCK;
    public static RegistryResult<Item> EXAMPLE_BLOCK_ITEM;
    public static RegistryResult<Item> EXAMPLE_GUI_ITEM;
    public static RegistryResult<Block> EXAMPLE_GUI_BLOCK;
    public static RegistryResult<Item> EXAMPLE_GUI_BLOCK_ITEM;

    public static void init() {
        // en: Register all items, blocks, and others. , ja: 全てのアイテム、ブロック、その他を登録します。
        EXAMPLE_SCREENHANDLER = registry.registerScreenHandlerType(id("example_gui"), () -> new SimpleScreenHandlerTypeBuilder<>(ExampleScreenHandler::new).build());
        EXAMPLE_ITEM = registry.registerItem(id("example_item"), () -> new ExtendItem(new CompatibleItemSettings().addGroup(() -> DefaultItemGroups.INGREDIENTS, id("example_item"))));
        EXAMPLE_BLOCK = registry.registerBlock(id("example_block"), () -> new ExtendBlock(CompatibleBlockSettings.of(CompatibleMaterial.STONE)));
        EXAMPLE_BLOCK_ITEM = registry.registerItem(id("example_block"), () -> ItemUtil.ofBlock(EXAMPLE_BLOCK.supplier.get(), new CompatibleItemSettings().addGroup(() -> DefaultItemGroups.INGREDIENTS, id("example_block"))));

        EXAMPLE_GUI_ITEM = registry.registerItem(id("example_gui_item"), () -> new ExampleGuiItem(new CompatibleItemSettings().addGroup(() -> DefaultItemGroups.INGREDIENTS, id("example_gui_item"))));

        EXAMPLE_GUI_BLOCK = registry.registerBlock(id("example_gui_block"), () -> new ExampleGuiBlock(CompatibleBlockSettings.of(CompatibleMaterial.STONE).build()));
        EXAMPLE_GUI_BLOCK_ITEM = registry.registerItem(id("example_gui_block"), () -> ItemUtil.ofBlock(EXAMPLE_GUI_BLOCK.supplier.get(), new CompatibleItemSettings().addGroup(() -> DefaultItemGroups.INGREDIENTS, id("example_gui_block"))));

        // en: Register all registered creative tabs and others , ja: 登録された全てのクリエイティブタブやその他を登録します
        registry.allRegister();

        // en: Register the command , ja: コマンドを登録します
        CommandRegistry.register("mpla", new ExampleCommand());
    }
}
