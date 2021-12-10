package net.attribute.velociraptor.attribute;

import net.minecraft.nbt.NbtCompound;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author warren
 * @function
 * @createDate 2021/12/1 16:56
 * @updateDate 2021/12/1 16:56
 * @updateAuthor
 * @describe
 */
public class PlayerAttribute {

    public double levelProgress;
    public int currentExperience;
    public int levelExperience;
    public int totalLevel;

    private int headLevel;
    private int chestLevel;
    private int leggingLevel;
    private int bootLevel;
    private int mainHandLevel;
    private int offHandLevel;

    public void readNbt(NbtCompound nbtCompound) {
        levelProgress = nbtCompound.getDouble("velociraptor_attr_level_progress");
        currentExperience = nbtCompound.getInt("velociraptor_attr_level_experience_current");
        levelExperience = nbtCompound.getInt("velociraptor_attr_level_experience_level");
        totalLevel = nbtCompound.getInt("velociraptor_attr_level_total_level");
        headLevel = nbtCompound.getInt("velociraptor_attr_level_head");
        chestLevel = nbtCompound.getInt("velociraptor_attr_level_chest");
        leggingLevel = nbtCompound.getInt("velociraptor_attr_level_legging");
        bootLevel = nbtCompound.getInt("velociraptor_attr_level_boot");
        mainHandLevel = nbtCompound.getInt("velociraptor_attr_level_main_hand");
        offHandLevel = nbtCompound.getInt("velociraptor_attr_level_off_hand");
    }

    public void writeNbt(NbtCompound nbtCompound) {
        nbtCompound.putDouble("velociraptor_attr_level_progress", levelProgress);
        nbtCompound.putInt("velociraptor_attr_level_experience_current", currentExperience);
        nbtCompound.putInt("velociraptor_attr_level_experience_level", levelExperience);
        nbtCompound.putInt("velociraptor_attr_level_total_level", totalLevel);
        nbtCompound.putInt("velociraptor_attr_level_head", headLevel);
        nbtCompound.putInt("velociraptor_attr_level_chest", chestLevel);
        nbtCompound.putInt("velociraptor_attr_level_legging", leggingLevel);
        nbtCompound.putInt("velociraptor_attr_level_boot", bootLevel);
        nbtCompound.putInt("velociraptor_attr_level_main_hand", mainHandLevel);
        nbtCompound.putInt("velociraptor_attr_level_off_hand", offHandLevel);
    }

    public void addLevelProgress(int experience) {
        currentExperience += experience;
        recursionExperience();
        levelProgress = BigDecimal.valueOf(currentExperience).divide(BigDecimal.valueOf(levelExperience), 2, RoundingMode.HALF_UP).doubleValue();
    }

    private void recursionExperience() {
        if (currentExperience > levelExperience) {
            currentExperience -= levelExperience;
            totalLevel += 1;
            if (currentExperience > levelExperience) {
                recursionExperience();
            }
        }
    }

}
