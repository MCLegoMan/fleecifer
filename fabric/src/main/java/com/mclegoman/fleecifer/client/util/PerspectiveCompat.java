/*
    Fleecifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Fleecifer
    License: GNU LGPLv3
*/

package com.mclegoman.fleecifer.client.util;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;

public class PerspectiveCompat {
	public static boolean installed;
	public static boolean isPerspectiveInstalled() {
		return installed;
	}
	public static ResourceLocation getPerspectiveTexturedEntitySheepEyesTexture(LivingEntityRenderState livingEntity, String entity_type, String suffix, ResourceLocation fallback) {
		return fallback;//TexturedEntity.getTexture(livingEntity, entity_type, suffix, fallback);
	}
}
