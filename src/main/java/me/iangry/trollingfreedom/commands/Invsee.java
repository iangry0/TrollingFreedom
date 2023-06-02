package me.iangry.trollingfreedom.commands;

import me.iangry.trollingfreedom.main.Core;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public class Invsee implements Listener {


    public static void Invsee(Player p) {
        String p2 = p.getName();
        Inventory inv = p.getInventory();
        for(Player all : Core.instance.getServer().getOnlinePlayers()) {
            all.openInventory(inv);
            InventoryView view = p.getOpenInventory();
            if (view.getTopInventory().toString().contains("Player")) {
                view.close();
            }
        }

    }
}
