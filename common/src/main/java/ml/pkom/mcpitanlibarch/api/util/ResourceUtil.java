package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;

import java.io.IOException;
import java.util.Map;

public class ResourceUtil {
    public static Resource getResource(ResourceManager resourceManager, Identifier identifier) {
        return resourceManager.getResource(identifier).get();
    }

    public static Map<Identifier, Resource> findResources(ResourceManager resourceManager, String startingPath, String endingPath) {
        return resourceManager.findResources(startingPath, s -> s.toString().endsWith(endingPath));
    }

    public static void close(Resource resource) throws IOException {
        resource.getInputStream().close();
    }
}
