/*
    Fleecifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Fleecifer
    License: GNU LGPLv3
*/

package com.mclegoman.fleecifer.client;

import net.fabricmc.api.ClientModInitializer;

public final class ClientMainFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient()  {
        ClientMain.init();
    }
}
