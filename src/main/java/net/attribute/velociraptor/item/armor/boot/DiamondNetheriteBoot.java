package net.attribute.velociraptor.item.armor.boot;

import com.google.common.collect.Multimap;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterials;

/**
 * @author hwl
 * @function
 * @createDate 2021/12/3 9:38
 * @updateDate 2021/12/3 9:38
 * @updateAuthor
 * @describe
 */

public class DiamondNetheriteBoot extends ArmorItem {
    public DiamondNetheriteBoot(Settings settings) {
        super(ArmorMaterials.NETHERITE, EquipmentSlot.FEET, settings);
    }
}
