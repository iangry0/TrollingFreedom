package me.iangry.trollingfreedom.commands;

import me.iangry.trollingfreedom.main.Core;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

//ArgsCmd also implements CommandInterface
public class Help implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player p = (Player) sender;
        if (commandLabel.equalsIgnoreCase("trollingfreedom")) {
            Help(p);

        }
        return false;
    }

    public void Help(Player p) {
        PluginDescriptionFile pdf = Core.instance.getDescription();
        for (String messages : Core.instance.getConfig().getStringList("trollingfreedom-help")) {
            String replaced = messages.replace("%version%", pdf.getVersion());
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', replaced));
        }
    }
}