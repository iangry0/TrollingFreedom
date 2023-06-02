package me.iangry.trollingfreedom.commands;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;

public class Deafen implements Listener {
    public static ArrayList<String> Deaf1 = new ArrayList();


    public static void Deafen(Player p) {
        Deaf1.add(p.getName());
    }

    public static void UnDeafen(Player p) {
        String p2 = p.getName();
        Deaf1.remove(p.getName());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player p = event.getPlayer();
        if (Deaf1.contains(p.getName())) {
            event.setCancelled(true);
        }
    }
}