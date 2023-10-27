/*
    Fleecifer
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Fleecifer
    License: GNU LGPLv3
*/

package com.mclegoman.fleecifer.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.TargetGoal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SheepEntity.class)
public abstract class SheepEntityMixin extends AnimalEntity {
	protected SheepEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
		super(entityType, world);
	}
	@Inject(method = "initGoals", at = @At("RETURN"))
	private void initGoals(CallbackInfo ci) {
		this.getAttributeInstance(EntityAttributes.GENERIC_ARMOR).setBaseValue(8.0);
		this.targetSelector.add(0, new TargetGoal<>(this, PlayerEntity.class, true));
		this.goalSelector.add(0, new MeleeAttackGoal(this, 1.25, true));
		this.goalSelector.add(1, new RevengeGoal(this).setGroupRevenge(SheepEntity.class));
	}
}
