package me.iangry.trollingfreedom.other;

import me.iangry.trollingfreedom.main.Core;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DependencyChecker implements Listener {

    public static void DependencyChecker() throws IOException {


        Path path1 = Paths.get(String.valueOf(Core.instance.getServer().getWorldContainer()));
        File f = new File(path1 + "/plugins/" + "ProtocolLib.jar");

        if (Bukkit.getPluginManager().isPluginEnabled("ProtocolLib")) {
            Bukkit.getLogger().info("§3TF§8: §7ProtocolLib dependency detected");
            return;
        } else {
            if (!Bukkit.getPluginManager().isPluginEnabled("ProtocolLib")) {

                f.createNewFile();
                try (BufferedInputStream inputStream = new BufferedInputStream(new URL("https://ci.dmulloy2.net/job/ProtocolLib/lastSuccessfulBuild/artifact/target/ProtocolLib.jar").openStream())) {
                    try (FileOutputStream fileOS = new FileOutputStream(path1 + "/plugins/" + "ProtocolLib.jar")) {
                        byte data[] = new byte[1024];
                        int byteContent;
                        Bukkit.getLogger().info("§3TF§8: §7ProtocolLib dependency has just been installed");
                        Bukkit.getLogger().info("§3TF§8: §7§lPLEASE RESTART YOUR SERVER TO ENABLE §b§lTROLLING§3§lFREEDOM");
                        Bukkit.getLogger().info("");
                        Bukkit.getLogger().info("");
                        Bukkit.getLogger().info("§3TF§8: §7ProtocolLib dependency has just been installed");
                        Bukkit.getLogger().info("§3TF§8: §7§lPLEASE RESTART YOUR SERVER TO ENABLE §b§lTROLLING§3§lFREEDOM");
                        while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
                            fileOS.write(data, 0, byteContent);
                        }
                    }
                }
            }
        }
    }
}