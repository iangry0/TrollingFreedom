package me.iangry.trollingfreedom.commands;

import me.iangry.trollingfreedom.main.Core;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.util.EulerAngle;

import java.util.ArrayList;

public class Coffin implements Listener {

    int procedure = 0;

    public boolean chk(ArmorStand[] a) {
        for (int i = 0; i < 6; i++) {
            if (a[i].isDead()) {
                Bukkit.getServer().getScheduler().cancelTasks(Core.instance);

                for (Entity entity : a)
                    if (entity instanceof ArmorStand)
                        entity.remove();



                    return true;
                }
        }
        return false;
    }
    public void p1(ArmorStand[] a) {
        int i;
        for (i = 0; i < 3; i++) {
            a[i].setHeadPose(new EulerAngle(Math.toRadians(0.0D), Math.toRadians(0.0D), Math.toRadians(0.0D)));
            a[i].setLeftLegPose(new EulerAngle(Math.toRadians(30.0D), Math.toRadians(0.0D), Math.toRadians(0.0D)));
            a[i].setRightLegPose(new EulerAngle(Math.toRadians(330.0D), Math.toRadians(0.0D), Math.toRadians(0.0D)));
            a[i].setLeftArmPose(new EulerAngle(Math.toRadians(0.0D), Math.toRadians(0.0D), Math.toRadians(330.0D)));
            a[i].setRightArmPose(new EulerAngle(Math.toRadians(0.0D), Math.toRadians(0.0D), Math.toRadians(0.0D)));
        }
        for (i = 3; i < 6; i++) {
            a[i].setHeadPose(new EulerAngle(Math.toRadians(0.0D), Math.toRadians(0.0D), Math.toRadians(0.0D)));
            a[i].setLeftLegPose(new EulerAngle(Math.toRadians(30.0D), Math.toRadians(0.0D), Math.toRadians(0.0D)));
            a[i].setRightLegPose(new EulerAngle(Math.toRadians(330.0D), Math.toRadians(0.0D), Math.toRadians(0.0D)));
            a[i].setLeftArmPose(new EulerAngle(Math.toRadians(0.0D), Math.toRadians(0.0D), Math.toRadians(0.0D)));
            a[i].setRightArmPose(new EulerAngle(Math.toRadians(0.0D), Math.toRadians(0.0D), Math.toRadians(30.0D)));
        }
    }

    public void p2(ArmorStand[] a) {
        int i;
        for (i = 0; i < 3; i++) {
            a[i].setHeadPose(new EulerAngle(Math.toRadians(0.0D), Math.toRadians(0.0D), Math.toRadians(30.0D)));
            a[i].setLeftLegPose(new EulerAngle(Math.toRadians(330.0D), Math.toRadians(0.0D), Math.toRadians(0.0D)));
            a[i].setRightLegPose(new EulerAngle(Math.toRadians(30.0D), Math.toRadians(0.0D), Math.toRadians(0.0D)));
            a[i].setLeftArmPose(new EulerAngle(Math.toRadians(0.0D), Math.toRadians(0.0D), Math.toRadians(0.0D)));
            a[i].setRightArmPose(new EulerAngle(Math.toRadians(0.0D), Math.toRadians(0.0D), Math.toRadians(0.0D)));
        }
        for (i = 3; i < 6; i++) {
            a[i].setHeadPose(new EulerAngle(Math.toRadians(0.0D), Math.toRadians(0.0D), Math.toRadians(330.0D)));
            a[i].setLeftLegPose(new EulerAngle(Math.toRadians(330.0D), Math.toRadians(0.0D), Math.toRadians(0.0D)));
            a[i].setRightLegPose(new EulerAngle(Math.toRadians(30.0D), Math.toRadians(0.0D), Math.toRadians(0.0D)));
            a[i].setLeftArmPose(new EulerAngle(Math.toRadians(0.0D), Math.toRadians(0.0D), Math.toRadians(0.0D)));
            a[i].setRightArmPose(new EulerAngle(Math.toRadians(0.0D), Math.toRadians(0.0D), Math.toRadians(0.0D)));
        }
    }


