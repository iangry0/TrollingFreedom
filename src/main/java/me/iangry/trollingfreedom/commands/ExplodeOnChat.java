package me.iangry.trollingfreedom.commands;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;

public class ExplodeOnChat implements Listener {

    public static ArrayList<String> Chat1 = new ArrayList();

    public static void Chat(final Player p) {
        String p2 = p.getName();
        Chat1.add(p.getName());
    }
    @EventHandler
    public void onChat(PlayerChatEvent e) {
        Player p = e.getPlayer();
        if (this.Chat1.contains(p.getName())) {
            World w = p.getWorld();
            w.createExplosion(p.getLocation(), 5, true);
        } else
            return;
            }
    public static void UnChat(Player p) {
        if (Chat1.contains(p.getName())) {
            Chat1.remove(p.getName());
        }
    }
}