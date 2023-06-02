package me.iangry.trollingfreedom.commands;

import me.iangry.trollingfreedom.main.Core;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class AnvilDrop implements Listener {



    public static void Anvil(final Player p) {
        String p2 = p.getName();
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.instance, new Runnable() {
            public void run() {
                Location loc1 = p.getLocation().add(p.getLocation().getDirection());
                Block block1 = p.getWorld().getBlockAt(loc1.add(0.0D, 20.0D, 0.0D)); //MIDDLE
                block1.setType(Material.DAMAGED_ANVIL);
            }
        },  40L, 10L);
    }

    public static void UnAnvil (Plugin plugin){
        Bukkit.getScheduler().cancelTasks(Core.instance);
    }
}
