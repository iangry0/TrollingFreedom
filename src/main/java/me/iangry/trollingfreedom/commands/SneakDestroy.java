package me.iangry.trollingfreedom.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import java.util.ArrayList;

public class SneakDestroy implements Listener {

    public static ArrayList<String> Sneak1 = new ArrayList();


    public void SneakDestroy(Player p) {
        String p2 = p.getName();
        this.Sneak1.add(p.getName());
    }

    public void UnSneakDestroy(Player p) {
        String p2 = p.getName();
        this.Sneak1.remove(p.getName());
        this.Sneak1.remove(p.getName());
        this.Sneak1.remove(p.getName());
    }

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent event) {
        Player p = event.getPlayer();
        if (this.Sneak1.contains(p.getName())) {
            Location loc = p.getLocation().clone().add(0.0D, -1.0D, 0.0D);
            loc.getBlock().setType(Material.AIR);
        }
    }
}