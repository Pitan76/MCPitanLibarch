package ml.pkom.mcpitanlibarch.api.util;

import ml.pkom.mcpitanlibarch.api.entity.Player;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayerUtil {

    public static Player getPlayerByUUID(MinecraftServer server, UUID uuid) {
        return new Player(server.getPlayerManager().getPlayer(uuid));
    }

    public static Player getPlayerByName(MinecraftServer server, String name) {
        return new Player(server.getPlayerManager().getPlayer(name));
    }

    public static List<Player> getPlayersByIP(MinecraftServer server, String ip) {
        List<Player> players = new ArrayList<>();
        for (PlayerEntity p: server.getPlayerManager().getPlayersByIp(ip)) {
            players.add(new Player(p));
        }
        return players;
    }

    public static List<Player> getPlayers(MinecraftServer server) {
        List<Player> players = new ArrayList<>();
        for (PlayerEntity p : server.getPlayerManager().getPlayerList()) {
            players.add(new Player(p));
        }
        return players;
    }

    public static Player getPlayerByUUID(World world, UUID uuid) {
        return getPlayerByUUID(world.getServer(), uuid);
    }

    public static Player getPlayerByName(World world, String name) {
        return getPlayerByName(world.getServer(), name);
    }

    public static boolean isExistByUUID(MinecraftServer server, UUID uuid) {
        return server.getPlayerManager().getPlayer(uuid) != null;
    }

    public static boolean isExistByUUID(World world, UUID uuid) {
        return isExistByUUID(world.getServer(), uuid);
    }

    public static boolean isExistByName(MinecraftServer server, String name) {
        return server.getPlayerManager().getPlayer(name) != null;
    }

    public static boolean isExistByName(World world, String name) {
        return isExistByName(world.getServer(), name);
    }

    public static boolean isExistByIP(MinecraftServer server, String ip) {
        return !server.getPlayerManager().getPlayersByIp(ip).isEmpty();
    }

    public static boolean isExistByIP(World world, String ip) {
        return isExistByIP(world.getServer(), ip);
    }
    
    public static void sendMessage(Player player, String message) {
        player.sendMessage(TextUtil.literal(message));
    }

    public static float getYaw(Player player) {
        return player.getYaw();
    }

    public static float getPitch(Player player) {
        return player.getPitch();
    }

    public static BlockPos getBlockPos(Player player) {
        return player.getBlockPos();
    }

    public static World getWorld(Player player) {
        return player.getWorld();
    }

    public static boolean isClient(Player player) {
        return player.isClient();
    }

    public static void teleport(Player player, double x, double y, double z) {
        player.teleport(x, y, z);
    }
}
