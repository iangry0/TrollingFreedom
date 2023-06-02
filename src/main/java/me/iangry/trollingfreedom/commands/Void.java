package me.iangry.trollingfreedom.commands;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Void implements Listener {

    public static void Void(final Player p) {
        String p2 = p.getName();
        p.teleport(p.getLocation().add(0.0,-100,0.0));
        p.setFlying(false);
        }
}
