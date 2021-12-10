package net.attribute.velociraptor.item.armor.helmet;

import net.attribute.velociraptor.item.materials.NetheriteMaterials;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;

/**
 * @author warren
 * @function
 * @createDate 2021/12/10 10:19
 * @updateDate 2021/12/10 10:19
 * @updateAuthor
 * @describe
 */
public class IronNetheriteHelmet extends ArmorItem {

    public IronNetheriteHelmet(Settings settings) {
        super(NetheriteMaterials.IRON_NETHERITE, EquipmentSlot.HEAD, settings);
    }

}
