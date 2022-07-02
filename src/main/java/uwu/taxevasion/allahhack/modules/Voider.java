package uwu.taxevasion.allahhack.modules;

import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.settings.*;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import uwu.taxevasion.allahhack.Allah;

public class Voider extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    private final Setting<Integer> r = sgGeneral.add(new IntSetting.Builder()
        .name("radius")
        .description("radius")
        .defaultValue(90)
        .sliderRange(1, 90)
        .build());

    private final Setting<Boolean> cf = sgGeneral.add(new BoolSetting.Builder()
        .name("disable-command-feedback")
        .description("disables command feedback")
        .defaultValue(false)
        .build());

    public Voider() {
        super(Allah.CATEGORY, "voider", "erekrjskjfofhsfhqe");
    }

    int i = 319;

    @EventHandler
    public void onTick(TickEvent.Post event) {
        if (!(mc.player.hasPermissionLevel(4))) {
            toggle();
            error("must have op");
        }
        i--;
        mc.player.sendChatMessage("/fill ~-" + r.get() + " " + i + " ~-" + r.get() + " ~" + r.get() + " " + i + " ~" + r.get() + " air");
        if (i == -64) {
            i = 319;
            toggle();
        }
    }

    @EventHandler
    public void onActivate() {
        if (cf.get()) {
            mc.player.sendChatMessage("/gamerule sendCommandFeedback false");
        }
    }

    @EventHandler
    public void onDeactivate() {
        if (cf.get()) {
            mc.player.sendChatMessage("/gamerule sendCommandFeedback true");
        }
    }
}
