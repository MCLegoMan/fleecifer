/*
    Fleecifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Fleecifer
    License: GNU LGPLv3
*/

package com.mclegoman.fleecifer.client;

import com.mclegoman.fleecifer.client.model.Models;
import com.mclegoman.fleecifer.client.util.PerspectiveCompat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientMain {
	public static final String modId = "fleecifer";
	public static final Logger logger = LoggerFactory.getLogger(modId);
	public static void init() {
		if (PerspectiveCompat.isPerspectiveInstalled()) logger.warn("Perspective Textured Entity Compatibility has been disabled in this version of " + modId + ".");
		Models.init();
	}
}
