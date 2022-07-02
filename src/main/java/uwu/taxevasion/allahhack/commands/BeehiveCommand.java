package uwu.taxevasion.allahhack.commands;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.systems.commands.Command;
import net.minecraft.command.CommandSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.StringNbtReader;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;

public class BeehiveCommand extends Command {
    public BeehiveCommand() {
        super("beehive", "Generates a beehive with bees");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.then(argument("bees", IntegerArgumentType.integer(1)).executes(ctx -> {
            ItemStack beehive = new ItemStack(Items.BEEHIVE);
            int aaa = ctx.getArgument("bees", Integer.class);
            String bee1 = "{EntityData:{id:\"minecraft:bee\"}}";
            String bee2 = "," + bee1;
            beehive.setNbt(StringNbtReader.parse("{BlockEntityTag:{Bees:[" + bee1 + bee2.repeat(aaa - 1) + "],id:\"minecraft:beehive\"}}"));
            mc.interactionManager.clickCreativeStack(beehive, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }));
    }
}
