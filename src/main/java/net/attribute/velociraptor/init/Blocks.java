package net.attribute.velociraptor.init;

import net.attribute.velociraptor.Velociraptors;
import net.attribute.velociraptor.block.CarrotBlock;
import net.attribute.velociraptor.block.PotatoBlock;
import net.attribute.velociraptor.block.RawRedIronBlock;
import net.attribute.velociraptor.item.block.CarrotBlockItem;
import net.attribute.velociraptor.item.block.PotatoBlockItem;
import net.attribute.velociraptor.item.block.RawRedIronBlockItem;
import net.attribute.velociraptor.item.ore.RedIronOreItem;
import net.attribute.velociraptor.ore.RedIronOre;
import net.attribute.velociraptor.util.ConstantString;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.*;

import static net.minecraft.world.gen.decorator.CountPlacementModifier.*;

public class Blocks {

    private Blocks() {
    }

    /**
     * 实例化方块
     */
    public static void initialize() {
        //实例化方块
        CarrotBlock carrotBlock = Registry.register(Registry.BLOCK, new Identifier(ConstantString.MOD_ID, ConstantString.CARROT_BLOCK), new CarrotBlock(FabricBlockSettings.of(Material.WOOD, MapColor.DARK_RED).strength(1.0F).sounds(BlockSoundGroup.WOOD).hardness(0.2F)));
        PotatoBlock potatoBlock = Registry.register(Registry.BLOCK, new Identifier(ConstantString.MOD_ID, ConstantString.POTATO_BLOCK), new PotatoBlock(FabricBlockSettings.of(Material.WOOD, MapColor.DEEPSLATE_GRAY).strength(1.0F).sounds(BlockSoundGroup.WOOD).hardness(0.2F)));
        RawRedIronBlock rawRedIronBlock = Registry.register(Registry.BLOCK, new Identifier(ConstantString.MOD_ID, ConstantString.RAW_RED_IRON_BLOCK), new RawRedIronBlock(FabricBlockSettings.of(Material.STONE).strength(2.5F).sounds(BlockSoundGroup.STONE).requiresTool()));
        //实例化矿物
        RedIronOre redIronOre = Registry.register(Registry.BLOCK, new Identifier(ConstantString.MOD_ID, ConstantString.RED_IRON_ORE), new RedIronOre(FabricBlockSettings.of(Material.STONE).strength(2.5F).sounds(BlockSoundGroup.STONE).requiresTool()));
        //实例化方块对应的物品
        CarrotBlockItem carrotBlockItem = Registry.register(Registry.ITEM, new Identifier(ConstantString.MOD_ID, ConstantString.CARROT_BLOCK_ITEM), new CarrotBlockItem(carrotBlock, new Item.Settings().maxCount(64).rarity(Rarity.UNCOMMON)));
        PotatoBlockItem potatoBlockItem = Registry.register(Registry.ITEM, new Identifier(ConstantString.MOD_ID, ConstantString.POTATO_BLOCK_ITEM), new PotatoBlockItem(potatoBlock, new Item.Settings().maxCount(64).rarity(Rarity.UNCOMMON)));
        RedIronOreItem redIronOreItem = Registry.register(Registry.ITEM, new Identifier(ConstantString.MOD_ID, ConstantString.RED_IRON_ORE_ITEM), new RedIronOreItem(redIronOre, new Item.Settings().maxCount(64).rarity(Rarity.COMMON)));
        RawRedIronBlockItem rawRedIronBlockItem = Registry.register(Registry.ITEM, new Identifier(ConstantString.MOD_ID, ConstantString.RAW_RED_IRON_BLOCK_ITEM), new RawRedIronBlockItem(rawRedIronBlock, new Item.Settings().maxCount(64).rarity(Rarity.COMMON)));
        //注册物品
        Items.ITEM_STACK_VECTOR.add(new ItemStack(carrotBlockItem));
        Items.ITEM_STACK_VECTOR.add(new ItemStack(potatoBlockItem));
        Items.ITEM_STACK_VECTOR.add(new ItemStack(redIronOreItem));
        Items.ITEM_STACK_VECTOR.add(new ItemStack(rawRedIronBlockItem));
        //注册矿物
        ConfiguredFeature<?, ?> overWorldRedIronOreConfiguredFeature = Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, redIronOre.getDefaultState(), 12));
        PlacedFeature overWorldRedIronOrePlacedFeature = overWorldRedIronOreConfiguredFeature.withPlacement(of(40), SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64)));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(ConstantString.MOD_ID, ConstantString.RED_IRON_ORE), overWorldRedIronOreConfiguredFeature);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(ConstantString.MOD_ID, ConstantString.RED_IRON_ORE), overWorldRedIronOrePlacedFeature);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(ConstantString.MOD_ID, ConstantString.RED_IRON_ORE)));
    }

}
