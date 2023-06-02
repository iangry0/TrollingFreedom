package me.iangry.trollingfreedom.commands;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLib;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import me.iangry.trollingfreedom.main.Core;
import me.iangry.trollingfreedom.ui.PlayerSelectorInventory;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Control implements CommandExecutor, Listener {
    public static List<String> controlled1 = new ArrayList<>();

    public static List<String> controller1 = new ArrayList<>();

    private boolean allowTargetChat;

    private ItemStack[] controller_inventory;
    private ItemStack[] controller_armor;

    // public static ArrayList<String> controlled1 = new ArrayList<>();

    // public static ArrayList<String> controller1 = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player controlled = Bukkit.getServer().getPlayer(controlled1.toString().replaceAll("\\[", "").replaceAll("\\]", ""));
        Player controller = Bukkit.getServer().getPlayer(controller1.toString().replaceAll("\\[", "").replaceAll("\\]", ""));
        if (!sender.hasPermission("trollingfreedom.open")) {

            String message2 = (String) Core.instance.getConfig().get("no-perms");
            String replaced2 = message2.replace("&", "§").replace("%player%", sender.getName());
            ;
            sender.sendMessage(replaced2);
            return false;
        }
        if (args.length == 0) {

            Player p = (Player) sender;
            PlayerSelectorInventory ps = new PlayerSelectorInventory();
            ps.openSel(p);
            return false;
        }
        if (args.length == 1) {

            Player t = Bukkit.getServer().getPlayer(args[0]);

            // control all
            if (args[0].equals("stop")) {
                if (controlled1.contains(controlled.getPlayer().getName())) {
                    UnControl(controlled);
                }
                return false;
            }
            //
            if (t == null) {
                String message4 = (String) Core.instance.getConfig().get("not-online");
                String replaced4 = message4.replace("&", "§").replace("%player%", args[0]);
                sender.sendMessage(replaced4);
                return false;
            }
            String message3 = (String) Core.instance.getConfig().get("cannot-troll-yourself");
            String replaced3 = message3.replace("&", "§");
            if (t.equals(sender)) {
                sender.sendMessage(replaced3);
            } else {
                controller1.add(sender.getName());
                String arg = args[0];
                controlled1.add(arg);

                Control(controlled);
            }
        }
        return false;
    }

