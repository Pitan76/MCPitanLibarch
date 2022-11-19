package ml.pkom.mcpitanlibarch.api.world;

import ml.pkom.mcpitanlibarch.api.util.WorldUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ExtendWorld {
    public World world;
    public ExtendWorld(World world) {
        this.world = world;
    }

    public boolean isDay() {
        return WorldUtil.isDay(world);
    }

    public boolean isThundering() {
        return WorldUtil.isThundering(world);
    }

    public boolean isSkyVisible(BlockPos pos) {
        return WorldUtil.isSkyVisible(world, pos);
    }

    public boolean isRaining() {
        return WorldUtil.isRaining(world);
    }

    public boolean hasSkyLight() {
        return WorldUtil.hasSkyLight(world);
    }
    
    public boolean isNight() {
        return WorldUtil.isNight(world);
    }

    public boolean isClient() {
        return WorldUtil.isClient(world);
    }

    public boolean isServer() {
        return WorldUtil.isServer(world);
    }

    public World getMinecraftWorld() {
        return world;
    }
}
