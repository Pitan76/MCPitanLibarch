package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ResourceUtil {
    public static Resource getResource(ResourceManager resourceManager, Identifier identifier) throws IOException {
        return resourceManager.getResource(identifier);
    }

    public static InputStream getInputStream(Resource resource) {
        return resource.getInputStream();
    }

    public static Map<Identifier, Resource> findResources(ResourceManager resourceManager, String startingPath, String endingPath) throws IOException {
        Map<Identifier, Resource> map = new HashMap<>();
        for (Identifier identifier : resourceManager.findResources(startingPath, s -> s.endsWith(endingPath))) {
            map.put(identifier, resourceManager.getResource(identifier));
        }
        return map;
    }

    public static void close(Resource resource) throws IOException {
        resource.close();
    }
}
