/*
    Fleecifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Fleecifer
    License: GNU LGPLv3
*/

package com.mclegoman.fleecifer.client;

import com.mclegoman.fleecifer.client.util.PerspectiveCompat;
import org.quiltmc.loader.api.QuiltLoader;

public class ClientMainInit {
	public static void onInitializeClient()  {
		PerspectiveCompat.installed = QuiltLoader.isModLoaded("perspective");
		ClientMain.init();
	}
}
