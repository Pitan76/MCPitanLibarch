package ml.pkom.mcpitanlibarch.api.util;

import dev.architectury.registry.menu.ExtendedMenuProvider;
import dev.architectury.registry.menu.MenuRegistry;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.Registries;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.collection.DefaultedList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ScreenHandlerUtil {
    public static DefaultedList<Slot> getSlots(ScreenHandler screenHandler) {
        return screenHandler.slots;
    }

    public static Slot getSlot(ScreenHandler screenHandler, int index) {
        return screenHandler.getSlot(index);
    }

    public static List<ScreenHandlerType<?>> getAllScreenHandlerTypes() {
        List<ScreenHandlerType<?>> screenHandlerTypes = new ArrayList<>();
        for (ScreenHandlerType<?> screenHandler : Registries.SCREEN_HANDLER) {
            screenHandlerTypes.add(screenHandler);
        }
        return screenHandlerTypes;
    }

    public static void openExtendedMenu(ServerPlayerEntity player, NamedScreenHandlerFactory provider, Consumer<PacketByteBuf> bufWriter) {
        MenuRegistry.openExtendedMenu(player, provider, bufWriter);
    }

    public static void openExtendedMenu(ServerPlayerEntity player, ExtendedMenuProvider provider) {
        MenuRegistry.openExtendedMenu(player, provider);
    }

    public static void openMenu(ServerPlayerEntity player, NamedScreenHandlerFactory provider) {
        MenuRegistry.openMenu(player, provider);
    }

    public static int getRawId(ScreenHandlerType<?> type) {
        return Registries.SCREEN_HANDLER.getRawId(type);
    }

    public static ScreenHandlerType<?> fromIndex(int index) {
        return Registries.SCREEN_HANDLER.get(index);
    }
}
