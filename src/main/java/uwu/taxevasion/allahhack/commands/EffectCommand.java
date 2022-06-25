package uwu.taxevasion.allahhack.commands;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.systems.commands.Command;
import net.minecraft.command.CommandSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.StringNbtReader;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;

public class EffectCommand extends Command {
    public EffectCommand() {
        super("effect", "gives you a potion effect");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        assert mc.interactionManager != null;
        assert mc.player != null;
        builder.then(literal("speed").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:1,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("slowness").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:2,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("haste").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:3,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("mining_fatigue").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:4,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("strength").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:5,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("instant_health").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:6,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("instant_damage").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:7,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("jump_boost").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:8,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("nausea").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:9,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("regeneration").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:10,Radius:2,WaitTime:0,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("resistance").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:11,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("fire_resistance").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:12,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("water_breathing").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:13,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("invisibility").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:14,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("blindness").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:15,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("night_vision").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:16,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("hunger").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:17,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("weakness").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:18,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("poison").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:19,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("wither").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:20,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("health_boost").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:21,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("absorption").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:22,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("saturation").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:23,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("glowing").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:23,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("levitation").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:24,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("luck").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:25,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("bad_luck").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:26,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("slow_falling").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:28,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("conduit_power").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:29,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("dolphins_grace").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:30,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("bad_omen").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:31,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("hero_of_the_village").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:32,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));

        builder.then(literal("darkness").then(argument("duration", IntegerArgumentType.integer()).then(argument("potency", IntegerArgumentType.integer()).executes(context -> {
            ItemStack bfr = mc.player.getMainHandStack();
            ItemStack egg = new ItemStack(Items.SALMON_SPAWN_EGG);
            BlockHitResult bhr = new BlockHitResult(mc.player.getEyePos(), Direction.DOWN, new BlockPos(mc.player.getEyePos()), false);
            int potency = context.getArgument("potency", Integer.class) - 1;
            egg.setNbt(StringNbtReader.parse("{EntityTag:{id:\"minecraft:area_effect_cloud\",Duration:2,Radius:2,WaitTime:0,Effects:[{Id:33,Amplifier:" + potency + ",Duration:" + context.getArgument("duration", Integer.class) * 20 + "}]}}"));
            mc.interactionManager.clickCreativeStack(egg, 36 + mc.player.getInventory().selectedSlot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, bhr);
            mc.interactionManager.clickCreativeStack(bfr, 36 + mc.player.getInventory().selectedSlot);
            return SINGLE_SUCCESS;
        }))));
    }
}
