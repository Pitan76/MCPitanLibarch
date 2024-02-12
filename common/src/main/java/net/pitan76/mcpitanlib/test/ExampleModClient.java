package net.pitan76.mcpitanlib.test;

import ml.pkom.mcpitanlibarch.api.client.registry.ArchRegistryClient;

public class ExampleModClient {
    public static void init() {
        ArchRegistryClient.registerScreen(ExampleMod.supplierEXAMPLE_SCREENHANDLER.getOrNull(), ExampleScreen::new);
    }
}
