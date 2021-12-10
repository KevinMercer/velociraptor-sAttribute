package net.attribute.velociraptor.enchant;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;

/**
 * @author warren
 */
public class AgileEnchantment extends Enchantment {
    public AgileEnchantment() {
        super(Rarity.COMMON, EnchantmentTarget.BOW, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return EnchantmentTarget.BOW.isAcceptableItem(stack.getItem());
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        boolean condition = false;
        try {
            condition = other.type == EnchantmentTarget.BOW && !(other instanceof SlownessEnchantment);
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
        return 3;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 10 * 2 * level, level - 1));
        super.onTargetDamaged(user, target, level);
    }
}
