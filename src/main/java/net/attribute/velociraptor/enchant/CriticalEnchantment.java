package net.attribute.velociraptor.enchant;

import net.attribute.velociraptor.util.RandomUtil;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageRecord;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTracker;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.TranslatableText;

public class CriticalEnchantment extends Enchantment {

    public CriticalEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentTarget.BOW, new EquipmentSlot[] {EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity targetEntity) {
            DamageTracker damageTracker = targetEntity.getDamageTracker();
            DamageSource damageSource = targetEntity.getRecentDamageSource();
            if (damageTracker != null && damageSource != null && damageSource.isProjectile()) {
                DamageRecord damageRecord = damageTracker.getMostRecentDamage();
                if (damageRecord != null) {
                    boolean condition = RandomUtil.getRandomNumber(level, 10);
                    if (condition && user instanceof PlayerEntity playerEntity) {
                        float damage = damageRecord.getDamage();
                        float appendDamage = damage * (2.0F + 0.1F * level);
                        playerEntity.sendMessage(new TranslatableText("attribute.critical.activeTip"), true);
                        targetEntity.damage(DamageSource.mob(user), appendDamage);
                    }
                }
            }

        }
        super.onTargetDamaged(user, target, level);
    }
}
