package ml.pkom.mcpitanlibarch.api.gui;

import dev.architectury.registry.menu.MenuRegistry;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public class SimpleScreenHandlerTypeBuilder<T extends ScreenHandler> {

    private final Factory<T> factory;

    public SimpleScreenHandlerTypeBuilder(Factory<T> factory) {
        this.factory = factory;
    }

    public ScreenHandlerType<T> build() {
        return MenuRegistry.of(factory::create);
    }

    @FunctionalInterface
    public interface Factory<T extends ScreenHandler> {
        T create(int syncId, PlayerInventory inventory);
    }
}
