package me.iangry.trollingfreedom.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class FakeCrash implements Listener {


    public static void FakeCrash(Player p) {
        String p2 = p.getName();
        p.kickPlayer(ChatColor.translateAlternateColorCodes('&', "Internal exception: java.net.SocketException: Connection reset."));
    }
    public static void FakeClosed(Player p) {
        String p2 = p.getName();
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&o[Server: Server Stopping]"));
    }
    public static void FakeBan(Player p) {
        String p2 = p.getName();
        p.kickPlayer(ChatColor.translateAlternateColorCodes('&', "You have been banned from this server!"));
    }
    public static void Burn(Player p) {
        String p2 = p.getName();
        p.setFireTicks(1000000000);
    }
}