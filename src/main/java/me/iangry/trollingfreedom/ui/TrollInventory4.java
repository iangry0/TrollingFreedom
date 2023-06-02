package me.iangry.trollingfreedom.ui;

import me.iangry.trollingfreedom.commands.*;
import me.iangry.trollingfreedom.commands.Void;
import me.iangry.trollingfreedom.main.Core;
import me.iangry.trollingfreedom.other.ConfirmIH;
import me.iangry.trollingfreedom.other.xseries.XEnchantment;
import me.iangry.trollingfreedom.other.xseries.XMaterial;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Consumer;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.BiConsumer;

public class TrollInventory4 implements Listener, InventoryHolder {

    HashMap<String, String> launchedPlayers = new HashMap<String, String>();
    HashMap<String, String> clearedFPlayers = new HashMap<String, String>();
    //HashMaps for Toggabels
    private final Inventory inv;
    static TrollInventory4 main;
    Player VictimPlayer;
    public String getNOU(Player p){
        return Core.uid()?p.getName():p.getUniqueId().toString();
    }
    public String centerTitle(String title) {
        StringBuilder result = new StringBuilder();
        int spaces = (27 - ChatColor.stripColor(title).length());

        for (int i = 0; i < spaces; i++) {
            result.append(" ");
        }

        return result.append(title).toString();
    }
    public TrollInventory4(Player vic) {

        VictimPlayer = vic;
        main = this;
        Bukkit.getPluginManager().registerEvents(this, Core.instance);
        // Create a new inventory, with "this" owner for comparison with other inventories, a size of nine, called example
        inv = Bukkit.createInventory(this, 45, centerTitle(Core.getPathCC("menu.menu-title")));
        // Put the items into the inventory
        initializeItems();

    }
    //To use method beyond this codeA
    public static TrollInventory4 getGUI() {
        return main;
    }
    public static HashMap getMaps(String maps) {
        switch (maps) {
            case "LP":
                return TrollInventory4.getGUI().launchedPlayers;
            case "cFP":
                return TrollInventory4.getGUI().clearedFPlayers;
        }
        // FrZLayers... creative.
        return null;
    }
    @Override
    public Inventory getInventory() {
        return inv;
    }

    // You can call this whenever you want to put the items in

  //  ItemStack mainPage = createGuiItem(XMaterial.REDSTONE_BLOCK, true, Core.getPathCC("items.Playerselector-name"), Core.getPathCC("items.Playerselector-lore"));

    ItemStack unTroll = createGuiItem(XMaterial.BARRIER, true, Core.getPathCC("items.Untroll-name"), Core.getPathCC("items.Untroll-lore"));

    ItemStack secondPage = createGuiItem(XMaterial.ARROW, true, Core.getPathCC("items.nextpage-name"), Core.getPathCC("items.nextpage-lore"));

    ItemStack backPage = createGuiItem(XMaterial.ARROW, true, Core.getPathCC("items.backpage-name"), Core.getPathCC("items.backpage-lore"));

