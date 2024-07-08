/*
    Fleecifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Fleecifer
    License: GNU LGPLv3
*/

package com.mclegoman.fleecifer.client;

import com.mclegoman.fleecifer.client.model.Models;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod("fleecifer")
public class ClientMain {
	public ClientMain(IEventBus modEventBus) {
		Models.init();
	}
}
