package ml.pkom.mcpitanlibarch.api.client.registry;

import dev.architectury.event.events.client.ClientTextureStitchEvent;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import dev.architectury.registry.client.particle.ParticleProviderRegistry;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import dev.architectury.registry.menu.MenuRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.ScreenHandlerProvider;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.Fluid;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

@Environment(EnvType.CLIENT)
public class ArchRegistryClient {
    public static <H extends ScreenHandler, S extends Screen & ScreenHandlerProvider<H>> void registerScreen(ScreenHandlerType<? extends H> type, ScreenFactory<H, S> factory) {
        MenuRegistry.registerScreenFactory(type, factory::create);
    }

    public interface ScreenFactory<H extends ScreenHandler, S extends Screen & ScreenHandlerProvider<H>> {
        S create(H handler, PlayerInventory inventory, Text text);
    }

    public static <T extends ParticleEffect> void registerParticle(ParticleType<T> type, ParticleFactory<T> factory) {
        ParticleProviderRegistry.register(type, factory);
    }

    public static <T extends ParticleEffect> void registerParticle(ParticleType<T> type, DeferredParticleProvider<T> provider) {
        ParticleProviderRegistry.register(type, spriteSet -> provider.create(new ExtendedSpriteSet() {
            @Override
            public SpriteAtlasTexture getAtlas() {
                return spriteSet.getAtlas();
            }

            @Override
            public List<Sprite> getSprites() {
                return spriteSet.getSprites();
            }

            @Override
            public Sprite getSprite(int age, int maxAge) {
                return spriteSet.getSprite(age, maxAge);
            }

            @Override
            public Sprite getSprite(Random random) {
                return spriteSet.getSprite(random);
            }
        }));
    }

    public static <T extends Entity> void registerEntityRenderer(Supplier<? extends EntityType<? extends T>> type, EntityRendererFactory<T> provider) {
        EntityRendererRegistry.register(type, provider);
    }

    @FunctionalInterface
    public interface DeferredParticleProvider<T extends ParticleEffect> {
        ParticleFactory<T> create(ExtendedSpriteSet spriteSet);
    }

    public interface ExtendedSpriteSet extends SpriteProvider {
        SpriteAtlasTexture getAtlas();

        List<Sprite> getSprites();
    }

    public static void registryClientSpriteAtlasTexture(Identifier identifier) {
        registryClientSprite(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE, identifier);
    }

    public static void registryClientSpriteAtlasTexture(Sprite sprite) {
        registryClientSprite(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE, sprite);
    }

    public static void registryClientSprite(Identifier atlasId, Identifier identifier) {
        ClientTextureStitchEvent.PRE.register(((atlas, spriteAdder) -> spriteAdder.accept(identifier)));
    }

    public static void registryClientSprite(Identifier atlasId, Sprite sprite) {
        ClientTextureStitchEvent.PRE.register(((atlas, spriteAdder) -> spriteAdder.accept(sprite.getId())));
    }

    public static <T extends BlockEntity> void registerBlockEntityRenderer(BlockEntityType<T> type, BlockEntityRendererFactory<T> provider) {
        BlockEntityRendererRegistry.register(type, ctx -> provider.create(new BlockEntityRendererFactory.Context(
                ctx.getRenderDispatcher(), ctx.getRenderManager(), ctx.getItemRenderer(), ctx.getEntityRenderDispatcher(), ctx.getLayerRenderDispatcher(), ctx.getTextRenderer()
        )));
    }

    @FunctionalInterface
    public interface BlockEntityRendererFactory<T extends BlockEntity> {
        BlockEntityRenderer<T> create(BlockEntityRendererFactory.Context ctx);

        class Context {
            private final BlockEntityRenderDispatcher renderDispatcher;
            private final BlockRenderManager renderManager;
            private final ItemRenderer itemRenderer;
            private final EntityRenderDispatcher entityRenderDispatcher;
            private final EntityModelLoader layerRenderDispatcher;
            private final TextRenderer textRenderer;

            public Context(BlockEntityRenderDispatcher renderDispatcher, BlockRenderManager renderManager, ItemRenderer itemRenderer, EntityRenderDispatcher entityRenderDispatcher, EntityModelLoader layerRenderDispatcher, TextRenderer textRenderer) {
                this.renderDispatcher = renderDispatcher;
                this.renderManager = renderManager;
                this.itemRenderer = itemRenderer;
                this.entityRenderDispatcher = entityRenderDispatcher;
                this.layerRenderDispatcher = layerRenderDispatcher;
                this.textRenderer = textRenderer;
            }

            public BlockEntityRenderDispatcher getRenderDispatcher() {
                return this.renderDispatcher;
            }

            public BlockRenderManager getRenderManager() {
                return this.renderManager;
            }

            public EntityRenderDispatcher getEntityRenderDispatcher() {
                return this.entityRenderDispatcher;
            }

            public ItemRenderer getItemRenderer() {
                return this.itemRenderer;
            }

            public EntityModelLoader getLayerRenderDispatcher() {
                return this.layerRenderDispatcher;
            }

            public ModelPart getLayerModelPart(EntityModelLayer modelLayer) {
                return this.layerRenderDispatcher.getModelPart(modelLayer);
            }

            public TextRenderer getTextRenderer() {
                return this.textRenderer;
            }
        }
    }


    public static void registerRenderTypeBlock(RenderLayer layer, Block block) {
        RenderTypeRegistry.register(layer, block);
    }

    public static void registerRenderTypeFluid(RenderLayer layer, Fluid fluid) {
        RenderTypeRegistry.register(layer, fluid);
    }
}
