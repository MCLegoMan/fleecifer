/*
    Fleecifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Fleecifer
    License: GNU LGPLv3
*/

package com.mclegoman.fleecifer.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
	@Inject(method = "<init>", at = @At("TAIL"))
	private void init(EntityType entityType, World world, CallbackInfo ci) {
		LivingEntity livingEntity = (LivingEntity) (Object) this;
		AttributeContainer entityAttributes = livingEntity.getAttributes();
		if (!entityAttributes.hasAttribute(EntityAttributes.GENERIC_ATTACK_DAMAGE) && entityType.equals(EntityType.SHEEP)) ((AttributeContainerInterface) entityAttributes).getCustom().putIfAbsent(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE, (entityAttributeInstance) -> {}));
	}
}
