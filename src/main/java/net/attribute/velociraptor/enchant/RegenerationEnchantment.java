package net.attribute.velociraptor.enchant;


import net.attribute.velociraptor.util.RandomUtil;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;

/**
 * @author HeWuLong
 */
public class RegenerationEnchantment extends Enchantment {

    public RegenerationEnchantment() {
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
            condition = other.type == EnchantmentTarget.WEAPON && !(other instanceof SuckBloodEnchantment);
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
        return 5;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        try {
            boolean condition = RandomUtil.getRandomNumber(level, 20);
            if (user.isAlive() && condition) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 2 * level, level - 1));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
