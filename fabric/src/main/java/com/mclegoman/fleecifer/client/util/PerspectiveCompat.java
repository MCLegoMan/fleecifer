/*
    Fleecifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Fleecifer
    License: GNU LGPLv3
*/

package com.mclegoman.fleecifer.client.util;

import com.mclegoman.perspective.client.textured_entity.TexturedEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;

public class PerspectiveCompat {
	public static boolean installed;
	public static boolean isPerspectiveInstalled() {
		return installed;
	}
	public static Identifier getPerspectiveTexturedEntitySheepEyesTexture(LivingEntity entity, String entity_type, String suffix, Identifier fallback) {
		return TexturedEntity.getTexture(entity, entity_type, suffix, fallback);
	}
}
