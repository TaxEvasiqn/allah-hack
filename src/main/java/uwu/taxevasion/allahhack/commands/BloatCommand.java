package uwu.taxevasion.allahhack.commands;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.systems.commands.Command;
import net.minecraft.command.CommandSource;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.StringNbtReader;

import java.util.Random;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;

public class BloatCommand extends Command {
    public BloatCommand() {
        super("bloat", "inflates data, dont make it too big or else youll get kicked also meteor byte counter is wrong", "inflate");
    }

    private final Random r = new Random();

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.executes(ctx -> {
            ItemStack item = mc.player.getMainHandStack();
            item.setNbt(StringNbtReader.parse("{" + "a".repeat(r.nextInt(65000)) + ":[]}"));
            return SINGLE_SUCCESS;
        });

        builder.then(argument("bytes", IntegerArgumentType.integer(6)).executes(context -> {
            ItemStack item = mc.player.getMainHandStack();
            int bytes = Math.round(context.getArgument("bytes", Integer.class) - 5);
            item.setNbt(StringNbtReader.parse("{" + "a".repeat(bytes) + ":[]}"));
            return SINGLE_SUCCESS;
        }));
    }
}
