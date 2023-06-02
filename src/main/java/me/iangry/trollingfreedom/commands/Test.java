package me.iangry.trollingfreedom.commands;

import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class Test implements Listener {

    public static ArrayList<String> Fish1 = new ArrayList();

    public static void Test(Player p) {
        String p2 = p.getName();

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