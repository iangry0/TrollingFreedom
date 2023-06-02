package me.iangry.trollingfreedom.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class AFK implements Listener {


    public static void FakeAFK(Player p) {
        String p2 = p.getName();
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7* " + p2 + " is now AFK."));
    }

    public static void FakeUnAFK(Player p) {
        String p2 = p.getName();
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7* " + p2 + " is no longer AFK."));
    }
}
