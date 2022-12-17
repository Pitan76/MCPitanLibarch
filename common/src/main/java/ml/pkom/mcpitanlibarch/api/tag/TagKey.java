package ml.pkom.mcpitanlibarch.api.tag;

import dev.architectury.hooks.tags.TagHooks;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class TagKey<T> {
    private final Tag.Identified<T> tagKey;

    @Deprecated
    public TagKey(Tag.Identified<T> tagKey) {
        this.tagKey = tagKey;
    }

    public static TagKey<?> create(Type type, Identifier identifier) {
        switch (type) {
            case BLOCK:
                return new TagKey<>(TagHooks.optionalBlock(identifier));
            case ITEM:
                return new TagKey<>(TagHooks.optionalItem(identifier));
            case FLUID:
                return new TagKey<>(TagHooks.optionalFluid(identifier));
            case ENTITY_TYPE:
                return new TagKey<>(TagHooks.optionalEntityType(identifier));
            default:
                throw new IllegalArgumentException();
        }
    }

    @Deprecated
    public Tag.Identified<T> getTagKey() {
        return tagKey;
    }

    public enum Type {
        BLOCK,
        ITEM,
        FLUID,
        ENTITY_TYPE;
    }

    public boolean isOf(T value) {
        return tagKey.contains(value);
    }
}
