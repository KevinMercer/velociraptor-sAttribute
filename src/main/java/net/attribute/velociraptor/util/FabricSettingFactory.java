package net.attribute.velociraptor.util;

import net.fabricmc.fabric.api.item.v1.EquipmentSlotProvider;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Rarity;

/**
 * @author warren
 */
public class FabricSettingFactory {

    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};

    public static FabricItemSettings buildSwordItemSetting(int durability, boolean fireproof, Rarity rarity) {
        FabricItemSettings fabricItemSettings = new FabricItemSettings();
        fabricItemSettings.maxCount(0);
        fabricItemSettings.maxDamage(durability);
        if (fireproof) {
            fabricItemSettings.fireproof();
        }
        if (rarity != null) {
            fabricItemSettings.rarity(rarity);
        }
        return fabricItemSettings;
    }

    public static FabricItemSettings buildArmorItemSetting(int durabilityMultiplier, boolean fireproof, Rarity rarity, EquipmentSlot equipmentSlot) {
        FabricItemSettings fabricItemSettings = new FabricItemSettings();
        if (durabilityMultiplier <= 0) {
            durabilityMultiplier = 1;
        }
        fabricItemSettings.maxCount(0);
        if (fireproof) {
            fabricItemSettings.fireproof();
        }
        if (rarity != null) {
            fabricItemSettings.rarity(rarity);
        }
        fabricItemSettings.maxDamage(BASE_DURABILITY[equipmentSlot.getEntitySlotId()] * durabilityMultiplier);
        return fabricItemSettings;
    }

}
