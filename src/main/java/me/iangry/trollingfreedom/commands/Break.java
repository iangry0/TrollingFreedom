package me.iangry.trollingfreedom.commands;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.ArrayList;

public class Break implements Listener {

    public static ArrayList<String> Break1 = new ArrayList();

    public void Break(Player p) {
        Player p2 = p.getPlayer();
        this.Break1.add(p2.getName());
    }
    public void unBreak(Player p) {
        Player p2 = p.getPlayer();
        this.Break1.remove(p2.getName());
    }
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (this.Break1.contains(p.getName())) {
            e.setCancelled(true);
        }
    }
        @EventHandler
        public void onBlockPlace(BlockPlaceEvent e) {
            Player p = e.getPlayer();
            if (this.Break1.contains(p.getName())) {
                e.setCancelled(true);
            }
        }
    }
