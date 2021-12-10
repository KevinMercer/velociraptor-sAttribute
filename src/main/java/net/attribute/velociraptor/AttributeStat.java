package net.attribute.velociraptor;

import net.attribute.velociraptor.init.Blocks;
import net.attribute.velociraptor.init.Enchantments;
import net.attribute.velociraptor.init.Items;
import net.attribute.velociraptor.network.PlayerAttributeClientPacket;
import net.attribute.velociraptor.network.PlayerAttributeServerPacket;
import net.attribute.velociraptor.util.ConstantString;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.util.Identifier;
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
            FabricItemGroupBuilder.create(new Identifier(ConstantString.MOD_ID, ConstantString.ITEM)).icon(() -> Items.ITEM_STACK_VECTOR.get(0)).appendItems(items -> items.addAll(Items.ITEM_STACK_VECTOR)).build();
        }
    }
}
