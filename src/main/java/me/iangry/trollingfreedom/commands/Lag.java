package me.iangry.trollingfreedom.commands;

import me.iangry.trollingfreedom.main.Core;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Lag implements Listener {



    public static void Lagg(final Player p) {
        String p2 = p.getName();
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.instance, new Runnable() {
            public void run() {
                Location loc1 = p.getLocation();
                p.teleport(loc1);
            }
        }, 8L, 5L);
    }
}