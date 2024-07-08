/*
    Fleecifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Fleecifer
    License: GNU LGPLv3
*/

package com.mclegoman.fleecifer.mixin;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Sheep.class)
public abstract class SheepEntityMixin extends Animal {
	protected SheepEntityMixin(EntityType<? extends Animal> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}
	@Inject(method = "createAttributes", at = @At("RETURN"), cancellable = true)
	private static void fleecifer$createAttributes(CallbackInfoReturnable<AttributeSupplier.Builder> cir) {
		cir.setReturnValue(cir.getReturnValue().add(Attributes.FOLLOW_RANGE, 35.0).add(Attributes.MOVEMENT_SPEED, 0.23000000417232513).add(Attributes.ATTACK_DAMAGE, 3.0).add(Attributes.ARMOR, 2.0).add(Attributes.MAX_HEALTH, 16.0));
	}
	@Inject(method = "registerGoals", at = @At("RETURN"))
	private void fleecifer$initGoals(CallbackInfo ci) {
		this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Player.class, true));
		this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 1.25, true));
		this.goalSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers(Sheep.class));
	}
}
