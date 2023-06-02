package me.iangry.trollingfreedom.main;

import me.iangry.trollingfreedom.commands.Help;
import me.iangry.trollingfreedom.ui.SettingsMenuInventory;
import me.iangry.trollingfreedom.other.UpdateChecker;
import me.iangry.trollingfreedom.ui.PlayerSelectorInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Set;

public class TrollCommand extends CommandHandler {
   Set<String> keys = Core.instance.config.getDefaultSection().getKeys(true);
   String[] args;

    // Not 1:1 Stolen fon GeeksforGeeks i swear....
    public static String[] convert(Set<String> setOfString)
    {
        String[] arrayOfString = new String[setOfString.size()];
        int index = 0;
        for (String str : setOfString)
            arrayOfString[index++] = str;
        return arrayOfString;
    }

    public static boolean isNumeric(String str) { // Surely not stolen.... xd

        if (str == null || str.length() == 0) {
            return false;
        }

        try {
            Double.parseDouble(str);
            return true;

        } catch (NumberFormatException e) {
            return false;
        }

    }


    public TrollCommand(CommandMap commandMap, JavaPlugin plugin) {
        super(plugin, "troll");
        keys.remove("items");
        keys.remove("menu");
        keys.remove("values");
        keys.remove("menu.messages");
        keys.remove("items.messages");
        keys.remove("values.explode-item");
        keys.remove("values.burn-item");
        keys.remove("values.random-look");
        keys.remove("values.fake-clear");
        keys.remove("values.advanced-perms");
        keys.remove("values.fakeBlocks");
        addDescription("");
        addUsage("");
        addPermission("trollingfreedom.open");
        addPermissionMessage(Core.instance.getP()+ Core.tcc(Core.instance.config.getString("no-perms")));
        registerCommand(commandMap);
        addListTabbComplete(0,"trollingfreedom.open", "reload", "giveskull", "contact", "help");

        addListTabbComplete(1, "trollingfreedom.open", convert(keys));
        addListTabbComplete(2, "trollingfreedom.open", "%SPACE_SEPERATOR%", "%EMPTY_CHAR%");
        setAliases(Arrays.asList("beeingabletotrolltheonlyplayerisfunbecauseitiskindafun"));
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, String[] strings) {
        String ags = strings.length > 0 ? strings[0] : "";
        if (sender instanceof Player){
            Player p = (Player) sender;
            if(Core.advCheck("trollingfreedom.open", p)){
                switch (ags){
                    case "reload":
                            SettingsMenuInventory sm = new SettingsMenuInventory();
                            sm.openInventory(p);
                        break;
                    case "giveskull":
                            p.getInventory().addItem(Core.instance.getSkull());
                            p.sendMessage(Core.instance.getP()+"§bYou got the skull item.");
                        break;
                    case "help":
                        Help helpcmd = new Help();
                        helpcmd.Help(p);
                        break;
                    case "contact":
                        p.sendMessage(Core.instance.getP()+"§7Plugin Contact: ");
                        p.sendMessage(Core.instance.getP()+"§9Discord§7: §nhttps://discord.gg/DkWRaszkDy");
                        p.sendMessage(Core.instance.getP()+"https://www.spigotmc.org/resources/.53419/");
                        break;
                    case "player":
                        p.sendMessage(Core.instance.getP()+"§7For command line trolling:");
                        p.sendMessage(Core.instance.getP()+"§9/Trollp <PLAYER> <TROLL>");
                        p.sendMessage(Core.instance.getP()+"");
                        p.sendMessage(Core.instance.getP()+"§7For GUI trolling:");
                        p.sendMessage(Core.instance.getP()+"§9/Troll");
                        break;
                    default:
                            PlayerSelectorInventory ps = new PlayerSelectorInventory();
                            ps.openSel(p);
                        break;
                }
            }
//            if(ags.equals("settings")){
//                SettingsMenu sm = new SettingsMenu();
//                sm.openInventory(p);
//            } else if(ags.equals("giveskull")) {
//                p.getInventory().addItem(core.instance.getSkull());
//                p.sendMessage(core.instance.getP()+"§bYou got the skull item.");
//            } else {
//                PlayerSelector ps = new PlayerSelector();
//                ps.openSel(p);
//            }

        }else{
            sender.sendMessage("no player");
        }

        return true;
    }

}
