package me.iangry.trollingfreedom.main;

import me.iangry.trollingfreedom.commands.*;
import me.iangry.trollingfreedom.commands.Void;
import me.iangry.trollingfreedom.other.*;
import me.iangry.trollingfreedom.other.xseries.XEnchantment;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandMap;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.permissions.ServerOperator;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;


public class Core extends JavaPlugin implements Listener {


    public FileConfiguration config = getConfig();
    static Boolean usingUUID = false;
    public static String version;
    private File file = null;

    public static Core instance;

    public Core() {

        if ((instance) == null)
            instance = this;

    }


    public static String tcc(String i) {
        i = ChatColor.translateAlternateColorCodes('&', i);
        return i;
    }

    @Override
    public void reloadConfig() {
        super.reloadConfig();
        saveDefaultConfig();
        config = getConfig();
        config.options().copyDefaults(true);
    }

    public static Boolean uid() {
        return usingUUID;
    }

    public String getServerVersion() {
        return Bukkit.getServer().getVersion().split("MC: ")[1].replaceAll("\\)", "").trim();
    }

    public ItemStack getSkull() {
        ItemStack skull = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGY0YzY3MzZjYjFjNjg4MGQ4MGEyMDYyZDdhYTRhYWIxZWEwYzU1YmYxNDJhZDMwZmQ1MmM1NzUxNWYwYzJkMSJ9fX0=");
        ItemMeta skullmeta = skull.getItemMeta();
        skullmeta.setDisplayName("§b§lTrolling§3§lFreedom §7| §bTroll GUI");
        skullmeta.setLore(Arrays.asList("§0§k000000000", "§7§k777777", "§9§k999999", "§a§k§l133742069YEET!"));
        skullmeta.addEnchant(XEnchantment.DURABILITY.parseEnchantment(), 1, false);
        skullmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        skull.setItemMeta(skullmeta);
        return skull;
    }


