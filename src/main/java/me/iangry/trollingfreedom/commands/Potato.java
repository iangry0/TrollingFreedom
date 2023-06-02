package me.iangry.trollingfreedom.commands;

import me.iangry.trollingfreedom.main.Core;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class Potato implements Listener {

	public static ArrayList<String> Break1 = new ArrayList<>();

	public void potato(final Player p) {
		Player p2 = p.getPlayer();
		p.setInvisible(true);
		Location tp = p.getLocation();
		Break1.add(p2.getName());
		Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin) Core.instance, new Runnable() {
			public void run() {
				ItemStack item1 = new ItemStack(Material.POTATO);
				p.getWorld().dropItemNaturally(p.getLocation().add(0.0D, 0.0D, 0.0D), item1);
				p.getWorld().dropItemNaturally(p.getLocation().add(0.0D, 0.0D, 0.0D), item1);
				p.getWorld().dropItemNaturally(p.getLocation().add(0.0D, 0.0D, 0.0D), item1);
				Player player = p;

			}
	},  10L, 5L);
	}

	public void unpotato(Player p) {
		if (this.Break1.contains(p.getName())) {
			p.setInvisible(false);
			Bukkit.getScheduler().cancelTasks((Plugin) Core.instance);

			p.getNearbyEntities(10.0D, 10.0D, 10.0D).stream().filter(entstream -> entstream instanceof Item).map(Item.class::cast).filter(item -> (item.getItemStack().getType() == Material.POTATO)).forEach(Entity::remove);

			Break1.remove(p.getName());
		}
		else {
			return;
		}
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (Break1.contains(p.getName()))
			e.setCancelled(true);
	}

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if (Break1.contains(p.getName()))
			e.setCancelled(true);
	}
	@EventHandler
	public void onPickUp(PlayerPickupItemEvent e) {
		if (!Break1.isEmpty()) {
			ItemStack item = e.getItem().getItemStack();
			if (item.getType() == Material.POTATO) {
				e.setCancelled(true);
				e.getItem().remove();
			}
		}
	}
}
