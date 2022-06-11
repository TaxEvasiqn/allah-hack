package uwu.taxevasion.allahhack.modules;

import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.settings.EnumSetting;
import meteordevelopment.meteorclient.settings.IntSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.util.math.Vec3d;
import uwu.taxevasion.allahhack.Allah;

public class ConsoleFlood extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    private final Setting<Modes> mode = sgGeneral.add(new EnumSetting.Builder<Modes>()
        .name("mode")
        .description("how to crash (more next update)")
        .defaultValue(Modes.Movement)
        .build()
    );

    public ConsoleFlood() {
        super(Allah.CATEGORY, "console-flood", "floods the console");
    }

    @EventHandler
    private void onTick(TickEvent.Post event) {
        Vec3d sex = new Vec3d(mc.player.getPos().x, mc.player.getPos().y, mc.player.getPos().z);
        switch (mode.get()) {
            case Movement -> {
                mc.player.setPos(1333333337, 1333333337, 1333333337);
            }
        }
    }
    public enum Modes {
        Movement
    }
}
