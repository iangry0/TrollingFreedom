package me.iangry.trollingfreedom.commands;

import me.iangry.trollingfreedom.main.Core;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class FakeReload implements Listener {

    public void Reload(Player p) {
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&o[CONSOLE: &cPlease note that this command is not supported and may cause issues when using some plugins.&7&o]"));
        Bukkit.getScheduler().scheduleSyncDelayedTask(Core.instance, () -> p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&o[CONSOLE: &cIf you encounter any issues please use the /stop command to restart your server.&7&o]")), 30L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Core.instance, () -> p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&o[CONSOLE: &aReload complete.&7&o]")), 100L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Core.instance, () -> {
            for (int x = 0; x < 1500; x++){
                //used to be 15000 to fake lag effect but it now seems to kick player so i set to 1.5k
                Location loc1 = p.getLocation();
                p.teleport(loc1);
            }
        }, 95L);
    }
}