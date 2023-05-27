package ml.pkom.mcpitanlibarch.api.block;

import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;

public final class CompatibleMaterial {
    public static final CompatibleMaterial AIR;
    public static final CompatibleMaterial STRUCTURE_VOID;
    public static final CompatibleMaterial PORTAL;
    public static final CompatibleMaterial CARPET;
    public static final CompatibleMaterial PLANT;
    public static final CompatibleMaterial UNDERWATER_PLANT;
    public static final CompatibleMaterial REPLACEABLE_PLANT;
    public static final CompatibleMaterial NETHER_SHOOTS;
    public static final CompatibleMaterial REPLACEABLE_UNDERWATER_PLANT;
    public static final CompatibleMaterial WATER;
    public static final CompatibleMaterial BUBBLE_COLUMN;
    public static final CompatibleMaterial LAVA;
    public static final CompatibleMaterial SNOW_LAYER;
    public static final CompatibleMaterial FIRE;
    public static final CompatibleMaterial DECORATION;
    public static final CompatibleMaterial COBWEB;
    public static final CompatibleMaterial SCULK;
    public static final CompatibleMaterial REDSTONE_LAMP;
    public static final CompatibleMaterial ORGANIC_PRODUCT;
    public static final CompatibleMaterial SOIL;
    public static final CompatibleMaterial SOLID_ORGANIC;
    public static final CompatibleMaterial DENSE_ICE;
    public static final CompatibleMaterial AGGREGATE;
    public static final CompatibleMaterial SPONGE;
    public static final CompatibleMaterial SHULKER_BOX;
    public static final CompatibleMaterial WOOD;
    public static final CompatibleMaterial NETHER_WOOD;
    public static final CompatibleMaterial BAMBOO_SAPLING;
    public static final CompatibleMaterial BAMBOO;
    public static final CompatibleMaterial WOOL;
    public static final CompatibleMaterial TNT;
    public static final CompatibleMaterial LEAVES;
    public static final CompatibleMaterial GLASS;
    public static final CompatibleMaterial ICE;
    public static final CompatibleMaterial CACTUS;
    public static final CompatibleMaterial STONE;
    public static final CompatibleMaterial METAL;
    public static final CompatibleMaterial SNOW_BLOCK;
    public static final CompatibleMaterial REPAIR_STATION;
    public static final CompatibleMaterial BARRIER;
    public static final CompatibleMaterial PISTON;
    public static final CompatibleMaterial MOSS_BLOCK;
    public static final CompatibleMaterial GOURD;
    public static final CompatibleMaterial EGG;
    public static final CompatibleMaterial CAKE;
    public static final CompatibleMaterial AMETHYST;
    public static final CompatibleMaterial POWDER_SNOW;
    private final MapColor color;
    private final PistonBehavior pistonBehavior;
    private final boolean burnable;
    private final boolean liquid;
    private final boolean replaceable;
    private final boolean solid;

    public CompatibleMaterial(MapColor color, boolean liquid, boolean solid, boolean burnable, boolean replaceable, PistonBehavior pistonBehavior) {
        this.color = color;
        this.liquid = liquid;
        this.solid = solid;
        this.burnable = burnable;
        this.replaceable = replaceable;
        this.pistonBehavior = pistonBehavior;
    }

    public boolean isLiquid() {
        return this.liquid;
    }

    public boolean isSolid() {
        return this.solid;
    }

    public boolean isBurnable() {
        return this.burnable;
    }

    public boolean isReplaceable() {
        return this.replaceable;
    }

    public PistonBehavior getPistonBehavior() {
        return this.pistonBehavior;
    }

    public MapColor getColor() {
        return this.color;
    }

