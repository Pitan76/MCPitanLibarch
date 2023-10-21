package ml.pkom.mcpitanlibarch.api.util;

import ml.pkom.mcpitanlibarch.api.entity.Player;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
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
}
