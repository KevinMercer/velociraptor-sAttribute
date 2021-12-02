package net.attribute.velociraptor.network;

import net.attribute.velociraptor.AttributeStat;
import net.attribute.velociraptor.util.LineNumberUtil;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import org.apache.commons.lang3.StringUtils;

/**
 * @author hwl
 * @function
 * @createDate 2021/12/1 19:11
 * @updateDate 2021/12/1 19:11
 * @updateAuthor
 * @describe
 */
public class PlayerAttributeClientPacket {

    public static void initialize() {
        AttributeStat.LOGGER.info("Initialize player attribute client packet success!");
        ClientPlayNetworking.registerGlobalReceiver(PlayerAttributeServerPacket.VELOCIRAPTOR_ATTR_EXPERIENCE_INSTANCE, (client, handler, buf, responseSender) -> {
            AttributeStat.LOGGER.info("register global receiver success");
            AttributeStat.LOGGER.info("Level instance executed!");
            if (buf == null) {
                AttributeStat.LOGGER.warn("No buf send in this packet! {}", LineNumberUtil.exceptionThrowLineNumber());
            } else {
                int value = buf.readInt();
                String topic = buf.readString();
                if (client.player == null) {
                    AttributeStat.LOGGER.error("Player is null");
                } else {
                    AttributeStat.LOGGER.info("Set player health success");
                    EntityAttributeInstance playerAttributeInstance = client.player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
                    if (playerAttributeInstance == null) {
                        AttributeStat.LOGGER.error("No player attribute in this instance! {}", LineNumberUtil.exceptionThrowLineNumber());
                    } else {
                        if (StringUtils.equals(topic, "health")) {
                            double maxHealth = playerAttributeInstance.getBaseValue() + value;
                            AttributeStat.LOGGER.info("client max health = {}", maxHealth);
                            playerAttributeInstance.setBaseValue(maxHealth);
                        }
                    }
                }
            }
        });
    }

}
