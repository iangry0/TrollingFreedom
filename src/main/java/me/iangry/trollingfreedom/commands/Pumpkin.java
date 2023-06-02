package me.iangry.trollingfreedom.commands;

import me.iangry.trollingfreedom.main.Core;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class Pumpkin implements Listener {
  

    public static ArrayList<String> Pumpkin1 = new ArrayList<>();

    public void Pumpkin(Player p) {
        Player p2 = p.getPlayer();
        ItemStack helmet = p.getInventory().getHelmet();
        if (helmet != null) {
            p.getWorld().dropItem(p.getLocation(), helmet);
            Pumpkin1.add(p2.getName());
            Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin) Core.instance, () -> {
                ItemStack stack = new ItemStack(Material.CARVED_PUMPKIN);
                p.getInventory().setHelmet(stack);
            }, 10L, 5L);
        } else {

            Pumpkin1.add(p2.getName());
            Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin) Core.instance, () -> {
                ItemStack stack = new ItemStack(Material.CARVED_PUMPKIN);
                p.getInventory().setHelmet(stack);
            }, 10L, 5L);
        }
    }

    public void unPumpkin(Player p) {
        Player p2 = p.getPlayer();
        if (this.Pumpkin1.contains(p.getName())) {
            Pumpkin1.remove(p2.getName());
            Bukkit.getScheduler().cancelTasks((Plugin) Core.instance);
            if (p.getInventory().getHelmet() == null) {
                return;
            }
            if (p.getInventory().getHelmet().equals(new ItemStack(Material.CARVED_PUMPKIN))) {
                ItemStack stack = new ItemStack(Material.AIR);
                p.getInventory().setHelmet(stack);
            }
        }
    }
        @EventHandler
        public void onPumpkinMove(InventoryClickEvent event) {
            Player player = (Player) event.getWhoClicked();
            if (this.Pumpkin1.contains(player.getName())) {
                    ItemStack clicked = event.getCurrentItem();
                    if( clicked.getType().equals(Material.CARVED_PUMPKIN)) {
                        event.setCancelled(true);
                    }
                    else {
                        return;
                    }

                }
            }
        }

