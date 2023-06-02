package me.iangry.trollingfreedom.commands;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.ArrayList;

public class EntityMultiply implements Listener {

    public static ArrayList<String> EntityMultiply1 = new ArrayList();


    public void EntityMultiply(Player p) {
        String p2 = p.getName();
        this.EntityMultiply1.add(p.getName());
    }

    public void UnEntityMultiply(Player p) {
        String p2 = p.getName();
        this.EntityMultiply1.remove(p.getName());
    }

    @EventHandler
    public void onKill(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        Entity p = event.getEntity().getKiller();
        if (event.getEntity().getKiller() == null) return;
        if (this.EntityMultiply1.contains(p.getName())) {
            Location l = entity.getLocation();
            l.getWorld().spawnEntity(l, entity.getType());
            l.getWorld().spawnEntity(l, entity.getType());
        }
    }
}