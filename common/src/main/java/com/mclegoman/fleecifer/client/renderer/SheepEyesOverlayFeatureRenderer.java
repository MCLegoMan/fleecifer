/*
    Fleecifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Fleecifer
    License: GNU LGPLv3
*/

package com.mclegoman.fleecifer.client.renderer;

import com.mclegoman.fleecifer.client.util.PerspectiveCompat;
import net.minecraft.ChatFormatting;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;

public class SheepEyesOverlayFeatureRenderer<T extends LivingEntityRenderState, M extends EntityModel<T>> extends EyesOverlayFeatureRenderer<T, M> {
	protected final ResourceLocation herobrineTexture;
	public SheepEyesOverlayFeatureRenderer(RenderLayerParent<T, M> context, EntityModel<T> model, ResourceLocation texture, ResourceLocation herobrineTexture, boolean emissive) {
		super(context, model, texture, emissive);
		this.herobrineTexture = herobrineTexture;
	}

	protected RenderType getRenderLayer(T entity) {
		return this.emissive ? RenderType.eyes(this.getTexture(entity)) : RenderType.entityCutoutNoCull(this.getTexture(entity));
	}
	protected ResourceLocation getTexture(T entity) {
		if (entity instanceof LivingEntityRenderState livingEntity) return PerspectiveCompat.isPerspectiveInstalled() ? PerspectiveCompat.getPerspectiveTexturedEntitySheepEyesTexture(entity, "minecraft:sheep", "_eyes" + (this.emissive ? "_emissive" : ""), getFallbackTexture(livingEntity)) : getFallbackTexture(livingEntity);
		else return this.texture;
	}
	private ResourceLocation getFallbackTexture(LivingEntityRenderState livingEntity) {
		return (livingEntity.customName != null && "Herobrine".equals(ChatFormatting.stripFormatting(livingEntity.customName.getString()))) ? this.herobrineTexture : this.texture;
	}
}
