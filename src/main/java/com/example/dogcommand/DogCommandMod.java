package com.example.dogcommand;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public final class DogCommandMod implements ModInitializer {
    private static final int DEFAULT_AMOUNT = 1;
    private static final int MAX_AMOUNT = 100;

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) ->
                dispatcher.register(CommandManager.literal("dog")
                        .executes(context -> spawnDogs(context.getSource(), DEFAULT_AMOUNT))
                        .then(CommandManager.argument("amount", IntegerArgumentType.integer(1, MAX_AMOUNT))
                                .executes(context -> spawnDogs(
                                        context.getSource(),
                                        IntegerArgumentType.getInteger(context, "amount"))))));
    }

    private static int spawnDogs(ServerCommandSource source, int amount) {
        ServerPlayerEntity player = source.getPlayer();
        if (player == null) {
            source.sendError(Text.literal("Only a player can use /dog."));
            return 0;
        }

        for (int index = 0; index < amount; index++) {
            WolfEntity dog = EntityType.WOLF.create(player.getServerWorld());
            if (dog == null) {
                source.sendError(Text.literal("The dog could not be created."));
                return 0;
            }

            double angle = index * Math.PI * 2.0 / Math.max(amount, 1);
            dog.setPosition(player.getX() + Math.cos(angle) * 1.5, player.getY(),
                    player.getZ() + Math.sin(angle) * 1.5);
            dog.setOwner(player);
            dog.setTamed(true, true);
            dog.setSitting(true);
            player.getServerWorld().spawnEntity(dog);
        }

        source.sendFeedback(() -> Text.literal("Spawned " + amount + (amount == 1 ? " tamed dog." : " tamed dogs.")), true);
        return amount;
    }
}
