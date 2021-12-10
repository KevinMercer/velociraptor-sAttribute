package net.attribute.velociraptor.block;

import net.minecraft.block.Block;
import net.minecraft.world.explosion.Explosion;

/**
 * @author warren
 */
public class CarrotBlock extends Block {

    public CarrotBlock(Settings settings) {
        super(settings);
    }

    @Override
    public boolean shouldDropItemsOnExplosion(Explosion explosion) {
        return true;
    }

}
