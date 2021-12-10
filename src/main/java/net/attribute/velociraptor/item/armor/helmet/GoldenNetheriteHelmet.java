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
public class GoldenNetheriteHelmet extends ArmorItem {

    public GoldenNetheriteHelmet(Settings settings) {
        super(NetheriteMaterials.GOLDEN_NETHERITE, EquipmentSlot.HEAD, settings);
    }

}
