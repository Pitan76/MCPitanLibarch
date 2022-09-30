package dev.architectury.networking;

import me.shedaniel.architectury.networking.NetworkManager.NetworkReceiver;
import me.shedaniel.architectury.networking.transformers.PacketSink;
import me.shedaniel.architectury.networking.transformers.PacketTransformer;
import me.shedaniel.architectury.utils.Env;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.ApiStatus;

import javax.annotation.Nullable;
import java.util.List;

public final class NetworkManager {
    public static void registerReceiver(Side side, Identifier id, NetworkReceiver receiver) {
        me.shedaniel.architectury.networking.NetworkManager.registerReceiver(sideConvert(side), id, (buf, context) -> {receiver.receive(buf, contextConvert(context));});
    }

    @ApiStatus.Experimental
    public static void registerReceiver(Side side, Identifier id, List<PacketTransformer> packetTransformers, NetworkReceiver receiver) {
        me.shedaniel.architectury.networking.NetworkManager.registerReceiver(sideConvert(side), id, packetTransformers, (buf, context) -> {receiver.receive(buf, contextConvert(context));});
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    @SuppressWarnings("unchecked")
    public static Packet<?> toPacket(Side side, Identifier id, PacketByteBuf buf) {
        return me.shedaniel.architectury.networking.NetworkManager.toPacket(sideConvert(side), id, buf);
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    @SuppressWarnings("unchecked")
    public static List<Packet<?>> toPackets(Side side, Identifier id, PacketByteBuf buf) {
        return me.shedaniel.architectury.networking.NetworkManager.toPackets(sideConvert(side), id, buf);

    }

    public static void collectPackets(PacketSink sink, Side side, Identifier id, PacketByteBuf buf) {
        me.shedaniel.architectury.networking.NetworkManager.collectPackets(sink, sideConvert(side), id, buf);
    }

    public static void sendToPlayer(ServerPlayerEntity player, Identifier id, PacketByteBuf buf) {
        me.shedaniel.architectury.networking.NetworkManager.sendToPlayer(player, id, buf);
    }

    public static void sendToPlayers(Iterable<ServerPlayerEntity> players, Identifier id, PacketByteBuf buf) {
        me.shedaniel.architectury.networking.NetworkManager.sendToPlayers(players, id, buf);
    }

    @Environment(EnvType.CLIENT)
    public static void sendToServer(Identifier id, PacketByteBuf buf) {
        me.shedaniel.architectury.networking.NetworkManager.sendToServer(id, buf);
    }

    @Environment(EnvType.CLIENT)
    public static boolean canServerReceive(Identifier id) {
        return me.shedaniel.architectury.networking.NetworkManager.canServerReceive(id);
    }

    public static boolean canPlayerReceive(ServerPlayerEntity player, Identifier id) {
        return me.shedaniel.architectury.networking.NetworkManager.canPlayerReceive(player, id);
    }

    public static Packet<?> createAddEntityPacket(Entity entity) {
        return me.shedaniel.architectury.networking.NetworkManager.createAddEntityPacket(entity);
    }

    @FunctionalInterface
    public interface NetworkReceiver {
        void receive(PacketByteBuf buf, PacketContext context);
    }

    public interface PacketContext {
        PlayerEntity getPlayer();

        void queue(Runnable runnable);

        Env getEnvironment();

        default EnvType getEnv() {
            return getEnvironment().toPlatform();
        }
    }

    public static Side s2c() {
        return Side.S2C;
    }

    public static Side c2s() {
        return Side.C2S;
    }

    public static Side serverToClient() {
        return Side.S2C;
    }

    public static Side clientToServer() {
        return Side.C2S;
    }

    public enum Side {
        S2C,
        C2S
    }

    @Nullable
    private static me.shedaniel.architectury.networking.NetworkManager.Side sideConvert(Side side) {
        switch (side) {
            case S2C:
                return me.shedaniel.architectury.networking.NetworkManager.Side.S2C;
            case C2S:
                return me.shedaniel.architectury.networking.NetworkManager.Side.C2S;
        }
        return null;
    }

    private static PacketContext contextConvert(me.shedaniel.architectury.networking.NetworkManager.PacketContext context) {
        return new PacketContext() {
            @Override
            public PlayerEntity getPlayer() {
                return context.getPlayer();
            }

            @Override
            public void queue(Runnable runnable) {
                context.queue(runnable);
            }

            @Override
            public Env getEnvironment() {
                return context.getEnvironment();
            }
        };
    }
}