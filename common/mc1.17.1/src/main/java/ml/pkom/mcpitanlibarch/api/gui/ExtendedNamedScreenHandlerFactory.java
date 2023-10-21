package ml.pkom.mcpitanlibarch.api.gui;

import dev.architectury.registry.menu.ExtendedMenuProvider;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerFactory;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

public class ExtendedNamedScreenHandlerFactory implements ExtendedMenuProvider {

    private final Text name;
    private final ScreenHandlerFactory baseFactory;
    private final PacketByteBufFactory bufFactory;

    public ExtendedNamedScreenHandlerFactory(Text name, ScreenHandlerFactory baseFactory, PacketByteBufFactory bufFactory) {
        this.name = name;
        this.baseFactory = baseFactory;
        this.bufFactory = bufFactory;
    }

    @Override
    public void saveExtraData(PacketByteBuf buf) {
        bufFactory.saveExtraData(buf);
    }

    @Override
    public Text getDisplayName() {
        return name;
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return baseFactory.createMenu(syncId, inv, player);

    }

    @FunctionalInterface
    public interface PacketByteBufFactory {
        void saveExtraData(PacketByteBuf buf);
    }
}
