package uwu.taxevasion.allahhack.modules;

import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import uwu.taxevasion.allahhack.Allah;

public class Freeze extends Module {
    public Freeze() {
        super(Allah.CATEGORY, "freeze", "freezes you for a moment");
    }

    @EventHandler
    public void onActivate() {
        mc.player.setVelocity(0, 0, 0);
        toggle();
    }
}
