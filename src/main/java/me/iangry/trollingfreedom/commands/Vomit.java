package me.iangry.trollingfreedom.commands;

import me.iangry.trollingfreedom.main.Core;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class Vomit implements Listener {


    public static ArrayList<String> Vomit1 = new ArrayList<>();

    public void Vomit(final Player p) {
        String p2 = p.getName();
        Vomit1.add(p.getName());
        Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin) Core.instance, new Runnable() {
            public void run() {
                ItemStack item = new ItemStack(Material.WHITE_WOOL);
                ItemStack item2 = new ItemStack(Material.LIGHT_GRAY_WOOL);
                ItemStack item3 = new ItemStack(Material.GRAY_WOOL);
                ItemStack item4 = new ItemStack(Material.BLACK_WOOL);
                ItemStack item5 = new ItemStack(Material.BROWN_WOOL);
                ItemStack item6 = new ItemStack(Material.RED_WOOL);
                ItemStack item7 = new ItemStack(Material.ORANGE_WOOL);
                ItemStack item8 = new ItemStack(Material.YELLOW_WOOL);
                ItemStack item9 = new ItemStack(Material.LIME_WOOL);
                ItemStack item10 = new ItemStack(Material.GREEN_WOOL);
                ItemStack item11 = new ItemStack(Material.CYAN_WOOL);
                ItemStack item12 = new ItemStack(Material.LIGHT_BLUE_WOOL);
                ItemStack item13 = new ItemStack(Material.BLUE_WOOL);
                ItemStack item14 = new ItemStack(Material.PURPLE_WOOL);
                ItemStack item15 = new ItemStack(Material.MAGENTA_WOOL);
                ItemStack item16 = new ItemStack(Material.PINK_WOOL);
                Item dropped = p.getLocation().getWorld().dropItem(p.getEyeLocation(), item);
                dropped.setVelocity(p.getEyeLocation().getDirection().normalize().multiply(0.3D));
                Item dropped2 = p.getLocation().getWorld().dropItem(p.getEyeLocation(), item2);
                dropped2.setVelocity(p.getEyeLocation().getDirection().normalize().multiply(0.3D));
                Item dropped3 = p.getLocation().getWorld().dropItem(p.getEyeLocation(), item3);
                dropped3.setVelocity(p.getEyeLocation().getDirection().normalize().multiply(0.3D));
                Item dropped4 = p.getLocation().getWorld().dropItem(p.getEyeLocation(), item4);
                dropped4.setVelocity(p.getEyeLocation().getDirection().normalize().multiply(0.3D));
                Item dropped5 = p.getLocation().getWorld().dropItem(p.getEyeLocation(), item5);
                dropped5.setVelocity(p.getEyeLocation().getDirection().normalize().multiply(0.3D));
                Item dropped6 = p.getLocation().getWorld().dropItem(p.getEyeLocation(), item6);
                dropped6.setVelocity(p.getEyeLocation().getDirection().normalize().multiply(0.3D));
                Item dropped7 = p.getLocation().getWorld().dropItem(p.getEyeLocation(), item7);
                dropped7.setVelocity(p.getEyeLocation().getDirection().normalize().multiply(0.3D));
                Item dropped8 = p.getLocation().getWorld().dropItem(p.getEyeLocation(), item8);
                dropped8.setVelocity(p.getEyeLocation().getDirection().normalize().multiply(0.3D));
                Item dropped9 = p.getLocation().getWorld().dropItem(p.getEyeLocation(), item9);
                dropped9.setVelocity(p.getEyeLocation().getDirection().normalize().multiply(0.3D));
                Item dropped10 = p.getLocation().getWorld().dropItem(p.getEyeLocation(), item10);
                dropped10.setVelocity(p.getEyeLocation().getDirection().normalize().multiply(0.3D));
                Item dropped11 = p.getLocation().getWorld().dropItem(p.getEyeLocation(), item11);
                dropped11.setVelocity(p.getEyeLocation().getDirection().normalize().multiply(0.3D));
                Item dropped12 = p.getLocation().getWorld().dropItem(p.getEyeLocation(), item12);
                dropped12.setVelocity(p.getEyeLocation().getDirection().normalize().multiply(0.3D));
                Item dropped13 = p.getLocation().getWorld().dropItem(p.getEyeLocation(), item13);
                dropped13.setVelocity(p.getEyeLocation().getDirection().normalize().multiply(0.3D));
                Item dropped14 = p.getLocation().getWorld().dropItem(p.getEyeLocation(), item14);
                dropped14.setVelocity(p.getEyeLocation().getDirection().normalize().multiply(0.3D));
                Item dropped15 = p.getLocation().getWorld().dropItem(p.getEyeLocation(), item15);
                dropped15.setVelocity(p.getEyeLocation().getDirection().normalize().multiply(0.3D));
                Item dropped16 = p.getLocation().getWorld().dropItem(p.getEyeLocation(), item16);
                dropped16.setVelocity(p.getEyeLocation().getDirection().normalize().multiply(0.3D));
            }
        }, 5L, 5L);
    }

    public void UnVomit(Player p) {
        if (Vomit1.contains(p.getName())) {
            String p2 = p.getName();
            Bukkit.getScheduler().cancelTasks((Plugin) Core.instance);
            Vomit1.remove(p.getName());
            Player player = p;
            player.getNearbyEntities(10.0D, 10.0D, 10.0D).stream().filter(entstream -> entstream instanceof Item).map(Item.class::cast).filter(item -> (item.getItemStack().getType() == Material.WHITE_WOOL)).forEach(Entity::remove);
            player.getNearbyEntities(10.0D, 10.0D, 10.0D).stream().filter(entstream -> entstream instanceof Item).map(Item.class::cast).filter(item -> (item.getItemStack().getType() == Material.CYAN_WOOL)).forEach(Entity::remove);
            player.getNearbyEntities(10.0D, 10.0D, 10.0D).stream().filter(entstream -> entstream instanceof Item).map(Item.class::cast).filter(item -> (item.getItemStack().getType() == Material.LIGHT_GRAY_WOOL)).forEach(Entity::remove);
            player.getNearbyEntities(10.0D, 10.0D, 10.0D).stream().filter(entstream -> entstream instanceof Item).map(Item.class::cast).filter(item -> (item.getItemStack().getType() == Material.GRAY_WOOL)).forEach(Entity::remove);
            player.getNearbyEntities(10.0D, 10.0D, 10.0D).stream().filter(entstream -> entstream instanceof Item).map(Item.class::cast).filter(item -> (item.getItemStack().getType() == Material.BLACK_WOOL)).forEach(Entity::remove);
            player.getNearbyEntities(10.0D, 10.0D, 10.0D).stream().filter(entstream -> entstream instanceof Item).map(Item.class::cast).filter(item -> (item.getItemStack().getType() == Material.RED_WOOL)).forEach(Entity::remove);
            player.getNearbyEntities(10.0D, 10.0D, 10.0D).stream().filter(entstream -> entstream instanceof Item).map(Item.class::cast).filter(item -> (item.getItemStack().getType() == Material.ORANGE_WOOL)).forEach(Entity::remove);
            player.getNearbyEntities(10.0D, 10.0D, 10.0D).stream().filter(entstream -> entstream instanceof Item).map(Item.class::cast).filter(item -> (item.getItemStack().getType() == Material.BROWN_WOOL)).forEach(Entity::remove);
            player.getNearbyEntities(10.0D, 10.0D, 10.0D).stream().filter(entstream -> entstream instanceof Item).map(Item.class::cast).filter(item -> (item.getItemStack().getType() == Material.YELLOW_WOOL)).forEach(Entity::remove);
            player.getNearbyEntities(10.0D, 10.0D, 10.0D).stream().filter(entstream -> entstream instanceof Item).map(Item.class::cast).filter(item -> (item.getItemStack().getType() == Material.LIME_WOOL)).forEach(Entity::remove);
            player.getNearbyEntities(10.0D, 10.0D, 10.0D).stream().filter(entstream -> entstream instanceof Item).map(Item.class::cast).filter(item -> (item.getItemStack().getType() == Material.GREEN_WOOL)).forEach(Entity::remove);
            player.getNearbyEntities(10.0D, 10.0D, 10.0D).stream().filter(entstream -> entstream instanceof Item).map(Item.class::cast).filter(item -> (item.getItemStack().getType() == Material.CYAN_WOOL)).forEach(Entity::remove);
            player.getNearbyEntities(10.0D, 10.0D, 10.0D).stream().filter(entstream -> entstream instanceof Item).map(Item.class::cast).filter(item -> (item.getItemStack().getType() == Material.BLUE_WOOL)).forEach(Entity::remove);
            player.getNearbyEntities(10.0D, 10.0D, 10.0D).stream().filter(entstream -> entstream instanceof Item).map(Item.class::cast).filter(item -> (item.getItemStack().getType() == Material.LIGHT_BLUE_WOOL)).forEach(Entity::remove);
            player.getNearbyEntities(10.0D, 10.0D, 10.0D).stream().filter(entstream -> entstream instanceof Item).map(Item.class::cast).filter(item -> (item.getItemStack().getType() == Material.PURPLE_WOOL)).forEach(Entity::remove);
            player.getNearbyEntities(10.0D, 10.0D, 10.0D).stream().filter(entstream -> entstream instanceof Item).map(Item.class::cast).filter(item -> (item.getItemStack().getType() == Material.MAGENTA_WOOL)).forEach(Entity::remove);
            player.getNearbyEntities(10.0D, 10.0D, 10.0D).stream().filter(entstream -> entstream instanceof Item).map(Item.class::cast).filter(item -> (item.getItemStack().getType() == Material.PINK_WOOL)).forEach(Entity::remove);
        }
    }

    @EventHandler
    public void PlayerItemPickup(PlayerPickupItemEvent e) {
        if (!Vomit1.isEmpty()) {
            ItemStack item = e.getItem().getItemStack();
            if (item.getType() == Material.WHITE_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.CYAN_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.LIGHT_GRAY_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.GRAY_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.BLACK_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.RED_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.ORANGE_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.BROWN_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.YELLOW_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.LIME_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.GREEN_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.BLUE_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.LIGHT_BLUE_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.PURPLE_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.MAGENTA_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.PINK_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.LIGHT_GRAY_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
        }
    }
    @EventHandler
    public void InventoryItemPickup(InventoryPickupItemEvent e) {
        if (!Vomit1.isEmpty()) {
            ItemStack item = e.getItem().getItemStack();


            if (item.getType() == Material.WHITE_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.CYAN_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.LIGHT_GRAY_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.GRAY_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.BLACK_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.RED_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.ORANGE_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.BROWN_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.YELLOW_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.LIME_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.GREEN_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.BLUE_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.LIGHT_BLUE_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.PURPLE_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.MAGENTA_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.PINK_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
            if (item.getType() == Material.LIGHT_GRAY_WOOL) {
                e.setCancelled(true);
                e.getItem().remove();
            }
        }
    }
}