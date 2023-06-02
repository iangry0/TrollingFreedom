package me.iangry.trollingfreedom.ui;

import me.iangry.trollingfreedom.commands.*;
import me.iangry.trollingfreedom.main.Core;
import me.iangry.trollingfreedom.other.xseries.XEnchantment;
import me.iangry.trollingfreedom.other.xseries.XMaterial;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class TrollInventory3 implements Listener, InventoryHolder {
    HashMap<String, String> launchedPlayers = new HashMap<String, String>();
    HashMap<String, String> clearedFPlayers = new HashMap<String, String>();
    //HashMaps for Toggabels
    private final Inventory inv;
    static TrollInventory3 main;
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
    public TrollInventory3(Player vic) {

        VictimPlayer = vic;
        main = this;
        Bukkit.getPluginManager().registerEvents(this, Core.instance);
        // Create a new inventory, with "this" owner for comparison with other inventories, a size of nine, called example
        inv = Bukkit.createInventory(this, 45, centerTitle(Core.getPathCC("menu.menu-title")));
        // Put the items into the inventory
        initializeItems();

    }
    //To use method beyond this codeA
    public static TrollInventory3 getGUI() {
        return main;
    }
    public static HashMap getMaps(String maps) {
        switch (maps) {
            case "LP":
                return TrollInventory3.getGUI().launchedPlayers;
            case "cFP":
                return TrollInventory3.getGUI().clearedFPlayers;
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

        inv.setItem(10,createGuiItem(XMaterial.OAK_DOOR, false, Core.tcc(Core.instance.getConfig().getString("items.fakeclose-name")), Core.tcc(Core.instance.getConfig().getString("items.fakeclose-lore"))));
        inv.setItem(11,createGuiItem(XMaterial.IRON_DOOR, false, Core.tcc(Core.instance.getConfig().getString("items.fakeban-name")), Core.tcc(Core.instance.getConfig().getString("items.fakeban-lore"))));
        inv.setItem(12,createGuiItem(XMaterial.FLINT_AND_STEEL, false, Core.tcc(Core.instance.getConfig().getString("items.burn-name")), Core.tcc(Core.instance.getConfig().getString("items.burn-lore"))));
        inv.setItem(13,createGuiItem(XMaterial.POTATO, false, Core.tcc(Core.instance.getConfig().getString("items.potato-name")), Core.tcc(Core.instance.getConfig().getString("items.potato-lore"))));
        inv.setItem(14,createGuiItem(XMaterial.CARVED_PUMPKIN, false, Core.tcc(Core.instance.getConfig().getString("items.pumpkin-name")), Core.tcc(Core.instance.getConfig().getString("items.pumpkin-lore"))));
        inv.setItem(15,createGuiItem(XMaterial.DIRT, false, Core.tcc(Core.instance.getConfig().getString("items.rainitems-name")), Core.tcc(Core.instance.getConfig().getString("items.rainitems-lore"))));
        inv.setItem(16,createGuiItem(XMaterial.CHEST, false, Core.tcc(Core.instance.getConfig().getString("items.randominv-name")), Core.tcc(Core.instance.getConfig().getString("items.randominv-lore"))));
        inv.setItem(19,createGuiItem(XMaterial.REDSTONE, false, Core.tcc(Core.instance.getConfig().getString("items.randomparticle-name")), Core.tcc(Core.instance.getConfig().getString("items.randomparticle-lore"))));
        inv.setItem(20,createGuiItem(XMaterial.ENDER_PEARL, false, Core.tcc(Core.instance.getConfig().getString("items.randomtp-name")), Core.tcc(Core.instance.getConfig().getString("items.randomtp-lore"))));
        inv.setItem(21,createGuiItem(XMaterial.ENCHANTED_GOLDEN_APPLE, false, Core.tcc(Core.instance.getConfig().getString("items.rickroll-name")), Core.tcc(Core.instance.getConfig().getString("items.rickroll-lore"))));
        inv.setItem(22,createGuiItem(XMaterial.SILVERFISH_SPAWN_EGG, false, Core.tcc(Core.instance.getConfig().getString("items.silverfish-name")), Core.tcc(Core.instance.getConfig().getString("items.silverfish-lore"))));
        inv.setItem(23,createGuiItem(XMaterial.ENDERMAN_SPAWN_EGG, false, Core.tcc(Core.instance.getConfig().getString("items.slenderman-name")), Core.tcc(Core.instance.getConfig().getString("items.slenderman-lore"))));
        inv.setItem(24,createGuiItem(XMaterial.PACKED_ICE,false,  Core.tcc(Core.instance.getConfig().getString("items.slipperyhands-name")), Core.tcc(Core.instance.getConfig().getString("items.slipperyhands-lore"))));
        inv.setItem(25,createGuiItem(XMaterial.DIAMOND_PICKAXE,false,  Core.tcc(Core.instance.getConfig().getString("items.sneakdestroy-name")), Core.tcc(Core.instance.getConfig().getString("items.sneakdestroy-lore"))));
        inv.setItem(29,createGuiItem(XMaterial.PUMPKIN,false,  Core.tcc(Core.instance.getConfig().getString("items.snowman-name")), Core.tcc(Core.instance.getConfig().getString("items.snowman-lore"))));
        inv.setItem(30,createGuiItem(XMaterial.POTION,false,  Core.tcc(Core.instance.getConfig().getString("items.spin-name")), Core.tcc(Core.instance.getConfig().getString("items.spin-lore"))));
        inv.setItem(31,createGuiItem(XMaterial.POISONOUS_POTATO,false,  Core.tcc(Core.instance.getConfig().getString("items.starve-name")), Core.tcc(Core.instance.getConfig().getString("items.starve-lore"))));
        inv.setItem(32,createGuiItem(XMaterial.CLOCK,false,  Core.tcc(Core.instance.getConfig().getString("items.timeflash-name")), Core.tcc(Core.instance.getConfig().getString("items.timeflash-lore"))));
        inv.setItem(33,createGuiItem(XMaterial.TNT,false,  Core.tcc(Core.instance.getConfig().getString("items.tnt-name")), Core.tcc(Core.instance.getConfig().getString("items.tnt-lore"))));

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
        if(VictimPlayer != null){
            if(e.getSlot() < 45){
                switch(e.getRawSlot()){
                    case 10:
                        FakeCrash troll = new FakeCrash();
                        troll.FakeClosed(VictimPlayer);
                        break;
                    case 11:
                        FakeCrash troll2 = new FakeCrash();
                        troll2.FakeBan(VictimPlayer);
                        break;
                    case 12:
                        FakeCrash troll3 = new FakeCrash();
                        troll3.Burn(VictimPlayer);
                        break;
                    case 13:
                        Potato troll4 = new Potato();
                        troll4.potato(VictimPlayer);
                        break;
                    case 14:
                        Pumpkin troll5 = new Pumpkin();
                        troll5.Pumpkin(VictimPlayer);
                        break;
                    case 15:
                        RainItems troll6 = new RainItems();
                        troll6.RainItem(VictimPlayer);
                        break;
                    case 16:
                        RandomInv troll7 = new RandomInv();
                        troll7.RandomInv(VictimPlayer);
                        break;
                    case 19:
                        RandomParticle troll8 = new RandomParticle();
                        troll8.RandomParticle(VictimPlayer);
                        break;
                    case 20:
                        RandomTP troll9 = new RandomTP();
                        troll9.RandomTP(VictimPlayer);
                        break;
                    case 21:
                        RickRoll troll10 = new RickRoll();
                        troll10.RickRoll(VictimPlayer);
                        break;
                    case 22:
                        Silverfish troll11 = new Silverfish();
                        troll11.Fish(VictimPlayer);
                        break;
                    case 23:
                        Slenderman troll12 = new Slenderman();
                        troll12.Enderman(VictimPlayer);
                        break;
                    case 24:
                        SlipperyHands troll13 = new SlipperyHands();
                        troll13.SlipperyHands(VictimPlayer);
                        break;
                    case 25:
                        SneakDestroy troll14 = new SneakDestroy();
                        troll14.SneakDestroy(VictimPlayer);
                        break;
                    case 29:
                        Snowman troll15 = new Snowman();
                        troll15.Snowman(VictimPlayer);
                        break;
                    case 30:
                        Spin troll16 = new Spin();
                        troll16.Spin(VictimPlayer);
                        break;
                    case 31:
                        Starve troll17 = new Starve();
                        troll17.Starve(VictimPlayer);
                        break;
                    case 32:
                        TimeFlash troll18 = new TimeFlash();
                        troll18.SkyFlash(VictimPlayer);
                        break;
                    case 33:
                        TNT troll19 = new TNT();
                        troll19.FakeNuke(VictimPlayer);
                        break;
                    case 36:
                        TrollInventory2 sp = new TrollInventory2(VictimPlayer.getPlayer());
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

