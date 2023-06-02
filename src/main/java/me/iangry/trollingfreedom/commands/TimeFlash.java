package me.iangry.trollingfreedom.commands;

import me.iangry.trollingfreedom.main.Core;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class TimeFlash implements Listener {
    public static ArrayList<String> flash1 = new ArrayList<>();

    public void SkyFlash(Player p) {
        flash1.add(p.getName());
        p.setPlayerTime(0, true);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.instance, () -> {
                p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 30, 100));
        }, 10L, 30L);
    }
    public void UnSkyFlash(Player p) {
        String p2 = p.getName();
        p.removePotionEffect((PotionEffectType.BLINDNESS));
        p.resetPlayerTime();
        flash1.remove(p.getName());
    }
}