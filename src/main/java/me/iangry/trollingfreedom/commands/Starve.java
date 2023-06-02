package me.iangry.trollingfreedom.commands;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class Starve implements Listener {
    public static ArrayList<String> starve1 = new ArrayList<>();

    public void Starve(Player p) {
        String p2 = p.getName();
                starve1.add(p.getName());
                p.setGameMode(GameMode.SURVIVAL);
                p.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 200000, 50));
            }

    public void UnStarve(Player p) {
        String p2 = p.getName();
        p.removePotionEffect(PotionEffectType.HUNGER);
        p.setFoodLevel(20);
        starve1.remove(p.getName());
    }
}