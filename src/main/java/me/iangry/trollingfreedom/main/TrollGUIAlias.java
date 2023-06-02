package me.iangry.trollingfreedom.main;

import me.iangry.trollingfreedom.main.Core;
import me.iangry.trollingfreedom.ui.PlayerSelectorInventory;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


//ArgsCmd also implements CommandInterface
public class TrollGUIAlias implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (!sender.hasPermission("trollingfreedom.trollingfreedom.open")) {

            String message2 = (String) Core.instance.getConfig().get("no-perms");
            String replaced2 = message2.replace("&", "§").replace("%player%", sender.getName());
            sender.sendMessage(replaced2);
            return false;
        }
        if (args.length > 0) {
            Player p = (Player) sender;
            PlayerSelectorInventory ps = new PlayerSelectorInventory();
            ps.openSel(p);
            return false;
        }
            else {
            Player p = (Player) sender;
            PlayerSelectorInventory ps = new PlayerSelectorInventory();
            ps.openSel(p);
            }
        return false;
    }

}
