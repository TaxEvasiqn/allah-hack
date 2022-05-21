package me.taxevasion.balls.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.systems.commands.Command;
import meteordevelopment.meteorclient.systems.commands.arguments.PlayerArgumentType;
import net.minecraft.command.CommandSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;
import java.util.UUID;

public class TpCommand extends Command {

    public TpCommand() {
        super("tp", "Teleports a player to you", "tp", "teleport");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.then(argument("player", PlayerArgumentType.player()).executes(context -> {
            ItemStack TpHere = new ItemStack(Items.ENDERMAN_SPAWN_EGG);
            NbtCompound tag1 = new NbtCompound();
            tag1.putString("Owner", );
            return SINGLE_SUCCESS;
        }));
    }
}
