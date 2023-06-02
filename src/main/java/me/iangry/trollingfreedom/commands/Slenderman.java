package me.iangry.trollingfreedom.commands;

import me.iangry.trollingfreedom.main.Core;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class Slenderman implements Listener {

    public static ArrayList<String> Slender1 = new ArrayList<>();

    public void Enderman(Player p) {
        Slender1.add(p.getName());
        p.setGameMode(GameMode.SURVIVAL);
        Entity enderman = p.getWorld().spawnEntity(p.getLocation(), EntityType.ENDERMAN);
        LivingEntity livingenderman = (LivingEntity) enderman;
        Creature creatureenderman = (Creature) livingenderman;
        creatureenderman.setInvulnerable(true);
        creatureenderman.setTarget(p);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.instance, new Runnable() {
            public void run() {
                p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_AMBIENT, 50, 1);
                p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_SCREAM, 100, 1);
                p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 1));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 2));
            }
        }, 10L, 5L);
    }

    public void UnEnderman(Player p) {
        Player p2 = p.getPlayer();
        if (Slender1.contains(p.getName())) {
            Slender1.remove(p2.getName());
            p.removePotionEffect(PotionEffectType.BLINDNESS);
            p.removePotionEffect(PotionEffectType.SLOW);
            Bukkit.getScheduler().cancelTasks(Core.instance);
            for (Entity entity : p.getNearbyEntities(100, 100, 100)) {
                if (entity instanceof Enderman)
                    entity.remove();
            }
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
    Player p = e.getEntity();
        if (Slender1.contains(p.getName())) {
            UnEnderman(p);
        }
    }
}


