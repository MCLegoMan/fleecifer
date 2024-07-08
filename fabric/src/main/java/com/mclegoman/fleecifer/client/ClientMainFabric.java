/*
    Fleecifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Fleecifer
    License: GNU LGPLv3
*/

package com.mclegoman.fleecifer.client;

import com.mclegoman.fleecifer.client.util.PerspectiveCompat;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public final class ClientMainFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient()  {
        PerspectiveCompat.installed = FabricLoader.getInstance().isModLoaded("perspective");
        ClientMain.init();
    }
}
