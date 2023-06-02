package me.iangry.trollingfreedom.commands;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

public class Lightning implements Listener {
    public static ArrayList<String> Lightning1 = new ArrayList();


    public void Lightning(Player p) {
        String p2 = p.getName();
        this.Lightning1.add(p.getName());
    }

    public void UnLightning(Player p) {
        String p2 = p.getName();
        this.Lightning1.remove(p.getName());
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player p = event.getPlayer();
        if (this.Lightning1.contains(p.getName())) {
            if (!event.getFrom().toVector().equals(event.getTo().toVector())) {
                World world = p.getWorld();
                world.strikeLightning(p.getLocation());

            }
        }
    }
}