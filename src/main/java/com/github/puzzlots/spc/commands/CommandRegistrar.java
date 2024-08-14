package com.github.puzzlots.spc.commands;

import com.github.puzzle.game.commands.CommandManager;
import com.github.puzzle.game.commands.PuzzleCommandSource;
import com.github.puzzle.game.util.BlockUtil;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import finalforeach.cosmicreach.blocks.BlockState;
import finalforeach.cosmicreach.gamestates.InGame;

public class CommandRegistrar {

    public static void register() {
        LiteralArgumentBuilder<PuzzleCommandSource> setblock = CommandManager.literal("setblock");
        setblock.then(CommandManager.argument("x", IntegerArgumentType.integer())
                .then(CommandManager.argument("y", IntegerArgumentType.integer())
                        .then(CommandManager.argument("z", IntegerArgumentType.integer())
                                .then(CommandManager.argument("blockstate", StringArgumentType.greedyString())
                                        .executes(context -> {
                                            int x = IntegerArgumentType.getInteger(context, "x");
                                            int y = IntegerArgumentType.getInteger(context, "y");
                                            int z = IntegerArgumentType.getInteger(context, "z");
                                            String blockState = StringArgumentType.getString(context, "blockstate");

                                            BlockUtil.setBlockAt(InGame.getLocalPlayer().getZone(InGame.world), BlockState.getInstance(blockState), x, y, z);
                                            return 0;
                                        })
                                )
                        )
                )
        );



        LiteralArgumentBuilder<PuzzleCommandSource> give = CommandManager.literal("give");

        give.then(CommandManager.argument("item",StringArgumentType.string())
                .executes(context -> {
                    Give.run(StringArgumentType.getString(context,"item"),1);
                    return 0;
                })
                .then(CommandManager.argument("count",IntegerArgumentType.integer(1,1000)).executes(context -> {
                    Give.run(StringArgumentType.getString(context,"item"),IntegerArgumentType.getInteger(context,"count"));
                    return 0;
                })));
        LiteralArgumentBuilder<PuzzleCommandSource> heal = CommandManager.literal("heal");

        heal.executes(context -> {
            Heal.run(10);
            return 0;
        }).then(CommandManager.argument("count",IntegerArgumentType.integer(-1000,1000)).executes(context -> {
            Heal.run(IntegerArgumentType.getInteger(context,"count"));
            return 0;
        }));
        CommandManager.dispatcher.register(setblock);
        CommandManager.dispatcher.register(give);
        CommandManager.dispatcher.register(heal);
    }

}
