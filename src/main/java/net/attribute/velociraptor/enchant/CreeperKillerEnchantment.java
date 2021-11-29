package net.attribute.velociraptor.enchant;


import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreeperKillerEnchantment extends Enchantment {

    public CreeperKillerEnchantment() {
        super(Rarity.COMMON, EnchantmentTarget.BOW, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        boolean condition = false;
        try {
            Item item = stack.getItem();
            condition = item instanceof BowItem;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return condition && super.isAcceptableItem(stack);
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && super.canAccept(other);
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
    public int getMinPower(int level) {
        return 1 + (level - 1) * 10;
    }

    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + 15;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof CreeperEntity creeperEntity) {
            if (creeperEntity.isAlive()) {
                DamageSource damageSource = creeperEntity.getRecentDamageSource();
                if (damageSource != null && damageSource.isProjectile()) {
                    DamageSource playerDamageSource = DamageSource.mob(user);
                    creeperEntity.damage(playerDamageSource, 5.0F + (float)level * 3.0F);
                }
            }
        }
        super.onTargetDamaged(user, target, level);
    }

    @Override
    public float getAttackDamage(int level, EntityGroup group) {
        return super.getAttackDamage(level, group);
    }
}
