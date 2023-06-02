package me.iangry.trollingfreedom.commands;

import me.iangry.trollingfreedom.main.Core;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RingOfFire implements Listener {
    public static ArrayList<String> nuke1 = new ArrayList();

    public void Nuke(Player p) {
        nuke1.add(p.getName());
        particle(p);
        extra(p);

        p.getLocation().getWorld().strikeLightning(p.getLocation());
    }

    public void UnNuke(Player p) {
        p.setFireTicks(0);
        p.setVisualFire(false);
        nuke1.remove(p.getName());
        Bukkit.getScheduler().cancelTasks(Core.instance);
    }

    private void extra(Player p) {
        p.setGameMode(GameMode.SURVIVAL);
        p.setFlying(false);
    }

    private void particle(Player p) {
                p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_BURN, 100, 1);
                p.getWorld().playSound(p.getLocation(), Sound.BLOCK_BELL_RESONATE, 100, 1);
                p.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, p.getLocation(), 1);
                p.getWorld().spawnParticle(Particle.FALLING_LAVA, p.getLocation(), 10);
        p.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, p.getLocation(), 10);
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player p = e.getEntity().getPlayer();
        if (nuke1.contains(p.getName())) {
            UnNuke(p);
        }
    }

    @EventHandler
    public void onWalk(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (nuke1.contains(p.getName())) {
          //  if(!(p.getLocation().add(p.getLocation().getX(),p.getLocation().getY(),p.getLocation().getZ()).getBlock().getType() == Material.AIR));
            if(!(p.getLocation().getBlock().getType() == Material.WATER)) {
            //surroundFlames(p.getLocation(), 3);
                createFlameRings(p);
        }
        }
    }
    private void createFlameRings( final Player p ) {
        new BukkitRunnable() {
            double alpha = 0;

            public void run() {
                // Each cycle alpha gets increase by pi / 16 which divides the whole circle into 32 sections
                alpha += Math.PI / 16;

                /*
                 * You can add to the location based on the coordinates of a point on the circumference on a circle
                 * The y location is meanwhile altering in a slightly shifted sine curve
                 */
                // You can add to the location based on the coordinates of a point on the circumference on a circle
                Location loc = p.getLocation();
                Location firstLocation = loc.clone().add( Math.cos( alpha ), Math.sin( alpha ) + 1, Math.sin( alpha ) );
                Location secondLocation = loc.clone().add( Math.cos( alpha + Math.PI ), Math.sin( alpha ) + 1, Math.sin( alpha + Math.PI ) );
                p.spawnParticle( Particle.FLAME, firstLocation, 0, 0, 0, 0, 0 );
                p.spawnParticle( Particle.FLAME, secondLocation, 0, 0, 0, 0, 0 );
                p.setFireTicks(1000);
            }
        }.runTaskTimer(  JavaPlugin.getPlugin( Core.class ), 0, 1 );
    }
}
