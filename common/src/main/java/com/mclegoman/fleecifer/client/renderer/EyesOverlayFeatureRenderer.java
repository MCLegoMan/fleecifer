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
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class EyesOverlayFeatureRenderer<T extends LivingEntityRenderState, M extends EntityModel<T>> extends RenderLayer<T, M> {
	protected final EntityModel<T> model;
	protected final ResourceLocation texture;
	protected final boolean emissive;
	public EyesOverlayFeatureRenderer(RenderLayerParent<T, M> context, EntityModel<T> model, ResourceLocation texture, boolean emissive) {
		super(context);
		this.model = model;
		this.texture = texture;
		this.emissive = emissive;
	}
	protected RenderType getRenderLayer(T entity) {
		return this.emissive ? RenderType.eyes(this.getTexture(entity)) : RenderType.entityCutoutNoCull(this.getTexture(entity));
	}
	protected ResourceLocation getTexture(T entity) {
		return this.texture;
	}
	public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, T livingEntityRenderState, float f, float g) {
		if (!livingEntityRenderState.isInvisible) {
			this.model.setupAnim(livingEntityRenderState);
			VertexConsumer vertexConsumer = multiBufferSource.getBuffer(this.getRenderLayer(livingEntityRenderState));
			this.model.renderToBuffer(poseStack, vertexConsumer, i, OverlayTexture.NO_OVERLAY);
		}
	}
}
