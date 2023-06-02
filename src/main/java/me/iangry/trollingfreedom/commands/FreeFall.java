package me.iangry.trollingfreedom.commands;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.util.Vector;

public class FreeFall implements Listener {

    public static void FreeFall(Player p) {
        String p2 = p.getName();
        Location location = p.getLocation();
        location.setY(location.getBlockY() + 1000);
        p.teleport(location);

        p.getWorld().playSound(p.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 100.0F, 2.0F);
        p.getWorld().spawnParticle(Particle.BUBBLE_POP, p.getLocation(), 100);
    }
}
