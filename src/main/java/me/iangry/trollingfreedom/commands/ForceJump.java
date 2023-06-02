package me.iangry.trollingfreedom.commands;

import me.iangry.trollingfreedom.main.Core;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

public class ForceJump implements Listener {

    public static ArrayList<String> Jump1 = new ArrayList();

    public void Jump(Player p) {
        Player p2 = p.getPlayer();
        this.Jump1.add(p2.getName());
    }
    public void UnJump(Player p) {
        Player p2 = p.getPlayer();
        this.Jump1.remove(p2.getName());
    }
    @EventHandler
    public void onWalk(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (this.Jump1.contains(p.getName())) {
            if (!e.getFrom().toVector().equals(e.getTo().toVector()))
                p.setVelocity(p.getVelocity().setY(1.0));
                Bukkit.getScheduler().scheduleSyncDelayedTask(Core.instance, () ->  p.setVelocity(p.getVelocity().setY(-1.0)), 20L);

        }
    }
}
