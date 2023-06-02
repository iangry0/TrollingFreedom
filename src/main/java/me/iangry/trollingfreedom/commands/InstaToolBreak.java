package me.iangry.trollingfreedom.commands;

import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class InstaToolBreak implements Listener {
    public static ArrayList<String> InstaToolBreak1 = new ArrayList();


    public void InstaToolBreak(Player p) {
        String p2 = p.getName();
        this.InstaToolBreak1.add(p.getName());
    }

    public void UnInstaToolBreak(Player p) {
        String p2 = p.getName();
        this.InstaToolBreak1.remove(p.getName());
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player p = event.getPlayer();
        if (this.InstaToolBreak1.contains(p.getName())) {
            ItemStack item = p.getItemInHand();
            Block block = event.getBlock();
            if (block != null && item != null && (
                    item.getType().name().contains("PICKAXE") || item.getType().name().contains("AXE") ||
                            item.getType().name().contains("SHOVEL") || item.getType().name().contains("SWORD") ||
                            item.getType().name().contains("SPADE"))) {
                item.setDurability((short) 12000);
                p.playSound(p.getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0F, 1.0F);
            }
        }
    }
                @EventHandler
            public void onEntityPunch (PlayerAnimationEvent event){
                Player p = event.getPlayer();
                if (this.InstaToolBreak1.contains(p.getName())) {
                    ItemStack item = p.getItemInHand();
                    if (item != null && (
                            item.getType().name().contains("PICKAXE") || item.getType().name().contains("AXE") ||
                                    item.getType().name().contains("SHOVEL") || item.getType().name().contains("SWORD") ||
                                    item.getType().name().contains("SPADE"))) {
                        item.setDurability((short) 12000);
                        p.getInventory().removeItem(item);
                        p.playSound(p.getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0F, 1.0F);
                    }
                }
            }
        }