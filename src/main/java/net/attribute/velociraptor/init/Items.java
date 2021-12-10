package net.attribute.velociraptor.init;

import net.attribute.velociraptor.item.armor.boot.DiamondNetheriteBoot;
import net.attribute.velociraptor.item.armor.boot.EmeraldNetheriteBoot;
import net.attribute.velociraptor.item.armor.boot.GoldenNetheriteBoot;
import net.attribute.velociraptor.item.armor.boot.IronNetheriteBoot;
import net.attribute.velociraptor.item.armor.chest.DiamondNetheriteChest;
import net.attribute.velociraptor.item.armor.chest.EmeraldNetheriteChest;
import net.attribute.velociraptor.item.armor.chest.GoldenNetheriteChest;
import net.attribute.velociraptor.item.armor.chest.IronNetheriteChest;
import net.attribute.velociraptor.item.armor.helmet.DiamondNetheriteHelmet;
import net.attribute.velociraptor.item.armor.helmet.EmeraldNetheriteHelmet;
import net.attribute.velociraptor.item.armor.helmet.GoldenNetheriteHelmet;
import net.attribute.velociraptor.item.armor.helmet.IronNetheriteHelmet;
import net.attribute.velociraptor.item.armor.legging.DiamondNetheriteLegging;
import net.attribute.velociraptor.item.armor.legging.EmeraldNetheriteLegging;
import net.attribute.velociraptor.item.armor.legging.GoldenNetheriteLegging;
import net.attribute.velociraptor.item.armor.legging.IronNetheriteLegging;
import net.attribute.velociraptor.item.drop.RawRedIronItem;
import net.attribute.velociraptor.item.weapon.DiamondNetheriteSword;
import net.attribute.velociraptor.item.weapon.EmeraldNetheriteSword;
import net.attribute.velociraptor.item.weapon.GoldenNetheriteSword;
import net.attribute.velociraptor.item.weapon.IronNetheriteSword;
import net.attribute.velociraptor.util.ConstantString;
import net.attribute.velociraptor.util.FabricSettingFactory;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import java.util.Vector;

/**
 * @author warren
 */
public class Items {

    public static final Vector<ItemStack> ITEM_STACK_VECTOR = new Vector<>();

    private Items() {
    }

