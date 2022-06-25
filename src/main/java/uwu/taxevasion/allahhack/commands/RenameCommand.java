package uwu.taxevasion.allahhack.commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.systems.commands.Command;
import net.minecraft.command.CommandSource;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;

public class RenameCommand extends Command {
    public RenameCommand() {
        super("rename", "renames the item in your hand");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.then(argument("text", StringArgumentType.string()).executes(ctx -> {
            ItemStack abc = mc.player.getMainHandStack();
            abc.setCustomName(Text.literal(ctx.getArgument("text", String.class)));
            return SINGLE_SUCCESS;
        }));
    }
}
