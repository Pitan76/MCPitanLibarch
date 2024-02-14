package ml.pkom.mcpitanlibarch.api.tag;

import net.pitan76.mcpitanlib.api.util.v1.BlockUtilV1;
import ml.pkom.mcpitanlibarch.api.util.EntityTypeUtil;
import ml.pkom.mcpitanlibarch.api.util.FluidUtil;
import net.pitan76.mcpitanlib.api.util.v1.ItemUtilV1;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class TagKey<T> {
    private final net.minecraft.registry.tag.TagKey<T> tagKey;

    @Deprecated
    public TagKey(net.minecraft.registry.tag.TagKey<T> tagKey) {
        this.tagKey = tagKey;
    }

    public static TagKey<?> create(Type type, Identifier identifier) {
        return switch (type) {
            case BLOCK -> new TagKey<>(net.minecraft.registry.tag.TagKey.of(RegistryKeys.BLOCK, identifier));
            case ITEM -> new TagKey<>(net.minecraft.registry.tag.TagKey.of(RegistryKeys.ITEM, identifier));
            case FLUID -> new TagKey<>(net.minecraft.registry.tag.TagKey.of(RegistryKeys.FLUID, identifier));
            case ENTITY_TYPE -> new TagKey<>(net.minecraft.registry.tag.TagKey.of(RegistryKeys.ENTITY_TYPE, identifier));
        };
    }

    @Deprecated
    public net.minecraft.registry.tag.TagKey<T> getTagKey() {
        return tagKey;
    }

    public enum Type {
        BLOCK,
        ITEM,
        FLUID,
        ENTITY_TYPE,
    }

    public boolean isOf(T value) {
        if (value instanceof Item)
            return getTagKey() == net.minecraft.registry.tag.TagKey.of(RegistryKeys.ITEM, ItemUtilV1.toID((Item) value));
        if (value instanceof Block)
            return getTagKey() == net.minecraft.registry.tag.TagKey.of(RegistryKeys.BLOCK, BlockUtilV1.toID((Block) value));
        if (value instanceof Fluid)
            return getTagKey() == net.minecraft.registry.tag.TagKey.of(RegistryKeys.FLUID, FluidUtil.toID((Fluid) value));
        if (value instanceof EntityType<?>)
            return getTagKey() == net.minecraft.registry.tag.TagKey.of(RegistryKeys.ENTITY_TYPE, EntityTypeUtil.toID((EntityType<?>) value));

        return RegistryEntry.of(value).isIn(getTagKey());
    }
}
