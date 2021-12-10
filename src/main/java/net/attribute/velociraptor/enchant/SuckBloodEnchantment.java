package net.attribute.velociraptor.enchant;

import net.attribute.velociraptor.Velociraptors;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageRecord;
import net.minecraft.entity.damage.DamageTracker;
import net.minecraft.item.ItemStack;

/**
 * @author warren
 */
public class SuckBloodEnchantment extends Enchantment {
    public SuckBloodEnchantment() {
        super(Rarity.COMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        boolean condition = false;
        try {
            condition = EnchantmentTarget.WEAPON.isAcceptableItem(stack.getItem());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return condition;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        boolean condition = false;
        try {
            condition = other.type == EnchantmentTarget.WEAPON && !(other instanceof RegenerationEnchantment);
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
        if (target instanceof LivingEntity targetEntity && user.isAlive()) {
            float recoverHealth = user.getHealth();
            DamageTracker damageTracker = targetEntity.getDamageTracker();
            if (damageTracker != null) {
                DamageRecord damageRecord = damageTracker.getMostRecentDamage();
                if (damageRecord != null) {
                    recoverHealth += damageRecord.getDamage() * level * 0.1F;
                } else {
                    recoverHealth += 20 * level * 0.2F;
                }
            } else {
                recoverHealth += 20 * level * 0.2F;
            }
            Velociraptors.LOGGER.info("回复生命值：{}", recoverHealth);
            user.setHealth(recoverHealth);
        }
        super.onTargetDamaged(user, target, level);
    }

}
