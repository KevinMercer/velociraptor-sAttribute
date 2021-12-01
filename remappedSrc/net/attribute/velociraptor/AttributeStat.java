package net.attribute.velociraptor;

import net.attribute.velociraptor.block.CarrotBlock;
import net.attribute.velociraptor.block.PotatoBlock;
import net.attribute.velociraptor.block.RawRedIronBlock;
import net.attribute.velociraptor.enchant.*;
import net.attribute.velociraptor.init.Blocks;
import net.attribute.velociraptor.item.block.CarrotBlockItem;
import net.attribute.velociraptor.item.block.PotatoBlockItem;
import net.attribute.velociraptor.item.block.RawRedIronBlockItem;
import net.attribute.velociraptor.item.weapon.DiamondNetheriteSword;
import net.attribute.velociraptor.item.weapon.EmeraldNetheriteSword;
import net.attribute.velociraptor.item.weapon.GoldenNetheriteSword;
import net.attribute.velociraptor.item.weapon.IronNetheriteSword;
import net.attribute.velociraptor.ore.RedIronOre;
import net.attribute.velociraptor.util.FabricSettingFactory;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.attribute.velociraptor.item.ore.RedIronOreItem;
import net.attribute.velociraptor.item.drop.RawRedIronItem;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AttributeStat implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("velociraptor-attribute-stat");

    /**
     * 实例化附魔
     */
    private static final Enchantment agile = Registry.register(Registry.ENCHANTMENT, new Identifier("chant", "agile"), new AgileEnchantment());
	private static final Enchantment regeneration = Registry.register(Registry.ENCHANTMENT, new Identifier("chant", "regeneration"), new RegenerationEnchantment());
	private static final Enchantment suckBlood = Registry.register(Registry.ENCHANTMENT, new Identifier("chant", "suck_blood"), new SuckBloodEnchantment());
	private static final Enchantment creeperKiller = Registry.register(Registry.ENCHANTMENT, new Identifier("chant", "creeper_killer"), new CreeperKillerEnchantment());
	private static final Enchantment slowness = Registry.register(Registry.ENCHANTMENT, new Identifier("chant", "slowness"), new SlownessEnchantment());
	private static final Enchantment judge = Registry.register(Registry.ENCHANTMENT, new Identifier("chant", "judge"), new JudgeEnchantment());
	private static final Enchantment critical = Registry.register(Registry.ENCHANTMENT, new Identifier("chant", "critical"), new CriticalEnchantment());

	/**
	 * 实例化方块
	 */
	public static final CarrotBlock CARROT_BLOCK = Registry.register(Registry.BLOCK, new Identifier("attribute", "carrot_block"), new CarrotBlock(FabricBlockSettings.of(Material.WOOD, MapColor.DARK_RED).breakByTool(FabricToolTags.AXES).strength(1.0F).sounds(BlockSoundGroup.WOOD).hardness(0.2F)));
	public static final PotatoBlock POTATO_BLOCK = Registry.register(Registry.BLOCK, new Identifier("attribute", "potato_block"), new PotatoBlock(FabricBlockSettings.of(Material.WOOD, MapColor.DEEPSLATE_GRAY).breakByTool(FabricToolTags.AXES).strength(1.0F).sounds(BlockSoundGroup.WOOD).hardness(0.2F)));
	public static final RedIronOre RED_IRON_ORE = Registry.register(Registry.BLOCK, new Identifier("attribute", "red_iron_ore"), new RedIronOre(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES, 3).strength(2.5F).sounds(BlockSoundGroup.STONE).requiresTool()));
	public static final RawRedIronBlock RAW_RED_IRON_BLOCK = Registry.register(Registry.BLOCK, new Identifier("attribute", "raw_red_iron_block"), new RawRedIronBlock(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES, 2).strength(2.5F).sounds(BlockSoundGroup.STONE).requiresTool()));

	/**
	 * 实例化物品
	 */
	private static final Item IRON_NETHERITE_SWORD = Registry.register(Registry.ITEM, new Identifier("attribute", "iron_netherite_sword"), new IronNetheriteSword(FabricSettingFactory.buildSwordItemSetting(2031, true, Rarity.EPIC)));
	private static final Item GOLDEN_NETHERITE_SWORD = Registry.register(Registry.ITEM, new Identifier("attribute", "golden_netherite_sword"), new GoldenNetheriteSword(FabricSettingFactory.buildSwordItemSetting(1561, true, Rarity.EPIC)));
	private static final Item DIAMOND_NETHERITE_SWORD = Registry.register(Registry.ITEM, new Identifier("attribute", "diamond_netherite_sword"), new DiamondNetheriteSword(FabricSettingFactory.buildSwordItemSetting(2031, true, Rarity.EPIC)));
	private static final Item EMERALD_NETHERITE_SWORD = Registry.register(Registry.ITEM, new Identifier("attribute", "emerald_netherite_sword"), new EmeraldNetheriteSword(FabricSettingFactory.buildSwordItemSetting(4062, true, Rarity.EPIC)));
	private static final RawRedIronItem RAW_RED_IRON_ITEM = Registry.register(Registry.ITEM, new Identifier("attribute", "raw_red_iron_item"), new RawRedIronItem(new Item.Settings().maxCount(64).rarity(Rarity.COMMON)));;

	/**
	 * 实例化方块对应的物品
	 */
	private static final CarrotBlockItem CARROT_BLOCK_ITEM = Registry.register(Registry.ITEM, new Identifier("attribute", "carrot_block_item"), new CarrotBlockItem(CARROT_BLOCK, new Item.Settings().maxCount(64).rarity(Rarity.UNCOMMON)));
	private static final PotatoBlockItem POTATO_BLOCK_ITEM = Registry.register(Registry.ITEM, new Identifier("attribute", "potato_block_item"), new PotatoBlockItem(POTATO_BLOCK, new Item.Settings().maxCount(64).rarity(Rarity.UNCOMMON)));
	private static final RedIronOreItem RED_IRON_ORE_ITEM = Registry.register(Registry.ITEM, new Identifier("attribute", "red_iron_ore"), new RedIronOreItem(RED_IRON_ORE, new Item.Settings().maxCount(64).rarity(Rarity.COMMON)));
	private static final RawRedIronBlockItem RAW_RED_IRON_BLOCK_ITEM = Registry.register(Registry.ITEM, new Identifier("attribute", "raw_red_iron_block_item"), new RawRedIronBlockItem(RAW_RED_IRON_BLOCK, new Item.Settings().maxCount(64).rarity(Rarity.COMMON)));;

	/**
	 * 注册物品组
	 */
	private static final ItemGroup ATTRIBUTE_STAT_MOD = FabricItemGroupBuilder.create(new Identifier("attribute", "item")).icon(() -> new ItemStack(IRON_NETHERITE_SWORD)).appendItems(items -> {
		items.add(new ItemStack(IRON_NETHERITE_SWORD));
		items.add(new ItemStack(GOLDEN_NETHERITE_SWORD));
		items.add(new ItemStack(DIAMOND_NETHERITE_SWORD));
		items.add(new ItemStack(EMERALD_NETHERITE_SWORD));
		items.add(new ItemStack(CARROT_BLOCK_ITEM));
		items.add(new ItemStack(POTATO_BLOCK_ITEM));
		items.add(new ItemStack(RED_IRON_ORE_ITEM));
		items.add(new ItemStack(RAW_RED_IRON_ITEM));
		items.add(new ItemStack(RAW_RED_IRON_BLOCK_ITEM));
	}).build();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
	}
}
