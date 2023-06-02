package me.iangry.trollingfreedom.ui;

import me.iangry.trollingfreedom.commands.*;
import me.iangry.trollingfreedom.other.xseries.XEnchantment;
import me.iangry.trollingfreedom.other.xseries.XMaterial;
import me.iangry.trollingfreedom.other.xseries.XSound;
import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import me.iangry.trollingfreedom.main.Core;

import java.io.IOException;
import java.util.*;

import static org.bukkit.Bukkit.getServer;

public class TrollInventory implements Listener, InventoryHolder {
    HashMap<String, String> launchedPlayers = new HashMap<String, String>();
    HashMap<String, String> clearedFPlayers = new HashMap<String, String>();
    //HashMaps for Toggabels
    private final Inventory inv;
    static TrollInventory main;
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
    public TrollInventory(Player vic) {

        VictimPlayer = vic;
        main = this;
        Bukkit.getPluginManager().registerEvents(this, Core.instance);
        // Create a new inventory, with "this" owner for comparison with other inventories, a size of nine, called example
        inv = Bukkit.createInventory(this, 45, centerTitle(Core.getPathCC("menu.menu-title")));
        // Put the items into the inventory
        initializeItems();

    }
    //To use method beyond this codeA
    public static TrollInventory getGUI() {
        return main;
    }
    public static HashMap getMaps(String maps) {
        switch (maps) {
            case "LP":
                return TrollInventory.getGUI().launchedPlayers;
            case "cFP":
                return TrollInventory.getGUI().clearedFPlayers;
        }
        // FrZLayers... creative.
        return null;
    }
    @Override
    public Inventory getInventory() {
        return inv;
    }

    // You can call this whenever you want to put the items in

    ItemStack mainPage = createGuiItem(XMaterial.REDSTONE_BLOCK, true, Core.getPathCC("items.Playerselector-name"), Core.getPathCC("items.Playerselector-lore"));

    ItemStack unTroll = createGuiItem(XMaterial.BARRIER, true, Core.getPathCC("items.Untroll-name"), Core.getPathCC("items.Untroll-lore"));

