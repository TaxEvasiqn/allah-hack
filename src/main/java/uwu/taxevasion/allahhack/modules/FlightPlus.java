package uwu.taxevasion.allahhack.modules;

import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.settings.*;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.utils.Utils;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.util.math.Vec3d;
import uwu.taxevasion.allahhack.Allah;

public class FlightPlus extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    private final Setting<Double> speed = sgGeneral.add(new DoubleSetting.Builder()
        .name("speed")
        .description("how fast")
        .defaultValue(3)
        .sliderRange(0, 10)
        .build());

    private final Setting<Boolean> cap = sgGeneral.add(new BoolSetting.Builder()
        .name("cap speed")
        .description("recommended!")
        .defaultValue(true)
        .build());

    public FlightPlus() {
        super(Allah.CATEGORY, "flight+", "allah makes sure you arent flagged by the vanilla console (very fucked will fix next update maybe)");
    }

    @EventHandler
    public void onTick(TickEvent.Post event) {
        mc.player.getAbilities().flying = false;
        Vec3d owo = mc.player.getRotationVector().multiply(speed.get() / 5);
        if (cap.get() && Utils.getPlayerSpeed() >= 200) {
            mc.player.setVelocity(mc.player.getVelocity());
        } else {
            if (mc.options.forwardKey.isPressed()) {
                mc.player.addVelocity(owo.x, 0, owo.z);
            }
            if (mc.options.backKey.isPressed()) {
                mc.player.addVelocity(-owo.x, 0, -owo.z);
            }
            if (mc.options.jumpKey.isPressed()) {
                mc.player.addVelocity(0, speed.get() / 10, 0);
            }
            if (mc.options.sneakKey.isPressed()) {
                mc.player.addVelocity(0, -speed.get() / 10, 0);
            }
            if (mc.options.leftKey.isPressed()) {
                //help
            }
            if (mc.options.rightKey.isPressed()) {
                //help
            }
            if (!(mc.options.jumpKey.isPressed() || mc.options.sneakKey.isPressed())) {
                mc.player.addVelocity(0, -mc.player.getVelocity().y, 0);
            }
        }
    }
}
