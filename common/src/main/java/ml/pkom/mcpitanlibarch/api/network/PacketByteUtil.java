package ml.pkom.mcpitanlibarch.api.network;

import io.netty.buffer.Unpooled;
import net.minecraft.network.PacketByteBuf;

public class PacketByteUtil {
    public static PacketByteBuf create() {
        return new PacketByteBuf(Unpooled.buffer());
    }


    public static PacketByteBuf empty() {
        return new PacketByteBuf(Unpooled.EMPTY_BUFFER);
    }
}