    static {
        AIR = (new Builder(MapColor.CLEAR)).allowsMovement().lightPassesThrough().notSolid().replaceable().build();
        STRUCTURE_VOID = (new Builder(MapColor.CLEAR)).allowsMovement().lightPassesThrough().notSolid().replaceable().build();
        PORTAL = (new Builder(MapColor.CLEAR)).allowsMovement().lightPassesThrough().notSolid().blocksPistons().build();
        CARPET = (new Builder(MapColor.WHITE_GRAY)).allowsMovement().lightPassesThrough().notSolid().burnable().build();
        PLANT = (new Builder(MapColor.DARK_GREEN)).allowsMovement().lightPassesThrough().notSolid().destroyedByPiston().build();
        UNDERWATER_PLANT = (new Builder(MapColor.WATER_BLUE)).allowsMovement().lightPassesThrough().notSolid().destroyedByPiston().build();
        REPLACEABLE_PLANT = (new Builder(MapColor.DARK_GREEN)).allowsMovement().lightPassesThrough().notSolid().destroyedByPiston().replaceable().burnable().build();
        NETHER_SHOOTS = (new Builder(MapColor.DARK_GREEN)).allowsMovement().lightPassesThrough().notSolid().destroyedByPiston().replaceable().build();
        REPLACEABLE_UNDERWATER_PLANT = (new Builder(MapColor.WATER_BLUE)).allowsMovement().lightPassesThrough().notSolid().destroyedByPiston().replaceable().build();
        WATER = (new Builder(MapColor.WATER_BLUE)).allowsMovement().lightPassesThrough().notSolid().destroyedByPiston().replaceable().liquid().build();
        BUBBLE_COLUMN = (new Builder(MapColor.WATER_BLUE)).allowsMovement().lightPassesThrough().notSolid().destroyedByPiston().replaceable().liquid().build();
        LAVA = (new Builder(MapColor.BRIGHT_RED)).allowsMovement().lightPassesThrough().notSolid().destroyedByPiston().replaceable().liquid().build();
        SNOW_LAYER = (new Builder(MapColor.WHITE)).allowsMovement().lightPassesThrough().notSolid().destroyedByPiston().replaceable().build();
        FIRE = (new Builder(MapColor.CLEAR)).allowsMovement().lightPassesThrough().notSolid().destroyedByPiston().replaceable().build();
        DECORATION = (new Builder(MapColor.CLEAR)).allowsMovement().lightPassesThrough().notSolid().destroyedByPiston().build();
        COBWEB = (new Builder(MapColor.WHITE_GRAY)).allowsMovement().lightPassesThrough().destroyedByPiston().build();
        SCULK = (new Builder(MapColor.BLACK)).build();
        REDSTONE_LAMP = (new Builder(MapColor.CLEAR)).build();
        ORGANIC_PRODUCT = (new Builder(MapColor.LIGHT_BLUE_GRAY)).build();
        SOIL = (new Builder(MapColor.DIRT_BROWN)).build();
        SOLID_ORGANIC = (new Builder(MapColor.PALE_GREEN)).build();
        DENSE_ICE = (new Builder(MapColor.PALE_PURPLE)).build();
        AGGREGATE = (new Builder(MapColor.PALE_YELLOW)).build();
        SPONGE = (new Builder(MapColor.YELLOW)).build();
        SHULKER_BOX = (new Builder(MapColor.PURPLE)).build();
        WOOD = (new Builder(MapColor.OAK_TAN)).burnable().build();
        NETHER_WOOD = (new Builder(MapColor.OAK_TAN)).build();
        BAMBOO_SAPLING = (new Builder(MapColor.OAK_TAN)).burnable().destroyedByPiston().allowsMovement().build();
        BAMBOO = (new Builder(MapColor.OAK_TAN)).burnable().destroyedByPiston().build();
        WOOL = (new Builder(MapColor.WHITE_GRAY)).burnable().build();
        TNT = (new Builder(MapColor.BRIGHT_RED)).burnable().lightPassesThrough().build();
        LEAVES = (new Builder(MapColor.DARK_GREEN)).burnable().lightPassesThrough().destroyedByPiston().build();
        GLASS = (new Builder(MapColor.CLEAR)).lightPassesThrough().build();
        ICE = (new Builder(MapColor.PALE_PURPLE)).lightPassesThrough().build();
        CACTUS = (new Builder(MapColor.DARK_GREEN)).lightPassesThrough().destroyedByPiston().build();
        STONE = (new Builder(MapColor.STONE_GRAY)).build();
        METAL = (new Builder(MapColor.IRON_GRAY)).build();
        SNOW_BLOCK = (new Builder(MapColor.WHITE)).build();
        REPAIR_STATION = (new Builder(MapColor.IRON_GRAY)).blocksPistons().build();
        BARRIER = (new Builder(MapColor.CLEAR)).blocksPistons().build();
        PISTON = (new Builder(MapColor.STONE_GRAY)).blocksPistons().build();
        MOSS_BLOCK = (new Builder(MapColor.DARK_GREEN)).destroyedByPiston().build();
        GOURD = (new Builder(MapColor.DARK_GREEN)).destroyedByPiston().build();
        EGG = (new Builder(MapColor.DARK_GREEN)).destroyedByPiston().build();
        CAKE = (new Builder(MapColor.CLEAR)).destroyedByPiston().build();
        AMETHYST = (new Builder(MapColor.PURPLE)).build();
        POWDER_SNOW = (new Builder(MapColor.WHITE)).notSolid().allowsMovement().build();
    }

    public static class Builder {
        private PistonBehavior pistonBehavior;
        private boolean blocksMovement;
        private boolean burnable;
        private boolean liquid;
        private boolean replaceable;
        private boolean solid;
        private final MapColor color;
        private boolean blocksLight;

        public Builder(MapColor color) {
            this.pistonBehavior = PistonBehavior.NORMAL;
            this.blocksMovement = true;
            this.solid = true;
            this.blocksLight = true;
            this.color = color;
        }

        public Builder liquid() {
            this.liquid = true;
            return this;
        }

        public Builder notSolid() {
            this.solid = false;
            return this;
        }

        public Builder allowsMovement() {
            this.blocksMovement = false;
            return this;
        }

        Builder lightPassesThrough() {
            this.blocksLight = false;
            return this;
        }

        protected Builder burnable() {
            this.burnable = true;
            return this;
        }

        public Builder replaceable() {
            this.replaceable = true;
            return this;
        }

        protected Builder destroyedByPiston() {
            this.pistonBehavior = PistonBehavior.DESTROY;
            return this;
        }

        protected Builder blocksPistons() {
            this.pistonBehavior = PistonBehavior.BLOCK;
            return this;
        }

        public CompatibleMaterial build() {
            return new CompatibleMaterial(this.color, this.liquid, this.solid, this.burnable, this.replaceable, this.pistonBehavior);
        }
    }
}
