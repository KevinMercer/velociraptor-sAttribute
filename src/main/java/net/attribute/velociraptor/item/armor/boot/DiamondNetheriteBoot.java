package net.attribute.velociraptor.item.armor.boot;

import net.attribute.velociraptor.item.materials.NetheriteMaterials;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;

/**
 * @author warren
 * @function
 * @createDate 2021/12/3 9:38
 * @updateDate 2021/12/3 9:38
 * @updateAuthor
 * @describe
 */

public class DiamondNetheriteBoot extends ArmorItem {
    public DiamondNetheriteBoot(Settings settings) {
        super(NetheriteMaterials.DIAMOND_NETHERITE, EquipmentSlot.FEET, settings);
    }
}
