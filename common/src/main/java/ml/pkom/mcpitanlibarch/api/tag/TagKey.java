package ml.pkom.mcpitanlibarch.api.tag;

import dev.architectury.hooks.tags.TagHooks;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TagKey<T> {
    private final Tag.Identified<T> tagKey;

    @Deprecated
    public TagKey(Tag.Identified<T> tagKey) {
        this.tagKey = tagKey;
    }

    public static Tag.Identified<?> create(Type type, Identifier identifier) {
        switch (type) {
            case BLOCK:
                return TagHooks.optionalBlock(identifier);
            case ITEM:
                return TagHooks.optionalItem(identifier);
            case FLUID:
                return TagHooks.optionalFluid(identifier);
        }
        return null;
    }

    @Deprecated
    public Tag.Identified getTagKey() {
        return tagKey;
    }

    public enum Type {
        BLOCK,
        ITEM,
        FLUID,
    }

    public boolean isOf(T value) {
        return tagKey.contains(value);
    }
}
