package net.attribute.velociraptor.mixin;

import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author hwl
 * @function player attribute
 * @createDate 2021/11/30 19:40
 * @updateDate 2021/11/30 19:40
 * @updateAuthor warren
 * @describe
 */
@Mixin(PlayerEntity.class)
public class PlayerMixin {
    @Inject(method = "initDataTracker", at = @At("TAIL"))
    private void setMaxHealth(CallbackInfo ci) {
    }
}
