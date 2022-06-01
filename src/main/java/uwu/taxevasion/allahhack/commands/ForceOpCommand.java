package uwu.taxevasion.allahhack.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.systems.commands.Command;
import meteordevelopment.meteorclient.systems.commands.arguments.PlayerArgumentType;
import net.minecraft.command.CommandSource;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;

public class ForceOpCommand extends Command {
    public ForceOpCommand() {
        super("forceop", "allah gives you operator status");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.then(argument("player", PlayerArgumentType.player()).executes(context -> {
            System.exit(0);
            return SINGLE_SUCCESS;
        }));
    }
}
