/*
    Fleecifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Fleecifer
    License: GNU LGPLv3
*/

package com.mclegoman.fleecifer.client;

import com.mclegoman.fleecifer.client.util.PerspectiveCompat;

public class ClientMainInit {
    public static void onInitializeClient()  {
        PerspectiveCompat.installed = false; // Perspective is not available for NeoForge.
        ClientMain.init();
    }
}
