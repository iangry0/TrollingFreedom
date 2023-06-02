package me.iangry.trollingfreedom.commands;

import me.iangry.trollingfreedom.main.Core;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Annoy implements Listener {


    public static void Annoy(Player p) {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.instance, () -> {
            p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_AMBIENT, 100, 1);
            p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_CELEBRATE, 100, 1);
            p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
        }, 10L, 5L);
    }
}   