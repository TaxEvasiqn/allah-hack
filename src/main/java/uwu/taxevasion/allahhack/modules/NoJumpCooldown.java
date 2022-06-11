package uwu.taxevasion.allahhack.modules;

import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import uwu.taxevasion.allahhack.Allah;
import uwu.taxevasion.allahhack.mixins.ILivingEntityAccessor;

public class NoJumpCooldown extends Module {
    public NoJumpCooldown() {
        super(Allah.CATEGORY, "no-jump-cooldown", "removes jump cooldown");
    }

    @EventHandler
    public void onTick(TickEvent.Post event) {
        ((ILivingEntityAccessor) mc.player).setJumpingCooldown(0);
    }
}
