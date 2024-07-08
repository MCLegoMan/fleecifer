/*
    Fleecifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Fleecifer
    License: GNU LGPLv3
*/

package com.mclegoman.fleecifer.client.renderer;

import net.minecraft.ChatFormatting;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class SheepEyesOverlayFeatureRenderer<T extends LivingEntity, M extends EntityModel<T>> extends EyesOverlayFeatureRenderer<T, M> {
	protected final ResourceLocation herobrineTexture;
	public SheepEyesOverlayFeatureRenderer(RenderLayerParent<T, M> context, M model, ResourceLocation texture, ResourceLocation herobrineTexture, boolean emissive) {
		super(context, model, texture, emissive);
		this.herobrineTexture = herobrineTexture;
	}
	@Override
	protected RenderType getRenderLayer(T entity) {
		return (entity.hasCustomName() && "Herobrine".equals(ChatFormatting.stripFormatting(entity.getName().getString()))) ? (this.emissive ? RenderType.eyes(this.herobrineTexture) : RenderType.entityCutoutNoCull(this.herobrineTexture)) : (this.emissive ? RenderType.eyes(this.texture) : RenderType.entityCutoutNoCull(this.texture));
	}
}
