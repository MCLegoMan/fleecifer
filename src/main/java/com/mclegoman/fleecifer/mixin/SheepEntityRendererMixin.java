/*
    Fleecifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Fleecifer
    License: GNU LGPLv3
*/

package com.mclegoman.fleecifer.mixin;

import com.mclegoman.fleecifer.client.model.Models;
import com.mclegoman.fleecifer.client.renderer.SheepEyesOverlayFeatureRenderer;
import net.minecraft.client.model.SheepModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.SheepRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Sheep;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SheepRenderer.class)
public abstract class SheepEntityRendererMixin extends MobRenderer<Sheep, SheepModel<Sheep>> {
	public SheepEntityRendererMixin(EntityRendererProvider.Context pContext, SheepModel<Sheep> pModel, float pShadowRadius) {
		super(pContext, pModel, pShadowRadius);
	}
	@Inject(method = "<init>", at = @At("TAIL"))
	private void fleecifer$init(EntityRendererProvider.Context context, CallbackInfo ci) {
		this.addLayer(new SheepEyesOverlayFeatureRenderer<>(this, new SheepModel<>(context.getModelSet().bakeLayer(Models.sheepEyes)), ResourceLocation.fromNamespaceAndPath("fleecifer", "textures/entity/sheep/sheep_eyes.png"), ResourceLocation.fromNamespaceAndPath("fleecifer", "textures/entity/sheep/herobrine_eyes.png"), false));
		this.addLayer(new SheepEyesOverlayFeatureRenderer<>(this, new SheepModel<>(context.getModelSet().bakeLayer(Models.sheepEyesEmissive)), ResourceLocation.fromNamespaceAndPath("fleecifer", "textures/entity/sheep/sheep_eyes_emissive.png"), ResourceLocation.fromNamespaceAndPath("fleecifer", "textures/entity/sheep/herobrine_eyes_emissive.png"), true));
	}
}
