package net.attribute.velociraptor.item.materials;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

/**
 * @author warren
 * @function
 * @createDate 2021/12/3 11:57
 * @updateDate 2021/12/3 11:57
 * @updateAuthor
 * @describe
 */
public enum NetheriteMaterials implements ArmorMaterial {
    IRON_NETHERITE("iron_netherite", 47, new int[]{4, 8, 10, 5}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.0F, 0.3F),
    GOLDEN_NETHERITE("golden_netherite", 37, new int[]{3, 6, 8, 3}, 35, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 3.0F, 0.1F),
    DIAMOND_NETHERITE("diamond_netherite", 47, new int[]{3, 6, 9, 4}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 6.0F, 0.1F),
    EMERALD_NETHERITE("emerald_netherite", 70, new int[]{3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F)
    ;

    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantAbility;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockBackResistance;

    NetheriteMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantAbility, SoundEvent equipSound, float toughness, float knockBackResistance) {
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
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
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
