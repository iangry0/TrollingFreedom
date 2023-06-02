package me.iangry.trollingfreedom.commands;

import me.iangry.trollingfreedom.main.Core;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.Random;

public class ChatChange implements Listener {
    public static ArrayList<String> Chat1 = new ArrayList();


    public void ChatChange(Player p) {
        String p2 = p.getName();
        this.Chat1.add(p.getName());
    }

    public void UnChatChange(Player p) {
        String p2 = p.getName();
        this.Chat1.remove(p.getName());
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player p = event.getPlayer();
        if (this.Chat1.contains(p.getName())) {
            ArrayList<String> messages = (ArrayList) Core.instance.getConfig().get("troll-config.randomchat");
            Random r = new Random();
            int randomitem = r.nextInt(messages.size());
            String message = (String)messages.get(randomitem);
            String replaced = message.replace("&", "§");
            event.setMessage(replaced);
        }
    }
}