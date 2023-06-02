package me.iangry.trollingfreedom.commands;

import me.iangry.trollingfreedom.main.Core;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.IOException;

//ArgsCmd also implements CommandInterface
public class UnTroll implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (!(sender instanceof Player)){
            String message0 = (String) Core.instance.getConfig().get("cant-use-in-console");
            String replaced0 = message0.replace("&", "§");
            sender.sendMessage(replaced0);
        }
        if (!sender.hasPermission("trollingfreedom.untroll")) {

            String message2 = (String) Core.instance.getConfig().get("no-perms");
            String replaced2 = message2.replace("&", "§").replace("%player%", sender.getName());
            sender.sendMessage(replaced2);
            return false;
        }
        if (args.length == 0) {

            String message3 = (String) Core.instance.getConfig().get("menu.select-player");
            String replaced3 = message3.replace("&", "§").replace("%player%", sender.getName());
            sender.sendMessage(replaced3);
            return false;
        }
        if (args.length == 1) {

            Player t = Bukkit.getServer().getPlayer(args[0]);

            // untroll all
            if (args[0].equals("all")) {
                for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                    try {
                        StopTrolls(all, (Player) sender);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
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

            try {
                StopTrolls(t, (Player) sender);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String message2 = (String) Core.instance.getConfig().get("untrolled");
            String replaced2 = message2.replace("&", "§").replace("%player%", t.getName());
            sender.sendMessage(replaced2);
        }
        return false;
    }

    public void StopTrolls(Player t, Player sndr) throws IOException {
        //remove all trolls
        Bukkit.getScheduler().cancelTasks((Plugin) Core.instance);
        if (Potato.Break1.contains(t.getPlayer().getName())) {
            Potato a = new Potato();
            a.unpotato(t);
        }
        if (Break.Break1.contains(t.getPlayer().getName())) {
            Break b = new Break();
            b.unBreak(t);
        }
        if (Spin.spin1.contains(t.getPlayer().getName())) {
            Spin sp = new Spin();
            sp.StopSpin(t);
        }
        if (Freeze.frozen.contains(t.getPlayer().getName())) {
            Freeze c = new Freeze();
            c.Unfreeze(t);
        }
        if (Silverfish.Fish1.contains(t.getPlayer().getName())) {
            Silverfish silverfish = new Silverfish();
            silverfish.UnFish(t);
        }
        if (Vomit.Vomit1.contains(t.getPlayer().getName())) {
            Vomit d = new Vomit();
            d.UnVomit(t);
        }
        if (Pumpkin.Pumpkin1.contains(t.getPlayer().getName())) {
            Pumpkin g = new Pumpkin();
            g.unPumpkin(t);
        }
        if (InventoryStop.InvStop1.contains(t.getPlayer().getName())) {
            InventoryStop j = new InventoryStop();
            j.UnInventoryStop(t);
        }
        if (Slenderman.Slender1.contains(t.getPlayer().getName())) {
            Slenderman k = new Slenderman();
            k.UnEnderman(t);
        }
        if (CreeperAwMan.Creeper1.contains(t.getPlayer().getName())) {
            CreeperAwMan cr = new CreeperAwMan();
            cr.UnCreeper(t);
        }
        if (Cage.Cage1.contains(t.getPlayer().getName())) {
            Cage n = new Cage();
            n.UnCage(t);
        }
        if (Starve.starve1.contains(t.getPlayer().getName())) {
            Starve l = new Starve();
            l.UnStarve(t);
        }
        if (ChatChange.Chat1.contains(t.getPlayer().getName())) {
            ChatChange m = new ChatChange();
            m.UnChatChange(t);
        }
        if (Lightning.Lightning1.contains(t.getPlayer().getName())) {
            Lightning r = new Lightning();
            r.UnLightning(t);
        }
        if (HideAllPlayers.hide1.contains(t.getPlayer().getName())) {
            HideAllPlayers u = new HideAllPlayers();
            u.UnHideAll(t);
        }
        if (TimeFlash.flash1.contains(t.getPlayer().getName())) {
            TimeFlash v = new TimeFlash();
            v.UnSkyFlash(t);
        }
        if (TNTPlace.Fireball1.contains(t.getPlayer().getName())) {
            TNTPlace w = new TNTPlace();
            w.UnTNTPlace(t);
        }
        if (RainItems.Rain1.contains(t.getPlayer().getName())) {
            RainItems x = new RainItems();
            x.UnRainItem(t);
        }
        if (Aquaphobia.Aqua1.contains(t.getPlayer().getName())) {
            Aquaphobia y = new Aquaphobia();
            y.unAqua(t);
        }
        if (SneakDestroy.Sneak1.contains(t.getPlayer().getName())) {
            SneakDestroy four = new SneakDestroy();
            four.UnSneakDestroy(t);
        }
        if (InstaToolBreak.InstaToolBreak1.contains(t.getPlayer().getName())) {
            InstaToolBreak five = new InstaToolBreak();
            five.UnInstaToolBreak(t);
        }
        if (EntityMultiply.EntityMultiply1.contains(t.getPlayer().getName())) {
            EntityMultiply six = new EntityMultiply();
            six.UnEntityMultiply(t);
        }
        if (BedExplosion.Explode1.contains(t.getPlayer().getName())) {
            BedExplosion seven = new BedExplosion();
            seven.UnBedExplosion(t);
        }
        if (RickRoll.Rick1.contains(t.getPlayer().getName())) {
            RickRoll twelve = new RickRoll();
            twelve.UnRickRoll(t);
        }
        if (RandomInv.RandomInv1.contains(t.getPlayer().getName())) {
            RandomInv thirteen = new RandomInv();
            thirteen.UnRandomInv(t);
        }
        if (RandomParticle.RandomParticle1.contains(t.getPlayer().getName())) {
            RandomParticle fourteen = new RandomParticle();
            fourteen.UnRandomParticle(t);
        }
        if (ForceJump.Jump1.contains(t.getPlayer().getName())) {
            ForceJump sixteen = new ForceJump();
            sixteen.UnJump(t);
        }
        if (Deafen.Deaf1.contains(t.getPlayer().getName())) {
            Deafen seventeen = new Deafen();
            seventeen.UnDeafen(t);
        }
        if (Nick.Nick1.contains(t.getPlayer().getName())) {
            NickWithoutEss eighteen = new NickWithoutEss();
            eighteen.UnNick(t);
        }
        if (KittyCannon.Kitty1.contains(t.getPlayer().getName())) {
            KittyCannon nineteen = new KittyCannon();
            nineteen.UnKittyCannon(t);
        }
        if (ExplodeOnChat.Chat1.contains(t.getPlayer().getName())) {
            ExplodeOnChat twenty = new ExplodeOnChat();
            twenty.UnChat(t);
        }
        if (InventoryRave.Rave1.contains(t.getPlayer().getName())) {
            InventoryRave twentyone = new InventoryRave();
            twentyone.UnInvRave(t);
        }
        if (InvertWalk.Invert1.contains(t.getPlayer().getName())) {
            InvertWalk twentytwo = new InvertWalk();
            twentytwo.UnInvert(t);
        }
        if (BedNight.Bed1.contains(t.getPlayer().getName())) {
            BedNight twentythree = new BedNight();
            twentythree.UnStopSleep(t);
        }
        if (ReverseMessage.Reverse1.contains(t.getPlayer().getName())) {
            ReverseMessage twentyfour = new ReverseMessage();
            twentyfour.UnReverse(t);
        }
        if (Poop.Poop1.contains(t.getPlayer().getName())) {
            Poop twentyfive = new Poop();
            twentyfive.UnPoop(t);
        }
        if (RingOfFire.nuke1.contains(t.getPlayer().getName())) {
            RingOfFire twentyseven = new RingOfFire();
            twentyseven.UnNuke(t);
        }
        if (Control.controlled1.contains(t.getPlayer().getName())) {
            sndr.performCommand("control stop");
        }
            //next troll here
        }
    }