package net.attribute.velociraptor.enchant;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.TranslatableText;

public class JudgeEnchantment extends Enchantment {

    public JudgeEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
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
    protected boolean canAccept(Enchantment other) {
        boolean condition = false;
        try {
            condition = other.type == EnchantmentTarget.WEAPON && !(other instanceof DamageEnchantment);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return condition;
    }

    @Override
    public float getAttackDamage(int level, EntityGroup group) {
        if (group == EntityGroup.ILLAGER) {
            return 3 + 3 * level;
        }
        return super.getAttackDamage(level, group);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (user instanceof PlayerEntity playerEntity && target instanceof LivingEntity targetEntity && targetEntity.isDead() && targetEntity.getGroup() == EntityGroup.ILLAGER) {
            playerEntity.sendMessage(new TranslatableText("attribute.judge.killTip"), true);
        }
        super.onTargetDamaged(user, target, level);
    }
}
