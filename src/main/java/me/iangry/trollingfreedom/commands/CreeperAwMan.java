package me.iangry.trollingfreedom.commands;

//https://www.dropbox.com/s/ebgvuutxlsve4p1/utils.zip?dl=1

import me.iangry.trollingfreedom.main.Core;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameRule;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;

import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;

import static net.md_5.bungee.api.ChatColor.AQUA;

public class CreeperAwMan implements Listener {
    public static ArrayList<String> Creeper1 = new ArrayList<>();

    public static void Creeper(Player p) throws IOException {
        Player p2 = p.getPlayer();
        Creeper1.add(p.getName());
        Path path1 = Paths.get(String.valueOf(Core.instance.getServer().getWorldContainer()));

        //finding world name
        Properties props = new Properties();
        props.load(new FileInputStream("server.properties"));
        String name = props.getProperty("level-name");
        //

        File f = new File(path1 + "/" + name + "/datapacks/" + "utils.zip");
        if(!f.exists()){
            f.createNewFile();
            try (BufferedInputStream inputStream = new BufferedInputStream(new URL("https://www.dropbox.com/s/fjnzmuykywii537/utils.zip?dl=1").openStream())) {
                try (FileOutputStream fileOS = new FileOutputStream(path1 + "/" + name + "/datapacks/" + "utils.zip")) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3[&9TrollingFreedom&3] &bDownloading assets complete!"));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3[&9TrollingFreedom&3] &bPlease restart the server to load assets and enable the troll"));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3[&9TrollingFreedom&3] &bContact discord for help if this does not work"));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3[&9TrollingFreedom&3] &b&nhttps://discord.gg/DkWRaszkDy"));
                    byte data[] = new byte[1024];
                    int byteContent;
                    while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
                        fileOS.write(data, 0, byteContent);
                    }
                }
            } catch (IOException e) {
                // handles IO exceptions
            }
        }else{
            p.getWorld().setGameRule(GameRule.SEND_COMMAND_FEEDBACK, false);
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "execute as @a at " + p2.getName() + " run function utils:play");
            Entity enderman = p.getWorld().spawnEntity(p.getLocation(), EntityType.CREEPER);
            LivingEntity livingenderman = (LivingEntity) enderman;
            Creature creatureenderman = (Creature) livingenderman;
            creatureenderman.setInvulnerable(false);
            creatureenderman.setTarget(p);
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new ComponentBuilder("Creeper Aw Man").color(AQUA).create());
            p.getWorld().setGameRule(GameRule.SEND_COMMAND_FEEDBACK, true);
        }
        }


    public void UnCreeper(Player p) {
        if (Creeper1.contains(p.getName())) {
            Creeper1.remove(p.getName());
            Player p2 = p.getPlayer();
            p.getWorld().setGameRule(GameRule.SEND_COMMAND_FEEDBACK, Boolean.valueOf(false));
            Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "execute as @a at " + p2.getName() + " run function utils:stop");
            p.getWorld().setGameRule(GameRule.SEND_COMMAND_FEEDBACK, Boolean.valueOf(true));
        } else {
            return;
        }
    }
}



