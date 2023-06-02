package me.iangry.trollingfreedom.commands;

//https://www.dropbox.com/s/e1qd3gthrhfba7b/creeperawman.zip?dl=1

import me.iangry.trollingfreedom.main.Core;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

public class ExplodingChicken implements Listener {


    public static void Chicken(Player p) {
        Entity enderman = p.getWorld().spawnEntity(p.getEyeLocation().add(3, -1,0), EntityType.CHICKEN);
        LivingEntity livingenderman = (LivingEntity) enderman;
        Creature creatureenderman = (Creature) livingenderman;
        creatureenderman.setInvulnerable(true);
        creatureenderman.setAI(false);
        Location loc = creatureenderman.getLocation();
        Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
        FireworkMeta fwm = fw.getFireworkMeta();

        fwm.setPower(5);
        fwm.addEffect(FireworkEffect.builder().withColor(Color.LIME).flicker(false).build());

        fw.setFireworkMeta(fwm);
        fw.detonate();
        for (int x = 0; x < 50; x++) {
            Firework fw2 = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
            fw2.setFireworkMeta(fwm);
            p.getWorld().spawnParticle(Particle.SMOKE_NORMAL, loc, 5, 0, 0, 0);

        }
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.instance, () -> {
            p.getWorld().createExplosion(loc, 2);
            ItemStack chicken = new ItemStack(Material.CHICKEN);
            p.getWorld().dropItemNaturally(loc, chicken);
            creatureenderman.setHealth(0);
        }, 90L);
    }
}


