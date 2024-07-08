/*
    Fleecifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Fleecifer
    License: GNU LGPLv3
*/

package com.mclegoman.fleecifer.client;

import com.mclegoman.fleecifer.client.util.PerspectiveCompat;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

@Mod(value = "fleecifer", dist = Dist.CLIENT)
public final class ClientMainNeoForge {
    public ClientMainNeoForge() {
        PerspectiveCompat.installed = false; // Perspective is not available for NeoForge.
        ClientMain.init();
    }
}
