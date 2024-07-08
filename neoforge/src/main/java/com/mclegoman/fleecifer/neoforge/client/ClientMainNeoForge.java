package com.mclegoman.fleecifer.neoforge.client;

import com.mclegoman.fleecifer.core.client.ClientMain;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

@Mod(value = "fleecifer", dist = Dist.CLIENT)
public final class ClientMainNeoForge {
    public ClientMainNeoForge() {
        ClientMain.init();
    }
}