    /**
     * 实例化物品
     */
    public static void initialize() {
        //sword
        DiamondNetheriteSword diamondNetheriteSword = Registry.register(Registry.ITEM, new Identifier(ConstantString.MOD_ID, ConstantString.DIAMOND_NETHERITE + ConstantString.UNDER_LINE + ConstantString.SWORD), new DiamondNetheriteSword(FabricSettingFactory.buildSwordItemSetting(2031, true, Rarity.EPIC)));
        EmeraldNetheriteSword emeraldNetheriteSword = Registry.register(Registry.ITEM, new Identifier(ConstantString.MOD_ID, ConstantString.EMERALD_NETHERITE + ConstantString.UNDER_LINE + ConstantString.SWORD), new EmeraldNetheriteSword(FabricSettingFactory.buildSwordItemSetting(4062, true, Rarity.EPIC)));
        GoldenNetheriteSword goldenNetheriteSword = Registry.register(Registry.ITEM, new Identifier(ConstantString.MOD_ID, ConstantString.GOLDEN_NETHERITE + ConstantString.UNDER_LINE + ConstantString.SWORD), new GoldenNetheriteSword(FabricSettingFactory.buildSwordItemSetting(1561, true, Rarity.EPIC)));
        IronNetheriteSword ironNetheriteSword = Registry.register(Registry.ITEM, new Identifier(ConstantString.MOD_ID, ConstantString.IRON_NETHERITE + ConstantString.UNDER_LINE + ConstantString.SWORD), new IronNetheriteSword(FabricSettingFactory.buildSwordItemSetting(2031, true, Rarity.EPIC)));
        //armor boot
        DiamondNetheriteBoot diamondNetheriteBoot = Registry.register(Registry.ITEM, new Identifier(ConstantString.MOD_ID, ConstantString.DIAMOND_NETHERITE + ConstantString.UNDER_LINE + ConstantString.BOOT), new DiamondNetheriteBoot(FabricSettingFactory.buildArmorItemSetting(66, true, Rarity.EPIC, EquipmentSlot.FEET)));
        EmeraldNetheriteBoot emeraldNetheriteBoot = Registry.register(Registry.ITEM, new Identifier(ConstantString.MOD_ID, ConstantString.EMERALD_NETHERITE + ConstantString.UNDER_LINE + ConstantString.BOOT), new EmeraldNetheriteBoot(FabricSettingFactory.buildArmorItemSetting(100, true, Rarity.EPIC, EquipmentSlot.FEET)));
        GoldenNetheriteBoot goldenNetheriteBoot = Registry.register(Registry.ITEM, new Identifier(ConstantString.MOD_ID, ConstantString.GOLDEN_NETHERITE + ConstantString.UNDER_LINE + ConstantString.BOOT), new GoldenNetheriteBoot(FabricSettingFactory.buildArmorItemSetting(37, true, Rarity.EPIC, EquipmentSlot.FEET)));
        IronNetheriteBoot ironNetheriteBoot = Registry.register(Registry.ITEM, new Identifier(ConstantString.MOD_ID, ConstantString.IRON_NETHERITE + ConstantString.UNDER_LINE + ConstantString.BOOT), new IronNetheriteBoot(FabricSettingFactory.buildArmorItemSetting(50, true, Rarity.EPIC, EquipmentSlot.FEET)));
        //armor chest
        DiamondNetheriteChest diamondNetheriteChest = Registry.register(Registry.ITEM, new Identifier(ConstantString.MOD_ID, ConstantString.DIAMOND_NETHERITE + ConstantString.UNDER_LINE + ConstantString.CHEST), new DiamondNetheriteChest(FabricSettingFactory.buildArmorItemSetting(66, true, Rarity.EPIC, EquipmentSlot.CHEST)));
        EmeraldNetheriteChest emeraldNetheriteChest = Registry.register(Registry.ITEM, new Identifier(ConstantString.MOD_ID, ConstantString.EMERALD_NETHERITE + ConstantString.UNDER_LINE + ConstantString.CHEST), new EmeraldNetheriteChest(FabricSettingFactory.buildArmorItemSetting(100, true, Rarity.EPIC, EquipmentSlot.CHEST)));
        GoldenNetheriteChest goldenNetheriteChest = Registry.register(Registry.ITEM, new Identifier(ConstantString.MOD_ID, ConstantString.GOLDEN_NETHERITE + ConstantString.UNDER_LINE + ConstantString.CHEST), new GoldenNetheriteChest(FabricSettingFactory.buildArmorItemSetting(37, true, Rarity.EPIC, EquipmentSlot.CHEST)));
        IronNetheriteChest ironNetheriteChest = Registry.register(Registry.ITEM, new Identifier(ConstantString.MOD_ID, ConstantString.IRON_NETHERITE + ConstantString.UNDER_LINE + ConstantString.CHEST), new IronNetheriteChest(FabricSettingFactory.buildArmorItemSetting(50, true, Rarity.EPIC, EquipmentSlot.CHEST)));
        //armor helmet
        DiamondNetheriteHelmet diamondNetheriteHelmet = Registry.register(Registry.ITEM, new Identifier(ConstantString.MOD_ID, ConstantString.DIAMOND_NETHERITE + ConstantString.UNDER_LINE + ConstantString.HELMET), new DiamondNetheriteHelmet(FabricSettingFactory.buildArmorItemSetting(66, true, Rarity.EPIC, EquipmentSlot.HEAD)));
        EmeraldNetheriteHelmet emeraldNetheriteHelmet = Registry.register(Registry.ITEM, new Identifier(ConstantString.MOD_ID, ConstantString.EMERALD_NETHERITE + ConstantString.UNDER_LINE + ConstantString.HELMET), new EmeraldNetheriteHelmet(FabricSettingFactory.buildArmorItemSetting(100, true, Rarity.EPIC, EquipmentSlot.HEAD)));
        GoldenNetheriteHelmet goldenNetheriteHelmet = Registry.register(Registry.ITEM, new Identifier(ConstantString.MOD_ID, ConstantString.GOLDEN_NETHERITE + ConstantString.UNDER_LINE + ConstantString.HELMET), new GoldenNetheriteHelmet(FabricSettingFactory.buildArmorItemSetting(37, true, Rarity.EPIC, EquipmentSlot.HEAD)));
        IronNetheriteHelmet ironNetheriteHelmet = Registry.register(Registry.ITEM, new Identifier(ConstantString.MOD_ID, ConstantString.IRON_NETHERITE + ConstantString.UNDER_LINE + ConstantString.HELMET), new IronNetheriteHelmet(FabricSettingFactory.buildArmorItemSetting(50, true, Rarity.EPIC, EquipmentSlot.HEAD)));
        //armor legging
        DiamondNetheriteLegging diamondNetheriteLegging = Registry.register(Registry.ITEM, new Identifier(ConstantString.MOD_ID, ConstantString.DIAMOND_NETHERITE + ConstantString.UNDER_LINE + ConstantString.LEGGING), new DiamondNetheriteLegging(FabricSettingFactory.buildArmorItemSetting(66, true, Rarity.EPIC, EquipmentSlot.LEGS)));
        EmeraldNetheriteLegging emeraldNetheriteLegging = Registry.register(Registry.ITEM, new Identifier(ConstantString.MOD_ID, ConstantString.EMERALD_NETHERITE + ConstantString.UNDER_LINE + ConstantString.LEGGING), new EmeraldNetheriteLegging(FabricSettingFactory.buildArmorItemSetting(100, true, Rarity.EPIC, EquipmentSlot.LEGS)));
        GoldenNetheriteLegging goldenNetheriteLegging = Registry.register(Registry.ITEM, new Identifier(ConstantString.MOD_ID, ConstantString.GOLDEN_NETHERITE + ConstantString.UNDER_LINE + ConstantString.LEGGING), new GoldenNetheriteLegging(FabricSettingFactory.buildArmorItemSetting(37, true, Rarity.EPIC, EquipmentSlot.LEGS)));
        IronNetheriteLegging ironNetheriteLegging = Registry.register(Registry.ITEM, new Identifier(ConstantString.MOD_ID, ConstantString.IRON_NETHERITE + ConstantString.UNDER_LINE + ConstantString.LEGGING), new IronNetheriteLegging(FabricSettingFactory.buildArmorItemSetting(50, true, Rarity.EPIC, EquipmentSlot.LEGS)));
        //raw ore
        RawRedIronItem rawRedIronItem = Registry.register(Registry.ITEM, new Identifier(ConstantString.MOD_ID, ConstantString.RAW_RED_IRON_ITEM), new RawRedIronItem(new Item.Settings().maxCount(64).rarity(Rarity.COMMON)));
        ITEM_STACK_VECTOR.add(new ItemStack(diamondNetheriteSword));
        ITEM_STACK_VECTOR.add(new ItemStack(emeraldNetheriteSword));
        ITEM_STACK_VECTOR.add(new ItemStack(goldenNetheriteSword));
        ITEM_STACK_VECTOR.add(new ItemStack(ironNetheriteSword));
        ITEM_STACK_VECTOR.add(new ItemStack(diamondNetheriteBoot));
        ITEM_STACK_VECTOR.add(new ItemStack(emeraldNetheriteBoot));
        ITEM_STACK_VECTOR.add(new ItemStack(goldenNetheriteBoot));
        ITEM_STACK_VECTOR.add(new ItemStack(ironNetheriteBoot));
        ITEM_STACK_VECTOR.add(new ItemStack(diamondNetheriteChest));
        ITEM_STACK_VECTOR.add(new ItemStack(emeraldNetheriteChest));
        ITEM_STACK_VECTOR.add(new ItemStack(goldenNetheriteChest));
        ITEM_STACK_VECTOR.add(new ItemStack(ironNetheriteChest));
        ITEM_STACK_VECTOR.add(new ItemStack(diamondNetheriteHelmet));
        ITEM_STACK_VECTOR.add(new ItemStack(emeraldNetheriteHelmet));
        ITEM_STACK_VECTOR.add(new ItemStack(goldenNetheriteHelmet));
        ITEM_STACK_VECTOR.add(new ItemStack(ironNetheriteHelmet));
        ITEM_STACK_VECTOR.add(new ItemStack(diamondNetheriteLegging));
        ITEM_STACK_VECTOR.add(new ItemStack(emeraldNetheriteLegging));
        ITEM_STACK_VECTOR.add(new ItemStack(goldenNetheriteLegging));
        ITEM_STACK_VECTOR.add(new ItemStack(ironNetheriteLegging));
        ITEM_STACK_VECTOR.add(new ItemStack(rawRedIronItem));
    }

}
