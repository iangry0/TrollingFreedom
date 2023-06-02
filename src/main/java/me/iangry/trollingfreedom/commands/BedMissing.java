package me.iangry.trollingfreedom.commands;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class BedMissing implements Listener {

    public void BedMissing(Player player) {
       player.sendMessage("You have no home bed or charged respawn anchor, or it was obstructed");
    }
}