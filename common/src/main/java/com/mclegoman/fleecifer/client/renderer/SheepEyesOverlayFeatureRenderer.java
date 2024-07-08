/*
    Fleecifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Fleecifer
    License: GNU LGPLv3
*/

package com.mclegoman.fleecifer.client.renderer;

import com.mclegoman.fleecifer.client.util.PerspectiveCompat;
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
	protected RenderLayer getRenderLayer(T entity) {
		return this.emissive ? RenderLayer.getEyes(this.getTexture(entity)) : RenderLayer.getEntityCutoutNoCull(this.getTexture(entity));
	}
	protected Identifier getTexture(T entity) {
		return PerspectiveCompat.isPerspectiveInstalled() ? PerspectiveCompat.getPerspectiveTexturedEntitySheepEyesTexture(entity, "minecraft:sheep", "_eyes" + (this.emissive ? "_emissive" : ""), getFallbackTexture(entity)) : getFallbackTexture(entity);
	}
	private Identifier getFallbackTexture(T entity) {
		return (entity.hasCustomName() && "Herobrine".equals(Formatting.strip(entity.getName().getString()))) ? this.herobrineTexture : this.texture;
	}
}
