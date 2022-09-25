package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemUtil {
    public static Item item(Identifier id) {
        return Registry.ITEM.get(id);
    }
}
