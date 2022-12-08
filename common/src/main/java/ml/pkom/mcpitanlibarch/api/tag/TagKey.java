package ml.pkom.mcpitanlibarch.api.tag;

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
        return RegistryEntry.of(value).isIn(tagKey);
    }
}
