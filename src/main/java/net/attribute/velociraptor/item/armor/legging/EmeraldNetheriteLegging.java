package net.attribute.velociraptor.item.armor.legging;

import net.attribute.velociraptor.item.materials.NetheriteMaterials;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;

/**
 * @author warren
 * @function
 * @createDate 2021/12/10 10:35
 * @updateDate 2021/12/10 10:35
 * @updateAuthor
 * @describe
 */
public class EmeraldNetheriteLegging extends ArmorItem {

    public EmeraldNetheriteLegging(Settings settings) {
        super(NetheriteMaterials.EMERALD_NETHERITE, EquipmentSlot.LEGS, settings);
    }

}
