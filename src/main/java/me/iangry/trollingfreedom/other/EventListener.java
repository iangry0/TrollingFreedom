package me.iangry.trollingfreedom.other;

import me.iangry.trollingfreedom.commands.UnTroll;
import me.iangry.trollingfreedom.other.xseries.XMaterial;
import me.iangry.trollingfreedom.ui.PlayerSelectorInventory;
import me.iangry.trollingfreedom.ui.TrollInventory;
import me.iangry.trollingfreedom.main.Core;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.*;

import java.io.IOException;


public class EventListener implements Listener {


    public String getNOU(Player p){
        return Core.uid()?p.getName():p.getUniqueId().toString();
    }
    @org.bukkit.event.EventHandler
    public void onPlayerFall(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();
            try{
                if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
                    if (TrollInventory.getMaps("LP").containsKey(Core.instance.getConfig().getBoolean("using-uuid")?player.getName():player.getUniqueId().toString())) {
                        e.setCancelled(true);
                        TrollInventory.getMaps("LP").remove(Core.instance.getConfig().getBoolean("using-uuid")?player.getName():player.getUniqueId().toString());
                    }
                }
            } catch (Exception ignored){
            }
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (Core.advCheck("ms3.use", p)) {
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
                if (p.getInventory().getItemInMainHand() != null && p.getInventory().getItemInMainHand().getType() != XMaterial.AIR.parseMaterial()) {
                    if (p.getInventory().getItemInMainHand().isSimilar(Core.instance.getSkull())) {
                        PlayerSelectorInventory ps = new PlayerSelectorInventory();
                        ps.openSel(p);
                        e.setCancelled(true);

                    }
                }
            }
        }
    }
                @EventHandler
                public void onPlayerDisconnect(PlayerQuitEvent e) throws IOException {
                    Player p = e.getPlayer();
                    UnTroll stoptroll = new UnTroll();
                    stoptroll.StopTrolls(p, p);
    }
    @EventHandler
    public void onMove(PlayerMoveEvent e){
            if (e.getPlayer() instanceof Player) {
                Player player = e.getPlayer();
                try {
                    if (TrollInventory.getMaps("FR").containsKey(Core.uid()?player.getName():player.getUniqueId().toString())) {
                        e.setCancelled(true);
                    }
                } catch (Exception ignored){
                }
            }
    }
    @EventHandler
    public void onPlayerDrop(PlayerDropItemEvent e){
        Player p = e.getPlayer();
        if(Core.advCheck("trollingfreedom.troll", p)){
            Item droppedi = e.getItemDrop();
            if(droppedi.getItemStack().isSimilar(Core.instance.getSkull())){
                p.sendMessage(Core.instance.getP()+"This item is undroppable.");
                e.setCancelled(true);
            }
        }
    }

}
