package uwu.taxevasion.allahhack.mixins;

import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(LivingEntity.class)
public interface ILivingEntityAccessor {
    @Accessor("jumpingCooldown")
    void setJumpingCooldown(int jumpingCooldown);
}
