package me.iangry.trollingfreedom.other;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Consumer;

import java.util.function.BiConsumer;

public class ConfirmIH implements InventoryHolder, Listener {

    private Player p;
    private boolean backButton;
    private BiConsumer<Player, Boolean> bi;
    private Consumer<Player> c;
    private String question;
    private String title;
    private Material material;


    /**
     *
     * @param p Player to show the GUI
     * @param question Question to show
     * @param questio Material of a item that containing the question
     * @param backButton Whether to insert a third "back" button
     * @param true_false Block of code to execute
     * @param backbutton Block of code to execute for the "back" button
     * @param title Title of the GUI
     * @param plugin Plugin instance
     */

    public ConfirmIH(Player p, String question, Material questio, boolean backButton,
                     BiConsumer<Player, Boolean> true_false, Consumer<Player> backbutton, String title, Plugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);

        this.p = p;
        this.backButton = backButton;
        bi = true_false;
        c = backbutton;
        this.question = question;
        this.title = title;
        material = questio;
        p.openInventory(getInventory());

    }

    public ConfirmIH() {

    }

    @Override
    public Inventory getInventory() {

        Inventory inv = Bukkit.createInventory(this, 45, title);

        ItemStack questionItem = new ItemStack(material);
        ItemMeta m = questionItem.getItemMeta();
        m.setDisplayName(ChatColor.GOLD + question);
        questionItem.setItemMeta(m);

        ItemStack true_ = new ItemStack(Material.GREEN_STAINED_GLASS);
        m = true_.getItemMeta();
        m.setDisplayName(ChatColor.GREEN + "Yes");
        true_.setItemMeta(m);

        ItemStack false_ = new ItemStack(Material.RED_STAINED_GLASS);
        m = false_.getItemMeta();
        m.setDisplayName(ChatColor.RED + "No");
        false_.setItemMeta(m);

        ItemStack back = new ItemStack(Material.BARRIER);
        m = back.getItemMeta();
        m.setDisplayName(ChatColor.YELLOW + "Turn Back / Cancel");
        back.setItemMeta(m);

        inv.setItem(13, questionItem);
        inv.setItem(29, false_);
        inv.setItem(33, true_);
        if (backButton)
            inv.setItem(44, back);

        return inv;
    }

    @EventHandler
    private void onClick(InventoryClickEvent e) {

        if (e.getView().getTopInventory().getHolder() != this)

            return;

        e.setCancelled(true);

        if (e.getClickedInventory() == null || e.getCurrentItem() == null
                || e.getCurrentItem().getType() == Material.AIR)
            return;

        if (e.getClickedInventory().getHolder() != this)
            return;

        switch (e.getSlot()) {
            case 29:

                bi.accept(p, false);

                break;

            case 33:

                bi.accept(p, true);

                break;
            case 44:

                c.accept(p);
                break;

            default:
                break;
        }

    }

    @EventHandler
    private void onClose(InventoryCloseEvent e) {

        if (e.getInventory().getHolder() == this) {

            InventoryClickEvent.getHandlerList().unregister(this);
            InventoryCloseEvent.getHandlerList().unregister(this);

        }

    }

}