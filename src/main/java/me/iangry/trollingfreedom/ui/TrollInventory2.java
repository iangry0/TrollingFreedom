package me.iangry.trollingfreedom.ui;

import me.iangry.trollingfreedom.commands.*;
import me.iangry.trollingfreedom.main.Core;
import me.iangry.trollingfreedom.other.ConfirmIH;
import me.iangry.trollingfreedom.other.xseries.XEnchantment;
import me.iangry.trollingfreedom.other.xseries.XMaterial;
import org.bukkit.*;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Consumer;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.BiConsumer;

public class TrollInventory2 implements Listener, InventoryHolder {
    HashMap<String, String> launchedPlayers = new HashMap<String, String>();
    HashMap<String, String> clearedFPlayers = new HashMap<String, String>();
    //HashMaps for Toggabels
    private final Inventory inv;
    static TrollInventory2 main;
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
    public TrollInventory2(Player vic) {

        VictimPlayer = vic;
        main = this;
        Bukkit.getPluginManager().registerEvents(this, Core.instance);
        // Create a new inventory, with "this" owner for comparison with other inventories, a size of nine, called example
        inv = Bukkit.createInventory(this, 45, centerTitle(Core.getPathCC("menu.menu-title")));
        // Put the items into the inventory
        initializeItems();

    }
    //To use method beyond this codeA
    public static TrollInventory2 getGUI() {
        return main;
    }
    public static HashMap getMaps(String maps) {
        switch (maps) {
            case "LP":
                return TrollInventory2.getGUI().launchedPlayers;
            case "cFP":
                return TrollInventory2.getGUI().clearedFPlayers;
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

        inv.setItem(10,createGuiItem(XMaterial.CHICKEN, false, Core.tcc(Core.instance.getConfig().getString("items.explodingchicken-name")), Core.tcc(Core.instance.getConfig().getString("items.explodingchicken-lore"))));
        inv.setItem(11,createGuiItem(XMaterial.MUTTON, false, Core.tcc(Core.instance.getConfig().getString("items.explosivesheep-name")), Core.tcc(Core.instance.getConfig().getString("items.explosivesheep-lore"))));
        inv.setItem(12,createGuiItem(XMaterial.TNT_MINECART, false, Core.tcc(Core.instance.getConfig().getString("items.fakecrash-name")), Core.tcc(Core.instance.getConfig().getString("items.fakecrash-lore"))));
        inv.setItem(13,createGuiItem(XMaterial.DEBUG_STICK, false, Core.tcc(Core.instance.getConfig().getString("items.fakereload-name")), Core.tcc(Core.instance.getConfig().getString("items.fakereload-lore"))));
        inv.setItem(14,createGuiItem(XMaterial.LINGERING_POTION, false, Core.tcc(Core.instance.getConfig().getString("items.forcejump-name")), Core.tcc(Core.instance.getConfig().getString("items.forcejump-lore"))));
        inv.setItem(15,createGuiItem(XMaterial.SOUL_SAND, false, Core.tcc(Core.instance.getConfig().getString("items.freeze-name")), Core.tcc(Core.instance.getConfig().getString("items.freeze-lore"))));
        inv.setItem(16,createGuiItem(XMaterial.PLAYER_HEAD, false, Core.tcc(Core.instance.getConfig().getString("items.herobrine-name")), Core.tcc(Core.instance.getConfig().getString("items.herobrine-lore"))));
        inv.setItem(19,createGuiItem(XMaterial.PLAYER_HEAD, false, Core.tcc(Core.instance.getConfig().getString("items.hideallplayers-name")), Core.tcc(Core.instance.getConfig().getString("items.hideallplayers-lore"))));
        inv.setItem(20,createGuiItem(XMaterial.GOLDEN_PICKAXE, false, Core.tcc(Core.instance.getConfig().getString("items.instatoolbreak-name")), Core.tcc(Core.instance.getConfig().getString("items.instatoolbreak-lore"))));
        inv.setItem(21,createGuiItem(XMaterial.CHEST, false, Core.tcc(Core.instance.getConfig().getString("items.inventorystop-name")), Core.tcc(Core.instance.getConfig().getString("items.inventorystop-lore"))));
        inv.setItem(22,createGuiItem(XMaterial.CHEST, false, Core.tcc(Core.instance.getConfig().getString("items.invsee-name")), Core.tcc(Core.instance.getConfig().getString("items.invsee-lore"))));
        inv.setItem(23,createGuiItem(XMaterial.CAT_SPAWN_EGG, false, Core.tcc(Core.instance.getConfig().getString("items.kittycannon-name")), Core.tcc(Core.instance.getConfig().getString("items.kittycannon-lore"))));
        inv.setItem(24,createGuiItem(XMaterial.COBWEB,false,  Core.tcc(Core.instance.getConfig().getString("items.lag-name")), Core.tcc(Core.instance.getConfig().getString("items.lag-lore"))));
        inv.setItem(25,createGuiItem(XMaterial.WATER_BUCKET,false,  Core.tcc(Core.instance.getConfig().getString("items.launch-name")), Core.tcc(Core.instance.getConfig().getString("items.launch-lore"))));
        inv.setItem(29,createGuiItem(XMaterial.FLINT_AND_STEEL,false,  Core.tcc(Core.instance.getConfig().getString("items.lightning-name")), Core.tcc(Core.instance.getConfig().getString("items.lightning-lore"))));
        inv.setItem(30,createGuiItem(XMaterial.CHEST,false,  Core.tcc(Core.instance.getConfig().getString("items.lockinventory-name")), Core.tcc(Core.instance.getConfig().getString("items.lockinventory-lore"))));
        inv.setItem(31,createGuiItem(XMaterial.NAME_TAG,false,  Core.tcc(Core.instance.getConfig().getString("items.nick-name")), Core.tcc(Core.instance.getConfig().getString("items.nick-lore"))));
        inv.setItem(32,createGuiItem(XMaterial.DIAMOND_BLOCK,false,  Core.tcc(Core.instance.getConfig().getString("items.op-name")), Core.tcc(Core.instance.getConfig().getString("items.op-lore"))));
        inv.setItem(33,createGuiItem(XMaterial.COAL_BLOCK,false,  Core.tcc(Core.instance.getConfig().getString("items.unop-name")), Core.tcc(Core.instance.getConfig().getString("items.unop-lore"))));

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
                        ExplodingChicken troll = new ExplodingChicken();
                        troll.Chicken(VictimPlayer);
                        break;
                    case 11:
                        ExplosiveSheep troll2 = new ExplosiveSheep ();
                        troll2.Sheep(VictimPlayer);
                        break;
                    case 12:
                        FakeCrash troll3 = new FakeCrash();
                        troll3.FakeCrash(VictimPlayer);
                        break;
                    case 13:
                        FakeReload troll4 = new FakeReload();
                        troll4.Reload(VictimPlayer);
                        break;
                    case 14:
                        ForceJump troll5 = new ForceJump();
                        troll5.Jump(VictimPlayer);
                        break;
                    case 15:
                        Freeze troll6 = new Freeze();
                        troll6.Freeze(VictimPlayer);
                        break;
                    case 16:
                        if(Bukkit.getServer().getPluginManager().getPlugin("Citizens") != null) {
                            Herobrine troll7 = new Herobrine();
                            troll7.Herobrine(VictimPlayer);
                        }
                        else {
                            p.sendMessage("§3TF§8: §7Please install Citizens for this troll to work");
                            p.sendMessage("§3TF§8: §7§nhttps://ci.citizensnpcs.co/job/citizens2/");
                        }
                        break;
                    case 19:
                        p.sendMessage("§b§lTF §8| §7Are you sure you want to §3§lhide all players §7from " + VictimPlayer.getName() + "?");

                        new ConfirmIH(p, "§7Confirm §3§lHide All Players §7On §l" + VictimPlayer.getName(), Material.TNT, true, new BiConsumer<Player, Boolean>() {

                            @Override
                            public void accept(Player p, Boolean bool) {

                                if (bool) {

                                    //code to execute if bool is true

                                    //p.sendMessage("true");
                                    HideAllPlayers troll8 = new HideAllPlayers();
                                    troll8.HideAll(VictimPlayer);
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
                        }, "§b§lTF §8| §7Confirm §3§lHide All", Core.instance);
                        break;
                    case 20:
                        InstaToolBreak troll9 = new InstaToolBreak();
                        troll9.InstaToolBreak(VictimPlayer);
                        break;
                    case 21:
                        InventoryStop troll10 = new InventoryStop();
                        troll10.InventoryStop(VictimPlayer);
                        break;
                    case 22:
                        Invsee troll11 = new Invsee();
                        troll11.Invsee(VictimPlayer);
                        break;
                    case 23:
                        KittyCannon troll12 = new KittyCannon();
                        troll12.KittyCannon(VictimPlayer);
                        break;
                    case 24:
                        Lag troll13 = new Lag();
                        troll13.Lagg(VictimPlayer);
                        break;
                    case 25:
                        Launch troll14 = new Launch();
                        troll14.Launch(VictimPlayer);
                        break;
                    case 29:
                        Lightning troll15 = new Lightning();
                        troll15.Lightning(VictimPlayer);
                        break;
                    case 30:
                        LockInventory troll16 = new LockInventory();
                        troll16.Lock(VictimPlayer);
                        break;
                    case 31:
                        if(Bukkit.getServer().getPluginManager().getPlugin("Essentials") != null) {
                            NickWithoutEss troll17 = new NickWithoutEss();
                            troll17.NickName(VictimPlayer);
                        }
                        else {
                            p.sendMessage("§3TF§8: §7Please install Essentials for this troll to work");
                            p.sendMessage("§3TF§8: §7§nhttps://www.spigotmc.org/resources/essentialsx.9089/");
                        }

                        break;
                    case 32:
                        OP troll18 = new OP();
                        troll18.FakeOP(VictimPlayer);
                        break;
                    case 33:
                        OP troll19 = new OP();
                        troll19.FakeDeOP(VictimPlayer);
                        break;
                    case 36:
                                TrollInventory sp1= new TrollInventory(VictimPlayer.getPlayer());
                                sp1.openInventory(p);
                        break;
                    case 40:
                        UnTroll stoptroll = new UnTroll();
                        stoptroll.StopTrolls(VictimPlayer, p);

                        String message2 = (String) Core.instance.getConfig().get("untrolled");
                        String replaced2 = message2.replace("&", "§").replace("%player%", VictimPlayer.getPlayer().getName());
                        p.sendMessage(replaced2);
                        break;
                    case 44:
                        TrollInventory3 sp = new TrollInventory3(VictimPlayer.getPlayer());
                        sp.openInventory(p);
                        break;
                }
            }
        }
    }
}

