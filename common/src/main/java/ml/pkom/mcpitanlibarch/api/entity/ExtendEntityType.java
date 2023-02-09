package ml.pkom.mcpitanlibarch.api.entity;

import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.resource.featuretoggle.FeatureFlags;

public class ExtendEntityType<T extends Entity> extends EntityType<T> {
    private final Boolean alwaysUpdateVelocity;

    public ExtendEntityType(EntityType.EntityFactory<T> factory, SpawnGroup spawnGroup, boolean saveable, boolean summonable, boolean fireImmune, boolean spawnableFarFromPlayer, ImmutableSet<Block> canSpawnBlocks, EntityDimensions entityDimensions, int maxTrackDistance, int trackTickInterval, Boolean alwaysUpdateVelocity) {
        super(factory, spawnGroup, saveable, summonable, fireImmune, spawnableFarFromPlayer, canSpawnBlocks, entityDimensions, maxTrackDistance, trackTickInterval, FeatureFlags.DEFAULT_ENABLED_FEATURES);
        this.alwaysUpdateVelocity = alwaysUpdateVelocity;
    }

    @Override
    public boolean alwaysUpdateVelocity() {
        if (alwaysUpdateVelocity != null)
            return alwaysUpdateVelocity;

        return super.alwaysUpdateVelocity();
    }
}
