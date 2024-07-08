/*
    Fleecifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Fleecifer
    License: GNU LGPLv3
*/

package com.mclegoman.fleecifer.mixin;

import com.google.common.collect.ImmutableMap;
import com.mclegoman.fleecifer.client.model.EntityModelLayerRegistry;
import com.mclegoman.fleecifer.client.model.ModelLayerImpl;
import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Iterator;
import java.util.Map;

@Mixin(LayerDefinitions.class)
public abstract class LayerDefinitionsMixin {
	@Inject(method = "createRoots", at = @At(value = "INVOKE", target = "Lcom/google/common/collect/ImmutableMap$Builder;build()Lcom/google/common/collect/ImmutableMap;", remap = false), locals = LocalCapture.CAPTURE_FAILEXCEPTION)
	private static void fleecifer$registerModelData(CallbackInfoReturnable<Map<ModelLayerLocation, LayerDefinition>> cir, ImmutableMap.Builder builder, LayerDefinition layerdefinition, LayerDefinition layerdefinition1, LayerDefinition layerdefinition2, LayerDefinition layerdefinition3, LayerDefinition layerdefinition4, LayerDefinition layerdefinition5, LayerDefinition layerdefinition6, LayerDefinition layerdefinition7, LayerDefinition layerdefinition8, LayerDefinition layerdefinition9, LayerDefinition layerdefinition10, LayerDefinition layerdefinition11, LayerDefinition layerdefinition12, LayerDefinition layerdefinition13, LayerDefinition layerdefinition14, LayerDefinition layerdefinition15, LayerDefinition layerdefinition16, LayerDefinition layerdefinition17, LayerDefinition layerdefinition18, LayerDefinition layerdefinition19, LayerDefinition layerdefinition20, LayerDefinition layerdefinition21, LayerDefinition layerdefinition22, LayerDefinition layerdefinition23, LayerDefinition layerdefinition24) {
		Iterator var2 = ModelLayerImpl.layers.entrySet().iterator();
		while(var2.hasNext()) {
			Map.Entry<ModelLayerLocation, EntityModelLayerRegistry.LayerDefinitionProvider> entry = (Map.Entry)var2.next();
			builder.put(entry.getKey(), entry.getValue().createLayerDefinition());
		}
	}
}