//https://github.com/hwdotexe/iControlU//

    //https://github.com/kaboomserver/icontrolu//


    //String result1 = controlled1.toString().replaceAll("\\[", "").replaceAll("\\]", "");
    // Player controlled = Bukkit.getServer().getPlayer(result1);

    //  String result2 = controller1.toString().replaceAll("\\[", "").replaceAll("\\]", "");
    // Player controller = Bukkit.getServer().getPlayer(result2);


    public void Control(Player p) {
        Player controlled = Bukkit.getServer().getPlayer(controlled1.toString().replaceAll("\\[", "").replaceAll("\\]", ""));
        Player controller = Bukkit.getServer().getPlayer(controller1.toString().replaceAll("\\[", "").replaceAll("\\]", ""));

        Player p2 = p.getPlayer();
        //p2.setFlying(true);

        StatTracker();
        Setup();
    }

    public void UnControl(Player p) {

        Player controlled = Bukkit.getServer().getPlayer(controlled1.toString().replaceAll("\\[", "").replaceAll("\\]", ""));
        Player controller = Bukkit.getServer().getPlayer(controller1.toString().replaceAll("\\[", "").replaceAll("\\]", ""));

        for (Player allPlayers : Bukkit.getOnlinePlayers()) {
            allPlayers.showPlayer(Core.instance, controller);
        }
        controller.setInvisible(false);
        controller.setInvulnerable(false);
        controller.setCollidable(false);
        controller.setFoodLevel(20);
        controller.setHealth(20);
        controller.setDisplayName(null);

        final Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = scoreboard.getTeam("icuCollision");
        team.unregister();

        //The player you were controlling has disconnected. You are invisible for 10 seconds.
        //make thjis


        Undo();
    }

    public void Undo() {
        Player controlled = Bukkit.getServer().getPlayer(controlled1.toString().replaceAll("\\[", "").replaceAll("\\]", ""));
        Player controller = Bukkit.getServer().getPlayer(controller1.toString().replaceAll("\\[", "").replaceAll("\\]", ""));
        Bukkit.getScheduler().cancelTasks(Core.instance);
        restoreControllerInventory();


        //grace period
        String message3 = (String) Core.instance.getConfig().get("control-troll-grace-period");
        String replaced3 = message3.replace("&", "§").replace("%player%", controller.getName());
        controller.sendMessage(replaced3);
        controller.addPotionEffect((new PotionEffect(PotionEffectType.INVISIBILITY, 600, 2)));
        controller.setGameMode(GameMode.SPECTATOR);
        Core.instance.getServer().getScheduler().scheduleSyncDelayedTask(Core.instance, new Runnable() {
            public void run() {
                String message3 = (String) Core.instance.getConfig().get("control-troll-grace-period-ended");
                String replaced3 = message3.replace("&", "§").replace("%player%", controller.getName());
                controller.sendMessage(replaced3);
                controller.setGameMode(GameMode.SURVIVAL);
            }
        }, 600);


        controlled1.remove(controlled.getName());
        controller1.remove(controller.getName());


    }

    public void Setup() {
        Player controlled = Bukkit.getServer().getPlayer(controlled1.toString().replaceAll("\\[", "").replaceAll("\\]", ""));
        Player controller = Bukkit.getServer().getPlayer(controller1.toString().replaceAll("\\[", "").replaceAll("\\]", ""));

        GameMode controlledgm = controlled.getGameMode();
        controller.setGameMode(controlledgm);

        controller.setInvisible(true);
        controller.setCollidable(false);
        controller.setInvulnerable(true);
        controller.setGameMode(controlled.getGameMode());
        saveControllerInventory();

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.hidePlayer(Core.instance, controller);
        }

        boolean controlledflight = controlled.isFlying();
        controller.setFlying(controlledflight);


        final Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = scoreboard.getTeam("icuCollision");

        if (team == null) {
            team = scoreboard.registerNewTeam("icuCollision");
        }

        team.setCanSeeFriendlyInvisibles(false);
        team.setOption(Team.Option.COLLISION_RULE, Team.OptionStatus.NEVER);

        if (!team.hasEntry(controller.getName())) {
            team.addEntry(controller.getName());
        }


    }

    public void StatTracker() {
        Player controlled = Bukkit.getServer().getPlayer(controlled1.toString().replaceAll("\\[", "").replaceAll("\\]", ""));
        Player controller = Bukkit.getServer().getPlayer(controller1.toString().replaceAll("\\[", "").replaceAll("\\]", ""));


        Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.instance, () -> {
            int controllerhunger = controlled.getFoodLevel();
            controller.setFoodLevel(controllerhunger);

            double controllerhealth = controlled.getHealth();
            controller.setHealth(controllerhealth);

            controlled.teleport(controller.getLocation());

            controlled.setLevel(controller.getLevel());
            controlled.setSneaking(controller.isSneaking());
            controlled.setSprinting(controller.isSprinting());

            //check github for their inv cloning thing

            if (controller != null) {
                for (int i = 0; i < controller.getInventory().getSize(); i++) {
                    if (controller.getInventory().getItem(i) != null) {
                        if (!controller.getInventory().getItem(i).equals(controlled.getInventory().getItem(i))) {
                            controlled.getInventory().setItem(i, controller.getInventory().getItem(i));
                        }
                    } else {
                        controlled.getInventory().setItem(i, null);
                    }
                }
            }
        }, 2L, 5L);
    }


    @EventHandler
    private void onPlayerInteract(final PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        Player controlled = Bukkit.getServer().getPlayer(controlled1.toString().replaceAll("\\[", "").replaceAll("\\]", ""));
        Player controller = Bukkit.getServer().getPlayer(controller1.toString().replaceAll("\\[", "").replaceAll("\\]", ""));
        if (controlled1.contains(controlled.getPlayer().getName())) {
            if ((event.getAction() == Action.LEFT_CLICK_AIR
                    || event.getAction() == Action.LEFT_CLICK_BLOCK)
                    && player != null) {

                if (event.getHand() == EquipmentSlot.HAND) {
                    controlled.swingMainHand();
                } else if (event.getHand() == EquipmentSlot.OFF_HAND) {
                    controlled.swingOffHand();
                }
            }
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        Player controlled = Bukkit.getServer().getPlayer(controlled1.toString().replaceAll("\\[", "").replaceAll("\\]", ""));
        Player controller = Bukkit.getServer().getPlayer(controller1.toString().replaceAll("\\[", "").replaceAll("\\]", ""));
        if (controlled1.contains(controlled.getPlayer().getName())) {
            if (e.getPlayer().equals(controlled)) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player controlled = Bukkit.getServer().getPlayer(controlled1.toString().replaceAll("\\[", "").replaceAll("\\]", ""));
        Player controller = Bukkit.getServer().getPlayer(controller1.toString().replaceAll("\\[", "").replaceAll("\\]", ""));
        if (controlled1.contains(controlled.getPlayer().getName())) {
            if (e.getPlayer().equals(controlled)) {
                e.setCancelled(true);
            }
        }
    }

    public void saveControllerInventory() {
        Player controlled = Bukkit.getServer().getPlayer(controlled1.toString().replaceAll("\\[", "").replaceAll("\\]", ""));
        Player controller = Bukkit.getServer().getPlayer(controller1.toString().replaceAll("\\[", "").replaceAll("\\]", ""));
        controller_inventory = controller.getInventory().getContents();
        controller_armor = controller.getInventory().getArmorContents();

        controller.getInventory().setContents(controlled.getInventory().getContents());
        controller.getInventory().setArmorContents(controlled.getInventory().getArmorContents());
    }

    public void restoreControllerInventory() {
        Player controlled = Bukkit.getServer().getPlayer(controlled1.toString().replaceAll("\\[", "").replaceAll("\\]", ""));
        Player controller = Bukkit.getServer().getPlayer(controller1.toString().replaceAll("\\[", "").replaceAll("\\]", ""));
        controlled.getInventory().setContents(controller.getInventory().getContents());
        controlled.getInventory().setArmorContents(controller.getInventory().getArmorContents());

        controller.getInventory().setContents(controller_inventory);
        controller.getInventory().setArmorContents(controller_armor);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onChat(PlayerChatEvent e) {
        Player controlled = Bukkit.getServer().getPlayer(controlled1.toString().replaceAll("\\[", "").replaceAll("\\]", ""));
        Player controller = Bukkit.getServer().getPlayer(controller1.toString().replaceAll("\\[", "").replaceAll("\\]", ""));
        if (controller1.contains(controller.getPlayer().getName())) {
            if (e.getPlayer().equals(controlled)) {
                e.setCancelled(!allowTargetChat);
                allowTargetChat = false;
            } else if (e.getPlayer().equals(controller)) {
                e.setCancelled(true);
                allowTargetChat = true;
                controlled.chat(e.getMessage());
            }
        }
    }

    @EventHandler
    public void onDie(PlayerDeathEvent e) {
        Player controlled = Bukkit.getServer().getPlayer(controlled1.toString().replaceAll("\\[", "").replaceAll("\\]", ""));
        Player controller = Bukkit.getServer().getPlayer(controller1.toString().replaceAll("\\[", "").replaceAll("\\]", ""));
        if (Control.controlled1.contains(controlled.getPlayer().getName())) {
            controller.performCommand("control stop");
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player controlled = Bukkit.getServer().getPlayer(controlled1.toString().replaceAll("\\[", "").replaceAll("\\]", ""));
        Player controller = Bukkit.getServer().getPlayer(controller1.toString().replaceAll("\\[", "").replaceAll("\\]", ""));
        if (Control.controlled1.contains(controlled.getPlayer().getName())) {
            controller.performCommand("control stop");
        }
    }
}