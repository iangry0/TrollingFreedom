package me.iangry.trollingfreedom.commands;

import me.iangry.trollingfreedom.main.Core;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class Poop implements Listener {


    public static ArrayList<String> Poop1 = new ArrayList<>();

    public void Poop(final Player p) {
        String p2 = p.getName();
        Poop1.add(p.getName());

    }
    public void UnPoop(Player p) {
        if (Poop1.contains(p.getName())) {
            String p2 = p.getName();
            Poop1.remove(p.getName());
            Player player = p;
            player.getNearbyEntities(10.0D, 10.0D, 10.0D).stream().filter(entstream -> entstream instanceof Item).map(Item.class::cast).filter(item -> (item.getItemStack().getType() == Material.COCOA_BEANS)).forEach(Entity::remove);
        }
    }
    @EventHandler
    public void PlayerSneak(PlayerToggleSneakEvent e) {
        Player p = e.getPlayer();
        if (Poop1.contains(p.getName())) {

            String text = Poop1.toString();
            String result = text.replaceAll("\\[", "").replaceAll("\\]", "");
            Player victim = Bukkit.getServer().getPlayer(result);
            ItemStack item = new ItemStack(Material.COCOA_BEANS);;
            victim.getWorld().playSound(victim.getLocation(), Sound.ENTITY_FOX_AGGRO, 100.0F, 1.0F);
            Item dropped = p.getLocation().getWorld().dropItem(p.getEyeLocation().add(0, -1.3, 0), item);
            dropped.setVelocity(p.getEyeLocation().getDirection().normalize().multiply(-0.3D));
            }
        }
    @EventHandler
    public void PlayerItemPickup(PlayerPickupItemEvent e) {
        if (!Poop1.isEmpty()) {
            ItemStack item = e.getItem().getItemStack();
            if (item.getType() == Material.COCOA_BEANS) {
                e.setCancelled(true);
                e.getItem().remove();
            }
        }
    }
    @EventHandler
    public void InventoryItemPickup(InventoryPickupItemEvent e) {
        if (!Poop1.isEmpty()) {
            ItemStack item = e.getItem().getItemStack();

            if (item.getType() == Material.COCOA_BEANS) {
                e.setCancelled(true);
                e.getItem().remove();
            }
        }
    }
}