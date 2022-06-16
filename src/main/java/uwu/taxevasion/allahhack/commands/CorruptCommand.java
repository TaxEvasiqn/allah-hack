package uwu.taxevasion.allahhack.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.systems.commands.Command;
import net.minecraft.command.CommandSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.StringNbtReader;
import net.minecraft.network.packet.c2s.play.CreativeInventoryActionC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;

public class CorruptCommand extends Command {
    public CorruptCommand() {
        super("corrupt", "corrupts the area around you (1.19 only)");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.executes(ctx -> {
            Vec3d sex = new Vec3d(Math.round(mc.player.getX()), Math.round(mc.player.getY()) - 1, Math.round(mc.player.getZ()));
            Vec3d balls = new Vec3d(Math.round(mc.player.getX()), Math.round(mc.player.getY()) - 1, Math.round(mc.player.getZ()) + 1);
            ItemStack ww = mc.player.getMainHandStack();
            ItemStack owo = new ItemStack(Items.SCULK_CATALYST);
            owo.setNbt(StringNbtReader.parse("{BlockEntityTag:{bloom:1,cursors:[{charge:1000,decay_delay:1,facings:[\"east\"],pos:[I;" + (int) sex.x + "," + (int) sex.y + "," + (int) sex.z + "],update_delay:1}],id:\"minecraft:sculk_catalyst\"}}"));

            BlockHitResult bhr = new BlockHitResult(sex, Direction.DOWN, new BlockPos(sex), false);
            BlockHitResult a = new BlockHitResult(balls, Direction.DOWN, new BlockPos(balls), false);
            mc.getNetworkHandler().sendPacket(new CreativeInventoryActionC2SPacket(36 + mc.player.getInventory().selectedSlot, owo));
            mc.getNetworkHandler().sendPacket(new PlayerActionC2SPacket(PlayerActionC2SPacket.Action.START_DESTROY_BLOCK, new BlockPos(balls), Direction.DOWN, 0));
            mc.getNetworkHandler().sendPacket(new PlayerInteractBlockC2SPacket(Hand.MAIN_HAND, a, 0));
            mc.getNetworkHandler().sendPacket(new CreativeInventoryActionC2SPacket(36 + mc.player.getInventory().selectedSlot, new ItemStack(Items.SCULK)));
            mc.getNetworkHandler().sendPacket(new PlayerActionC2SPacket(PlayerActionC2SPacket.Action.START_DESTROY_BLOCK, new BlockPos(sex), Direction.DOWN, 0));
            mc.getNetworkHandler().sendPacket(new PlayerInteractBlockC2SPacket(Hand.MAIN_HAND, bhr, 0));
            mc.getNetworkHandler().sendPacket(new CreativeInventoryActionC2SPacket(36 + mc.player.getInventory().selectedSlot, ww));
            return SINGLE_SUCCESS;
        });
    }
}
