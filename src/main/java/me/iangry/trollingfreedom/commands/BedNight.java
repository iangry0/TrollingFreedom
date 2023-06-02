package me.iangry.trollingfreedom.commands;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

public class BedNight implements Listener {
    public static ArrayList<String> Bed1 = new ArrayList();

    public void BedNight(Player player) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new ComponentBuilder("You can only sleep at night or during thunderstorms").create());

    }

    public void BedMonster(Player player) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new ComponentBuilder("You may not rest now; there are monsters nearby").create());
        player.playSound(player.getLocation(), Sound.ENTITY_ZOMBIE_AMBIENT, 100, 1);
        player.playSound(player.getLocation(), Sound.ENTITY_ZOMBIE_AMBIENT, 100, 1);

    }

    public void StopSleep(Player player) {
        BedNight.Bed1.add(player.getName());

        if (player.isSleeping()) {
            player.wakeup(false);
        }
    }

    public void UnStopSleep(Player player) {
        BedNight.Bed1.remove(player.getName());
    }

    @EventHandler
    public void onBedEnter(PlayerBedEnterEvent e) {
        Player p = e.getPlayer();
        if (BedNight.Bed1.contains(p.getName())) {
            e.setCancelled(true);
        }
    }
}