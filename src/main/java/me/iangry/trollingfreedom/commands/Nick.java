package me.iangry.trollingfreedom.commands;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.User;
import me.iangry.trollingfreedom.main.Core;
import me.iangry.trollingfreedom.other.Mode;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;

public class Nick implements Listener {

    public static ArrayList<String> Nick1 = new ArrayList();

    public void NickName(final Player p) {
        String p2 = p.getName();
        Essentials ess = (Essentials) Bukkit.getServer().getPluginManager().getPlugin("Essentials");
        User user = ess.getUserMap().getUser(p.getName());
        Nick1.add(p.getName());
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.instance, new Runnable() {
            public void run() {
                String randomString1 = Mode.getString(8, Mode.ALPHANUMERIC);
                //Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nick " + p.getName() + " " + randomString1);
                user.setNickname(randomString1);
            }
        }, 10L, 10L);
    }

    public void UnNick(Player p) {
        Essentials ess = (Essentials) Bukkit.getServer().getPluginManager().getPlugin("Essentials");
        User user = ess.getUserMap().getUser(p.getName());

       // String nick = user.getNick();
        if (Nick1.contains(p.getName())) {
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nick " + p.getName() + " off");
            Nick1.remove(p.getName());
        } else {
            return;
        }
    }
}