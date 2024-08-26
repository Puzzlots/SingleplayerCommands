package com.github.puzzlots.spc.commands;

import finalforeach.cosmicreach.gamestates.InGame;


public class Heal {
    public static void run(int count) {

        float actualHeal = Math.min(
                count,
                InGame.getLocalPlayer().getEntity().maxHitpoints - InGame.getLocalPlayer().getEntity().hitpoints
        );
        InGame.getLocalPlayer().getEntity().hitpoints += actualHeal;

    }
}
