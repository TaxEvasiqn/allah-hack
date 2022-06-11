package uwu.taxevasion.allahhack.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.systems.commands.Command;
import net.minecraft.command.CommandSource;
import net.minecraft.screen.slot.SlotActionType;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;

public class ClearCommand extends Command {
    public ClearCommand() { //fuck you clear chat command for overwriting this whatever addon your from
        super("clear", "clears your inv when in gmc", "clear", "clearinv");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.executes(context -> {
            for (int i = 5; i < 46; i++) {
                mc.interactionManager.clickSlot(mc.player.currentScreenHandler.syncId, i, 120, SlotActionType.SWAP, mc.player);
            } return SINGLE_SUCCESS;
        });
    }
}
