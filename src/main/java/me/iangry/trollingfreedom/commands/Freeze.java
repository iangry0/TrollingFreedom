package me.iangry.trollingfreedom.commands;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

public class Freeze implements Listener {
    public static ArrayList<String> frozen = new ArrayList();


    public void Freeze(Player p) {
        Player p2 = p.getPlayer();
        //p2.setFlying(true);
        this.frozen.add(p2.getName());
    }
    public void Unfreeze(Player p) {
        Player p2 = p.getPlayer();
        //p2.setFlying(false);
        this.frozen.remove(p2.getName());
    }
        @EventHandler
        public void onPlayerMove (PlayerMoveEvent e){
            Player p = e.getPlayer();
            if (this.frozen.contains(p.getName())) {
                e.setTo(e.getFrom());
            }
        }

        @EventHandler
        public void onBlockBreak (BlockBreakEvent e){
            Player p = e.getPlayer();
            if (this.frozen.contains(p.getName())) {
                e.setCancelled(true);
            }
        }

        @EventHandler
        public void onBlockPlace (BlockPlaceEvent e){
            Player p = e.getPlayer();
            if (this.frozen.contains(p.getName())) {
                e.setCancelled(true);
            }
        }
    }