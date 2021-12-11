package net.attribute.velociraptor.network;

import net.attribute.velociraptor.AttributeStat;
import net.attribute.velociraptor.util.LineNumberUtil;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.s2c.play.CustomPayloadS2CPacket;
import net.minecraft.util.Identifier;
import org.apache.commons.lang3.StringUtils;

/**
 * @author hwl
 * @function
 * @createDate 2021/12/1 17:30
 * @updateDate 2021/12/1 17:30
 * @updateAuthor
 * @describe
 */
public class PlayerAttributeServerPacket {

    public static final Identifier VELOCIRAPTOR_ATTR_LEVEL_INSTANCE = new Identifier("attribute", "velociraptor_attr_level_instance");
    public static final Identifier VELOCIRAPTOR_ATTR_EXPERIENCE_INSTANCE = new Identifier("attribute", "velociraptor_attr_experience_instance");

    public static void initialize() {
        AttributeStat.LOGGER.info("Player attribute server packet initialize success!");
        ServerPlayNetworking.registerGlobalReceiver(VELOCIRAPTOR_ATTR_LEVEL_INSTANCE, (server, player, handler, buf, responseSender) -> {
            if (server == null) {
                AttributeStat.LOGGER.error("No server in this instance！ {}", LineNumberUtil.exceptionThrowLineNumber());
            } else {
                if (player == null) {
                    AttributeStat.LOGGER.error("Player is null! {}", LineNumberUtil.exceptionThrowLineNumber());
                } else {
                    String topic = buf.readString();
                    int value = buf.readInt();
                    AttributeStat.LOGGER.info("Player attribute server packet initialize success, uuid = {},  name = {}", player.getUuidAsString(), player.getName().getString());
                    AttributeStat.LOGGER.info("topic is {}, and the value is {}", topic, value);
                    if (server.isSingleplayer()) {
                        EntityAttributeInstance playerAttribute = player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
                        if (playerAttribute == null) {
                            AttributeStat.LOGGER.error("No player attribute in this instance! {}", LineNumberUtil.exceptionThrowLineNumber());
                        } else {
                            if (StringUtils.equals("health", topic)) {
                                double maxHealth = playerAttribute.getBaseValue() + value;
                                AttributeStat.LOGGER.info("server max health = {}", maxHealth);
                                playerAttribute.setBaseValue(maxHealth);
                            }
                        }
                        PacketByteBuf packetByteBuf = PacketByteBufs.create();
                        packetByteBuf.writeInt(value);
                        packetByteBuf.writeString(topic);
                        CustomPayloadS2CPacket customPayloadS2CPacket = new CustomPayloadS2CPacket(PlayerAttributeServerPacket.VELOCIRAPTOR_ATTR_EXPERIENCE_INSTANCE, packetByteBuf);
                        player.networkHandler.sendPacket(customPayloadS2CPacket);
                    } else {
                        AttributeStat.LOGGER.info("Now playing in multi player mode!");
                    }
                }
            }
        });
    }

}
