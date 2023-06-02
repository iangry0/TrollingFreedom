package me.iangry.trollingfreedom.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;

import java.util.ArrayList;

public class InventoryStop implements CommandExecutor, Listener {

    public static ArrayList<String> InvStop1 = new ArrayList();

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (commandLabel.equalsIgnoreCase("unchesttroll")) {
            Player p = (Player) sender;
            UnInventoryStop(p);
        }
        return false;
    }
    public void InventoryStop(Player p) {
        Player p2 = p.getPlayer();
        this.InvStop1.add(p2.getName());
    }

    public void UnInventoryStop(Player p) {
        Player p2 = p.getPlayer();
        this.InvStop1.remove(p2.getName());
    }

    @EventHandler
    public void onInvOpen(InventoryOpenEvent e) {
        Player p = (Player) e.getPlayer();
        if (this.InvStop1.contains(p.getName())) {
            e.setCancelled(true);
        }
    }
}