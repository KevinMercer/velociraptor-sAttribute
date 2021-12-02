package net.attribute.velociraptor.enchant;

import net.attribute.velociraptor.AttributeStat;
import net.attribute.velociraptor.network.PlayerAttributeClientPacket;
import net.attribute.velociraptor.network.PlayerAttributeServerPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.c2s.play.CustomPayloadC2SPacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.TranslatableText;

public class JudgeEnchantment extends Enchantment {

    public JudgeEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }


    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        boolean condition = false;
        try {
            condition = other.type == EnchantmentTarget.WEAPON && !(other instanceof DamageEnchantment);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return condition;
    }

    @Override
    public float getAttackDamage(int level, EntityGroup group) {
        if (group == EntityGroup.ILLAGER) {
            MinecraftClient minecraftClient = MinecraftClient.getInstance();
            MinecraftServer minecraftClientServer = minecraftClient.getServer();
            if (minecraftClient.player != null) {
                PacketByteBuf packetByteBuf = PacketByteBufs.create();
                packetByteBuf.writeString("health");
                packetByteBuf.writeInt(1);
                CustomPayloadC2SPacket customPayloadC2SPacket = new CustomPayloadC2SPacket(PlayerAttributeServerPacket.VELOCIRAPTOR_ATTR_LEVEL_INSTANCE, packetByteBuf);
                ClientPlayNetworkHandler clientPlayNetworkHandler = minecraftClient.getNetworkHandler();
                if (clientPlayNetworkHandler == null) {
                    AttributeStat.LOGGER.error("No network handler in this instance!");
                } else {
                    clientPlayNetworkHandler.sendPacket(customPayloadC2SPacket);
                }
                if (minecraftClientServer != null && minecraftClientServer.isSingleplayer()) {
                    AttributeStat.LOGGER.info("Player name is {}", minecraftClientServer.getSinglePlayerName());
                    AttributeStat.LOGGER.info("Player uuid is {}", minecraftClient.player.getUuidAsString());
                    AttributeStat.LOGGER.info("Player number = {}", minecraftClientServer.getPlayerManager().getCurrentPlayerCount());
                    ServerPlayerEntity serverPlayerEntity = minecraftClientServer.getPlayerManager().getPlayer(minecraftClient.player.getUuidAsString());
                    PlayerEntity player = minecraftClient.player;
                    if (serverPlayerEntity == null) {
                        AttributeStat.LOGGER.error("No server player in this instance!");
                    } else {
                        ServerPlayNetworking.send(serverPlayerEntity, PlayerAttributeServerPacket.VELOCIRAPTOR_ATTR_EXPERIENCE_INSTANCE, packetByteBuf);
                        ServerPlayNetworking.send(serverPlayerEntity, PlayerAttributeServerPacket.VELOCIRAPTOR_ATTR_LEVEL_INSTANCE, packetByteBuf);
                    }
                } else {
                    AttributeStat.LOGGER.error("No server in this instance!");
                }
            } else {
                AttributeStat.LOGGER.error("You just can't create a client player entity");
            }
            return 3 + 3 * level;
        }
        return super.getAttackDamage(level, group);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (user instanceof PlayerEntity playerEntity && target instanceof LivingEntity targetEntity && targetEntity.isDead() && targetEntity.getGroup() == EntityGroup.ILLAGER) {
            playerEntity.sendMessage(new TranslatableText("attribute.judge.killTip"), true);
        }
        super.onTargetDamaged(user, target, level);
    }
}
