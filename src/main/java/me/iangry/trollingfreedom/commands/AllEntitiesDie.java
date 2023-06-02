package me.iangry.trollingfreedom.commands;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class AllEntitiesDie implements Listener {



    public static void EntityDie(Player p) {
        String p2 = p.getName();
        for (Entity entity : p.getNearbyEntities(10, 10, 10)) {
            if (entity instanceof Mob)
                entity.remove();
            entity.getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, entity.getLocation(), 1);
            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_DONKEY_DEATH, 5.0F, 1.2F);
            if (p.getNearbyEntities(10, 10, 10) == null) {
                return;
            }
        }
    }
}