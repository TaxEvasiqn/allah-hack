package uwu.taxevasion.allahhack.modules;

import net.minecraft.item.SpawnEggItem;
import uwu.taxevasion.allahhack.Allah;
import meteordevelopment.meteorclient.settings.*;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import meteordevelopment.meteorclient.events.meteor.MouseButtonEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtDouble;
import net.minecraft.nbt.NbtList;
import net.minecraft.network.packet.c2s.play.CreativeInventoryActionC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

public class AnyPlacer extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    private final Setting<Boolean> fluidplace = sgGeneral.add(new BoolSetting.Builder()
        .name("fluid-place")
        .description("Places on fluids.")
        .defaultValue(true)
        .build());

    public AnyPlacer() {
        super(Allah.CATEGORY, "anyplacer", "allah gifts you to place spawn eggs with infinite reach in creative");
    }

    @EventHandler
    private void onMouseButton(MouseButtonEvent event) {
        HitResult hitResult = mc.getCameraEntity().raycast(300, 0, fluidplace.get());
        Vec3d hr = hitResult.getPos();
        if (mc.player.getAbilities().creativeMode) {
            if (hitResult != null && mc.currentScreen == null && mc.player.getMainHandStack().getItem() instanceof SpawnEggItem) {
                event.cancel();
                ItemStack egg = mc.player.getInventory().getMainHandStack();
                NbtCompound tag = egg.getOrCreateSubNbt("EntityTag");
                NbtList list = new NbtList();
                list.add(NbtDouble.of(hr.x));
                list.add(NbtDouble.of(hr.y));
                list.add(NbtDouble.of(hr.z));
                tag.put("Pos", list);
                CreativeInventoryActionC2SPacket theegg = new CreativeInventoryActionC2SPacket(36 + mc.player.getInventory().selectedSlot, egg);
                mc.getNetworkHandler().sendPacket(theegg);
                BlockHitResult placepos = new BlockHitResult(mc.player.getPos(), Direction.DOWN, new BlockPos(mc.player.getPos()), false);
                if (mc.options.useKey.isPressed()) {
                    PlayerInteractBlockC2SPacket balls = new PlayerInteractBlockC2SPacket(Hand.MAIN_HAND, placepos, 0);
                    mc.getNetworkHandler().sendPacket(balls);
                }
            }
        } else {
            error("You need to be in creative mode.");
            toggle();
        }
    }
}