    ItemStack secondPage = createGuiItem(XMaterial.ARROW, true, Core.getPathCC("items.nextpage-name"), Core.getPathCC("items.nextpage-lore"));
    public void initializeItems() {
        ItemStack plc = new ItemStack(XMaterial.CYAN_STAINED_GLASS_PANE.parseMaterial(), 1);
        ItemMeta meta = plc.getItemMeta();
        meta.setDisplayName(" ");
        plc.setItemMeta(meta);
        for(Integer i = 0; i < 45; i++){
            inv.setItem(i, plc);
        }
        inv.setItem(10,createGuiItem(XMaterial.WHITE_WOOL, false, Core.tcc(Core.instance.getConfig().getString("items.afk-name")), Core.tcc(Core.instance.getConfig().getString("items.afk-lore"))));
        inv.setItem(11,createGuiItem(XMaterial.RED_WOOL, false, Core.tcc(Core.instance.getConfig().getString("items.unafk-name")), Core.tcc(Core.instance.getConfig().getString("items.unafk-lore"))));
        inv.setItem(12,createGuiItem(XMaterial.DIAMOND_SWORD, false, Core.tcc(Core.instance.getConfig().getString("items.entitydie-name")), Core.tcc(Core.instance.getConfig().getString("items.entitydie-lore"))));
        inv.setItem(13,createGuiItem(XMaterial.VILLAGER_SPAWN_EGG, false, Core.tcc(Core.instance.getConfig().getString("items.annoy-name")), Core.tcc(Core.instance.getConfig().getString("items.annoy-lore"))));
        inv.setItem(14,createGuiItem(XMaterial.ANVIL, false, Core.tcc(Core.instance.getConfig().getString("items.anvildrop-name")), Core.tcc(Core.instance.getConfig().getString("items.anvildrop-lore"))));
        inv.setItem(15,createGuiItem(XMaterial.WATER_BUCKET, false, Core.tcc(Core.instance.getConfig().getString("items.aquaphobia-name")), Core.tcc(Core.instance.getConfig().getString("items.aquaphobia-lore"))));
        inv.setItem(16,createGuiItem(XMaterial.WHITE_BED, false, Core.tcc(Core.instance.getConfig().getString("items.bedexplosion-name")), Core.tcc(Core.instance.getConfig().getString("items.bedexplosion-lore"))));
        inv.setItem(19,createGuiItem(XMaterial.RED_BED, false, Core.tcc(Core.instance.getConfig().getString("items.bedmissing-name")), Core.tcc(Core.instance.getConfig().getString("items.bedmissing-lore"))));
        inv.setItem(20,createGuiItem(XMaterial.WOODEN_PICKAXE, false, Core.tcc(Core.instance.getConfig().getString("items.break-name")), Core.tcc(Core.instance.getConfig().getString("items.break-lore"))));
        inv.setItem(21,createGuiItem(XMaterial.GLASS, false, Core.tcc(Core.instance.getConfig().getString("items.cage-name")), Core.tcc(Core.instance.getConfig().getString("items.cage-lore"))));
        inv.setItem(22,createGuiItem(XMaterial.STONE, false, Core.tcc(Core.instance.getConfig().getString("items.cavesounds-name")), Core.tcc(Core.instance.getConfig().getString("items.cavesounds-lore"))));
        inv.setItem(23,createGuiItem(XMaterial.PAPER, false, Core.tcc(Core.instance.getConfig().getString("items.chatchange-name")), Core.tcc(Core.instance.getConfig().getString("items.chatchange-lore"))));
        inv.setItem(24,createGuiItem(XMaterial.WITHER_SKELETON_SKULL,false,  Core.tcc(Core.instance.getConfig().getString("items.coffin-name")), Core.tcc(Core.instance.getConfig().getString("items.coffin-lore"))));
        inv.setItem(25,createGuiItem(XMaterial.IRON_BARS,false,  Core.tcc(Core.instance.getConfig().getString("items.credits-name")), Core.tcc(Core.instance.getConfig().getString("items.credits-lore"))));
        inv.setItem(29,createGuiItem(XMaterial.CARROT,false,  Core.tcc(Core.instance.getConfig().getString("items.entitymultiply-name")), Core.tcc(Core.instance.getConfig().getString("items.entitymultiply-lore"))));
        inv.setItem(30,createGuiItem(XMaterial.CREEPER_HEAD,false,  Core.tcc(Core.instance.getConfig().getString("items.creeperawman-name")), Core.tcc(Core.instance.getConfig().getString("items.creeperawman-lore"))));
        inv.setItem(31,createGuiItem(XMaterial.PAPER,false,  Core.tcc(Core.instance.getConfig().getString("items.deafen-name")), Core.tcc(Core.instance.getConfig().getString("items.deafen-lore"))));
        inv.setItem(32,createGuiItem(XMaterial.IRON_BARS,false,  Core.tcc(Core.instance.getConfig().getString("items.demo-name")), Core.tcc(Core.instance.getConfig().getString("items.demo-lore"))));
        inv.setItem(33,createGuiItem(XMaterial.ICE,false,  Core.tcc(Core.instance.getConfig().getString("items.dropall-name")), Core.tcc(Core.instance.getConfig().getString("items.dropall-lore"))));

        inv.setItem(36, mainPage);

        inv.setItem(40, unTroll);

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
        if(VictimPlayer != null){
            if(e.getSlot() < 45){
                switch(e.getRawSlot()){
                    case 10:
                        AFK troll = new AFK();
                        troll.FakeAFK(VictimPlayer);
                        break;
                    case 11:
                        AFK troll2 = new AFK();
                        troll2.FakeUnAFK(VictimPlayer);
                        break;
                    case 12:
                        AllEntitiesDie troll3 = new AllEntitiesDie();
                        troll3.EntityDie(VictimPlayer);
                        break;
                    case 13:
                        Annoy troll4 = new Annoy();
                        troll4.Annoy(VictimPlayer);
                        break;
                    case 14:
                        AnvilDrop troll5 = new AnvilDrop();
                        troll5.Anvil(VictimPlayer);
                        break;
                    case 15:
                        Aquaphobia troll6 = new Aquaphobia();
                        troll6.Aqua(VictimPlayer);
                        break;
                    case 16:
                        BedExplosion troll7 = new BedExplosion();
                        troll7.BedExplosion(VictimPlayer);
                        break;
                    case 19:
                        BedMissing troll8 = new BedMissing();
                        troll8.BedMissing(VictimPlayer);
                        break;
                    case 20:
                        Break troll9 = new Break();
                        troll9.Break(VictimPlayer);
                        break;
                    case 21:
                        Cage troll10 = new Cage();
                        troll10.Cage(VictimPlayer);
                        break;
                    case 22:
                        CaveSounds troll11 = new CaveSounds();
                        troll11.CaveSound(VictimPlayer);
                        break;
                    case 23:
                        ChatChange troll12 = new ChatChange();
                        troll12.ChatChange(VictimPlayer);
                        break;
                    case 24:
                        Coffin troll13 = new Coffin();
                        troll13.CoffinStart(VictimPlayer);
                        break;
                    case 25:
                        Credits troll14 = new Credits();
                        troll14.Credits(VictimPlayer);
                        break;
                    case 29:
                        EntityMultiply troll15 = new EntityMultiply();
                        troll15.EntityMultiply(VictimPlayer);
                        break;
                    case 30:
                        CreeperAwMan troll16 = new CreeperAwMan();
                        troll16.Creeper(VictimPlayer);
                        break;
                    case 31:
                        Deafen troll17 = new Deafen();
                        troll17.Deafen(VictimPlayer);
                        break;
                    case 32:
                        if (Bukkit.getVersion().contains("1.18")) {
                            Demo troll18 = new Demo();
                            troll18.DemoMenu(VictimPlayer);
                        }
                        else {
                            p.sendMessage("§3TF§8: §7If this troll did not work");
                            p.sendMessage("§3TF§8: §7then please make sure you are on the ");
                            p.sendMessage("§3TF§8: §7latest version of Minecraft");
                            Demo troll18 = new Demo();
                            troll18.DemoMenu(VictimPlayer);
                        }

                        break;
                    case 33:
                        DropAll troll19 = new DropAll();
                        troll19.DropAll(VictimPlayer);
                        break;
                    case 36:
                        PlayerSelectorInventory ps = new PlayerSelectorInventory();
                        ps.openSel(p);
                        break;
                    case 40:
                        UnTroll stoptroll = new UnTroll();
                        stoptroll.StopTrolls(VictimPlayer, p);

                        String message2 = (String) Core.instance.getConfig().get("untrolled");
                        String replaced2 = message2.replace("&", "§").replace("%player%", VictimPlayer.getPlayer().getName());
                        p.sendMessage(replaced2);
                        break;
                    case 44:
                                TrollInventory2 sp = new TrollInventory2(VictimPlayer.getPlayer());
                                sp.openInventory(p);
                        break;
                }
            }
        }
    }
}

