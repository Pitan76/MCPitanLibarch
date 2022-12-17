package ml.pkom.mcpitanlibarch.api.tag;

import ml.pkom.mcpitanlibarch.api.util.BlockUtil;
import ml.pkom.mcpitanlibarch.api.util.EntityTypeUtil;
import ml.pkom.mcpitanlibarch.api.util.FluidUtil;
import ml.pkom.mcpitanlibarch.api.util.ItemUtil;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;

public class TagKey<T> {
    private final net.minecraft.tag.TagKey<T> tagKey;

    @Deprecated
    public TagKey(net.minecraft.tag.TagKey<T> tagKey) {
        this.tagKey = tagKey;
    }

    public static TagKey<?> create(Type type, Identifier identifier) {
        return switch (type) {
            case BLOCK -> new TagKey<>(net.minecraft.tag.TagKey.of(Registry.BLOCK_KEY, identifier));
            case ITEM -> new TagKey<>(net.minecraft.tag.TagKey.of(Registry.ITEM_KEY, identifier));
            case FLUID -> new TagKey<>(net.minecraft.tag.TagKey.of(Registry.FLUID_KEY, identifier));
            case ENTITY_TYPE -> new TagKey<>(net.minecraft.tag.TagKey.of(Registry.ENTITY_TYPE_KEY, identifier));
        };
    }

    @Deprecated
    public net.minecraft.tag.TagKey<T> getTagKey() {
        return tagKey;
    }

    public enum Type {
        BLOCK,
        ITEM,
        FLUID,
        ENTITY_TYPE;
    }

    public boolean isOf(T value) {
        if (value instanceof Item)
            return getTagKey() == net.minecraft.tag.TagKey.of(Registry.ITEM_KEY, ItemUtil.toID((Item) value));
        if (value instanceof Block)
            return getTagKey() == net.minecraft.tag.TagKey.of(Registry.BLOCK_KEY, BlockUtil.toID((Block) value));
        if (value instanceof Fluid)
            return getTagKey() == net.minecraft.tag.TagKey.of(Registry.FLUID_KEY, FluidUtil.toID((Fluid) value));
        if (value instanceof EntityType<?>)
            return getTagKey() == net.minecraft.tag.TagKey.of(Registry.ENTITY_TYPE_KEY, EntityTypeUtil.toID((EntityType<?>) value));

        return RegistryEntry.of(value).isIn(getTagKey());
    }
}
