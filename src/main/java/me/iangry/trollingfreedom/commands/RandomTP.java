package me.iangry.trollingfreedom.commands;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class RandomTP implements Listener {


    public static void RandomTP(Player p) {
        String p2 = p.getName();

        int xk = (int)(Math.random() * 1000 + 1);
        int yk = (int)(Math.random() * 1000 + 1);
        double y = 255;
        double x = xk;
        double z = yk;
        World w = p.getWorld();
        p.teleport(new Location(w, x, y, z));
        teleportToTop(p);
                }
    public static void teleportToTop(Player p){
        Location l = p.getLocation();
        Block b = p.getWorld().getHighestBlockAt(l.getBlockX(), l.getBlockZ());
        Location l2 = new Location(b.getLocation().getWorld(), b.getLocation().getBlockX(), b.getLocation().getBlockY() + 1, b.getLocation().getBlockZ());
        p.teleport(l2);
    }
}