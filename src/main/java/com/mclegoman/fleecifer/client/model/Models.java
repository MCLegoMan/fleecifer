/*
    Fleecifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Fleecifer
    License: GNU LGPLv3
*/

package com.mclegoman.fleecifer.client.model;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.*;
import net.minecraft.util.Identifier;

public class Models {
	public static final EntityModelLayer sheepEyes = new EntityModelLayer(Identifier.of("minecraft", "sheep"), "eyes");
	public static void init() {
		EntityModelLayerRegistry.registerModelLayer(sheepEyes, () -> getSheepTexturedModelData(new Dilation(0.001F)));
	}
	public static TexturedModelData getSheepTexturedModelData(Dilation dilation) {
		ModelData modelData = QuadrupedEntityModel.getModelData(12, dilation);
		ModelPartData modelPartData = modelData.getRoot();
		modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -4.0F, -6.0F, 6.0F, 6.0F, 8.0F), ModelTransform.pivot(0.0F, 6.0F, -8.0F));
		modelPartData.addChild("body", ModelPartBuilder.create().uv(28, 8).cuboid(-4.0F, -10.0F, -7.0F, 8.0F, 16.0F, 6.0F), ModelTransform.of(0.0F, 5.0F, 2.0F, 1.5707964F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 32);
	}
}
