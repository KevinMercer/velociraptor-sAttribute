package net.attribute.velociraptor.util;

import net.attribute.velociraptor.AttributeStat;

import java.util.Random;

/**
 * @author warren
 */
public class RandomUtil {
    public static boolean getRandomNumber(int level, int weight) {
        if (weight <= 10) {
            weight = 10;
        }
        Random random = new Random();
        int number = random.nextInt(weight);
        AttributeStat.LOGGER.info("本次随机数为：{}", number);
        return number < level;
    }
}
