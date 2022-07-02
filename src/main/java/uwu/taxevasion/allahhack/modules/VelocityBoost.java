package uwu.taxevasion.allahhack.modules;

import meteordevelopment.meteorclient.settings.*;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.util.math.Vec3d;
import uwu.taxevasion.allahhack.Allah;

public class VelocityBoost extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    private final Setting<Modes> mode = sgGeneral.add(new EnumSetting.Builder<Modes>()
        .name("mode")
        .description("set or add")
        .defaultValue(Modes.Set)
        .build());

    private final Setting<Boolean> facing = sgGeneral.add(new BoolSetting.Builder()
        .name("facing")
        .description("boosts you in the direction you're facing")
        .defaultValue(true)
        .build());

    private final Setting<Double> boost = sgGeneral.add(new DoubleSetting.Builder()
        .name("boost")
        .description("the boost")
        .defaultValue(0)
        .sliderRange(-10, 10)
        .visible(facing::get)
        .build());

    private final Setting<Double> xboost = sgGeneral.add(new DoubleSetting.Builder()
        .name("x")
        .description("boost in x")
        .defaultValue(0)
        .sliderRange(-10, 10)
        .visible(() -> !facing.get())
        .build());

    private final Setting<Double> yboost = sgGeneral.add(new DoubleSetting.Builder()
        .name("y")
        .description("boost in y")
        .defaultValue(0)
        .sliderRange(-10, 10)
        .build());

    private final Setting<Double> zboost = sgGeneral.add(new DoubleSetting.Builder()
        .name("z")
        .description("boost in z")
        .defaultValue(0)
        .sliderRange(-10, 10)
        .visible(() -> !facing.get())
        .build());

    public VelocityBoost() {
        super(Allah.CATEGORY, "velocity-boost", "changes your velocity (much faster than you think)");
    }

    @EventHandler
    public void onActivate() {
        Vec3d sex = mc.player.getRotationVector().multiply(boost.get());
        switch (mode.get()) {
            case Set -> {
                if (facing.get()) {
                    mc.player.setVelocity(sex.x, yboost.get(), sex.z);
                } else {
                    mc.player.setVelocity(xboost.get(), yboost.get(), zboost.get());
                }
            }
            case Add -> {
                    if (facing.get()) {
                    mc.player.addVelocity(sex.x, yboost.get(), sex.z);
                } else {
                    mc.player.addVelocity(xboost.get(), yboost.get(), zboost.get());
                }
            }
        }
        toggle();
    }

    public enum Modes {
        Set, Add
    }
}
