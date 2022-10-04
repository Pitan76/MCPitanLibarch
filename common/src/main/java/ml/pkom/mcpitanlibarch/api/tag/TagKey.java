package ml.pkom.mcpitanlibarch.api.tag;

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
        switch (type) {
            case BLOCK:
                new TagKey<>(net.minecraft.tag.TagKey.of(Registry.BLOCK_KEY, identifier));
            case ITEM:
                new TagKey<>(net.minecraft.tag.TagKey.of(Registry.ITEM_KEY, identifier));
            case FLUID:
                new TagKey<>(net.minecraft.tag.TagKey.of(Registry.FLUID_KEY, identifier));
        }
        return null;
    }

    @Deprecated
    public net.minecraft.tag.TagKey<T> getTagKey() {
        return tagKey;
    }

    public enum Type {
        BLOCK,
        ITEM,
        FLUID,
    }

    public boolean isOf(T value) {
        return RegistryEntry.of(value).isIn(tagKey);
    }
}
