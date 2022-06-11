package uwu.taxevasion.allahhack.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.systems.commands.Command;
import meteordevelopment.meteorclient.systems.commands.arguments.PlayerArgumentType;
import net.minecraft.command.CommandSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.StringNbtReader;
import net.minecraft.network.packet.c2s.play.CreativeInventoryActionC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;

public class KillCommand extends Command {

    public KillCommand() {
        super("kill", "kills someone in render distance", "kill");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.then(argument("player", PlayerArgumentType.player()).executes(context -> {
            ItemStack sex = new ItemStack(Items.SALMON_SPAWN_EGG);
            sex.setNbt(StringNbtReader.parse("{EntityTag:{Duration:5,Effects:[{Amplifier:125,Id:6}],Radius:5,WaitTime:1,id:\"minecraft:area_effect_cloud\",Pos:[" + PlayerArgumentType.getPlayer(context).getPos().x + "," + PlayerArgumentType.getPlayer(context).getPos().y + "," + PlayerArgumentType.getPlayer(context).getPos().z +"]}}"));
            CreativeInventoryActionC2SPacket set = new CreativeInventoryActionC2SPacket(36 + mc.player.getInventory().selectedSlot, sex);
            CreativeInventoryActionC2SPacket clr = new CreativeInventoryActionC2SPacket(36 + mc.player.getInventory().selectedSlot, new ItemStack(Items.AIR));
            BlockHitResult bhr = new BlockHitResult(mc.player.getPos(), Direction.DOWN, new BlockPos(mc.player.getPos()), false);
            PlayerInteractBlockC2SPacket use = new PlayerInteractBlockC2SPacket(Hand.MAIN_HAND, bhr, 0);
            mc.getNetworkHandler().sendPacket(set);
            mc.getNetworkHandler().sendPacket(use);
            mc.getNetworkHandler().sendPacket(clr);
            return SINGLE_SUCCESS;
        }));
    }
}
