package me.iangry.trollingfreedom.commands;

import me.iangry.trollingfreedom.main.Core;
import me.iangry.trollingfreedom.other.MathUtils;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Random;

public class ExplosiveSheep implements Listener {
    private ArrayList<Sheep> sheepArrayList = new ArrayList<>();

    public void Sheep(Player p) {
        String p2 = p.getName();
        Sheep s = p.getWorld().spawn(p.getLocation(), Sheep.class);

        s.setInvulnerable(true);
        s.setNoDamageTicks(20);
        s.setCustomName(ChatColor.RED + "Explosive Sheep");
        s.setCustomNameVisible(false);
        s.setColor(DyeColor.RED);
        s.setSheared(false);
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                s.setColor(DyeColor.WHITE);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 10, 5);
            }
        }, 40L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                s.setColor(DyeColor.RED);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 10, 10);
            }
        }, 80L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                s.setColor(DyeColor.WHITE);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 10, 5);
            }
        }, 124L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                s.setColor(DyeColor.RED);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 10, 10);
            }
        }, 144L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                s.setColor(DyeColor.WHITE);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 10, 5);
            }
        }, 164L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                s.setColor(DyeColor.RED);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 10, 10);
            }
        }, 184L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                s.setColor(DyeColor.WHITE);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 10, 5);
            }
        }, 200L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                s.setColor(DyeColor.RED);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 10, 10);
            }
        }, 216L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                s.setColor(DyeColor.WHITE);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 10, 5);
            }
        }, 240L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                s.setColor(DyeColor.RED);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 10, 5);
            }
        }, 256L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                s.setColor(DyeColor.WHITE);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 10, 10);
            }
        }, 268L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                s.setColor(DyeColor.RED);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 10, 5);
            }
        }, 280L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                s.setColor(DyeColor.WHITE);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 10, 10);
            }
        }, 292L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                s.setColor(DyeColor.RED);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 10, 5);
            }
        }, 304L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                s.setColor(DyeColor.WHITE);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 10, 10);
            }
        }, 312L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                s.setColor(DyeColor.RED);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 10, 5);
            }
        }, 320L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                s.setColor(DyeColor.WHITE);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 10, 10);
            }
        }, 328L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                s.setColor(DyeColor.RED);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 10, 5);
            }
        }, 336L);
        scheduler.scheduleSyncDelayedTask((Core.instance), new Runnable() {
            public void run() {
                s.remove();
                s.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, s.getLocation(), 2, 2, 2, 2);
                p.playSound(p.getLocation(), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 10, 1);
            }
        }, 338L);
        Bukkit.getScheduler().scheduleSyncDelayedTask((Core.instance), () -> {
            for (int x = 0; x < 150; x++) {
                final Sheep sheep = p.getPlayer().getWorld().spawn(s.getLocation(), Sheep.class);

                try {
                    sheep.setColor(DyeColor.values()[MathUtils.randomRangeInt(0, 15)]);
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
                Random r = new Random();
                MathUtils.applyVelocity(sheep, new Vector(r.nextDouble() - 0.5, r.nextDouble() / 2, r.nextDouble() - 0.5).multiply(2).add(new Vector(0, 0.8, 0)));
                sheep.setBaby();
                sheep.setInvulnerable(true);
                sheep.setAgeLock(true);
                sheep.setAware(true);
                sheep.setNoDamageTicks(120);
                sheepArrayList.add(sheep);
                p.playSound(p.getLocation(), Sound.ENTITY_SHEEP_AMBIENT, 100, 1);
                //Data.get().getVersionManager().getEntityUtil().clearPathfinders(sheep);
                //Data.get().getVersionManager().getEntityUtil().makePanic(sheep);
                Bukkit.getScheduler().runTaskLater(Core.instance, () -> {
                    p.getWorld().spawnParticle(Particle.LAVA, sheep.getLocation(), 5);
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 10);
                    sheep.remove();
                }, 110);
                sheepArrayList.remove(s);
                s.remove();
            }
        }, 342L);
    }
}
