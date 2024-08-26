package com.github.puzzlots.spc.commands;

import finalforeach.cosmicreach.chat.Chat;
import finalforeach.cosmicreach.gamestates.InGame;
import finalforeach.cosmicreach.items.Item;
import finalforeach.cosmicreach.items.ItemStack;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

public class Give {

    static final Pattern f = Pattern.compile("\\[[^]]*]", Pattern.CASE_INSENSITIVE);
    public static void run(String itemName,int count) {
        Item item;

        if (Pattern.matches(f.pattern(), itemName)) {
            item = Item.getItem(itemName);
        }
        else  {
            item = Item.getItem(itemName+"[default]");
            // check if it's a non block item.
            if(item==null)
                item = Item.getItem(itemName);
        }
        if(item==null) {
            Chat.MAIN_CHAT.sendMessage(InGame.world, InGame.getLocalPlayer(), null, "Invalid item");
            return;
        }


        var itemStack = new ItemStack(item,count);
        InGame.getLocalPlayer().inventory.addItemStack(itemStack);
    }
}