    @Override
    public void onEnable() {

        if (getConfig().getBoolean("values.dependency-downloader") == true) {
            try {
                DependencyChecker chk = new DependencyChecker();
                chk.DependencyChecker();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (getConfig().getBoolean("values.dependency-downloader") == false) {
                return;
            }
        }

        getCommand("trollingfreedom").setExecutor(new Help());
        getCommand("untroll").setExecutor(new UnTroll());

        getCommand("control").setExecutor(new Control());

        version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        Bukkit.getServer().getPluginManager().registerEvents(new EventListener(), this);
        getCommand("trollp").setExecutor(new TrollWithCMD());
        getCommand("trollp").setTabCompleter(new TrollWithCMD());



        getCommand("trollgui").setExecutor(new TrollGUIAlias());

        getServer().getPluginManager().registerEvents(new AFK(), this);
        getServer().getPluginManager().registerEvents(new OP(), this);
        getServer().getPluginManager().registerEvents(new Demo(), this);
        getServer().getPluginManager().registerEvents(new TNT(), this);
        getServer().getPluginManager().registerEvents(new Credits(), this);
        getServer().getPluginManager().registerEvents(new Freeze(), this);
        getServer().getPluginManager().registerEvents(new Spin(), this);
        getServer().getPluginManager().registerEvents(new Launch(), this);
        getServer().getPluginManager().registerEvents(new Herobrine(), this);
        getServer().getPluginManager().registerEvents(new FakeCrash(), this);
        getServer().getPluginManager().registerEvents(new Break(), this);
        getServer().getPluginManager().registerEvents(new Potato(), this);
        getServer().getPluginManager().registerEvents(new Void(), this);
        getServer().getPluginManager().registerEvents(new Annoy(), this);
        getServer().getPluginManager().registerEvents(new Vomit(), this);
        getServer().getPluginManager().registerEvents(new WorldLoading(), this);
        getServer().getPluginManager().registerEvents(new Pumpkin(), this);
        getServer().getPluginManager().registerEvents(new CaveSounds(), this);
        getServer().getPluginManager().registerEvents(new AnvilDrop(), this);
        getServer().getPluginManager().registerEvents(new InventoryStop(), this);
        getServer().getPluginManager().registerEvents(new Slenderman(), this);
        getServer().getPluginManager().registerEvents(new CreeperAwMan(), this);
        getServer().getPluginManager().registerEvents(new Coffin(), this);
        getServer().getPluginManager().registerEvents(new DropAll(), this);
        getServer().getPluginManager().registerEvents(new Cage(), this);
        getServer().getPluginManager().registerEvents(new Starve(), this);
        getServer().getPluginManager().registerEvents(new ChatChange(), this);
        getServer().getPluginManager().registerEvents(new Invsee(), this);
        getServer().getPluginManager().registerEvents(new RandomTP(), this);
        getServer().getPluginManager().registerEvents(new Lightning(), this);
        getServer().getPluginManager().registerEvents(new HideAllPlayers(), this);
        getServer().getPluginManager().registerEvents(new TimeFlash(), this);
        getServer().getPluginManager().registerEvents(new TNTPlace(), this);
        getServer().getPluginManager().registerEvents(new Aquaphobia(), this);
        getServer().getPluginManager().registerEvents(new SlipperyHands(), this);
        getServer().getPluginManager().registerEvents(new LockInventory(), this);
        getServer().getPluginManager().registerEvents(new SneakDestroy(), this);
        getServer().getPluginManager().registerEvents(new InstaToolBreak(), this);
        getServer().getPluginManager().registerEvents(new EntityMultiply(), this);
        getServer().getPluginManager().registerEvents(new BedExplosion(), this);
        getServer().getPluginManager().registerEvents(new Lag(), this);
        getServer().getPluginManager().registerEvents(new FakeReload(), this);
        getServer().getPluginManager().registerEvents(new ExplodingChicken(), this);
        getServer().getPluginManager().registerEvents(new ExplosiveSheep(), this);
        getServer().getPluginManager().registerEvents(new MathUtils(), this);
        getServer().getPluginManager().registerEvents(new RickRoll(), this);
        getServer().getPluginManager().registerEvents(new RandomInv(), this);
        getServer().getPluginManager().registerEvents(new RandomParticle(), this);
        getServer().getPluginManager().registerEvents(new AllEntitiesDie(), this);
        getServer().getPluginManager().registerEvents(new ForceJump(), this);
        getServer().getPluginManager().registerEvents(new Deafen(), this);
        getServer().getPluginManager().registerEvents(new KittyCannon(), this);
        getServer().getPluginManager().registerEvents(new BedMissing(), this);
        getServer().getPluginManager().registerEvents(new ExplodeOnChat(), this);
        getServer().getPluginManager().registerEvents(new InventoryRave(), this);
        getServer().getPluginManager().registerEvents(new InvertWalk(), this);
        getServer().getPluginManager().registerEvents(new BedNight(), this);
        getServer().getPluginManager().registerEvents(new ReverseMessage(), this);
        getServer().getPluginManager().registerEvents(new RainItems(), this);
        getServer().getPluginManager().registerEvents(new Poop(), this);
        getServer().getPluginManager().registerEvents(new ConfirmIH(), this);
        getServer().getPluginManager().registerEvents(new Control(), this);
        getServer().getPluginManager().registerEvents(new RingOfFire(), this);

        super.onEnable();
        reloadConfig();
        usingUUID = getConfig().getBoolean("values.using-uuid");
        if (Integer.parseInt(getServerVersion().split("\\.")[1]) < 7) {
            usingUUID = false;
            this.getServer().getLogger().info("using UUID disable because server is version " + getServerVersion());
        }
        try {

            Field f = null;
            f = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            f.setAccessible(true);
            CommandMap commandMap = (CommandMap) f.get(Bukkit.getServer());

            new TrollCommand(commandMap, this);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            getLogger().severe(e.getLocalizedMessage());
            e.printStackTrace();
            this.getPluginLoader().disablePlugin(this);
        }
        usingUUID = getServer().getOnlineMode();


        new UpdateChecker(this, 53419).getVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                String message1 = (String) Core.instance.getConfig().get("trollingfreedom-console-no-update");
                String replaced1 = message1.replace("&", "§");
                getServer().getConsoleSender().sendMessage(replaced1);
            } else {
                getServer().getConsoleSender().sendMessage(ChatColor.RED + "=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                getServer().getConsoleSender().sendMessage(ChatColor.RED + "You are using an older version of §bTrolling§3§lFreedom");
                getServer().getConsoleSender().sendMessage(ChatColor.RED + "Download the newest version here:");
                getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "§nhttps://www.spigotmc.org/resources/.53419/");
                getServer().getConsoleSender().sendMessage(ChatColor.RED + "=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                Bukkit.getOnlinePlayers().stream().filter(ServerOperator::isOp).forEach(operator -> operator.sendMessage("§b§lTF §8| §7There is now a newer version of §bTrolling§3§lFreedom"));
                Bukkit.getOnlinePlayers().stream().filter(ServerOperator::isOp).forEach(operator -> operator.sendMessage("§7Please download the newest version here:"));
                Bukkit.getOnlinePlayers().stream().filter(ServerOperator::isOp).forEach(operator -> operator.sendMessage("§b§nhttps://www.spigotmc.org/resources/.53419/"));
            }
        });
    }

    public String getP() {
        return tcc(this.config.getString("prefix"));
    }

    public String getPrefixedMessage(String configPath) {
        return tcc(this.config.getString("prefix") + this.config.get(configPath));
    }

    public static String getPathCC(String path) {
        String c = Core.instance.getConfig().getString(path);
        assert c != null;
        c = ChatColor.translateAlternateColorCodes('&', c);
        return c;
    }

    public static Boolean advCheck(String perm, Player p) {
        if (instance.getConfig().getBoolean("values.advanced-perms.enabled")) {
            if (usingUUID) {
                OfflinePlayer pp = Bukkit.getPlayerExact(instance.getConfig().getString("values.advanced-perms.playername"));
                if (pp.isOnline() && pp.hasPlayedBefore()) {
                    return p.getUniqueId().equals(pp.getUniqueId());
                }
            } else {
                return p.getName().equals(instance.getConfig().getString("values.advanced-perms.playername"));
            }
        } else {
            return p.hasPermission(perm);
        }
        return false;
    }

    @Override
    public void onDisable() {

        this.getServer().getLogger().info("§b§lTrolling§3§lFreedom §7| §cDisabling");
        this.getServer().getLogger().info("§c§lDisabled");

    }
    }