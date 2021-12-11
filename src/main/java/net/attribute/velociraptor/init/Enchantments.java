package net.attribute.velociraptor.init;

import net.attribute.velociraptor.enchant.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Enchantments {

    private Enchantments() {
    }

    /**
     * 实例化附魔
     */
    public static void initialize() {
        Registry.register(Registry.ENCHANTMENT, new Identifier("chant", "agile"), new AgileEnchantment());
        Registry.register(Registry.ENCHANTMENT, new Identifier("chant", "regeneration"), new RegenerationEnchantment());
        Registry.register(Registry.ENCHANTMENT, new Identifier("chant", "suck_blood"), new SuckBloodEnchantment());
        Registry.register(Registry.ENCHANTMENT, new Identifier("chant", "creeper_killer"), new CreeperKillerEnchantment());
        Registry.register(Registry.ENCHANTMENT, new Identifier("chant", "slowness"), new SlownessEnchantment());
        Registry.register(Registry.ENCHANTMENT, new Identifier("chant", "judge"), new JudgeEnchantment());
        Registry.register(Registry.ENCHANTMENT, new Identifier("chant", "critical"), new CriticalEnchantment());
    }

}
