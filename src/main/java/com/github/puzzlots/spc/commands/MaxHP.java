package com.github.puzzlots.spc.commands;

import finalforeach.cosmicreach.gamestates.InGame;

public class MaxHP {
    public static void run(float count) {

        InGame.getLocalPlayer().getEntity().maxHitpoints = count;

    }
}
