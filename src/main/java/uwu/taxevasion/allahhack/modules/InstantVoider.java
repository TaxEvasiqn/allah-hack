package uwu.taxevasion.allahhack.modules;

import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.settings.BoolSetting;
import meteordevelopment.meteorclient.settings.IntSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import uwu.taxevasion.allahhack.Allah;

public class InstantVoider extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    private final Setting<Integer> radius = sgGeneral.add(new IntSetting.Builder()
        .name("radius")
        .description("radius")
        .defaultValue(90)
        .sliderRange(1, 90)
        .build()
    );

    private final Setting<Boolean> cf = sgGeneral.add(new BoolSetting.Builder()
        .name("disable-command-feedback")
        .description("disables command feedback")
        .defaultValue(false)
        .build()
    );

    public InstantVoider() {
        super(Allah.CATEGORY, "instant-voider", "erekrjskjfofhsfhqe");
    }

    @EventHandler
    public void onTick(TickEvent.Post event) {
        int r = radius.get();
        if (cf.get()) {
            mc.player.sendChatMessage("/gamerule sendCommandFeedback false");
        }
        for (int i = 319; i > -64; i--) {
            mc.player.sendChatMessage("/fill ~-" + r + " " + i + " ~-" + r + " ~" + r + " " + i + " ~" + r + " air");
        }
        if (cf.get()) {
            mc.player.sendChatMessage("/gamerule sendCommandFeedback true");
        }
        toggle();
    }
}
