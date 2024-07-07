/*
    Fleecifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Fleecifer
    License: GNU LGPLv3
*/

package com.mclegoman.fleecifer.client.renderer;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

public class SheepEyesOverlayFeatureRenderer<T extends LivingEntity, M extends EntityModel<T>> extends EyesOverlayFeatureRenderer<T, M> {
	protected final Identifier herobrineTexture;
	public SheepEyesOverlayFeatureRenderer(FeatureRendererContext<T, M> context, M model, Identifier texture, Identifier herobrineTexture, boolean emissive) {
		super(context, model, texture, emissive);
		this.herobrineTexture = herobrineTexture;
	}
	@Override
	protected RenderLayer getRenderLayer(T entity) {
		return (entity.hasCustomName() && "Herobrine".equals(Formatting.strip(entity.getName().getString()))) ? (this.emissive ? RenderLayer.getEyes(this.herobrineTexture) : RenderLayer.getEntityCutoutNoCull(this.herobrineTexture)) : (this.emissive ? RenderLayer.getEyes(this.texture) : RenderLayer.getEntityCutoutNoCull(this.texture));
	}
}
