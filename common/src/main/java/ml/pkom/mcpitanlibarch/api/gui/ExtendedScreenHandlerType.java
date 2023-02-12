package ml.pkom.mcpitanlibarch.api.gui;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public class ExtendedScreenHandlerType<T extends ExtendedScreenHandler> extends ScreenHandlerType<T> {

    private final Factory<T> factory;

    public ExtendedScreenHandlerType(Factory<T> factory) {
        super(null);
        this.factory = factory;

    }

    public T create(int syncId, PlayerInventory inventory, PacketByteBuf buf) {
        return factory.create(syncId, inventory, buf);
    }

    @FunctionalInterface
    public interface Factory<T extends ScreenHandler> {
        T create(int syncId, PlayerInventory inventory, PacketByteBuf buf);
    }
}
