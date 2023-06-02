package me.iangry.trollingfreedom.commands;

import me.iangry.trollingfreedom.main.Core;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class TNT implements Listener {


    public static void FakeNuke(Player p) {
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "gamerule sendCommandFeedback false");
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&5May death rain upon them."));
        p.playSound(p.getLocation(), Sound.ENTITY_TNT_PRIMED, 100, 1);
        p.getLocation().getWorld().spawnEntity(p.getLocation().add(0.0D, 4.0D, 0.0D), EntityType.PRIMED_TNT);
        p.getLocation().getWorld().spawnEntity(p.getLocation().add(1.0D, 4.0D, 0.0D), EntityType.PRIMED_TNT);
        p.getLocation().getWorld().spawnEntity(p.getLocation().add(2.0D, 4.0D, 0.0D), EntityType.PRIMED_TNT);
        p.getLocation().getWorld().spawnEntity(p.getLocation().add(3.0D, 4.0D, 0.0D), EntityType.PRIMED_TNT);
        p.getLocation().getWorld().spawnEntity(p.getLocation().add(4.0D, 4.0D, 0.0D), EntityType.PRIMED_TNT);
        p.getLocation().getWorld().spawnEntity(p.getLocation().add(0.0D, 4.0D, 1.0D), EntityType.PRIMED_TNT);
        p.getLocation().getWorld().spawnEntity(p.getLocation().add(0.0D, 4.0D, 2.0D), EntityType.PRIMED_TNT);
        p.getLocation().getWorld().spawnEntity(p.getLocation().add(0.0D, 4.0D, 3.0D), EntityType.PRIMED_TNT);
        p.getLocation().getWorld().spawnEntity(p.getLocation().add(0.0D, 4.0D, 4.0D), EntityType.PRIMED_TNT);
        p.getLocation().getWorld().spawnEntity(p.getLocation().add(1.0D, 4.0D, 1.0D), EntityType.PRIMED_TNT);
        p.getLocation().getWorld().spawnEntity(p.getLocation().add(2.0D, 4.0D, 2.0D), EntityType.PRIMED_TNT);
        p.getLocation().getWorld().spawnEntity(p.getLocation().add(3.0D, 4.0D, 3.0D), EntityType.PRIMED_TNT);
        p.getLocation().getWorld().spawnEntity(p.getLocation().add(4.0D, 4.0D, 4.0D), EntityType.PRIMED_TNT);
        Bukkit.getLogger().setFilter(record -> !record.getMessage().toLowerCase().startsWith("/minecraft:kill"));
        Bukkit.getLogger().setFilter(record -> !record.getMessage().toLowerCase().startsWith(ChatColor.stripColor("Killed Primed TNT")));
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.instance, new Runnable() {
            public void run() {
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "minecraft:kill @e[type=tnt]");
            }
        }, 60L); //20 = 1 second | 20*30 = 600 (The "L" also needs to be here)
    }

    public void Nuke(Player p) {
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&5May death rain upon them."));
        for (int x = 0; x < 20; x++) {
            p.playSound(p.getLocation(), Sound.ENTITY_TNT_PRIMED, 100, 1);
            p.getLocation().getWorld().spawnEntity(p.getLocation().add(0.0D, 5.0D, 0.0D), EntityType.PRIMED_TNT);
            p.getLocation().getWorld().spawnEntity(p.getLocation().add(1.0D, 5.0D, 0.0D), EntityType.PRIMED_TNT);
            p.getLocation().getWorld().spawnEntity(p.getLocation().add(2.0D, 5.0D, 0.0D), EntityType.PRIMED_TNT);
            p.getLocation().getWorld().spawnEntity(p.getLocation().add(3.0D, 5.0D, 0.0D), EntityType.PRIMED_TNT);
            p.getLocation().getWorld().spawnEntity(p.getLocation().add(5.0D, 5.0D, 0.0D), EntityType.PRIMED_TNT);
            p.getLocation().getWorld().spawnEntity(p.getLocation().add(0.0D, 5.0D, 1.0D), EntityType.PRIMED_TNT);
            p.getLocation().getWorld().spawnEntity(p.getLocation().add(0.0D, 5.0D, 2.0D), EntityType.PRIMED_TNT);
            p.getLocation().getWorld().spawnEntity(p.getLocation().add(0.0D, 5.0D, 3.0D), EntityType.PRIMED_TNT);
            p.getLocation().getWorld().spawnEntity(p.getLocation().add(0.0D, 5.0D, 4.0D), EntityType.PRIMED_TNT);
            p.getLocation().getWorld().spawnEntity(p.getLocation().add(0.0D, 5.0D, 5.0D), EntityType.PRIMED_TNT);
            p.getLocation().getWorld().spawnEntity(p.getLocation().add(0.0D, 5.0D, 0.0D), EntityType.PRIMED_TNT);
            p.getLocation().getWorld().spawnEntity(p.getLocation().add(1.0D, 5.0D, 1.0D), EntityType.PRIMED_TNT);
            p.getLocation().getWorld().spawnEntity(p.getLocation().add(2.0D, 5.0D, 2.0D), EntityType.PRIMED_TNT);
            p.getLocation().getWorld().spawnEntity(p.getLocation().add(3.0D, 5.0D, 3.0D), EntityType.PRIMED_TNT);
            p.getLocation().getWorld().spawnEntity(p.getLocation().add(4.0D, 5.0D, 4.0D), EntityType.PRIMED_TNT);
            p.getLocation().getWorld().spawnEntity(p.getLocation().add(5.0D, 5.0D, 5.0D), EntityType.PRIMED_TNT);
        }
    }
}

