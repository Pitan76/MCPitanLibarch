package ml.pkom.mcpitanlibarch.api.packet;

public class UpdatePacketType {
    public static final UpdatePacketType NONE = new UpdatePacketType("NONE");
    public static final UpdatePacketType BLOCK_ENTITY_UPDATE_S2C = new UpdatePacketType("BLOCK_ENTITY_UPDATE_S2C");

    public final String name;

    public UpdatePacketType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public UpdatePacketType fromName(String name) {
        switch (name) {
            case "NONE":
                return NONE;
            case "BLOCK_ENTITY_UPDATE_S2C":
                return BLOCK_ENTITY_UPDATE_S2C;
        }
        return null;
    }
}
