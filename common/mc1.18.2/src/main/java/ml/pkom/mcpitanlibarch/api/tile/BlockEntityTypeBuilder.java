package ml.pkom.mcpitanlibarch.api.tile;

import com.mojang.datafixers.types.Type;
import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlockEntityTypeBuilder<T extends BlockEntity> {
    private final Factory<? extends T> factory;
    private final List<Block> blocks;

    public BlockEntityTypeBuilder(Factory<? extends T> factory, List<Block> blocks) {
        this.factory = factory;
        this.blocks = blocks;
    }

    public static <T extends BlockEntity> BlockEntityTypeBuilder<T> create(Factory<? extends T> factory, Block... blocks) {
        List<Block> blocksList = new ArrayList<>(blocks.length);
        Collections.addAll(blocksList, blocks);

        return new BlockEntityTypeBuilder<>(factory, blocksList);
    }

    public BlockEntityTypeBuilder<T> addBlock(Block block) {
        this.blocks.add(block);
        return this;
    }

    public BlockEntityTypeBuilder<T> addBlocks(Block... blocks) {
        Collections.addAll(this.blocks, blocks);
        return this;
    }

    public BlockEntityType<T> build() {
        return build(null);
    }

    public BlockEntityType<T> build(Type<?> type) {
        return BlockEntityType.Builder.<T>create(factory::create, blocks.toArray(new Block[0])).build(type);
    }

    @FunctionalInterface
    public interface Factory<T extends BlockEntity> {
        T create(TileCreateEvent event);

        @Deprecated
        default T create(BlockPos pos, BlockState state) {
            return create(new TileCreateEvent(pos, state));
        }
    }
}
