/*
    Fleecifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Fleecifer
    License: GNU LGPLv3
*/

package com.mclegoman.fleecifer.mixin;

import com.mclegoman.fleecifer.client.model.Models;
import com.mclegoman.fleecifer.client.renderer.EyesOverlayFeatureRenderer;
import net.minecraft.client.render.entity.*;
import net.minecraft.client.render.entity.model.SheepEntityModel;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SheepEntityRenderer.class)
public abstract class SheepEntityRendererMixin extends MobEntityRenderer<SheepEntity, SheepEntityModel<SheepEntity>> {
	public SheepEntityRendererMixin(EntityRendererFactory.Context context, SheepEntityModel<SheepEntity> entityModel, float f) {
		super(context, entityModel, f);
	}
	@Inject(method = "<init>(Lnet/minecraft/client/render/entity/EntityRendererFactory$Context;)V", at = @At("TAIL"))
	private void perspective$init(EntityRendererFactory.Context context, CallbackInfo ci) {
		this.addFeature(new EyesOverlayFeatureRenderer<>(this, new SheepEntityModel<>(context.getPart(Models.sheepEyes)), Identifier.of("fleecifer", "textures/entity/sheep/sheep_eyes.png"), false));
		this.addFeature(new EyesOverlayFeatureRenderer<>(this, new SheepEntityModel<>(context.getPart(Models.sheepEyesEmissive)), Identifier.of("fleecifer", "textures/entity/sheep/sheep_eyes_emissive.png"), true));
	}
}