    public boolean CoffinStart(Player p) {
        String p2 = p.getName();

        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta meta = (LeatherArmorMeta) boots.getItemMeta();
        meta.setColor(Color.BLACK);
        boots.setItemMeta(meta);

        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta meta3 = (LeatherArmorMeta) leggings.getItemMeta();
        meta3.setColor(Color.BLACK);
        leggings.setItemMeta(meta3);

        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta meta4 = (LeatherArmorMeta) chestplate.getItemMeta();
        meta4.setColor(Color.BLACK);
        chestplate.setItemMeta(meta4);

        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        //skin
        ItemMeta metaref16 = head.getItemMeta();
        ArrayList<String> lore16 = new ArrayList<String>();

        //HEAD
        SkullMeta meta1 = (SkullMeta) head.getItemMeta();
        meta1.setOwner("Pallbearers");
        head.setItemMeta(meta1);
        //

        final ArmorStand[] a = new ArmorStand[6];
        final Location loc = p.getLocation();
        loc.setX(Math.round(loc.getX()) + 0.5D);
        loc.setY(Math.floor(loc.getY()));
        loc.setZ(Math.round(loc.getZ()) + 0.5D);

        Block[] cb = {
                loc.add(3.0D, 2.0D, 0.0D).getBlock(),
                loc.add(1.0D, 0.0D, 0.0D).getBlock(),
                loc.add(1.0D, 0.0D, 0.0D).getBlock(),
                loc.add(0.0D, 0.0D, 1.0D).getBlock(),
                loc.add(-1.0D, 0.0D, 0.0D).getBlock(),
                loc.add(-1.0D, 0.0D, 0.0D).getBlock(),

        };

        a[0] = (ArmorStand) p.getWorld().spawnEntity(loc.add(0.0D, -2.0D, 0.0D), EntityType.ARMOR_STAND);
        a[1] = (ArmorStand) p.getWorld().spawnEntity(loc.add(1.0D, 0.0D, 0.0D), EntityType.ARMOR_STAND);
        a[2] = (ArmorStand) p.getWorld().spawnEntity(loc.add(1.0D, 0.0D, 0.0D), EntityType.ARMOR_STAND);
        a[3] = (ArmorStand) p.getWorld().spawnEntity(loc.add(0.0D, 0.0D, -1.0D), EntityType.ARMOR_STAND);
        a[4] = (ArmorStand) p.getWorld().spawnEntity(loc.add(-1.0D, 0.0D, 0.0D), EntityType.ARMOR_STAND);
        a[5] = (ArmorStand) p.getWorld().spawnEntity(loc.add(-1.0D, 0.0D, 0.0D), EntityType.ARMOR_STAND);

        int i;
        for (i = 0; i < 6; i++) {
            a[i].setBasePlate(false);
            a[i].setArms(true);
            a[i].setBoots(boots);
            a[i].setLeggings(leggings);
            a[i].setChestplate(chestplate);
            a[i].setHelmet(head);
            a[i].setItemInHand(new ItemStack(Material.PAPER));
            a[i].setRotation(90.0F, 0.0F);
        }

        for (i = 0; i < 6; i++) {
            if (cb[i].getType() == Material.AIR) {
                cb[i].setType(Material.DARK_OAK_SLAB);
            }
        }


        int id = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Core.instance, new Runnable() {
            public void run() {
                Coffin.this.chk(a);

                if (Coffin.this.procedure % 4 == 1 || Coffin.this.procedure % 4 == 2) {
                    Coffin.this.p1(a);
                } else {
                    Coffin.this.p2(a);
                }

                switch (Coffin.this.procedure % 32) {
                    case 0:
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BIT, 1.0F, 1.0F);
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BASS, 1.0F, 1.587F);
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1.0F, 1.0F);
                        break;
                    case 2:
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BIT, 1.0F, 1.0F);
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_SNARE, 1.0F, 1.0F);
                        break;
                    case 3:
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BIT, 1.0F, 1.498F);
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1.0F, 1.0F);
                        break;
                    case 4:
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BIT, 1.0F, 1.334F);
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BASS, 1.0F, 1.587F);
                        break;
                    case 5:
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1.0F, 1.0F);
                        break;
                    case 6:
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BIT, 1.0F, 1.189F);
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_SNARE, 1.0F, 1.0F);
                        break;
                    case 8:
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BIT, 1.0F, 1.122F);
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BASS, 1.0F, 1.782F);
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1.0F, 1.0F);
                        break;
                    case 10:
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BIT, 1.0F, 1.122F);
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_SNARE, 1.0F, 1.0F);
                        break;
                    case 11:
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BIT, 1.0F, 1.189F);
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1.0F, 1.0F);
                        break;
                    case 12:
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BIT, 1.0F, 1.334F);
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BASS, 1.0F, 1.782F);
                        break;
                    case 13:
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1.0F, 1.0F);
                        break;
                    case 14:
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BIT, 1.0F, 1.189F);
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_SNARE, 1.0F, 1.0F);
                        break;
                    case 15:
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BIT, 1.0F, 1.122F);
                        break;
                    case 16:
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BIT, 1.0F, 1.0F);
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BASS, 1.0F, 1.0F);
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1.0F, 1.0F);
                        break;
                    case 18:
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BIT, 1.0F, 1.0F);
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_SNARE, 1.0F, 1.0F);
                        break;
                    case 19:
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BIT, 1.0F, 1.189F);
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1.0F, 1.0F);
                        break;
                    case 20:
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BIT, 1.0F, 1.122F);
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BASS, 1.0F, 1.0F);
                        break;
                    case 21:
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BIT, 1.0F, 1.189F);
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1.0F, 1.0F);
                        break;
                    case 22:
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BIT, 1.0F, 1.122F);
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_SNARE, 1.0F, 1.0F);
                        break;
                    case 23:
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BIT, 1.0F, 1.189F);
                        break;
                    case 24:
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BIT, 1.0F, 1.0F);
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BASS, 1.0F, 1.0F);
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1.0F, 1.0F);
                        break;
                    case 26:
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BIT, 1.0F, 1.0F);
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_SNARE, 1.0F, 1.0F);
                        break;
                    case 27:
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BIT, 1.0F, 1.189F);
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1.0F, 1.0F);
                        break;
                    case 28:
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BIT, 1.0F, 1.122F);
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BASS, 1.0F, 1.0F);
                        break;
                    case 29:
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BIT, 1.0F, 1.189F);
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BASEDRUM, 1.0F, 1.0F);
                        break;
                    case 30:
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BIT, 1.0F, 1.122F);
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_SNARE, 1.0F, 1.0F);
                        break;
                    case 31:
                        p.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BIT, 1.0F, 1.189F);
                        break;
                }
                Coffin.this.procedure++;
            }
    },  5L, 5L);

        //p.sendMessage(ChatColor.BLUE + "CoFfIn DaNcE");
        return true;
    }
}