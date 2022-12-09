package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.registry.Registries;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.collection.DefaultedList;

import java.util.ArrayList;
import java.util.List;

public class ScreenHandlerUtil {
    public static DefaultedList<Slot> getSlots(ScreenHandler screenHandler) {
        return screenHandler.slots;
    }

    public static List<ScreenHandlerType<?>> getAllScreenHandlerTypes() {
        List<ScreenHandlerType<?>> screenHandlerTypes = new ArrayList<>();
        for (ScreenHandlerType<?> screenHandler : Registries.SCREEN_HANDLER) {
            screenHandlerTypes.add(screenHandler);
        }
        return screenHandlerTypes;
    }
}
