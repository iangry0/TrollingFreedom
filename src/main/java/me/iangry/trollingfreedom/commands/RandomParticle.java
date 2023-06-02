package me.iangry.trollingfreedom.commands;

import me.iangry.trollingfreedom.main.Core;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;
import java.util.Random;

public class RandomParticle implements Listener {

    public static ArrayList<String> RandomParticle1 = new ArrayList<>();

    public void RandomParticle(Player p) {
        Player p2 = p.getPlayer();
        RandomParticle1.add(p2.getName());
    }

    public void UnRandomParticle(Player p) {
        Player p2 = p.getPlayer();
        RandomParticle1.remove(p2.getName());
    }

    @EventHandler
    public void onWalk(PlayerMoveEvent e) {
        Player p = (Player) e.getPlayer();
        if (this.RandomParticle1.contains(p.getName())) {
            // player is in water
            Random rnd = new Random();
            int rand = rnd.nextInt(11);
            if(rand == 0){
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.instance, () -> {
                    p.getWorld().spawnParticle(Particle.CLOUD, p.getLocation(), 10);
                }, 100L);

            } else if(rand == 1){
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.instance, () -> {
                    p.getWorld().spawnParticle(Particle.LAVA, p.getLocation(), 10);
                }, 100L);

            } else if(rand == 3){
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.instance, () -> {
                    p.getWorld().spawnParticle(Particle.SMOKE_NORMAL, p.getLocation(), 10);
                }, 100L);

            } else if(rand == 4) {
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.instance, () -> {
                    p.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, p.getLocation(), 10);
                }, 100L);

            } else if(rand == 5) {
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.instance, () -> {
                    p.getWorld().spawnParticle(Particle.PORTAL, p.getLocation(), 10);
                }, 100L);

            } else if(rand == 6) {
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.instance, () -> {
                    p.getWorld().spawnParticle(Particle.BUBBLE_POP, p.getLocation(), 10);
                }, 100L);

            } else if(rand == 7) {
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.instance, () -> {
                    p.getWorld().spawnParticle(Particle.CRIT, p.getLocation(), 10);
                }, 100L);

            } else if(rand == 8) {
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.instance, () -> {
                    p.getWorld().spawnParticle(Particle.DOLPHIN, p.getLocation(), 10);
                }, 100L);

            } else if(rand == 9) {
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.instance, () -> {
                    p.getWorld().spawnParticle(Particle.ENCHANTMENT_TABLE, p.getLocation(), 10);
                }, 100L);

            } else if(rand == 10) {
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.instance, () -> {
                    p.getWorld().spawnParticle(Particle.HEART, p.getLocation(), 10);
                }, 100L);

            } else if(rand == 11) {
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.instance, () -> {
                    p.getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, p.getLocation(), 10);
                }, 100L);
            }
        }
    }
}
