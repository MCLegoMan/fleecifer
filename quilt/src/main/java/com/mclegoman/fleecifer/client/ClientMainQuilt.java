package com.mclegoman.fleecifer.client;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

public final class ClientMainQuilt implements ClientModInitializer {
    @Override
    public void onInitializeClient(ModContainer modContainer)  {
        ClientMain.init();
    }
}
