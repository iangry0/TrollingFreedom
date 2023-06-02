package me.iangry.trollingfreedom.commands;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.util.Vector;

public class Launch implements Listener {

    public static void Launch(Player p) {
        String p2 = p.getName();
        Vector direction = p.getLocation().getDirection().multiply(1); // should be enough
        direction.setY(direction.getY() + 150); // small boost up
         p.setVelocity(direction); // chuck 'em
    //    p.teleport(p.getLocation().add(0.0D, 100D, 0.0D));
    //    p.setVelocity(new Vector(p.getLocation().getDirection().getX(), p.getLocation().getDirection().getY() + 100.0D, p.getLocation().getDirection().getZ()));
        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PUFFER_FISH_BLOW_UP, 5.0F, 2.0F);
        p.getWorld().spawnParticle(Particle.CLOUD, p.getLocation(), 100);
    }
}
