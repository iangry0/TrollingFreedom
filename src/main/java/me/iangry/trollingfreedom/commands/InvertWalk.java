

package me.iangry.trollingfreedom.commands;

import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.Location;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import org.bukkit.event.Listener;

public class InvertWalk implements Listener
{
    public static ArrayList<String> Invert1 = new ArrayList<>();;

    public static void Invert(final Player p) {
        Invert1.add(p.getName());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onMove(final PlayerMoveEvent move) {
        if (Invert1.contains(move.getPlayer().getName())) {
            move.getPlayer().setFlySpeed(0.5f);
            move.getPlayer().setWalkSpeed(1.0f);
            final Location from = move.getFrom();
            final Location to = move.getTo();
            final double xDiff = from.getX() - to.getX();
            final double zDiff = from.getZ() - to.getZ();
            to.setX(from.getX() + xDiff);
            to.setZ(from.getZ() + zDiff);
        }
        return;
    }

    public static void UnInvert(final Player p) {
        if (Invert1.contains(p.getName())) {
            p.setWalkSpeed(0.2f);
            p.setFlySpeed(0.1f);
            Invert1.remove(p.getName());
        }
    }
}
