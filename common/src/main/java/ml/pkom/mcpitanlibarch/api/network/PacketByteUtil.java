package ml.pkom.mcpitanlibarch.api.network;

import com.google.common.collect.Maps;
import io.netty.buffer.Unpooled;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class PacketByteUtil {
    public static PacketByteBuf create() {
        return new PacketByteBuf(Unpooled.buffer());
    }


    public static PacketByteBuf empty() {
        return new PacketByteBuf(Unpooled.EMPTY_BUFFER);
    }

    public static <K, V> Map<K, V> readMap(PacketByteBuf buf, Function<PacketByteBuf, K> keyParser, Function<PacketByteBuf, V> valueParser) {
        return buf.readMap(keyParser, valueParser);
    }

    public static <K, V> void writeMap(PacketByteBuf buf, Map<K, V> map) {
        writeMap(buf, map, PacketByteUtil::writeVar, PacketByteUtil::writeVar);
    }

    public static <K, V> void writeMap(PacketByteBuf buf, Map<K, V> map, BiConsumer<PacketByteBuf, K> keySerializer, BiConsumer<PacketByteBuf, V> valueSerializer) {
        buf.writeMap(map, keySerializer, valueSerializer);
    }

    public static void writeVar(PacketByteBuf buf, Object obj) {
        if (obj instanceof String) {
            String s = (String) obj;
            buf.writeString(s);
        }
        if (obj instanceof Integer) {
            int i = (int) obj;
            buf.writeInt(i);
        }
        if (obj instanceof Long) {
            long l = (long) obj;
            buf.writeLong(l);
        }
        if (obj instanceof Short) {
            short s = (short) obj;
            buf.writeShort(s);
        }
        if (obj instanceof Boolean) {
            boolean b = (boolean) obj;
            buf.writeBoolean(b);
        }
        if (obj instanceof Byte) {
            byte b = (byte) obj;
            buf.writeByte(b);
        }
        if (obj instanceof NbtCompound) {
            NbtCompound nbt = (NbtCompound) obj;
            buf.writeNbt(nbt);
        }
        if (obj instanceof UUID) {
            UUID uuid = (UUID) obj;
            buf.writeUuid(uuid);
        }
        if (obj instanceof Text) {
            Text text = (Text) obj;
            buf.writeText(text);
        }
        if (obj instanceof BlockPos) {
            BlockPos pos = (BlockPos) obj;
            buf.writeBlockPos(pos);
        }
    }
}


