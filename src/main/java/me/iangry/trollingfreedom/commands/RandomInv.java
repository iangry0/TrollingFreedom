package me.iangry.trollingfreedom.commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.Random;

public class RandomInv implements Listener {


    public static ArrayList<String> RandomInv1 = new ArrayList<>();

    public void RandomInv(Player p) {
        Player p2 = p.getPlayer();
        RandomInv1.add(p2.getName());
    }

    public void UnRandomInv(Player p) {
        Player p2 = p.getPlayer();
        RandomInv1.remove(p2.getName());
    }

    @EventHandler
    public void onOpenInv(InventoryCloseEvent e) {
        Player p = (Player) e.getPlayer();
        if (this.RandomInv1.contains(p.getName())) {
                // player is in water
            Random rnd = new Random();
            int rand = rnd.nextInt(7);
            if(rand == 0){
                Inventory inv1 = Bukkit.createInventory(p, InventoryType.WORKBENCH);
                p.openInventory(inv1);
            } else if(rand == 1){
                Inventory inv2 = Bukkit.createInventory(p, InventoryType.BARREL);
                p.openInventory(inv2);
            } else if(rand == 3){
                Inventory inv3 = Bukkit.createInventory(p, InventoryType.FURNACE);
                p.openInventory(inv3);
            } else if(rand == 4) {
                Inventory inv4 = Bukkit.createInventory(p, InventoryType.ENCHANTING);
                p.openInventory(inv4);
            } else if(rand == 5) {
                Inventory inv5 = Bukkit.createInventory(p, InventoryType.DISPENSER);
                p.openInventory(inv5);
            } else if(rand == 6) {
                Inventory inv6 = Bukkit.createInventory(p, InventoryType.LECTERN);
                p.openInventory(inv6);
            } else if(rand == 7) {
                Inventory inv7 = Bukkit.createInventory(p, InventoryType.STONECUTTER);
                p.openInventory(inv7);
            } else if(rand == 8) {
                Inventory inv8 = Bukkit.createInventory(p, InventoryType.MERCHANT);
                p.openInventory(inv8);
            } else if(rand == 9) {
                Inventory inv9 = Bukkit.createInventory(p, InventoryType.HOPPER);
                p.openInventory(inv9);
            } else if(rand == 10) {
                Inventory inv10 = Bukkit.createInventory(p, InventoryType.GRINDSTONE);
                p.openInventory(inv10);
            }
            }
        }
    }
