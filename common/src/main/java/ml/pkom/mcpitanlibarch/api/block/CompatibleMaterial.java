package ml.pkom.mcpitanlibarch.api.block;

import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
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
    private Material material;

    public CompatibleMaterial(MapColor color, boolean liquid, boolean solid, boolean burnable, boolean replaceable, PistonBehavior pistonBehavior) {
        this.color = color;
        this.liquid = liquid;
        this.solid = solid;
        this.burnable = burnable;
        this.replaceable = replaceable;
        this.pistonBehavior = pistonBehavior;
        this.material = Material.STONE;
    }

    private CompatibleMaterial(Material material, MapColor color, boolean liquid, boolean solid, boolean burnable, boolean replaceable, PistonBehavior pistonBehavior) {
        this(material.getColor(), material.isLiquid(), material.isSolid(), material.isBurnable(), material.isReplaceable(), material.getPistonBehavior());
        this.material = material;
    }

    @Deprecated
    public Material getMaterial() {
        return material;
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
        AIR = (new Builder(MapColor.CLEAR)).allowsMovement().lightPassesThrough().notSolid().replaceable().material(Material.AIR).build();
        STRUCTURE_VOID = (new Builder(MapColor.CLEAR)).allowsMovement().lightPassesThrough().notSolid().replaceable().material(Material.STRUCTURE_VOID).build();
        PORTAL = (new Builder(MapColor.CLEAR)).allowsMovement().lightPassesThrough().notSolid().blocksPistons().material(Material.PORTAL).build();
        CARPET = (new Builder(MapColor.WHITE_GRAY)).allowsMovement().lightPassesThrough().notSolid().burnable().material(Material.CARPET).build();
        PLANT = (new Builder(MapColor.DARK_GREEN)).allowsMovement().lightPassesThrough().notSolid().destroyedByPiston().material(Material.PLANT).build();
        UNDERWATER_PLANT = (new Builder(MapColor.WATER_BLUE)).allowsMovement().lightPassesThrough().notSolid().destroyedByPiston().material(Material.UNDERWATER_PLANT).build();
        REPLACEABLE_PLANT = (new Builder(MapColor.DARK_GREEN)).allowsMovement().lightPassesThrough().notSolid().destroyedByPiston().replaceable().burnable().material(Material.REPLACEABLE_PLANT).build();
        NETHER_SHOOTS = (new Builder(MapColor.DARK_GREEN)).allowsMovement().lightPassesThrough().notSolid().destroyedByPiston().replaceable().material(Material.NETHER_SHOOTS).build();
        REPLACEABLE_UNDERWATER_PLANT = (new Builder(MapColor.WATER_BLUE)).allowsMovement().lightPassesThrough().notSolid().destroyedByPiston().replaceable().material(Material.REPLACEABLE_UNDERWATER_PLANT).build();
        WATER = (new Builder(MapColor.WATER_BLUE)).allowsMovement().lightPassesThrough().notSolid().destroyedByPiston().replaceable().liquid().material(Material.WATER).build();
        BUBBLE_COLUMN = (new Builder(MapColor.WATER_BLUE)).allowsMovement().lightPassesThrough().notSolid().destroyedByPiston().replaceable().liquid().material(Material.BUBBLE_COLUMN).build();
        LAVA = (new Builder(MapColor.BRIGHT_RED)).allowsMovement().lightPassesThrough().notSolid().destroyedByPiston().replaceable().liquid().material(Material.LAVA).build();
        SNOW_LAYER = (new Builder(MapColor.WHITE)).allowsMovement().lightPassesThrough().notSolid().destroyedByPiston().replaceable().material(Material.SNOW_LAYER).build();
        FIRE = (new Builder(MapColor.CLEAR)).allowsMovement().lightPassesThrough().notSolid().destroyedByPiston().replaceable().material(Material.FIRE).build();
        DECORATION = (new Builder(MapColor.CLEAR)).allowsMovement().lightPassesThrough().notSolid().destroyedByPiston().material(Material.DECORATION).build();
        COBWEB = (new Builder(MapColor.WHITE_GRAY)).allowsMovement().lightPassesThrough().destroyedByPiston().material(Material.COBWEB).build();
        SCULK = (new Builder(MapColor.BLACK)).build();
        REDSTONE_LAMP = (new Builder(MapColor.CLEAR)).material(Material.REDSTONE_LAMP).build();
        ORGANIC_PRODUCT = (new Builder(MapColor.LIGHT_BLUE_GRAY)).material(Material.ORGANIC_PRODUCT).build();
        SOIL = (new Builder(MapColor.DIRT_BROWN)).material(Material.SOIL).build();
        SOLID_ORGANIC = (new Builder(MapColor.PALE_GREEN)).material(Material.SOLID_ORGANIC).build();
        DENSE_ICE = (new Builder(MapColor.PALE_PURPLE)).material(Material.DENSE_ICE).build();
        AGGREGATE = (new Builder(MapColor.PALE_YELLOW)).material(Material.AGGREGATE).build();
        SPONGE = (new Builder(MapColor.YELLOW)).material(Material.SPONGE).build();
        SHULKER_BOX = (new Builder(MapColor.PURPLE)).material(Material.SHULKER_BOX).build();
        WOOD = (new Builder(MapColor.OAK_TAN)).burnable().material(Material.WOOD).build();
        NETHER_WOOD = (new Builder(MapColor.OAK_TAN)).material(Material.NETHER_WOOD).build();
        BAMBOO_SAPLING = (new Builder(MapColor.OAK_TAN)).burnable().destroyedByPiston().allowsMovement().material(Material.BAMBOO_SAPLING).build();
        BAMBOO = (new Builder(MapColor.OAK_TAN)).burnable().destroyedByPiston().material(Material.BAMBOO).build();
        WOOL = (new Builder(MapColor.WHITE_GRAY)).burnable().material(Material.WOOL).build();
        TNT = (new Builder(MapColor.BRIGHT_RED)).burnable().lightPassesThrough().material(Material.TNT).build();
        LEAVES = (new Builder(MapColor.DARK_GREEN)).burnable().lightPassesThrough().destroyedByPiston().material(Material.LEAVES).build();
        GLASS = (new Builder(MapColor.CLEAR)).lightPassesThrough().material(Material.GLASS).build();
        ICE = (new Builder(MapColor.PALE_PURPLE)).lightPassesThrough().material(Material.ICE).build();
        CACTUS = (new Builder(MapColor.DARK_GREEN)).lightPassesThrough().destroyedByPiston().material(Material.CACTUS).build();
        STONE = (new Builder(MapColor.STONE_GRAY)).material(Material.STONE).build();
        METAL = (new Builder(MapColor.IRON_GRAY)).material(Material.METAL).build();
        SNOW_BLOCK = (new Builder(MapColor.WHITE)).material(Material.SNOW_BLOCK).build();
        REPAIR_STATION = (new Builder(MapColor.IRON_GRAY)).blocksPistons().material(Material.REPAIR_STATION).build();
        BARRIER = (new Builder(MapColor.CLEAR)).blocksPistons().material(Material.BARRIER).build();
        PISTON = (new Builder(MapColor.STONE_GRAY)).blocksPistons().material(Material.PISTON).build();
        MOSS_BLOCK = (new Builder(MapColor.DARK_GREEN)).destroyedByPiston().material(Material.MOSS_BLOCK).build();
        GOURD = (new Builder(MapColor.DARK_GREEN)).destroyedByPiston().material(Material.GOURD).build();
        EGG = (new Builder(MapColor.DARK_GREEN)).destroyedByPiston().material(Material.EGG).build();
        CAKE = (new Builder(MapColor.CLEAR)).destroyedByPiston().material(Material.CAKE).build();
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
        private Material material = Material.STONE;

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

        protected Builder material(Material material) {
            this.material = material;
            return this;
        }

        public CompatibleMaterial build() {
            return new CompatibleMaterial(material, this.color, this.liquid, this.solid, this.burnable, this.replaceable, this.pistonBehavior);
        }
    }
}
