package net.attribute.velociraptor;

import net.attribute.velociraptor.block.CarrotBlock;
import net.attribute.velociraptor.block.PotatoBlock;
import net.attribute.velociraptor.block.RawRedIronBlock;
import net.attribute.velociraptor.enchant.*;
import net.attribute.velociraptor.init.Blocks;
import net.attribute.velociraptor.init.Enchantments;
import net.attribute.velociraptor.init.Items;
import net.attribute.velociraptor.item.block.CarrotBlockItem;
import net.attribute.velociraptor.item.block.PotatoBlockItem;
import net.attribute.velociraptor.item.block.RawRedIronBlockItem;
import net.attribute.velociraptor.item.weapon.DiamondNetheriteSword;
import net.attribute.velociraptor.item.weapon.EmeraldNetheriteSword;
import net.attribute.velociraptor.item.weapon.GoldenNetheriteSword;
import net.attribute.velociraptor.item.weapon.IronNetheriteSword;
import net.attribute.velociraptor.network.PlayerAttributeClientPacket;
import net.attribute.velociraptor.network.PlayerAttributeServerPacket;
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

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		AttributeStat.LOGGER.info("fabric on initialize!");
		Items.initialize();
		Enchantments.initialize();
		Blocks.initialize();
		PlayerAttributeServerPacket.initialize();
		PlayerAttributeClientPacket.initialize();
		if (Items.ITEM_STACK_VECTOR.size() > 0) {
			FabricItemGroupBuilder.create(new Identifier("attribute", "item")).icon(() -> Items.ITEM_STACK_VECTOR.get(0)).appendItems(items -> items.addAll(Items.ITEM_STACK_VECTOR)).build();
		}
		AttributeStat.LOGGER.info("Player attribute server packet initialize over!");
	}
}
