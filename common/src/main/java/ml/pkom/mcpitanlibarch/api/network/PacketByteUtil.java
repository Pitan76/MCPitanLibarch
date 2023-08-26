package ml.pkom.mcpitanlibarch.api.network;

import io.netty.buffer.Unpooled;
import net.minecraft.item.ItemStack;
import ml.pkom.mcpitanlibarch.api.util.TextUtil;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
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
        NbtCompound nbt = buf.readUnlimitedNbt();
        Map<K, V> map = new HashMap<>();
        for (String key_v : Objects.requireNonNull(nbt).getKeys()) {
            if (key_v.endsWith("_t") || key_v.endsWith("_k")) continue;
            String key = key_v.substring(0, key_v.length() - 2);
            String key_t = key + "_t";
            key_v = key + "_v";

            V v;
            switch (key_t) {
                case "int":
                    v = (V) Integer.valueOf(nbt.getInt(key_v));
                    break;
                case "str":
                    v = (V) nbt.getString(key_v);
                    break;
                case "short":
                    v = (V) Short.valueOf(nbt.getShort(key_v));
                    break;
                case "long":
                    v = (V) Long.valueOf(nbt.getLong(key_v));
                    break;
                case "float":
                    v = (V) Float.valueOf(nbt.getFloat(key_v));
                    break;
                case "byte":
                    v = (V) Byte.valueOf(nbt.getByte(key_v));
                    break;
                case "double":
                    v = (V) Double.valueOf(nbt.getDouble(key_v));
                    break;
                case "bool":
                    v = (V) Boolean.valueOf(nbt.getBoolean(key_v));
                    break;
                case "uuid":
                    v = (V) nbt.getUuid(key_v);
                    break;
                case "text":
                    v = (V) TextUtil.literal(nbt.getString(key_v));
                    break;
                case "itemstack":
                    v = (V) ItemStack.fromNbt(nbt.getCompound(key_v));
                    break;
                case "identifier":
                    v = (V) new Identifier(nbt.getString(key_v));
                    break;
                default:
                    v = null;
                    break;
            }

            K k;
            switch (nbt.getString("type_k")) {
                case "int":
                    k = (K) Integer.valueOf(key);
                    break;
                case "str":
                    k = (K) key;
                    break;
                case "short":
                    k = (K) Short.valueOf(key);
                    break;
                case "long":
                    k = (K) Long.valueOf(key);
                    break;
                case "float":
                    k = (K) Float.valueOf(key);
                    break;
                case "byte":
                    k = (K) Byte.valueOf(key);
                    break;
                case "double":
                    k = (K) Double.valueOf(key);
                    break;
                case "bool":
                    k = (K) Boolean.valueOf(key);
                    break;
                case "uuid":
                    k = (K) UUID.fromString(key);
                    break;
                case "text":
                    k = (K) TextUtil.literal(key);
                    break;
                case "identifier":
                    k = (K) new Identifier(key);
                    break;
                default:
                    k = null;
                    break;
            }

            if (k == null || v == null) continue;
            map.put(k, v);
        }
        return map;
    }

    public static <K, V> void writeMap(PacketByteBuf buf, Map<K, V> map) {
        writeMap(buf, map, PacketByteUtil::writeVar, PacketByteUtil::writeVar);
    }

    public static <K, V> void writeMap(PacketByteBuf buf, Map<K, V> map, BiConsumer<PacketByteBuf, K> keySerializer, BiConsumer<PacketByteBuf, V> valueSerializer) {
        NbtCompound nbt = new NbtCompound();

        K lastK = null;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            K k = entry.getKey();
            V v = entry.getValue();
            lastK = k;
            String key = k.toString();
            if (v instanceof Integer) {
                nbt.putInt(key + "_v", (int) v);
                nbt.putString(key + "_t", "int");
            }
            if (v instanceof String) {
                nbt.putString(key, (String) v);
                nbt.putString(key + "_t", "str");
            }
            if (v instanceof Long) {
                nbt.putLong(key, (long) v);
                nbt.putString(key + "_t", "long");
            }
            if (v instanceof Short) {
                nbt.putShort(key, (short) v);
                nbt.putString(key + "_t", "short");
            }
            if (v instanceof Double) {
                nbt.putDouble(key, (double) v);
                nbt.putString(key + "_t", "double");
            }
            if (v instanceof Boolean) {
                nbt.putBoolean(key, (boolean) v);
                nbt.putString(key + "_t", "bool");
            }
            if (v instanceof Float) {
                nbt.putFloat(key, (float) v);
                nbt.putString(key + "_t", "float");
            }
            if (v instanceof Byte) {
                nbt.putByte(key, (byte) v);
                nbt.putString(key + "_t", "byte");
            }
            if (v instanceof UUID) {
                nbt.putUuid(key, (UUID) v);
                nbt.putString(key + "_t", "uuid");
            }
            if (v instanceof Text) {
                nbt.putString(key, ((Text) v).getString());
                nbt.putString(key + "_t", "text");
            }
            if (v instanceof ItemStack) {
                NbtCompound stackNbt = new NbtCompound();
                ((ItemStack) v).writeNbt(stackNbt);
                nbt.put(key, stackNbt);
                nbt.putString(key + "_t", "itemstack");
            }
            if (v instanceof Identifier) {
                nbt.putString(key, v.toString());
                nbt.putString(key + "_t", "identifier");
            }
        }

        if (lastK == null) return;

        if (lastK instanceof Integer) {
            nbt.putString("type_k", "int");
        }
        if (lastK instanceof String) {
            nbt.putString("type_k", "str");
        }
        if (lastK instanceof Long) {
            nbt.putString("type_k", "long");
        }
        if (lastK instanceof Short) {
            nbt.putString("type_k", "short");
        }
        if (lastK instanceof Double) {
            nbt.putString("type_k", "double");
        }
        if (lastK instanceof Boolean) {
            nbt.putString("type_k", "bool");
        }
        if (lastK instanceof Float) {
            nbt.putString("type_k", "float");
        }
        if (lastK instanceof Byte) {
            nbt.putString("type_k", "byte");
        }
        if (lastK instanceof UUID) {
            nbt.putString("type_k", "uuid");
        }
        if (lastK instanceof Text) {
            nbt.putString("type_k", "text");
        }
        if (lastK instanceof ItemStack) {
            nbt.putString("type_k", "itemstack");
        }
        if (lastK instanceof Identifier) {
            nbt.putString("type_k", "identifier");
        }

        buf.writeNbt(nbt);
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
}


