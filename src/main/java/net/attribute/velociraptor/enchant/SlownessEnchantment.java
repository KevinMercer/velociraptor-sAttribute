package net.attribute.velociraptor.enchant;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;

public class SlownessEnchantment extends Enchantment {
    public SlownessEnchantment() {
        super(Rarity.COMMON, EnchantmentTarget.BOW, new EquipmentSlot[] {EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        boolean condition = false;
        try {
            condition = EnchantmentTarget.BOW.isAcceptableItem(stack.getItem());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return condition;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        boolean condition = false;
        try {
            condition = other.type == EnchantmentTarget.BOW && !(other instanceof AgileEnchantment);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return condition;
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        try {
            if (target instanceof LivingEntity targetEntity) {
                DamageSource damageSource = targetEntity.getRecentDamageSource();
                if (damageSource != null) {
                    if (damageSource.getAttacker() == user && damageSource.isProjectile()) {
                        targetEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 2 * level, level - 1));
                    }
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
