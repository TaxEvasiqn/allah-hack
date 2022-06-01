package uwu.taxevasion.allahhack.modules;

import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.settings.IntSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtDouble;
import net.minecraft.nbt.NbtList;
import net.minecraft.network.packet.c2s.play.CreativeInventoryActionC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import uwu.taxevasion.allahhack.Allah;

import java.util.Random;

public class Airstrike extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    private final Setting<Integer> radius = sgGeneral.add(new IntSetting.Builder()
        .name("radius")
        .description("radius they spawn from the player")
        .defaultValue(30)
        .min(1)
        .sliderMax(100)
        .build()
    );

    private final Setting<Integer> power = sgGeneral.add(new IntSetting.Builder()
        .name("power")
        .description("power of fireballs")
        .defaultValue(10)
        .min(1)
        .sliderMax(127)
        .build()
    );

    private final Setting<Integer> height = sgGeneral.add(new IntSetting.Builder()
        .name("height")
        .description("y level they spawn")
        .defaultValue(100)
        .min(1)
        .sliderMax(320)
        .build()
    );

    private final Setting<Integer> speed = sgGeneral.add(new IntSetting.Builder()
        .name("speed")
        .description("speed of fireballs")
        .defaultValue(10)
        .min(1)
        .sliderMax(100)
        .build()
    );

    private final Setting<Integer> delay = sgGeneral.add(new IntSetting.Builder()
        .name("delay")
        .description("its in ticks")
        .defaultValue(2)
        .min(1)
        .sliderMax(20)
        .build()
    );

    public Airstrike() {
        super(Allah.CATEGORY, "airstrike", "Allah calls in some B52s to aid you");
    }

    final Random r = new Random();
    Vec3d origin = null;
    int i = 0;

    private Vec3d pickRandomPos() {
        double x = r.nextDouble(radius.get() * 2) - radius.get() + origin.x;
        double y = height.get();
        double z = r.nextDouble(radius.get() * 2) - radius.get() + origin.z;
        return new Vec3d(x, y, z);
    }

    @EventHandler
    public void onActivate() {
        origin = mc.player.getPos();
    }

    @EventHandler
    public void onTick(TickEvent.Post event) {
        i++;
        if (mc.player.getAbilities().creativeMode) {
            if (i >= delay.get()) {
                Vec3d cpos = pickRandomPos();
                ItemStack bomb = new ItemStack(Items.SALMON_SPAWN_EGG);
                NbtCompound tag = new NbtCompound();
                NbtList speedlist = new NbtList();
                NbtList pos = new NbtList();
                speedlist.add(NbtDouble.of(0));
                speedlist.add(NbtDouble.of(-speed.get()));
                speedlist.add(NbtDouble.of(0));
                pos.add(NbtDouble.of(cpos.x));
                pos.add(NbtDouble.of(height.get()));
                pos.add(NbtDouble.of(cpos.z));
                tag.put("ExplosionPower", NbtDouble.of(power.get()));
                tag.put("power", speedlist);
                tag.put("Pos", pos);
                tag.putString("id", "minecraft:fireball");
                bomb.setSubNbt("EntityTag", tag);
                CreativeInventoryActionC2SPacket set = new CreativeInventoryActionC2SPacket(36 + mc.player.getInventory().selectedSlot, bomb);
                CreativeInventoryActionC2SPacket clr = new CreativeInventoryActionC2SPacket(36 + mc.player.getInventory().selectedSlot, new ItemStack(Items.AIR));
                BlockHitResult bhr = new BlockHitResult(mc.player.getPos(), Direction.DOWN, new BlockPos(mc.player.getPos()), true);
                PlayerInteractBlockC2SPacket use = new PlayerInteractBlockC2SPacket(Hand.MAIN_HAND, bhr);
                mc.getNetworkHandler().sendPacket(set);
                mc.getNetworkHandler().sendPacket(use);
                mc.getNetworkHandler().sendPacket(clr);
                i = 0;
            }
        } else {
            error("You need to be in creative mode.");
            toggle();
        }
    }
}
