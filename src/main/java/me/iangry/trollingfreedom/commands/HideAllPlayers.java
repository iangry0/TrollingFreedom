package me.iangry.trollingfreedom.commands;

import me.iangry.trollingfreedom.main.Core;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;

public class HideAllPlayers implements Listener {
    public static ArrayList<String> hide1 = new ArrayList<>();

    public void HideAll(Player p) {
        hide1.add(p.getName());
        for (Player online : Bukkit.getOnlinePlayers()) {
            p.hidePlayer(Core.instance, online);
        }
    }
        public void UnHideAll (Player p){
            hide1.remove(p.getName());
            for (Player online : Bukkit.getOnlinePlayers()) {
                p.showPlayer(Core.instance, online);
            }
        }
    }