    public void initializeItems() {
        ItemStack plc = new ItemStack(XMaterial.CYAN_STAINED_GLASS_PANE.parseMaterial(), 1);
        ItemMeta meta = plc.getItemMeta();
        meta.setDisplayName(" ");
        plc.setItemMeta(meta);
        for(Integer i = 0; i < 45; i++){
            inv.setItem(i, plc);
        }

        inv.setItem(10,createGuiItem(XMaterial.GHAST_SPAWN_EGG, false, Core.tcc(Core.instance.getConfig().getString("items.ghastsound-name")), Core.tcc(Core.instance.getConfig().getString("items.ghastsound-lore"))));
        inv.setItem(11,createGuiItem(XMaterial.TNT, false, Core.tcc(Core.instance.getConfig().getString("items.nuke-name")), Core.tcc(Core.instance.getConfig().getString("items.nuke-lore"))));
        inv.setItem(12,createGuiItem(XMaterial.TNT, false, Core.tcc(Core.instance.getConfig().getString("items.tntplace-name")), Core.tcc(Core.instance.getConfig().getString("items.tntplace-lore"))));
        inv.setItem(13,createGuiItem(XMaterial.STRUCTURE_BLOCK, false, Core.tcc(Core.instance.getConfig().getString("items.void-name")), Core.tcc(Core.instance.getConfig().getString("items.void-lore"))));
        inv.setItem(14,createGuiItem(XMaterial.GREEN_WOOL, false, Core.tcc(Core.instance.getConfig().getString("items.vomit-name")), Core.tcc(Core.instance.getConfig().getString("items.vomit-lore"))));
        inv.setItem(15,createGuiItem(XMaterial.DIRT, false, Core.tcc(Core.instance.getConfig().getString("items.worldloading-name")), Core.tcc(Core.instance.getConfig().getString("items.worldloading-lore"))));
        inv.setItem(16,createGuiItem(XMaterial.PAPER, false, Core.tcc(Core.instance.getConfig().getString("items.explodeonchat-name")), Core.tcc(Core.instance.getConfig().getString("items.explodeonchat-lore"))));
        inv.setItem(19,createGuiItem(XMaterial.RED_STAINED_GLASS_PANE, false, Core.tcc(Core.instance.getConfig().getString("items.invrave-name")), Core.tcc(Core.instance.getConfig().getString("items.invrave-lore"))));
        inv.setItem(20,createGuiItem(XMaterial.LEATHER_BOOTS, false, Core.tcc(Core.instance.getConfig().getString("items.invert-name")), Core.tcc(Core.instance.getConfig().getString("items.invert-lore"))));
        inv.setItem(21,createGuiItem(XMaterial.BLACK_BED, false, Core.tcc(Core.instance.getConfig().getString("items.bednight-name")), Core.tcc(Core.instance.getConfig().getString("items.bednight-lore"))));
        inv.setItem(22,createGuiItem(XMaterial.GREEN_BED, false, Core.tcc(Core.instance.getConfig().getString("items.bedmonster-name")), Core.tcc(Core.instance.getConfig().getString("items.bedmonster-lore"))));
        inv.setItem(23,createGuiItem(XMaterial.BLUE_BED, false, Core.tcc(Core.instance.getConfig().getString("items.stopsleep-name")), Core.tcc(Core.instance.getConfig().getString("items.stopsleep-lore"))));
        inv.setItem(24,createGuiItem(XMaterial.WHITE_WOOL, false, Core.tcc(Core.instance.getConfig().getString("items.freefall-name")), Core.tcc(Core.instance.getConfig().getString("items.freefall-lore"))));
        inv.setItem(25,createGuiItem(XMaterial.PAPER, false, Core.tcc(Core.instance.getConfig().getString("items.reversemessage-name")), Core.tcc(Core.instance.getConfig().getString("items.reversemessage-lore"))));
        inv.setItem(29,createGuiItem(XMaterial.ELDER_GUARDIAN_SPAWN_EGG, false, Core.tcc(Core.instance.getConfig().getString("items.guardian-name")), Core.tcc(Core.instance.getConfig().getString("items.guardian-lore"))));
        inv.setItem(30,createGuiItem(XMaterial.COCOA_BEANS, false, Core.tcc(Core.instance.getConfig().getString("items.poop-name")), Core.tcc(Core.instance.getConfig().getString("items.poop-lore"))));
        inv.setItem(31,createGuiItem(XMaterial.CARROT_ON_A_STICK, false, Core.tcc(Core.instance.getConfig().getString("items.control-name")), Core.tcc(Core.instance.getConfig().getString("items.control-lore"))));
        inv.setItem(32,createGuiItem(XMaterial.FLINT_AND_STEEL, false, Core.tcc(Core.instance.getConfig().getString("items.ringoffire-name")), Core.tcc(Core.instance.getConfig().getString("items.ringoffire-lore"))));

        //inv.setItem(36, mainPage);

        inv.setItem(40, unTroll);

        inv.setItem(36, backPage);

        inv.setItem(44, secondPage);
    }

    protected ItemStack createGuiItem(final XMaterial XMaterial, final Boolean isEnchanted , final String name, final String... lore) {
        final ItemStack item = new ItemStack(XMaterial.parseMaterial(), 1);
        final ItemMeta meta = item.getItemMeta();

        // Set the name of the item
        meta.setDisplayName(name);
        if(isEnchanted){
            meta.addEnchant(XEnchantment.DURABILITY.parseEnchantment(), 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        // Set the lore of the item
        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);

        return item;
    }

    // You can open the inventory with this
    public void openInventory(final HumanEntity ent) {
        ent.openInventory(inv);
    }

    // Check for clicks on items
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) throws IOException {
        if (e.getInventory().getHolder() != this) return;
        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType() == XMaterial.AIR.parseMaterial()) return;

