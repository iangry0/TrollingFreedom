package me.iangry.trollingfreedom.commands;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class DropAll implements Listener {



    public static void DropAll(Player p) {
        for (ItemStack i : p.getInventory().getContents()) {
            if (i != null) {
                p.getWorld().dropItemNaturally(p.getLocation(), i);
                p.getInventory().remove(i);
            }
        }
    }
    public static void UnDropAll(Player p) {
        String p2 = p.getName();
        p.setInvisible(false);
    }
}