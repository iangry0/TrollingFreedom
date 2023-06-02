package me.iangry.trollingfreedom.commands;

import me.iangry.trollingfreedom.main.Core;
import me.iangry.trollingfreedom.other.MathUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Random;

public class Snowman implements Listener {
 
    private ArrayList<org.bukkit.entity.Snowman> sheepArrayList = new ArrayList<>();

    public void Snowman(Player p) {
        String p2 = p.getName();
        org.bukkit.entity.Snowman s = p.getWorld().spawn(p.getLocation(), org.bukkit.entity.Snowman.class);

        s.setInvulnerable(true);
        s.setNoDamageTicks(20);
        s.setCustomName(ChatColor.RED + "Explosive Snowman");
        s.setCustomNameVisible(false);
       
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 10, 5);
                s.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, s.getLocation(), 1, 10, 1, 50);
            }
        }, 40L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 10, 50);
                s.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, s.getLocation(), 1, 10, 1, 50);
            }
        }, 80L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 10, 5);
                s.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, s.getLocation(), 1, 10, 1, 50);
            }
        }, 124L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 10, 50);
                s.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, s.getLocation(), 1, 10, 1, 50);
            }
        }, 144L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 10, 5);
                s.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, s.getLocation(), 1, 10, 1, 50);
            }
        }, 164L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 10, 50);
                s.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, s.getLocation(), 1, 10, 1, 50);
            }
        }, 184L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 10, 5);
                s.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, s.getLocation(), 1, 10, 1, 50);
            }
        }, 200L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 10, 50);
                s.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, s.getLocation(), 1, 10, 1, 50);
            }
        }, 216L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 10, 5);
                s.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, s.getLocation(), 1, 10, 1, 50);
            }
        }, 240L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 10, 5);
                s.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, s.getLocation(), 1, 10, 1, 50);
            }
        }, 256L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 10, 50);
                s.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, s.getLocation(), 1, 10, 1, 50);
            }
        }, 268L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 10, 5);
                s.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, s.getLocation(), 1, 10, 1, 50);
            }
        }, 280L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 10, 50);
                s.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, s.getLocation(), 1, 10, 1, 50);
            }
        }, 292L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 10, 5);
                s.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, s.getLocation(), 1, 10, 1, 50);
            }
        }, 304L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 10, 50);
                s.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, s.getLocation(), 1, 10, 1, 50);
            }
        }, 312L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 10, 5);
                s.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, s.getLocation(), 1, 10, 1, 50);
            }
        }, 320L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 10, 50);
                s.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, s.getLocation(), 1, 10, 1, 50);
            }
        }, 328L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 10, 5);
                s.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, s.getLocation(), 1, 10, 1, 50);
            }
        }, 336L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                s.remove();
                s.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, s.getLocation(), 2, 2, 2, 2);
                p.playSound(p.getLocation(), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 10, 1);
            }
        }, 338L);
        Bukkit.getScheduler().scheduleSyncDelayedTask((Core.instance), () -> {
            for (int x = 0; x < 250; x++) {
                s.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, s.getLocation(), 1, 10, 1, 50);
                org.bukkit.entity.Snowman snowman= p.getPlayer().getWorld().spawn(s.getLocation(), org.bukkit.entity.Snowman.class);
                Random r = new Random();
                MathUtils.applyVelocity(snowman, new Vector(r.nextDouble() - 0.5, r.nextDouble() / 2, r.nextDouble() - 0.5).multiply(2).add(new Vector(0, 0.8, 0)));
                snowman.setInvulnerable(true);
                snowman.setAware(true);
                snowman.setNoDamageTicks(120);
                sheepArrayList.add(snowman);
                //Data.get().getVersionManager().getEntityUtil().clearPathfinders(sheep);
                //Data.get().getVersionManager().getEntityUtil().makePanic(sheep);
                Bukkit.getScheduler().runTaskLater(Core.instance, () -> {
                    s.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, s.getLocation(), 1, 10, 1, 100);
                    p.getWorld().spawnParticle(Particle.FLAME, snowman.getLocation(), 5);
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 10);
                    snowman.remove();
                }, 110);
                sheepArrayList.remove(s);
                s.remove();
            }
        }, 352L);
    }
}
