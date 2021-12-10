package net.attribute.velociraptor.item.materials;

import net.attribute.velociraptor.util.ConstantString;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

/**
 * @author warren
 * @function
 * @createDate 2021/12/3 11:57
 * @updateDate 2021/12/3 11:57
 * @updateAuthor
 * @describe
 */
public enum NetheriteMaterials implements ArmorMaterial {
    DIAMOND_NETHERITE(ConstantString.DIAMOND_NETHERITE, 47, new int[]{3, 6, 9, 4}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 6.0F, 0.1F),
    EMERALD_NETHERITE(ConstantString.EMERALD_NETHERITE, 70, new int[]{3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F),
    GOLDEN_NETHERITE(ConstantString.GOLDEN_NETHERITE, 37, new int[]{3, 6, 8, 3}, 35, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 3.0F, 0.1F),
    IRON_NETHERITE(ConstantString.IRON_NETHERITE, 47, new int[]{4, 8, 10, 5}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.0F, 0.3F)
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

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return this.protectionAmounts[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantAbility;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockBackResistance;
    }

}
