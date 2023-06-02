package me.iangry.trollingfreedom.commands;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

import java.util.ArrayList;

public class BedExplosion implements Listener {
    public static ArrayList<String> Explode1 = new ArrayList();


    public void BedExplosion(Player p) {
        String p2 = p.getName();
        this.Explode1.add(p.getName());
    }

    public void UnBedExplosion(Player p) {
        String p2 = p.getName();
        this.Explode1.remove(p.getName());
    }

    @EventHandler
    public void onSex(PlayerBedEnterEvent event) {
        Player p = event.getPlayer();
        if (this.Explode1.contains(p.getName())) {
            World w = p.getWorld();
            w.createExplosion(event.getBed().getLocation(), 3, true);
        }
    }
}