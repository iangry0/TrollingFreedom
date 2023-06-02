package me.iangry.trollingfreedom.commands;

import me.iangry.trollingfreedom.main.Core;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Objects;

public class RainItems implements Listener {
    public static ArrayList<String> Rain1 = new ArrayList<>();

    public void RainItem(Player p) {
        Rain1.add(p.getName());
        Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin) Core.instance, new Runnable() {
            public void run() {
                for (Player online : Bukkit.getOnlinePlayers()) {
                    ItemStack item = new ItemStack(Material.matchMaterial((String) Core.instance.getConfig().get("troll-config.rain-item-material")));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(0, 5, 0), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(1, 5, 0), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(2, 5, 0), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(3, 5, 0), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(4, 5, 0), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(5, 5, 0), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(0, 5, 1), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(0, 5, 2), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(0, 5, 3), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(0, 5, 4), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(0, 5, 5), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(1, 5, 1), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(2, 5, 2), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(3, 5, 3), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(4, 5, 4), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(5, 5, 5), item));
                    online.getInventory().remove(item);

                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(0, 5, 0), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(-1, 5, 0), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(-2, 5, 0), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(-3, 5, 0), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(-4, 5, 0), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(-5, 5, 0), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(0, 5, 1), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(0, 5, 2), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(0, 5, 3), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(0, 5, 4), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(0, 5, 5), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(-1, 5, 1), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(-2, 5, 2), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(-3, 5, 3), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(-4, 5, 4), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(-5, 5, 5), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(0, 5, 0), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(1, 5, 0), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(2, 5, 0), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(3, 5, 0), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(4, 5, 0), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(5, 5, 0), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(0, 5, -1), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(0, 5, -2), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(0, 5, -3), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(0, 5, -4), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(0, 5, -5), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(1, 5, -1), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(2, 5, -2), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(3, 5, -3), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(4, 5, -4), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(5, 5, -5), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(0, 5, 0), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(-1, 5, 0), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(-2, 5, 0), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(-3, 5, 0), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(-4, 5, 0), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(-5, 5, 0), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(0, 5, -1), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(0, 5, -2), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(0, 5, -3), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(0, 5, -4), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(0, 5, -5), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(-1, 5, -1), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(-2, 5, -2), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(-3, 5, -3), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(-4, 5, -4), item));
                    online.getInventory().remove(item);
                    p.setPassenger(p.getLocation().getWorld().dropItem(p.getEyeLocation().add(-5, 5, -5), item));
                    online.getInventory().remove(item);


                }
            }
        }, 5L, 5L);
    }

    public void UnRainItem(Player p) {
        if (Rain1.contains(p.getName())) {
            Rain1.remove(p.getName());
            p.getNearbyEntities(20.0D, 20.0D, 20.0D).stream().filter(entstream -> entstream instanceof Item).map(Item.class::cast).filter(item -> (item.getItemStack().getType() == Material.matchMaterial((String) Core.instance.getConfig().get("troll-config.rain-item-material")))).forEach(Entity::remove);
        }
    }

    @EventHandler
    public void onPickUp(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();
        if (!Rain1.isEmpty()) {
            ItemStack item = e.getItem().getItemStack();
            if (item.getType() == Material.matchMaterial((String) Core.instance.getConfig().get("troll-config.rain-item-material"))) {
                e.setCancelled(true);
                e.getItem().remove();
            }
        }
    }
}