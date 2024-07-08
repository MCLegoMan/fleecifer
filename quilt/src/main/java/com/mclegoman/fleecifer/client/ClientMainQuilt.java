/*
    Fleecifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Fleecifer
    License: GNU LGPLv3
*/

package com.mclegoman.fleecifer.client;

import com.mclegoman.fleecifer.client.util.PerspectiveCompat;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.QuiltLoader;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

public final class ClientMainQuilt implements ClientModInitializer {
    @Override
    public void onInitializeClient(ModContainer modContainer)  {
        PerspectiveCompat.installed = QuiltLoader.isModLoaded("perspective");
        ClientMain.init();
    }
}
