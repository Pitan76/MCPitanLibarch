package ml.pkom.mcpitanlibarch.api.network;

import io.netty.buffer.Unpooled;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtTagSizeTracker;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

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
        if (obj instanceof ItemStack) {
            ItemStack stack = (ItemStack) obj;
            buf.writeItemStack(stack);
        }
        if (obj instanceof Identifier) {
            Identifier identifier = (Identifier) obj;
            buf.writeIdentifier(identifier);
        }
        if (obj instanceof Float) {
            Float f = (Float) obj;
            buf.writeFloat(f);
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
        if (obj instanceof Map) {
            Map map = (Map) obj;
            writeMap(buf, map);
        }
    }

    public static PacketByteBuf writeNbt(PacketByteBuf buf, NbtCompound nbt) {
        return buf.writeNbt(nbt);
    }

    public static NbtCompound readNbt(PacketByteBuf buf) {
        return buf.readNbt();
    }

    public static PacketByteBuf writeItemStack(PacketByteBuf buf, ItemStack stack) {
        return buf.writeItemStack(stack);
    }

    public static ItemStack readItemStack(PacketByteBuf buf) {
        return buf.readItemStack();
    }

    public static PacketByteBuf writeIdentifier(PacketByteBuf buf, Identifier identifier) {
        return buf.writeIdentifier(identifier);
    }

    public static Identifier readIdentifier(PacketByteBuf buf) {
        return buf.readIdentifier();
    }

    public static PacketByteBuf writeText(PacketByteBuf buf, Text text) {
        return buf.writeText(text);
    }

    public static Text readText(PacketByteBuf buf) {
        return buf.readText();
    }

    public static PacketByteBuf writeBlockPos(PacketByteBuf buf, BlockPos pos) {
        return buf.writeBlockPos(pos);
    }

    public static BlockPos readBlockPos(PacketByteBuf buf) {
        return buf.readBlockPos();
    }

    public static PacketByteBuf writeUuid(PacketByteBuf buf, UUID uuid) {
        return buf.writeUuid(uuid);
    }

    public static UUID readUuid(PacketByteBuf buf) {
        return buf.readUuid();
    }

    public static PacketByteBuf writeVarInt(PacketByteBuf buf, int i) {
        return buf.writeVarInt(i);
    }

    public static int readVarInt(PacketByteBuf buf) {
        return buf.readVarInt();
    }

    public static PacketByteBuf writeVarLong(PacketByteBuf buf, long l) {
        return buf.writeVarLong(l);
    }

    public static long readVarLong(PacketByteBuf buf) {
        return buf.readVarLong();
    }

    public static PacketByteBuf writeBoolean(PacketByteBuf buf, boolean b) {
        return buf.writeBoolean(b);
    }

    public static boolean readBoolean(PacketByteBuf buf) {
        return buf.readBoolean();
    }

    public static PacketByteBuf writeByte(PacketByteBuf buf, byte b) {
        return buf.writeByte(b);
    }

    public static byte readByte(PacketByteBuf buf) {
        return buf.readByte();
    }

    public static PacketByteBuf writeShort(PacketByteBuf buf, short s) {
        return buf.writeShort(s);
    }

    public static short readShort(PacketByteBuf buf) {
        return buf.readShort();
    }

    public static PacketByteBuf writeInt(PacketByteBuf buf, int i) {
        return buf.writeInt(i);
    }

    public static int readInt(PacketByteBuf buf) {
        return buf.readInt();
    }

    public static PacketByteBuf writeLong(PacketByteBuf buf, long l) {
        return buf.writeLong(l);
    }

    public static long readLong(PacketByteBuf buf) {
        return buf.readLong();
    }

    public static PacketByteBuf writeFloat(PacketByteBuf buf, float f) {
        return buf.writeFloat(f);
    }

    public static float readFloat(PacketByteBuf buf) {
        return buf.readFloat();
    }

    public static PacketByteBuf writeDouble(PacketByteBuf buf, double d) {
        return buf.writeDouble(d);
    }

    public static double readDouble(PacketByteBuf buf) {
        return buf.readDouble();
    }

    public static PacketByteBuf writeByteArray(PacketByteBuf buf, byte[] bytes) {
        return buf.writeByteArray(bytes);
    }

    public static byte[] readByteArray(PacketByteBuf buf) {
        return buf.readByteArray();
    }

    public static PacketByteBuf writeString(PacketByteBuf buf, String s) {
        return buf.writeString(s);
    }

    public static String readString(PacketByteBuf buf) {
        return buf.readString();
    }

    public static PacketByteBuf writeIntArray(PacketByteBuf buf, int[] ints) {
        return buf.writeIntArray(ints);
    }

    public static int[] readIntArray(PacketByteBuf buf) {
        return buf.readIntArray();
    }

    public static PacketByteBuf writeLongArray(PacketByteBuf buf, long[] longs) {
        return buf.writeLongArray(longs);
    }

    public static long[] readLongArray(PacketByteBuf buf) {
        return buf.readLongArray();
    }

    public static NbtElement readUnlimitedNbt(PacketByteBuf buf) {
        return buf.readNbt(NbtTagSizeTracker.ofUnlimitedBytes());
    }
}


