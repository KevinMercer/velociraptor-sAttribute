package net.attribute.velociraptor.init;

import net.attribute.velociraptor.item.armor.boot.DiamondNetheriteBoot;
import net.attribute.velociraptor.item.drop.RawRedIronItem;
import net.attribute.velociraptor.item.weapon.DiamondNetheriteSword;
import net.attribute.velociraptor.item.weapon.EmeraldNetheriteSword;
import net.attribute.velociraptor.item.weapon.GoldenNetheriteSword;
import net.attribute.velociraptor.item.weapon.IronNetheriteSword;
import net.attribute.velociraptor.util.FabricSettingFactory;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import java.util.Vector;

public class Items {

    public static FabricItemGroupBuilder ATTRIBUTE_STAT_MOD;
    public static final Vector<ItemStack> ITEM_STACK_VECTOR = new Vector<>();

    private Items() {
    }

    /**
     * 实例化物品
     */
    public static void initialize() {
        //sword
        IronNetheriteSword ironNetheriteSword = Registry.register(Registry.ITEM, new Identifier("attribute", "iron_netherite_sword"), new IronNetheriteSword(FabricSettingFactory.buildSwordItemSetting(2031, true, Rarity.EPIC)));
        GoldenNetheriteSword goldenNetheriteSword = Registry.register(Registry.ITEM, new Identifier("attribute", "golden_netherite_sword"), new GoldenNetheriteSword(FabricSettingFactory.buildSwordItemSetting(1561, true, Rarity.EPIC)));
        DiamondNetheriteSword diamondNetheriteSword = Registry.register(Registry.ITEM, new Identifier("attribute", "diamond_netherite_sword"), new DiamondNetheriteSword(FabricSettingFactory.buildSwordItemSetting(2031, true, Rarity.EPIC)));
        EmeraldNetheriteSword emeraldNetheriteSword = Registry.register(Registry.ITEM, new Identifier("attribute", "emerald_netherite_sword"), new EmeraldNetheriteSword(FabricSettingFactory.buildSwordItemSetting(4062, true, Rarity.EPIC)));
        //armor
        DiamondNetheriteBoot diamondNetheriteBoot = Registry.register(Registry.ITEM, new Identifier("attribute", "diamond_netherite_boot"), new DiamondNetheriteBoot(FabricSettingFactory.buildArmorItemSetting(66, true, Rarity.EPIC, EquipmentSlot.FEET)));
        //raw ore
        RawRedIronItem rawRedIronItem = Registry.register(Registry.ITEM, new Identifier("attribute", "raw_red_iron_item"), new RawRedIronItem(new Item.Settings().maxCount(64).rarity(Rarity.COMMON)));
        ITEM_STACK_VECTOR.add(new ItemStack(ironNetheriteSword));
        ITEM_STACK_VECTOR.add(new ItemStack(goldenNetheriteSword));
        ITEM_STACK_VECTOR.add(new ItemStack(diamondNetheriteSword));
        ITEM_STACK_VECTOR.add(new ItemStack(emeraldNetheriteSword));
        ITEM_STACK_VECTOR.add(new ItemStack(rawRedIronItem));
        ITEM_STACK_VECTOR.add(new ItemStack(diamondNetheriteBoot));
    }

}
