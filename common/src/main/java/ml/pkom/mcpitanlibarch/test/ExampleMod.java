package ml.pkom.mcpitanlibarch.test;

import ml.pkom.mcpitanlibarch.api.event.registry.RegistryEvent;
import ml.pkom.mcpitanlibarch.api.registry.ArchRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
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

    public static void init() {
        registry.registerItem(id("example_item"), () -> new Item(new Item.Settings().group(ItemGroup.MISC)));
        RegistryEvent<Block> EXAMPLE_BLOCK_SUPPLIER = registry.registerBlock(id("example_block"), () -> new Block(AbstractBlock.Settings.of(Material.STONE)));
        registry.registerItem(id("example_block"), () -> new BlockItem(EXAMPLE_BLOCK_SUPPLIER.supplier.get(), new Item.Settings().group(ItemGroup.MISC)));
        registry.allRegister();
    }
}
