package com.mclegoman.fleecifer.quilt.client;

import com.mclegoman.fleecifer.core.client.ClientMain;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

public final class ClientMainQuilt implements ClientModInitializer {
    @Override
    public void onInitializeClient(ModContainer modContainer)  {
        ClientMain.init();
    }
}
