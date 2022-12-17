package ml.pkom.mcpitanlibarch.api.gui;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandlerType;
import org.jetbrains.annotations.Nullable;

public class ExtendedScreenHandler extends SimpleScreenHandler {
    protected ExtendedScreenHandler(@Nullable ScreenHandlerType<?> type, int syncId, PacketByteBuf buf) {
        this(type, syncId);
    }

    protected ExtendedScreenHandler(@Nullable ScreenHandlerType<?> type, int syncId) {
        super(type, syncId);
    }
}
