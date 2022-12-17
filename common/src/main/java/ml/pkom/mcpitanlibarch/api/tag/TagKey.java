package ml.pkom.mcpitanlibarch.api.tag;

import me.shedaniel.architectury.hooks.TagHooks;
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
                return new TagKey<>(TagHooks.getBlockOptional(identifier));
            case ITEM:
                return new TagKey<>(TagHooks.getItemOptional(identifier));
            case FLUID:
                return new TagKey<>(TagHooks.getFluidOptional(identifier));
            case ENTITY_TYPE:
                return new TagKey<>(TagHooks.getEntityTypeOptional(identifier));
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
