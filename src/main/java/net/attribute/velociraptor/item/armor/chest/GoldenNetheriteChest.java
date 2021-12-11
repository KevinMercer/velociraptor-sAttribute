package net.attribute.velociraptor.item.armor.chest;

import net.attribute.velociraptor.item.materials.NetheriteMaterials;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;

/**
 * @author warren
 * @function
 * @createDate 2021/12/10 10:18
 * @updateDate 2021/12/10 10:18
 * @updateAuthor
 * @describe
 */
public class GoldenNetheriteChest extends ArmorItem {

    public GoldenNetheriteChest(Settings settings) {
        super(NetheriteMaterials.GOLDEN_NETHERITE, EquipmentSlot.CHEST, settings);
    }

}
