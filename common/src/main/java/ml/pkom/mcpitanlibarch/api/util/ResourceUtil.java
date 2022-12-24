package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ResourceUtil {
    public static Resource getResource(ResourceManager resourceManager, Identifier identifier) {
        return resourceManager.getResource(identifier).get();
    }

    public static InputStream getInputStream(Resource resource) throws IOException {
        return resource.getInputStream();
    }

    public static Map<Identifier, Resource> findResources(ResourceManager resourceManager, String startingPath, String endingPath) throws IOException {
        return resourceManager.findResources(startingPath, s -> s.toString().endsWith(endingPath));
    }

    public static void close(Resource resource) throws IOException {
        getInputStream(resource).close();
    }
}
