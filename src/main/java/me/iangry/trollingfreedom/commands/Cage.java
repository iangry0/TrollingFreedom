package me.iangry.trollingfreedom.commands;

import me.iangry.trollingfreedom.main.Core;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

public class Cage implements Listener {

    public static ArrayList<String> Cage1 = new ArrayList();


    public void Cage(Player p) {
        String p2 = p.getName();
        this.Cage1.add(p.getName());
        if (this.Cage1.contains(p.getName()))
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.instance, new Runnable() {
            public void run() {
                buildIronCageAround(p, 3, 2, true);
            }
        }, 5L, 5L);
}

    public void UnCage(Player p) {
        String p2 = p.getName();
        this.Cage1.remove(p.getName());
    }
    @EventHandler
    public void onPlayerMove (PlayerMoveEvent e){
        Player p = e.getPlayer();
        if (this.Cage1.contains(p.getName())) {
            if (!e.getFrom().toVector().equals(e.getTo().toVector()))
                e.setCancelled(true);
        }
    }

    public void buildIronCageAround(Entity ent, int sideLength, int height, boolean wantRoof) {
        Material fence = Material.GLASS;
        Material roof = Material.GLASS;
        Location entLoc = ent.getLocation();

        // Let's make sure our preconditions were met.
        if (sideLength < 3 || sideLength % 2 == 0) {
            throw new IllegalArgumentException("You must enter an odd number greater than 3 for the side length");
        } else if (height == 0) {
            throw new IllegalArgumentException("Height must be greater than 0.");
        }

        int delta = (sideLength / 2);
        Location corner1 = new Location(entLoc.getWorld(), entLoc.getBlockX() + delta, entLoc.getBlockY() + 1, entLoc.getBlockZ() - delta);
        Location corner2 = new Location(entLoc.getWorld(), entLoc.getBlockX() - delta, entLoc.getBlockY() + 1, entLoc.getBlockZ() + delta);
        int minX = Math.min(corner1.getBlockX(), corner2.getBlockX());
        int maxX = Math.max(corner1.getBlockX(), corner2.getBlockX());
        int minZ = Math.min(corner1.getBlockZ(), corner2.getBlockZ());
        int maxZ = Math.max(corner1.getBlockZ(), corner2.getBlockZ());

        for (int x = minX; x <= maxX; x++) {
            for (int y = 0; y < height; y++) {
                for (int z = minZ; z <= maxZ; z++) {
                    if ((x == minX || x == maxX) || (z == minZ || z == maxZ)) {
                        Block b = corner1.getWorld().getBlockAt(x, entLoc.getBlockY() + y, z);
                        b.setType(fence);
                    }

                    if (y == height - 1 && wantRoof) {
                        Block b = corner1.getWorld().getBlockAt(x, entLoc.getBlockY() + y + 1, z);
                        b.setType(roof);
                    }
                }
            }
        }
    }
}