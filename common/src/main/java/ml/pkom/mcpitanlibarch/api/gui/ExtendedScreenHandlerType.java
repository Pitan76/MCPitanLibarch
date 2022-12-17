package ml.pkom.mcpitanlibarch.api.gui;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public class ExtendedScreenHandlerType<T extends ExtendedScreenHandler> extends ScreenHandlerType<T> {

    public ExtendedScreenHandlerType(Factory<T> factory) {
        super(factory);
        this.factory = factory;
    }

    private final Factory<T> factory;

    public T create(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
        return this.factory.create(syncId, playerInventory, buf);
    }

    public interface Factory<T extends ScreenHandler> extends ScreenHandlerType.Factory<T> {
        T create(int syncId, PlayerInventory playerInventory, PacketByteBuf buf);
    }
}
