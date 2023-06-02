package me.iangry.trollingfreedom.commands;

import org.bukkit.GameMode;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class Silverfish implements Listener {

    public static ArrayList<String> Fish1 = new ArrayList();

    public static void Fish(Player p) {
        String p2 = p.getName();
        Fish1.add(p.getName());
        p.setGameMode(GameMode.SURVIVAL);
        p.setFlying(false);
        for (int x = 0; x < 50; x++) {
            Entity silverfish = p.getWorld().spawnEntity(p.getLocation(), EntityType.SILVERFISH);
            LivingEntity livingSilverfish = (LivingEntity) silverfish;
            Creature creatureSilverfish = (Creature) livingSilverfish;
            creatureSilverfish.setInvulnerable(true);
            creatureSilverfish.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 1000000000, 5, false, false), true);
            creatureSilverfish.setTarget(p);
        }
    }

    public void UnFish(Player p) {
        String p2 = p.getName();
        if (Fish1.contains(p.getName())) {
            Fish1.remove(p.getName());
            for (Entity entity : p.getNearbyEntities(100, 100, 100)) {
                if (entity instanceof org.bukkit.entity.Silverfish)
                    entity.remove();
                else {
                    return;
                }
            }
        }
    }
}