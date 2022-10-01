package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.collection.DefaultedList;

public class ScreenHandlerUtil {
    public static DefaultedList<Slot> getSlots(ScreenHandler screenHandler) {
        return screenHandler.slots;
    }
}
