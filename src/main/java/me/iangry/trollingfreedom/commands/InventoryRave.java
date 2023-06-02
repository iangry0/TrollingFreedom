package me.iangry.trollingfreedom.commands;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import me.iangry.trollingfreedom.main.Core;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class InventoryRave implements Listener {
    public static ArrayList<String> Rave1 = new ArrayList<>();
    private int r = 255, g = 0, b = 0;

    private int posRed, negRed;
    private int posGreen, negGreen;
    private int posBlue, negBlue;

    public void saveInventory(Player p) throws IOException {
        File f = new File(Core.instance.getDataFolder().getAbsolutePath(), p.getName() + ".yml");
        FileConfiguration c = YamlConfiguration.loadConfiguration(f);
        c.set("inventory.armor", p.getInventory().getArmorContents());
        c.set("inventory.content", p.getInventory().getContents());
        c.save(f);
    }

    @SuppressWarnings("unchecked")
    public void restoreInventory(Player p) throws IOException {
        File f = new File(Core.instance.getDataFolder().getAbsolutePath(), p.getName() + ".yml");
        FileConfiguration c = YamlConfiguration.loadConfiguration(f);
        ItemStack[] content = ((List<ItemStack>) c.get("inventory.armor")).toArray(new ItemStack[0]);
        p.getInventory().setArmorContents(content);
        content = ((List<ItemStack>) c.get("inventory.content")).toArray(new ItemStack[0]);
        p.getInventory().setContents(content);
    }
    public void deleteInventoryFile(Player p) throws IOException {
        File f = new File(Core.instance.getDataFolder().getAbsolutePath(), p.getName() + ".yml");
        f.delete();
    }

    public void InvRave(Player p) throws IOException {
        if (Rave1.contains(p.getName())) {
            return;
        } else {
            Rave1.add(p.getName());
            saveInventory(p);
            Rave(p);
            Rave2(p);
        }
    }

    public void UnInvRave(Player p) throws IOException {
        if (Rave1.contains(p.getName())) {
            Rave1.remove(p.getName());
            Bukkit.getScheduler().cancelTasks((Plugin)Core.instance);
            p.getInventory().clear();
            p.getInventory().setArmorContents(null);
            restoreInventory(p);
            deleteInventoryFile(p);
        } else {
            return;
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        if (Rave1.contains(event.getPlayer().getName()))
            event.setCancelled(true);
        return;
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (Rave1.contains(event.getPlayer().getName()))
            event.setCancelled(true);
        return;
    }

    public void Rave(final Player p) {
        (new BukkitRunnable() {
            int i = 0;

            public void run() {
                p.getInventory().clear();
                for (int counter = 1; counter <= 36; counter++)
                    p.getInventory().setItem(p.getInventory().firstEmpty(), new ItemStack(Material.LEGACY_STAINED_GLASS_PANE, 1, (short)(byte)((new Random()).nextInt(13) + 1)));
            }
        }).runTaskTimer((Plugin)Core.instance, 1L, 5L);
    }

    public void Rave2(final Player p) {
        p.getInventory().setArmorContents(null);
        (new BukkitRunnable() {
            int i = 0;

            public void run() {
                Color color = nextRGB();

                p.getInventory().setHelmet(new ItemStack(Material.LEGACY_STAINED_GLASS, 1, (short)(byte)((new Random()).nextInt(13) + 1)));
                p.getInventory().setChestplate(getItemStack(Material.LEATHER_CHESTPLATE, color));
                p.getInventory().setLeggings(getItemStack(Material.LEATHER_LEGGINGS, color));
                p.getInventory().setBoots(getItemStack(Material.LEATHER_BOOTS, color));
                p.getInventory().setItemInOffHand(new ItemStack(Material.LEGACY_STAINED_GLASS_PANE, 1, (short)(byte)((new Random()).nextInt(13) + 1)));
            }
        }).runTaskTimer((Plugin)Core.instance, 1L, 1L);
    }
    public ItemStack getItemStack(Material material, Color color) {
        ItemStack itemStack = new ItemStack(material, 1, (byte) 0);
        ItemMeta itemMeta = itemStack.getItemMeta();

        ((LeatherArmorMeta) itemMeta).setColor(color);
        itemMeta.setDisplayName("§4R§ca§6v§ee§a!");
        itemMeta.addItemFlags(ItemFlag.values());

        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public ItemStack getItemStack(Material material) {
        return getItemStack(material, Color.fromRGB(r, g, b));
    }
    private Color nextRGB() {
        int increment = 15;
        int max = 255 / increment;

        if (posGreen <= max) {
            ++this.posGreen;
            this.g = (posGreen - 1) * increment;
        } else if (negRed <= max) {
            this.negRed++;
            this.r = 255 - increment * (negRed - 1);
        } else if (posBlue <= max) {
            ++this.posBlue;
            this.b = (posBlue - 1) * increment;
        } else if (negGreen <= max) {
            ++this.negGreen;
            this.g = 255 - increment * (negGreen - 1);
        } else if (posRed <= max) {
            ++this.posRed;
            this.r = (posRed - 1) * increment;
        } else if (negBlue <= max) {
            ++this.negBlue;
            this.b = 255 - increment * (negBlue - 1);
        } else {
            this.posRed = 0;
            this.negRed = 0;
            this.posGreen = 0;
            this.negGreen = 0;
            this.posBlue = 0;
            this.negBlue = 0;
        }

        return Color.fromRGB(r, g, b);
    }
}
