package me.iangry.trollingfreedom.commands;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;

public class ReverseMessage implements Listener {

    public static String reverseMessage(String i) {
        StringBuilder res = new StringBuilder();
        int length = i.length();

        for (int i1 = length - 1; i1 >= 0; i1--)
            res.append(i.charAt(i1));
        return res.toString();
    }

    public static ArrayList<String> Reverse1 = new ArrayList();

    public void Reverse(final Player p) {
        Reverse1.add(p.getName());
    }

    public void UnReverse(Player p) {
        if (Reverse1.contains(p.getName())) {
            Reverse1.remove(p.getName());
        }
    }
        @EventHandler
        public void onChat(AsyncPlayerChatEvent event) {
            Player p = event.getPlayer();
            if (Reverse1.contains(p.getName())) {

                String msg = reverseMessage(event.getMessage());
                event.setMessage(msg);
            }
        }
}


