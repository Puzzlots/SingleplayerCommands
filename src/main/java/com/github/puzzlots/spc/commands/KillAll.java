package com.github.puzzlots.spc.commands;

import finalforeach.cosmicreach.entities.player.PlayerEntity;
import finalforeach.cosmicreach.gamestates.InGame;

import javax.swing.text.html.parser.Entity;

public class KillAll {
    public static void run() {
        InGame.getLocalPlayer().getZone(InGame.world).allEntities.forEach(entity -> {
            if(entity instanceof PlayerEntity){

            }else
                InGame.getLocalPlayer().getZone(InGame.world).despawnEntity(entity);

        });
    }
}
