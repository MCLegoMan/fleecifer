/*
    Fleecifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Fleecifer
    License: GNU LGPLv3
*/

package com.mclegoman.fleecifer.client.renderer;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;

public class EyesOverlayFeatureRenderer<T extends LivingEntity, M extends EntityModel<T>> extends FeatureRenderer<T, M> {
	protected final M model;
	protected final Identifier texture;
	protected final boolean emissive;
	public EyesOverlayFeatureRenderer(FeatureRendererContext<T, M> context, M model, Identifier texture, boolean emissive) {
		super(context);
		this.model = model;
		this.texture = texture;
		this.emissive = emissive;
	}
	public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
		this.getContextModel().copyStateTo(this.model);
		this.model.animateModel(entity, limbAngle, limbDistance, tickDelta);
		this.model.setAngles(entity, limbAngle, limbDistance, animationProgress, headYaw, headPitch);
		VertexConsumer vertexConsumer = vertexConsumers.getBuffer(this.getRenderLayer(entity));
		this.model.method_60879(matrices, vertexConsumer, this.emissive ? 15728640 : light, this.emissive ? OverlayTexture.DEFAULT_UV : LivingEntityRenderer.getOverlay(entity, 0.0F));
	}
	protected RenderLayer getRenderLayer(T entity) {
		return this.emissive ? RenderLayer.getEyes(this.texture) : RenderLayer.getEntityCutoutNoCull(this.texture);
	}
}
