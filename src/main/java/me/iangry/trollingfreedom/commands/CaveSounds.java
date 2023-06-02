package me.iangry.trollingfreedom.commands;

import me.iangry.trollingfreedom.main.Core;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class CaveSounds implements Listener {


    public static void CaveSound(final Player p) {
        String p2 = p.getName();
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.instance, new Runnable() {
            public void run() {
                p.playSound(p.getLocation(), Sound.AMBIENT_CAVE, 100, 1);
            }
        }, 10L, 5L);
    }

    public static void GhastSound(final Player p) {
        String p2 = p.getName();
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.instance, new Runnable() {
            public void run() {
                p.playSound(p.getLocation(), Sound.ENTITY_GHAST_AMBIENT, 100, 1);
            }
        },  10L, 40L);
    }
}