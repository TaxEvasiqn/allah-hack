package uwu.taxevasion.allahhack.commands;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.systems.commands.Command;
import meteordevelopment.meteorclient.utils.world.BlockUtils;
import net.minecraft.command.CommandSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.StringNbtReader;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;

public class ShriekCommand extends Command {
    public ShriekCommand() {
        super("shriek", "summons wardens from the ground", "warden");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.then(argument("amount", IntegerArgumentType.integer(1)).executes(ctx -> {
            Vec3d sex = mc.player.getPos();
            BlockPos sex2 = new BlockPos(sex.x, sex.y + 2, sex.z);
            ItemStack asdf = new ItemStack(Items.SCULK_SHRIEKER);
            ItemStack bfr = mc.player.getMainHandStack();
            int wardens = ctx.getArgument("amount", Integer.class);
            asdf.setNbt(StringNbtReader.parse("{BlockEntityTag:{warning_level:4},BlockStateTag:{can_summon:\"true\",shrieking:\"true\"}}"));
            mc.interactionManager.clickCreativeStack(asdf, 36 + mc.player.getInventory().selectedSlot);
            for (int i = 0; i < wardens; i++) {
                mc.getNetworkHandler().sendPacket(new PlayerActionC2SPacket(PlayerActionC2SPacket.Action.START_DESTROY_BLOCK, sex2, Direction.DOWN, 0));
                BlockUtils.place(sex2, Hand.MAIN_HAND, mc.player.getInventory().selectedSlot, false, 0, false, true, false);
            }
            mc.getNetworkHandler().sendPacket(new PlayerActionC2SPacket(PlayerActionC2SPacket.Action.START_DESTROY_BLOCK, sex2, Direction.DOWN, 0));
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }));
    }
}
