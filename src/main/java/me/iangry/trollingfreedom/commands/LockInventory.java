package me.iangry.trollingfreedom.commands;

import me.iangry.trollingfreedom.main.Core;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class LockInventory implements Listener {


    public static void Lock(Player p) {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.instance, new Runnable() {
            public void run() {
                p.closeInventory();

                if (p.isSneaking()) {
                    Bukkit.getScheduler().cancelTasks((Plugin)Core.instance);
                }
                }
        }, 1L, 1L);
    }
}


