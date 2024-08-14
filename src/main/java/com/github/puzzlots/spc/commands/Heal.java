package com.github.puzzlots.spc.commands;

import finalforeach.cosmicreach.chat.Chat;
import finalforeach.cosmicreach.gamestates.InGame;
import finalforeach.cosmicreach.items.Item;
import finalforeach.cosmicreach.items.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

public class Heal {
    public static void run(int count) {

        float actualHeal = Math.min(
                count,
                InGame.getLocalPlayer().getEntity().maxHitpoints - InGame.getLocalPlayer().getEntity().hitpoints
        );
        InGame.getLocalPlayer().getEntity().hitpoints += actualHeal;

    }
}
