package ml.pkom.mcpitanlibarch.api.gui;

import me.shedaniel.architectury.registry.MenuRegistry;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public class ExtendedScreenHandlerTypeBuilder<T extends ExtendedScreenHandler> {

    private final Factory<T> factory;

    public ExtendedScreenHandlerTypeBuilder(Factory<T> factory) {
        this.factory = factory;
    }

    public ScreenHandlerType<T> build() {
        return MenuRegistry.ofExtended(factory::create);
    }

    @FunctionalInterface
    public interface Factory<T extends ScreenHandler> {
        T create(int syncId, PlayerInventory inventory, PacketByteBuf buf);
    }
}
