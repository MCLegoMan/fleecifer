package com.mclegoman.fleecifer.common;

import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.resource.loader.api.ResourceLoader;
import org.quiltmc.qsl.resource.loader.api.ResourcePackActivationType;

public class Fleecifer implements ModInitializer {
	@Override
	public void onInitialize(ModContainer mod) {
		ResourceLoader.registerBuiltinResourcePack(new Identifier("fleecifer", "fleecifer"), ResourcePackActivationType.DEFAULT_ENABLED, Text.translatable("gui.fleecifer.resource_pack.fleecifer.title"));
	}
}