        final Player p = (Player) e.getWhoClicked();
        if (VictimPlayer != null) {
            if (e.getSlot() < 45) {
                switch (e.getRawSlot()) {
                    case 10:
                        CaveSounds troll = new CaveSounds();
                        troll.GhastSound(VictimPlayer);
                        break;
                    case 11:
                        p.sendMessage("§b§lTF §8| §7Are you sure you want to §c§lNUKE §7" + VictimPlayer.getName() + "?");
                        p.sendMessage("§b§lTF §8| §7This troll will blow stuff up a lot!");

                        new ConfirmIH(p, "§7Confirm §c§lNUKE §7on §l" + VictimPlayer.getName(), Material.TNT, true, new BiConsumer<Player, Boolean>() {

                            @Override
                            public void accept(Player p, Boolean bool) {

                                if (bool) {

                                    //code to execute if bool is true

                                    //p.sendMessage("true");
                                    TNT troll2 = new TNT();
                                    troll2.Nuke(VictimPlayer);
                                    p.closeInventory();
                                } else {
                                    //p.sendMessage("false");

                                    //code to execute if bool is false
                                    p.closeInventory();

                                }

                            }
                        }, new Consumer<Player>() {

                            @Override
                            public void accept(Player arg0) {
                                //code to execute for back buttok

                                // p.sendMessage("back");
                                TrollInventory4 sp2 = new TrollInventory4(VictimPlayer.getPlayer());
                                sp2.openInventory(p);

                            }
                        }, "§b§lTF §8| §7Confirm §c§lNUKE", Core.instance);
                        break;
                    case 12:
                        TNTPlace troll3 = new TNTPlace();
                        troll3.TNTPlace(VictimPlayer);
                        break;
                    case 13:
                        Void troll4 = new Void();
                        troll4.Void(VictimPlayer);
                        break;
                    case 14:
                        Vomit troll5 = new Vomit();
                        troll5.Vomit(VictimPlayer);
                        break;
                    case 15:
                        p.sendMessage("§b§lTF §8| §7Are you sure you want to start §7world loading §7" + VictimPlayer.getName() + "?");
                        p.sendMessage("§b§lTF §8| §7They may not be able to exit out of this until they leave the game");

                        new ConfirmIH(p, "§7Confirm §7world loading §7on §l" + VictimPlayer.getName(), Material.DIRT, true, new BiConsumer<Player, Boolean>() {

                            @Override
                            public void accept(Player p, Boolean bool) {

                                if (bool) {

                                    //code to execute if bool is true

                                    //p.sendMessage("true");
                                    WorldLoading troll6 = new WorldLoading();
                                    troll6.WorldLoading(VictimPlayer);

                                } else {
                                    //p.sendMessage("false");

                                    //code to execute if bool is false
                                    p.closeInventory();

                                }

                            }
                        }, new Consumer<Player>() {

                            @Override
                            public void accept(Player arg0) {
                                //code to execute for back buttok

                                // p.sendMessage("back");
                                TrollInventory4 sp2 = new TrollInventory4(VictimPlayer.getPlayer());
                                sp2.openInventory(p);

                            }
                        }, "§b§lTF §8| §7Confirm §7World Loading", Core.instance);
                        break;
                    case 16:
                        ExplodeOnChat troll7 = new ExplodeOnChat();
                        troll7.Chat(VictimPlayer);
                        break;
                    case 19:
                        InventoryRave troll8 = new InventoryRave();
                        troll8.InvRave(VictimPlayer);
                        break;
                    case 20:
                        InvertWalk troll9 = new InvertWalk();
                        troll9.Invert(VictimPlayer);
                        break;
                    case 21:
                        BedNight troll10 = new BedNight();
                        troll10.BedNight(VictimPlayer);
                        break;
                    case 22:
                        BedNight troll11 = new BedNight();
                        troll11.BedMonster(VictimPlayer);
                        break;
                    case 23:
                        BedNight troll12 = new BedNight();
                        troll12.StopSleep(VictimPlayer);
                        break;
                    case 24:
                        FreeFall troll13 = new FreeFall();
                        troll13.FreeFall(VictimPlayer);
                        break;
                    case 25:
                        ReverseMessage troll14 = new ReverseMessage();
                        troll14.Reverse(VictimPlayer);
                        break;
                    case 29:
                        Guardian troll15 = new Guardian();
                        troll15.Guardian(VictimPlayer);
                        break;
                    case 30:
                        Poop troll16 = new Poop();
                        troll16.Poop(VictimPlayer);
                        break;
                    case 31:
                        String message12 = (String) Core.instance.getConfig().get("cannot-troll-yourself");
                        String replaced12 = message12.replace("&", "§");
                        if (p.equals(VictimPlayer)) {
                            p.sendMessage(replaced12);
                        } else {
                            p.performCommand("control " + VictimPlayer.getName());
                        }
                        break;
                    case 32:
                        RingOfFire troll18 = new RingOfFire();
                        troll18.Nuke(VictimPlayer);
                    case 36:
                        TrollInventory3 sp = new TrollInventory3(VictimPlayer.getPlayer());
                        sp.openInventory(p);
                        break;
                    case 40:
                        UnTroll stoptroll = new UnTroll();
                        stoptroll.StopTrolls(VictimPlayer, p);

                        String message2 = (String) Core.instance.getConfig().get("untrolled");
                        String replaced2 = message2.replace("&", "§").replace("%player%", VictimPlayer.getPlayer().getName());
                        p.sendMessage(replaced2);
                        break;
                    case 44:
                        TrollInventory4 sp2 = new TrollInventory4(VictimPlayer.getPlayer());
                        sp2.openInventory(p);
                        break;
                }
            }
        }
    }
}

