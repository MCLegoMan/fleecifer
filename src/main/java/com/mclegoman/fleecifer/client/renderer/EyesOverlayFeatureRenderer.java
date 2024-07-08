/*
    Fleecifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Fleecifer
    License: GNU LGPLv3
*/

package com.mclegoman.fleecifer.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class EyesOverlayFeatureRenderer<T extends LivingEntity, M extends EntityModel<T>> extends RenderLayer<T, M> {
	protected final M model;
	protected final ResourceLocation texture;
	protected final boolean emissive;
	public EyesOverlayFeatureRenderer(RenderLayerParent<T, M> context, M model, ResourceLocation texture, boolean emissive) {
		super(context);
		this.model = model;
		this.texture = texture;
		this.emissive = emissive;
	}
	public void render(PoseStack matrices, MultiBufferSource vertexConsumers, int light, T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
		this.getParentModel().copyPropertiesTo(this.model);
		this.model.prepareMobModel(entity, limbAngle, limbDistance, tickDelta);
		this.model.setupAnim(entity, limbAngle, limbDistance, animationProgress, headYaw, headPitch);
		VertexConsumer vertexConsumer = vertexConsumers.getBuffer(this.getRenderLayer(entity));
		this.model.renderToBuffer(matrices, vertexConsumer, this.emissive ? 15728640 : light, this.emissive ? OverlayTexture.NO_OVERLAY : LivingEntityRenderer.getOverlayCoords(entity, 0.0F));
	}
	protected RenderType getRenderLayer(T entity) {
		return this.emissive ? RenderType.eyes(this.texture) : RenderType.entityCutoutNoCull(this.texture);
	}
}
