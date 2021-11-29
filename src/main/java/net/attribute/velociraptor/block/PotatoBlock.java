package net.attribute.velociraptor.block;

import net.minecraft.block.Block;
import net.minecraft.world.explosion.Explosion;

public class PotatoBlock extends Block {

    public PotatoBlock(Settings settings) {
        super(settings);
    }

    @Override
    public boolean shouldDropItemsOnExplosion(Explosion explosion) {
        return true;
    }

}
