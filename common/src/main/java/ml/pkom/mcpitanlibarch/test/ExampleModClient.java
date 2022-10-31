package ml.pkom.mcpitanlibarch.test;

import dev.architectury.registry.menu.MenuRegistry;

public class ExampleModClient {
    public static void init() {
        MenuRegistry.registerScreenFactory(ExampleMod.supplierEXAMPLE_SCREENHANDLER.getOrNull(), ExampleScreen::new);
    }
}
