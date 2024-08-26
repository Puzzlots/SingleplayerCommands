package com.github.puzzlots.spc.commands;


import finalforeach.cosmicreach.gamestates.InGame;

public class Clear {
    public static void run() {
        InGame.getLocalPlayer().inventory.forEachSlot((slot) -> slot.itemStack = null);
    }
}
