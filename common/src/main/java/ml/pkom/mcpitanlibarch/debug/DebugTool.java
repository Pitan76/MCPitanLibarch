package ml.pkom.mcpitanlibarch.debug;

import ml.pkom.mcpitanlibarch.api.item.CompatibleItemSettings;
import ml.pkom.mcpitanlibarch.api.item.ExtendItem;

import static ml.pkom.mcpitanlibarch.MCPitanLibarch.*;

/**
 * A tool for debugging.
 * Example of condition: item instance DebugTool
 */
public class DebugTool extends ExtendItem {

    public static CompatibleItemSettings defaultSettings = CompatibleItemSettings.of();

    public DebugTool() {
        super(defaultSettings);
    }

    public static void debug(String message) {
        System.out.println(message);
    }

    public static void register() {
        registry.registerItem(id("debug_tool"), DebugTool::new);
    }
}
