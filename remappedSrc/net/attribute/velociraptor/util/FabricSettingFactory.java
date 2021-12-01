package net.attribute.velociraptor.util;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.util.Rarity;

/**
 * @author HeWuLong
 */
public class FabricSettingFactory {

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

}
