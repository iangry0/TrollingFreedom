package me.iangry.trollingfreedom.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import me.iangry.trollingfreedom.commands.*;
import me.iangry.trollingfreedom.commands.Void;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

public class TrollWithCMD
        implements CommandExecutor,
        TabCompleter {
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        String ags;

      String pl = args[0];
      Player t = Bukkit.getPlayer(pl);

        if (!sender.hasPermission("trollingfreedom.trollp")) {

            String message2 = (String) Core.instance.getConfig().get("no-perms");
            String replaced2 = message2.replace("&", "§").replace("%player%", sender.getName());
            sender.sendMessage(replaced2);
            return false;
        }
        if (args.length == 0) {
            String message1 = (String) Core.instance.getConfig().get("trollp-usage");
            String replaced1 = message1.replace("&", "§").replace("%player%", sender.getName());
            sender.sendMessage(replaced1);
            return false;
        }
        if (args.length == 1) {

            String message3 = (String)Core.instance.getConfig().get("trollp-usage");
            String replaced3 = message3.replace("&", "§").replace("%player%", sender.getName());
            sender.sendMessage(replaced3);
                return false;
            }
            //
            if (t == null) {
                String message4 = (String) Core.instance.getConfig().get("not-online");
                String replaced4 = message4.replace("&", "§").replace("%player%", args[0]);
                sender.sendMessage(replaced4);
                return false;
            }
        switch (ags = args.length > 1 ? args[1] : "") {
            case "afk": {
                AFK troll = new AFK();
                troll.FakeAFK(t);
                break;
            }
            case "unafk": {
                AFK troll2 = new AFK();
                troll2.FakeUnAFK(t);
                break;
            }
            case "entitydie": {
                AllEntitiesDie troll3 = new AllEntitiesDie();
                troll3.EntityDie(t);
                break;
            }
            case "annoy": {
                Annoy troll4 = new Annoy();
                troll4.Annoy(t);
                break;
            }
            case "anvildrop": {
                AnvilDrop troll5 = new AnvilDrop();
                troll5.Anvil(t);
                break;
            }
            case "aquaphobia": {
                Aquaphobia troll6 = new Aquaphobia();
                troll6.Aqua(t);
                break;
            }
            case "bedexplosion": {
                BedExplosion troll7 = new BedExplosion();
                troll7.BedExplosion(t);
                break;
            }
            case "bedmissing": {
                BedMissing troll8 = new BedMissing();
                troll8.BedMissing(t);
                break;
            }
            case "stopblockbreakplace": {
                Break troll9 = new Break();
                troll9.Break(t);
                break;
            }
            case "cage": {
                Cage troll10 = new Cage();
                troll10.Cage(t);
                break;
            }
            case "cavesounds": {
                CaveSounds troll11 = new CaveSounds();
                CaveSounds.CaveSound(t);
                break;
            }
            case "randomchat": {
                ChatChange troll12 = new ChatChange();
                troll12.ChatChange(t);
                break;
            }
            case "coffindance": {
                Coffin troll13 = new Coffin();
                troll13.CoffinStart(t);
                break;
            }
            case "credits": {
                Credits troll14 = new Credits();
                troll14.Credits(t);
                break;
            }
            case "entitymultiply": {
                EntityMultiply troll15 = new EntityMultiply();
                troll15.EntityMultiply(t);
                break;
            }
            case "creeperawman": {
                CreeperAwMan troll16 = new CreeperAwMan();
                try {
                    CreeperAwMan.Creeper(t);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            case "deafen": {
                Deafen troll17 = new Deafen();
                Deafen.Deafen(t);
                break;
            }
            case "demo": {
                Demo troll18 = new Demo();
                troll18.DemoMenu(t);
                break;
            }
            case "dropall": {
                DropAll troll19 = new DropAll();
                DropAll.DropAll(t);
                break;
            }
            case "explodingchicken": {
                ExplodingChicken trollpg2 = new ExplodingChicken();
                ExplodingChicken.Chicken(t);
                break;
            }
            case "explosivesheep": {
                ExplosiveSheep trollpg22 = new ExplosiveSheep();
                trollpg22.Sheep(t);
                break;
            }
            case "fakecrash": {
                FakeCrash trollpg23 = new FakeCrash();
                FakeCrash.FakeCrash(t);
                break;
            }
            case "fakereload": {
                FakeReload trollpg24 = new FakeReload();
                trollpg24.Reload(t);
                break;
            }
            case "forcejump": {
                ForceJump trollpg25 = new ForceJump();
                trollpg25.Jump(t);
                break;
            }
            case "freeze": {
                Freeze trollpg26 = new Freeze();
                trollpg26.Freeze(t);
                break;
            }
            case "herobrine": {
                Herobrine trollpg27 = new Herobrine();
                Herobrine.Herobrine(t);
                break;
            }
            case "hideallplayers": {
                HideAllPlayers trollpg28 = new HideAllPlayers();
                trollpg28.HideAll(t);
                break;
            }
            case "instatoolbreak": {
                InstaToolBreak trollpg29 = new InstaToolBreak();
                trollpg29.InstaToolBreak(t);
                break;
            }
            case "inventorystop": {
                InventoryStop trollpg210 = new InventoryStop();
                trollpg210.InventoryStop(t);
                break;
            }
            case "invsee": {
                Invsee trollpg211 = new Invsee();
                Invsee.Invsee(t);
                break;
            }
            case "kittycannon": {
                KittyCannon trollpg212 = new KittyCannon();
                trollpg212.KittyCannon(t);
                break;
            }
            case "lag": {
                Lag trollpg213 = new Lag();
                Lag.Lagg(t);
                break;
            }
            case "launch": {
                Launch trollpg214 = new Launch();
                Launch.Launch(t);
                break;
            }
            case "lightning": {
                Lightning trollpg215 = new Lightning();
                trollpg215.Lightning(t);
                break;
            }
            case "lockinventory": {
                LockInventory trollpg216 = new LockInventory();
                LockInventory.Lock(t);
                break;
            }
            case "nick": {
                NickWithoutEss trollpg217 = new NickWithoutEss();
                trollpg217.NickName(t);
                break;
            }
            case "fakeop": {
                OP trollpg218 = new OP();
                OP.FakeOP(t);
                break;
            }
            case "fakeunop": {
                OP trollpg219 = new OP();
                OP.FakeDeOP(t);
                break;
            }
            case "fakeclose": {
                FakeCrash trollpg3 = new FakeCrash();
                FakeCrash.FakeClosed(t);
                break;
            }
            case "fakeban": {
                FakeCrash trollpg32 = new FakeCrash();
                FakeCrash.FakeBan(t);
                break;
            }
            case "burn": {
                FakeCrash trollpg33 = new FakeCrash();
                FakeCrash.Burn(t);
                break;
            }
            case "potato": {
                Potato trollpg34 = new Potato();
                trollpg34.potato(t);
                break;
            }
            case "pumpkin": {
                Pumpkin trollpg35 = new Pumpkin();
                trollpg35.Pumpkin(t);
                break;
            }
            case "rainitems": {
                RainItems trollpg36 = new RainItems();
                trollpg36.RainItem(t);
                break;
            }
            case "randominv": {
                RandomInv trollpg37 = new RandomInv();
                trollpg37.RandomInv(t);
                break;
            }
            case "randomparticle": {
                RandomParticle trollpg38 = new RandomParticle();
                trollpg38.RandomParticle(t);
                break;
            }
            case "randomtp": {
                RandomTP trollpg39 = new RandomTP();
                RandomTP.RandomTP(t);
                break;
            }
            case "rickroll": {
                RickRoll trollpg310 = new RickRoll();
                trollpg310.RickRoll(t);
                break;
            }
            case "silverfish": {
                Silverfish trollpg311 = new Silverfish();
                Silverfish.Fish(t);
                break;
            }
            case "slenderman": {
                Slenderman trollpg312 = new Slenderman();
                trollpg312.Enderman(t);
                break;
            }
            case "slipperyhands": {
                SlipperyHands trollpg313 = new SlipperyHands();
                SlipperyHands.SlipperyHands(t);
                break;
            }
            case "sneakdestroy": {
                SneakDestroy trollpg314 = new SneakDestroy();
                trollpg314.SneakDestroy(t);
                break;
            }
            case "snowman": {
                Snowman trollpg315 = new Snowman();
                trollpg315.Snowman(t);
                break;
            }
            case "spin": {
                Spin trollpg316 = new Spin();
                Spin.Spin(t);
                break;
            }
            case "starve": {
                Starve trollpg317 = new Starve();
                trollpg317.Starve(t);
                break;
            }
            case "skyflash": {
                TimeFlash trollpg318 = new TimeFlash();
                trollpg318.SkyFlash(t);
                break;
            }
            case "fakenuke": {
                TNT trollpg319 = new TNT();
                TNT.FakeNuke(t);
                break;
            }
            case "ghastsound": {
                CaveSounds trollpg4 = new CaveSounds();
                CaveSounds.GhastSound(t);
                break;
            }
            case "nuke": {
                TNT trollpg42 = new TNT();
                trollpg42.Nuke(t);
                break;
            }
            case "tntplace": {
                TNTPlace trollpg43 = new TNTPlace();
                trollpg43.TNTPlace(t);
                break;
            }
            case "void": {
                Void trollpg44 = new Void();
                Void.Void(t);
                break;
            }
            case "vomit": {
                Vomit trollpg45 = new Vomit();
                trollpg45.Vomit(t);
                break;
            }
            case "worldloading": {
                WorldLoading trollpg46 = new WorldLoading();
                trollpg46.WorldLoading(t);
                break;
            }
            case "explodeonchat": {
                ExplodeOnChat trollpg47 = new ExplodeOnChat();
                ExplodeOnChat.Chat(t);
                break;
            }
            case "invert": {
                InvertWalk trollpg48 = new InvertWalk();
                InvertWalk.Invert(t);
                break;
            }
            case "inventoryrave": {
                InventoryRave trollpg49 = new InventoryRave();
                try {
                    trollpg49.InvRave(t);
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            case "bednight": {
                BedNight trollpg50 = new BedNight();
                trollpg50.BedNight(t);
                break;
            }
            case "bedmonster": {
                BedNight trollpg51 = new BedNight();
                trollpg51.BedMonster(t);
                break;
            }
            case "stopsleep": {
                BedNight trollpg52 = new BedNight();
                trollpg52.StopSleep(t);
                break;
            }
            case "freefall": {
                FreeFall trollpg53 = new FreeFall();
                trollpg53.FreeFall(t);
                break;
            }
            case "reversemessage": {
                ReverseMessage trollpg54 = new ReverseMessage();
                trollpg54.Reverse(t);
                break;
            }
            case "test": {
              Test trollpg55 = new Test();
            trollpg55.Test(t);
                break;
           }
            case "guardian": {
                Guardian trollpg56 = new Guardian();
                trollpg56.Guardian(t);
                break;
            }
            case "poop": {
                Poop trollpg57 = new Poop();
                trollpg57.Poop(t);
                break;
            }
            case "control": {
                String message2 = (String) Core.instance.getConfig().get("cannot-troll-yourself");
                String replaced2 = message2.replace("&", "§");
                if(t.equals(sender)) {
                    sender.sendMessage(replaced2);
                }
                else {
                    Player sendr = (Player) sender;
                    sendr.performCommand("control " + t.getName());
                }
                break;
            }
            case "ringoffire": {
                RingOfFire trollpg59 = new RingOfFire();
                trollpg59.Nuke(t);

                break;
            }
        }
        return false;
    }

    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        ArrayList<String> completions = new ArrayList<String>();
        ArrayList<String> commands = new ArrayList<String>();
        if (args.length == 1) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                commands.add(p.getName());
            }
            StringUtil.copyPartialMatches((String)args[0], commands, completions);
        } else if (args.length == 2) {
            if (!args[0].isEmpty()) {
                commands.add("afk");
                commands.add("unafk");
                commands.add("entitydie");
                commands.add("annoy");
                commands.add("anvildrop");
                commands.add("aquaphobia");
                commands.add("bedexplosion");
                commands.add("bedmissing");
                commands.add("stopblockbreakplace");
                commands.add("cage");
                commands.add("cavesounds");
                commands.add("randomchat");
                commands.add("coffindance");
                commands.add("credits");
                commands.add("entitymultiply");
                commands.add("creeperawman");
                commands.add("deafen");
                commands.add("demo");
                commands.add("dropall");
                commands.add("explodingchicken");
                commands.add("explosivesheep");
                commands.add("fakecrash");
                commands.add("fakereload");
                commands.add("forcejump");
                commands.add("freeze");
                commands.add("herobrine");
                commands.add("hideallplayers");
                commands.add("instatoolbreak");
                commands.add("inventorystop");
                commands.add("invsee");
                commands.add("kittycannon");
                commands.add("lag");
                commands.add("launch");
                commands.add("lightning");
                commands.add("lockinventory");
                commands.add("nick");
                commands.add("fakeop");
                commands.add("fakeunop");
                commands.add("fakeclose");
                commands.add("fakeban");
                commands.add("burn");
                commands.add("potato");
                commands.add("pumpkin");
                commands.add("rainitems");
                commands.add("randominv");
                commands.add("randomparticle");
                commands.add("randomtp");
                commands.add("rickroll");
                commands.add("silverfish");
                commands.add("slenderman");
                commands.add("slipperyhands");
                commands.add("sneakdestroy");
                commands.add("snowman");
                commands.add("spin");
                commands.add("starve");
                commands.add("skyflash");
                commands.add("fakenuke");
                commands.add("ghastsound");
                commands.add("nuke");
                commands.add("tntplace");
                commands.add("void");
                commands.add("vomit");
                commands.add("worldloading");
                commands.add("explodeonchat");
                commands.add("invert");
                commands.add("inventoryrave");
                commands.add("bednight");
                commands.add("bedmonster");
                commands.add("stopsleep");
                commands.add("freefall");
                commands.add("reversemessage");
                commands.add("guardian");
                commands.add("poop");
                commands.add("control");
                commands.add("ringoffire");
            }
            StringUtil.copyPartialMatches((String)args[1], commands, completions);
        }
        Collections.sort(completions);
        return completions;
    }
}