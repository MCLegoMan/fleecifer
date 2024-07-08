/*
    Fleecifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Fleecifer
    License: GNU LGPLv3
*/

package com.mclegoman.fleecifer.client.model;

import com.mclegoman.fleecifer.mixin.ModelLayersAccessor;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModelLayer;

import java.util.Objects;

public class EntityModelLayerRegistry {
	public static void registerModelLayer(EntityModelLayer modelLayer, LayerDefinitionProvider provider) {
		Objects.requireNonNull(modelLayer, "ModelLayerLocation cannot be null");
		Objects.requireNonNull(provider, "LayerDefinition cannot be null");
		if (ModelLayerImpl.layers.putIfAbsent(modelLayer, provider) != null) throw new IllegalArgumentException("Model layer was already registered: " + modelLayer);
		else ModelLayersAccessor.getAllModels().add(modelLayer);
	}
	@FunctionalInterface
	public interface LayerDefinitionProvider {
		TexturedModelData createLayerDefinition();
	}
}

