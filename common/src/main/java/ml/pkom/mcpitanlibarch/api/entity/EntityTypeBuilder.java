package ml.pkom.mcpitanlibarch.api.entity;

import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;

public class EntityTypeBuilder<T extends Entity> {

    private SpawnGroup spawnGroup;
    private EntityType.EntityFactory<T> factory;
    private EntityDimensions entityDimensions;
    private boolean saveable;
    private boolean summonable;
    private boolean fireImmune;
    private boolean spawnableFarFromPlayer;
    private ImmutableSet<Block> canSpawnBlocks;
    private int maxTrackDistance;
    private int trackTickInterval;
    private Boolean alwaysUpdateVelocity = null;


    @Deprecated
    // Recommend: create()
    public EntityTypeBuilder() {
        setSaveable(true);
        setSummonable(true);
        setFireImmune(false);
        setChangingDimensions(-1.0f, -1.0f);
        spawnableFarFromPlayer = false;
        maxTrackDistance = 5;
        trackTickInterval = 3;
        canSpawnBlocks = ImmutableSet.of();
    }

    @Deprecated
    public EntityTypeBuilder(SpawnGroup spawnGroup, EntityType.EntityFactory<T> factory) {
        setSaveable(true);
        setSummonable(true);
        setFireImmune(false);
        setChangingDimensions(-1.0f, -1.0f);
        spawnableFarFromPlayer = false;
        maxTrackDistance = 5;
        trackTickInterval = 3;
        canSpawnBlocks = ImmutableSet.of();
        this.spawnGroup = spawnGroup;
        this.factory = factory;
    }

    public static <T extends Entity> EntityTypeBuilder<T> create() {
        return new EntityTypeBuilder<>();
    }

    public static <T extends Entity> EntityTypeBuilder<T> create(SpawnGroup spawnGroup, EntityType.EntityFactory<T> factory) {
        return new EntityTypeBuilder<>(spawnGroup, factory);
    }

    public EntityType<T> build() {
        return new ExtendEntityType<>(factory, spawnGroup, saveable, summonable, fireImmune, spawnableFarFromPlayer, canSpawnBlocks, entityDimensions, maxTrackDistance, trackTickInterval, alwaysUpdateVelocity);
    }

    public EntityTypeBuilder<T> setSpawnGroup(SpawnGroup spawnGroup) {
        this.spawnGroup = spawnGroup;
        return this;
    }

    public EntityTypeBuilder<T> setEntityFactory(EntityType.EntityFactory<T> factory) {
        this.factory = factory;
        return this;
    }

    public EntityTypeBuilder<T> setDimensions(EntityDimensions entityDimensions) {
        this.entityDimensions = entityDimensions;
        return this;
    }

    public EntityTypeBuilder<T> setFixedDimensions(float width, float height) {
        return setDimensions(EntityDimensions.fixed(width, height));
    }

    public EntityTypeBuilder<T> setChangingDimensions(float width, float height) {
        return setDimensions(EntityDimensions.changing(width, height));
    }

    public EntityTypeBuilder<T> setSaveable(boolean saveable) {
        this.saveable = saveable;
        return this;
    }

    public EntityTypeBuilder<T> setSummonable(boolean summonable) {
        this.summonable = summonable;
        return this;
    }

    public EntityTypeBuilder<T> setFireImmune(boolean fireImmune) {
        this.fireImmune = fireImmune;
        return this;
    }

    public EntityTypeBuilder<T> setSpawnableFarFromPlayer(boolean spawnableFarFromPlayer) {
        this.spawnableFarFromPlayer = spawnableFarFromPlayer;
        return this;
    }

    public EntityTypeBuilder<T> setCanSpawnBlocks(ImmutableSet<Block> canSpawnBlocks) {
        this.canSpawnBlocks = canSpawnBlocks;
        return this;
    }

    public EntityTypeBuilder<T> setMaxTrackDistance(int maxTrackDistance) {
        this.maxTrackDistance = maxTrackDistance;
        return this;
    }

    public EntityTypeBuilder<T> setTrackTickInterval(int trackTickInterval) {
        this.trackTickInterval = trackTickInterval;
        return this;
    }

    public EntityTypeBuilder<T> setAlwaysUpdateVelocity(Boolean alwaysUpdateVelocity) {
        this.alwaysUpdateVelocity = alwaysUpdateVelocity;
        return this;
    }
}
