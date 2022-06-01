package uwu.taxevasion.allahhack.modules;

import meteordevelopment.meteorclient.events.meteor.MouseButtonEvent;
import meteordevelopment.meteorclient.settings.IntSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.settings.StringSetting;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import uwu.taxevasion.allahhack.Allah;

public class ClickNuke extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    private final Setting<Integer> radius = sgGeneral.add(new IntSetting.Builder()
        .name("radius")
        .description("The radius of Allah's magic.")
        .defaultValue(15)
        .min(1)
        .sliderMax(15)
        .build()
    );

    private final Setting<String> block = sgGeneral.add(new StringSetting.Builder()
        .name("block")
        .description("What block for Allah to create.")
        .defaultValue("air")
        .build()
    );

    public ClickNuke() {
        super(Allah.CATEGORY, "click-nuke", "allah does his magic where you click");
    }

    @EventHandler
    private void onMouseButton(MouseButtonEvent event) {
        if (mc.options.attackKey.isPressed()) {
            if (mc.currentScreen == null) {
                HitResult hr = mc.cameraEntity.raycast(300, 0, true);
                Vec3d owo = hr.getPos();
                BlockPos pos = new BlockPos(owo);
                //this probably can be simpler
                int x1 = Math.round(pos.getX()) + radius.get();
                int y1 = Math.round(pos.getY()) + radius.get();
                int z1 = Math.round(pos.getZ()) + radius.get();
                int x2 = Math.round(pos.getX()) - radius.get();
                int y2 = Math.round(pos.getY()) - radius.get();
                int z2 = Math.round(pos.getZ()) - radius.get();
                mc.player.sendChatMessage("/fill " + x1 + " " + y1 + " " + z1 + " " + x2 + " " + y2 + " " + z2 + " " + block);
            }
        }
    }
}
