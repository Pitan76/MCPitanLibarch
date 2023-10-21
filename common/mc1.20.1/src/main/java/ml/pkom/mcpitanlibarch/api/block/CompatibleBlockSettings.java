package ml.pkom.mcpitanlibarch.api.block;

import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;

import java.util.function.Function;
import java.util.function.ToIntFunction;

public class CompatibleBlockSettings {
    private final AbstractBlock.Settings settings;

    public CompatibleBlockSettings() {
        this.settings = AbstractBlock.Settings.create();
    }

    private static CompatibleBlockSettings copyCompatibleMaterial(CompatibleMaterial material, CompatibleBlockSettings settings) {
        settings.mapColor(material.getColor());
        if (material.isLiquid())
            settings.settings.liquid();
        if (material.isSolid())
            settings.settings.solid();
        if (material.isReplaceable())
            settings.settings.replaceable();
        if (material.isSolid())
            settings.settings.solid();
        if (material.isBurnable())
            settings.settings.burnable();
        settings.settings.pistonBehavior(material.getPistonBehavior());
        return settings;
    }

    public CompatibleBlockSettings(CompatibleMaterial material, MapColor mapColor) {
        this.settings = AbstractBlock.Settings.create();
        copyCompatibleMaterial(material, this);
        mapColor(mapColor);
    }

    public CompatibleBlockSettings(CompatibleMaterial material, DyeColor dyeColor) {
        this.settings = AbstractBlock.Settings.create();
        copyCompatibleMaterial(material, this);
        mapColor(dyeColor);
    }

    public CompatibleBlockSettings(CompatibleMaterial material) {
        this.settings = AbstractBlock.Settings.create();
        copyCompatibleMaterial(material, this);
    }

    public CompatibleBlockSettings(CompatibleMaterial material, Function<BlockState, MapColor> mapColor) {
        this.settings = AbstractBlock.Settings.create();
        copyCompatibleMaterial(material, this);
        mapColor(mapColor);
    }

    public static CompatibleBlockSettings of(CompatibleMaterial material, MapColor mapColor) {
        return new CompatibleBlockSettings(material, mapColor);
    }

    public static CompatibleBlockSettings of(CompatibleMaterial material, DyeColor dyeColor) {
        return new CompatibleBlockSettings(material, dyeColor);
    }

    public static CompatibleBlockSettings of(CompatibleMaterial material) {
        return new CompatibleBlockSettings(material);
    }

    public static CompatibleBlockSettings of(CompatibleMaterial material, Function<BlockState, MapColor> mapColor) {
        return new CompatibleBlockSettings(material, mapColor);
    }

    public CompatibleBlockSettings(AbstractBlock block) {
        this.settings = AbstractBlock.Settings.copy(block);
    }

    public static CompatibleBlockSettings copy(AbstractBlock block) {
        return new CompatibleBlockSettings(block);
    }

    public CompatibleBlockSettings air() {
        settings.air();
        return this;
    }

    public CompatibleBlockSettings blockVision(AbstractBlock.ContextPredicate predicate) {
        settings.blockVision(predicate);
        return this;
    }

    public CompatibleBlockSettings postProcess(AbstractBlock.ContextPredicate predicate) {
        settings.postProcess(predicate);
        return this;
    }

    public CompatibleBlockSettings solidBlock(AbstractBlock.ContextPredicate predicate) {
        settings.solidBlock(predicate);
        return this;
    }

    public CompatibleBlockSettings suffocates(AbstractBlock.ContextPredicate predicate) {
        settings.suffocates(predicate);
        return this;
    }

    public CompatibleBlockSettings mapColor(MapColor color) {
        settings.mapColor(color);
        return this;
    }

    public CompatibleBlockSettings mapColor(DyeColor color) {
        settings.mapColor(color);
        return this;
    }

    public CompatibleBlockSettings mapColor(Function<BlockState, MapColor> color) {
        settings.mapColor(color);
        return this;
    }

    public CompatibleBlockSettings dropsLike(Block source) {
        settings.dropsLike(source);
        return this;
    }

    public CompatibleBlockSettings breakInstantly() {
        settings.breakInstantly();
        return this;
    }

    public CompatibleBlockSettings dropsNothing() {
        settings.dropsNothing();
        return this;
    }

    public CompatibleBlockSettings dynamicBounds() {
        settings.dynamicBounds();
        return this;
    }

    public CompatibleBlockSettings hardness(float hardness) {
        settings.hardness(hardness);
        return this;
    }

    public CompatibleBlockSettings noBlockBreakParticles() {
        settings.noBlockBreakParticles();
        return this;
    }

    public CompatibleBlockSettings requiresTool() {
        settings.requiresTool();
        return this;
    }

    public CompatibleBlockSettings noCollision() {
        settings.noCollision();
        return this;
    }

    public CompatibleBlockSettings nonOpaque() {
        settings.nonOpaque();
        return this;
    }

    public CompatibleBlockSettings resistance(float resistance) {
        settings.resistance(resistance);
        return this;
    }

    public CompatibleBlockSettings strength(float strength) {
        settings.strength(strength);
        return this;
    }

    public CompatibleBlockSettings strength(float hardness, float resistance) {
        settings.strength(hardness, resistance);
        return this;
    }

    public CompatibleBlockSettings ticksRandomly() {
        settings.ticksRandomly();
        return this;
    }

    public CompatibleBlockSettings sounds(BlockSoundGroup blockSoundGroup) {
        settings.sounds(blockSoundGroup);
        return this;
    }

    public CompatibleBlockSettings luminance(ToIntFunction<BlockState> luminance) {
        settings.luminance(luminance);
        return this;
    }

    public CompatibleBlockSettings jumpVelocityMultiplier(float jumpVelocityMultiplier) {
        settings.jumpVelocityMultiplier(jumpVelocityMultiplier);
        return this;
    }

    public CompatibleBlockSettings slipperiness(float slipperiness) {
        settings.slipperiness(slipperiness);
        return this;
    }

    public CompatibleBlockSettings velocityMultiplier(float velocityMultiplier) {
        settings.velocityMultiplier(velocityMultiplier);
        return this;
    }

    public CompatibleBlockSettings emissiveLighting(AbstractBlock.ContextPredicate predicate) {
        settings.emissiveLighting(predicate);
        return this;
    }

    public CompatibleBlockSettings offset(AbstractBlock.OffsetType offsetType) {
        settings.offset(offsetType);
        return this;
    }

    public CompatibleBlockSettings allowsSpawning(AbstractBlock.TypedContextPredicate<net.minecraft.entity.EntityType<?>> predicate) {
        settings.allowsSpawning(predicate);
        return this;
    }

    public AbstractBlock.Settings build() {
        return settings;

    }
}
