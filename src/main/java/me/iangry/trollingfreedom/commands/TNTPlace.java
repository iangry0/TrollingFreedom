package me.iangry.trollingfreedom.commands;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.ArrayList;

public class TNTPlace implements Listener {

    public static ArrayList<String> Fireball1 = new ArrayList();

    public void TNTPlace(Player p) {
        Player p2 = p.getPlayer();
        this.Fireball1.add(p2.getName());
    }
    public void UnTNTPlace(Player p) {
        Player p2 = p.getPlayer();
        this.Fireball1.remove(p2.getName());
    }
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (this.Fireball1.contains(p.getName())) {
            p.getLocation().getWorld().spawnEntity(e.getBlock().getLocation(), EntityType.PRIMED_TNT);
            e.getBlockPlaced().breakNaturally();
        }
    }
}
