package net.attribute.velociraptor.init;

import net.attribute.velociraptor.enchant.*;
import net.attribute.velociraptor.util.ConstantString;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Enchantments {

    private Enchantments() {
    }

    /**
     * 实例化附魔
     */
    public static void initialize() {
        Registry.register(Registry.ENCHANTMENT, new Identifier(ConstantString.MOD_ID, ConstantString.AGILE), new AgileEnchantment());
        Registry.register(Registry.ENCHANTMENT, new Identifier(ConstantString.MOD_ID, ConstantString.REGENERATION), new RegenerationEnchantment());
        Registry.register(Registry.ENCHANTMENT, new Identifier(ConstantString.MOD_ID, ConstantString.SUCK_BLOOD), new SuckBloodEnchantment());
        Registry.register(Registry.ENCHANTMENT, new Identifier(ConstantString.MOD_ID, ConstantString.CREEPER_KILLER), new CreeperKillerEnchantment());
        Registry.register(Registry.ENCHANTMENT, new Identifier(ConstantString.MOD_ID, ConstantString.SLOWNESS), new SlownessEnchantment());
        Registry.register(Registry.ENCHANTMENT, new Identifier(ConstantString.MOD_ID, ConstantString.JUDGE), new JudgeEnchantment());
        Registry.register(Registry.ENCHANTMENT, new Identifier(ConstantString.MOD_ID, ConstantString.CRITICAL), new CriticalEnchantment());
    }

}
