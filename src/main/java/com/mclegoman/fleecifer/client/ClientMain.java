/*
    Fleecifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Fleecifer
    License: GNU LGPLv3
*/

package com.mclegoman.fleecifer.client;

import com.mclegoman.fleecifer.client.model.Models;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

public class ClientMain implements ClientModInitializer {
	@Override
	public void onInitializeClient(ModContainer mod) {
		Models.init();
	}
}
