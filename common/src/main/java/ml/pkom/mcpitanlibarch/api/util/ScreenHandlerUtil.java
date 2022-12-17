package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class ScreenHandlerUtil {
    public static DefaultedList<Slot> getSlots(ScreenHandler screenHandler) {
        DefaultedList<Slot> slots = DefaultedList.of();
        slots.addAll(screenHandler.slots);
        return slots;
    }

    public static Slot getSlot(ScreenHandler screenHandler, int index) {
        return screenHandler.getSlot(index);
    }

    public static List<ScreenHandlerType<?>> getAllScreenHandlerTypes() {
        List<ScreenHandlerType<?>> screenHandlerTypes = new ArrayList<>();
        for (ScreenHandlerType<?> screenHandler : Registry.SCREEN_HANDLER) {
            screenHandlerTypes.add(screenHandler);
        }
        return screenHandlerTypes;
    }
}
