package net.attribute.velociraptor.init;

import net.attribute.velociraptor.block.CarrotBlock;
import net.attribute.velociraptor.block.PotatoBlock;
import net.attribute.velociraptor.block.RawRedIronBlock;
import net.attribute.velociraptor.item.block.CarrotBlockItem;
import net.attribute.velociraptor.item.block.PotatoBlockItem;
import net.attribute.velociraptor.item.block.RawRedIronBlockItem;
import net.attribute.velociraptor.item.ore.RedIronOreItem;
import net.attribute.velociraptor.ore.RedIronOre;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class Blocks {

    private Blocks() {
    }

    /**
     * 实例化方块
     */
    public static void initialize() {
        CarrotBlock CARROT_BLOCK = Registry.register(Registry.BLOCK, new Identifier("attribute", "carrot_block"), new CarrotBlock(FabricBlockSettings.of(Material.WOOD, MapColor.DARK_RED).strength(1.0F).sounds(BlockSoundGroup.WOOD).hardness(0.2F)));
        PotatoBlock POTATO_BLOCK = Registry.register(Registry.BLOCK, new Identifier("attribute", "potato_block"), new PotatoBlock(FabricBlockSettings.of(Material.WOOD, MapColor.DEEPSLATE_GRAY).strength(1.0F).sounds(BlockSoundGroup.WOOD).hardness(0.2F)));
        RedIronOre RED_IRON_ORE = Registry.register(Registry.BLOCK, new Identifier("attribute", "red_iron_ore"), new RedIronOre(FabricBlockSettings.of(Material.STONE).strength(2.5F).sounds(BlockSoundGroup.STONE).requiresTool()));
        RawRedIronBlock RAW_RED_IRON_BLOCK = Registry.register(Registry.BLOCK, new Identifier("attribute", "raw_red_iron_block"), new RawRedIronBlock(FabricBlockSettings.of(Material.STONE).strength(2.5F).sounds(BlockSoundGroup.STONE).requiresTool()));
        //实例化方块对应的物品
        CarrotBlockItem CARROT_BLOCK_ITEM = Registry.register(Registry.ITEM, new Identifier("attribute", "carrot_block_item"), new CarrotBlockItem(CARROT_BLOCK, new Item.Settings().maxCount(64).rarity(Rarity.UNCOMMON)));
        PotatoBlockItem POTATO_BLOCK_ITEM = Registry.register(Registry.ITEM, new Identifier("attribute", "potato_block_item"), new PotatoBlockItem(POTATO_BLOCK, new Item.Settings().maxCount(64).rarity(Rarity.UNCOMMON)));
        RedIronOreItem RED_IRON_ORE_ITEM = Registry.register(Registry.ITEM, new Identifier("attribute", "red_iron_ore"), new RedIronOreItem(RED_IRON_ORE, new Item.Settings().maxCount(64).rarity(Rarity.COMMON)));
        RawRedIronBlockItem RAW_RED_IRON_BLOCK_ITEM = Registry.register(Registry.ITEM, new Identifier("attribute", "raw_red_iron_block_item"), new RawRedIronBlockItem(RAW_RED_IRON_BLOCK, new Item.Settings().maxCount(64).rarity(Rarity.COMMON)));
        //注册物品
        Items.ITEM_STACK_VECTOR.add(new ItemStack(CARROT_BLOCK_ITEM));
        Items.ITEM_STACK_VECTOR.add(new ItemStack(POTATO_BLOCK_ITEM));
        Items.ITEM_STACK_VECTOR.add(new ItemStack(RED_IRON_ORE_ITEM));
        Items.ITEM_STACK_VECTOR.add(new ItemStack(RAW_RED_IRON_BLOCK_ITEM));
    }

}
