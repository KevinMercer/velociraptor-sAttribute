package net.attribute.velociraptor.item.materials;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Lazy;

/**
 * @author warren
 * @function
 * @createDate 2021/12/3 11:57
 * @updateDate 2021/12/3 11:57
 * @updateAuthor
 * @describe
 */
public enum Materials implements ArmorMaterial {
    ;

    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantAbility;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockBackResistance;

    Materials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantAbility, SoundEvent equipSound, float toughness, float knockBackResistance) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantAbility = enchantAbility;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockBackResistance = knockBackResistance;
    }

    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
    }

    public int getProtectionAmount(EquipmentSlot slot) {
        return this.protectionAmounts[slot.getEntitySlotId()];
    }

    public int getEnchantability() {
        return this.enchantAbility;
    }

    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    public Ingredient getRepairIngredient() {
        return null;
    }

    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockBackResistance;
    }

}
