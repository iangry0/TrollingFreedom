package me.iangry.trollingfreedom.commands;

import me.iangry.trollingfreedom.main.Core;
import org.bukkit.*;
import org.bukkit.Note.Tone;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RickRoll implements Listener {
    public static ArrayList<String> Rick1 = new ArrayList<>();
    int procedure = 0;

    public void RickRoll(Player p) {
        Rick1.add(p.getName());

        List<String> pages = new ArrayList<String>();
    //    pages.add("§4We're no strangers to love\n" +
   //             "§4You know the rules and so do I\n" +
    //            "§4A full commitment's what I'm thinking of\n" +
   //             "§4You wouldn't get this from any other guy"); // Page 1
   //     pages.add("I just wanna tell you how I'm feeling\n" +
  //              "Gotta make you understand"); // Page 2
        pages.add("§4Never gonna give you up\n" +
                "Never gonna let you down\n" +
                "Never gonna run around and desert you\n" +
                "Never gonna make you cry\n" +
                "Never gonna say goodbye\n" +
                "Never gonna tell a lie and hurt you"); // Page 3
        pages.add("We've known each other for so long\n" +
                "Your heart's been aching but you're too shy to say it\n" +
                "Inside we both know what's been going on\n" +
                "We know the game and we're gonna play it");
        pages.add("And if you ask me how I'm feeling\n" +
                "Don't tell me you're too blind to see");
        pages.add("Never gonna give you up\n" +
                "Never gonna let you down\n" +
                "Never gonna run around and desert you\n" +
                "Never gonna make you cry\n" +
                "Never gonna say goodbye");
        pages.add("Never gonna tell a lie and hurt you\n" +
                "Never gonna give you up\n" +
                "Never gonna let you down\n" +
                "Never gonna run around and desert you\n" +
                "Never gonna make you cry\n" +
                "Never gonna say goodbye\n" +
                "Never gonna tell a lie and hurt you");
        pages.add("Never gonna give, never gonna give\n" +
                "(Give you up)\n" +
                "(Ooh) Never gonna give, never gonna give\n" +
                "(Give you up)");
        pages.add("We've known each other for so long\n" +
                "Your heart's been aching but you're too shy to say it\n" +
                "Inside we both know what's been going on\n" +
                "We know the game and we're gonna play it");
        pages.add("I just wanna tell you how I'm feeling\n" +
                "Gotta make you understand");
        pages.add("Never gonna give you up\n" +
                "Never gonna let you down\n" +
                "Never gonna run around and desert you\n" +
                "Never gonna make you cry\n" +
                "Never gonna say goodbye\n" +
                "Never gonna tell a lie and hurt you\n" +
                "Never gonna give you up");
        pages.add("Never gonna let you down\n" +
                "Never gonna run around and desert you\n" +
                "Never gonna make you cry\n" +
                "Never gonna say goodbye\n" +
                "Never gonna tell a lie and hurt you\n" +
                "Never gonna give you up\n" +
                "Never gonna let you down\n" +
                "Never gonna run around and desert you\n" +
                "Never gonna make you cry");

        ItemStack writtenBook = new ItemStack(Material.WRITTEN_BOOK, 1);
        BookMeta bookMeta = (BookMeta) writtenBook.getItemMeta();
        bookMeta.setTitle("Never Gonna Give You Up");
        bookMeta.setAuthor("Rick Astley");
        bookMeta.setPages(pages);
        writtenBook.setItemMeta(bookMeta);

        p.openBook(writtenBook);

        int id = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Core.instance, new Runnable() {
            public void run() {
                switch (RickRoll.this.procedure % 56) {
                    case 0:
                        p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.sharp(0, Tone.A));
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.sharp(0, Tone.G));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(0, Tone.D));
                        break;
                    case 2:
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(0, Tone.D));
                        break;
                    case 3:
                        p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.natural(0, Tone.F));
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.sharp(1, Tone.G));
                        p.playNote(p.getLocation(), Instrument.FLUTE, Note.sharp(0, Tone.G));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(0, Tone.D));
                        break;
                    case 4:
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.sharp(1, Tone.A));
                        p.playNote(p.getLocation(), Instrument.FLUTE, Note.sharp(0, Tone.A));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(0, Tone.D));
                        break;
                    case 5:
                        p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.natural(0, Tone.G));
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.sharp(1, Tone.C));
                        p.playNote(p.getLocation(), Instrument.FLUTE, Note.sharp(0, Tone.C));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(0, Tone.D));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.C));
                        break;
                    case 6:
                        p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.natural(0, Tone.F));
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.sharp(1, Tone.A));
                        p.playNote(p.getLocation(), Instrument.FLUTE, Note.sharp(0, Tone.A));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(0, Tone.D));
                        break;
                    case 8:
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.natural(0, Tone.F));
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.sharp(0, Tone.F));
                        p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.sharp(0, Tone.D));
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.sharp(1, Tone.F));
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.sharp(1, Tone.C));
                        p.playNote(p.getLocation(), Instrument.FLUTE, Note.natural(0, Tone.F));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        p.playNote(p.getLocation(), Instrument.BASS_DRUM, Note.natural(0, Tone.C));
                        break;
                    case 10:
                        p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.sharp(0, Tone.D));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        break;
                    case 11:
                        p.playNote(p.getLocation(), Instrument.BASS_DRUM, Note.sharp(0, Tone.D));
                        p.playNote(p.getLocation(), Instrument.FLUTE, Note.natural(0, Tone.F));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        p.playNote(p.getLocation(), Instrument.STICKS, Note.natural(0, Tone.D));
                        break;
                    case 12:
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(0, Tone.D));
                        break;
                    case 13:
                        p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.natural(0, Tone.C));
                        break;
                    case 14:
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.sharp(0, Tone.D));
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.natural(0, Tone.C));
                        p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.sharp(0, Tone.A));
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.sharp(1, Tone.G));
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.sharp(1, Tone.D));
                        p.playNote(p.getLocation(), Instrument.FLUTE, Note.sharp(0, Tone.D));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        p.playNote(p.getLocation(), Instrument.STICKS, Note.sharp(0, Tone.G));
                        break;
                    case 15:
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        break;
                    case 16:
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.sharp(0, Tone.G));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        p.playNote(p.getLocation(), Instrument.BASS_DRUM, Note.natural(0, Tone.C));
                        break;
                    case 18:
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.sharp(0, Tone.G));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        break;
                    case 19:
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        p.playNote(p.getLocation(), Instrument.STICKS, Note.natural(0, Tone.D));
                        break;
                    case 20:
                        p.playNote(p.getLocation(), Instrument.FLUTE, Note.sharp(0, Tone.G));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(0, Tone.D));
                        break;
                    case 21:
                        p.playNote(p.getLocation(), Instrument.FLUTE, Note.sharp(0, Tone.A));
                        break;
                    case 22:
                        p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.sharp(0, Tone.D));
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.sharp(1, Tone.G));
                        p.playNote(p.getLocation(), Instrument.FLUTE, Note.sharp(0, Tone.C));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        p.playNote(p.getLocation(), Instrument.STICKS, Note.sharp(0, Tone.G));
                        break;
                    case 23:
                        p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.sharp(0, Tone.G));
                        p.playNote(p.getLocation(), Instrument.FLUTE, Note.sharp(0, Tone.A));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        break;
                    case 24:
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.sharp(0, Tone.G));
                        p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.natural(0, Tone.F));
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.sharp(1, Tone.D));
                        p.playNote(p.getLocation(), Instrument.FLUTE, Note.sharp(0, Tone.D));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        p.playNote(p.getLocation(), Instrument.BASS_DRUM, Note.natural(0, Tone.C));
                        break;
                    case 26:
                        p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.natural(0, Tone.F));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        break;
                    case 27:
                        p.playNote(p.getLocation(), Instrument.BASS_DRUM, Note.natural(0, Tone.C));
                        p.playNote(p.getLocation(), Instrument.FLUTE, Note.sharp(0, Tone.D));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        p.playNote(p.getLocation(), Instrument.STICKS, Note.natural(0, Tone.D));
                        break;
                    case 28:
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(0, Tone.D));
                        break;
                    case 29:
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.natural(0, Tone.F));
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.sharp(0, Tone.A));
                        p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.sharp(0, Tone.A));
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.natural(1, Tone.F));
                        p.playNote(p.getLocation(), Instrument.FLUTE, Note.sharp(0, Tone.C));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        p.playNote(p.getLocation(), Instrument.STICKS, Note.sharp(0, Tone.G));
                        break;
                    case 30:
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        break;
                    case 31:
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        p.playNote(p.getLocation(), Instrument.BASS_DRUM, Note.natural(0, Tone.C));
                        break;
                    case 32:
                        p.playNote(p.getLocation(), Instrument.FLUTE, Note.natural(0, Tone.C));
                        break;
                    case 33:
                        p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.sharp(0, Tone.A));
                        p.playNote(p.getLocation(), Instrument.FLUTE, Note.sharp(0, Tone.A));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        break;
                    case 34:
                        p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.sharp(0, Tone.A));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        p.playNote(p.getLocation(), Instrument.STICKS, Note.natural(0, Tone.D));
                        break;
                    case 35:
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.sharp(1, Tone.G));
                        p.playNote(p.getLocation(), Instrument.FLUTE, Note.sharp(0, Tone.G));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(0, Tone.D));
                        break;
                    case 36:
                        p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.natural(0, Tone.C));
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.sharp(1, Tone.F));
                        p.playNote(p.getLocation(), Instrument.FLUTE, Note.sharp(0, Tone.A));
                        break;
                    case 37:
                        p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.sharp(0, Tone.A));
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.natural(1, Tone.F));
                        p.playNote(p.getLocation(), Instrument.FLUTE, Note.sharp(0, Tone.C));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.C));
                        p.playNote(p.getLocation(), Instrument.STICKS, Note.sharp(0, Tone.G));
                        break;
                    case 38:
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.sharp(1, Tone.C));
                        p.playNote(p.getLocation(), Instrument.FLUTE, Note.sharp(0, Tone.A));
                        break;
                    case 39:
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.natural(0, Tone.F));
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.sharp(0, Tone.F));
                        p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.sharp(0, Tone.D));
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.sharp(0, Tone.F));
                        p.playNote(p.getLocation(), Instrument.FLUTE, Note.sharp(0, Tone.C));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        p.playNote(p.getLocation(), Instrument.BASS_DRUM, Note.natural(0, Tone.C));
                        break;
                    case 40:
                        p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.sharp(1, Tone.D));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        break;
                    case 41:
                        p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.natural(0, Tone.C));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        p.playNote(p.getLocation(), Instrument.STICKS, Note.natural(0, Tone.D));
                        break;
                    case 42:
                        p.playNote(p.getLocation(), Instrument.FLUTE, Note.sharp(0, Tone.D));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(0, Tone.D));
                        break;
                    case 43:
                        p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.natural(0, Tone.C));
                        break;
                    case 44:
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.sharp(0, Tone.D));
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.natural(0, Tone.C));
                        p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.sharp(0, Tone.A));
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.sharp(0, Tone.G));
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.sharp(1, Tone.D));
                        p.playNote(p.getLocation(), Instrument.FLUTE, Note.natural(0, Tone.C));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        p.playNote(p.getLocation(), Instrument.STICKS, Note.sharp(0, Tone.G));
                        break;
                    case 45:
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        break;
                    case 46:
                        p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.sharp(0, Tone.G));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        p.playNote(p.getLocation(), Instrument.BASS_DRUM, Note.natural(0, Tone.C));
                        break;
                    case 47:
                        p.playNote(p.getLocation(), Instrument.FLUTE, Note.sharp(0, Tone.A));
                        break;
                    case 48:
                        p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.sharp(0, Tone.G));
                        p.playNote(p.getLocation(), Instrument.FLUTE, Note.sharp(0, Tone.G));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        break;
                    case 49:
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        p.playNote(p.getLocation(), Instrument.STICKS, Note.natural(0, Tone.D));
                        break;
                    case 50:
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.sharp(1, Tone.G));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(0, Tone.D));
                        break;
                    case 51:
                        p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.sharp(0, Tone.D));
                        p.playNote(p.getLocation(), Instrument.FLUTE, Note.sharp(0, Tone.G));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        p.playNote(p.getLocation(), Instrument.STICKS, Note.sharp(0, Tone.G));
                        break;
                    case 52:
                        p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.sharp(0, Tone.D));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        break;
                    case 53:
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.sharp(0, Tone.G));
                        p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.natural(0, Tone.F));
                        p.playNote(p.getLocation(), Instrument.FLUTE, Note.sharp(0, Tone.D));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        p.playNote(p.getLocation(), Instrument.BASS_DRUM, Note.natural(0, Tone.C));
                        break;
                    case 54:
                        p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.natural(0, Tone.F));
                        p.playNote(p.getLocation(), Instrument.FLUTE, Note.sharp(0, Tone.C));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        break;
                    case 55:
                        p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.natural(0, Tone.F));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        p.playNote(p.getLocation(), Instrument.STICKS, Note.natural(0, Tone.D));
                        break;
                    case 56:
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.natural(0, Tone.F));
                        p.playNote(p.getLocation(), Instrument.PIANO, Note.sharp(0, Tone.C));
                        p.playNote(p.getLocation(), Instrument.FLUTE, Note.sharp(0, Tone.C));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(1, Tone.E));
                        p.playNote(p.getLocation(), Instrument.SNARE_DRUM, Note.natural(0, Tone.D));
                        break;
                }
                RickRoll.this.procedure++;
            }
        }, 5L, 3L);
    }


    public void UnRickRoll(Player p) {
        String p2 = p.getName();
        Bukkit.getScheduler().cancelTasks(Core.instance);
        Rick1.remove(p.getName());

    }
    @EventHandler
    public void onquit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if (this.Rick1.contains(p.getName())) {
            Bukkit.getScheduler().cancelTasks(Core.instance);
            Rick1.remove(p.getName());
        }
    }
        @EventHandler
        public void onexit(PlayerMoveEvent e) {
            Player p = e.getPlayer();
            if (this.Rick1.contains(p.getName())) {
                Bukkit.getScheduler().cancelTasks(Core.instance);
                Rick1.remove(p.getName());
            }
    }
}