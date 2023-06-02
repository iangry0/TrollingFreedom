package me.iangry.trollingfreedom.commands;

import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class Aquaphobia implements Listener {

    public static ArrayList<String> Aqua1 = new ArrayList<>();

    public void Aqua(Player p) {
        Player p2 = p.getPlayer();
        Aqua1.add(p2.getName());
    }

    public void unAqua(Player p) {
        Player p2 = p.getPlayer();
        Aqua1.remove(p2.getName());
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Material m = e.getPlayer().getLocation().getBlock().getType();
        Player p = e.getPlayer();
        if (this.Aqua1.contains(p.getName())) {
            if (m == Material.WATER) {
                        // player is in water
                        p.setGameMode(GameMode.SURVIVAL);
                        p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 1, 5));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1, 1));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 1, 2));
                        p.getWorld().playEffect(p.getEyeLocation(), Effect.MOBSPAWNER_FLAMES, 2);

                    }
                }
            }
        }