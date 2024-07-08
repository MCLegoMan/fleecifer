/*
    Fleecifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Fleecifer
    License: GNU LGPLv3
*/

package com.mclegoman.fleecifer.core.mixin;

import com.google.common.collect.ImmutableMap;
import com.mclegoman.fleecifer.core.client.model.EntityModelLayerRegistry;
import com.mclegoman.fleecifer.core.client.model.ModelLayerImpl;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModels;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Iterator;
import java.util.Map;

@Mixin(EntityModels.class)
public abstract class LayerDefinitionsMixin {
	@Inject(method = "getModels", at = @At(value = "INVOKE", target = "Lcom/google/common/collect/ImmutableMap$Builder;build()Lcom/google/common/collect/ImmutableMap;", remap = false), locals = LocalCapture.CAPTURE_FAILEXCEPTION)
	private static void fleecifer$registerModelData(CallbackInfoReturnable<Map<EntityModelLayer, TexturedModelData>> cir, ImmutableMap.Builder builder, TexturedModelData texturedModelData, TexturedModelData texturedModelData2, TexturedModelData texturedModelData3, TexturedModelData texturedModelData4, TexturedModelData texturedModelData5, TexturedModelData texturedModelData6, TexturedModelData texturedModelData7, TexturedModelData texturedModelData8, TexturedModelData texturedModelData9, TexturedModelData texturedModelData10, TexturedModelData texturedModelData11, TexturedModelData texturedModelData12, TexturedModelData texturedModelData13, TexturedModelData texturedModelData14, TexturedModelData texturedModelData15, TexturedModelData texturedModelData16, TexturedModelData texturedModelData17, TexturedModelData texturedModelData18, TexturedModelData texturedModelData19, TexturedModelData texturedModelData20, TexturedModelData texturedModelData21, TexturedModelData texturedModelData22, TexturedModelData texturedModelData23, TexturedModelData texturedModelData24, TexturedModelData texturedModelData25) {
		Iterator var2 = ModelLayerImpl.layers.entrySet().iterator();
		while(var2.hasNext()) {
			Map.Entry<EntityModelLayer, EntityModelLayerRegistry.LayerDefinitionProvider> entry = (Map.Entry)var2.next();
			builder.put(entry.getKey(), entry.getValue().createLayerDefinition());
		}
	}
}
