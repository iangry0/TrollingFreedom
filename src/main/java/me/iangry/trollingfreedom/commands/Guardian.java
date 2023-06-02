package me.iangry.trollingfreedom.commands;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import me.iangry.trollingfreedom.main.Core;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import com.comphenix.protocol.events.PacketContainer;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.security.Guard;

public class Guardian implements Listener {


    static Field field_spectatorMode;

    public void Guardian(Player player) {
        if (field_spectatorMode == null) {
            Core.instance.getLogger().severe("Failed to show guardian to player. This server version is not compatible.");
            return;
        }
        final PacketContainer packet = new PacketContainer(PacketType.Play.Server.GAME_STATE_CHANGE);
        packet.getGameStateIDs().write(0, (int) 10);
        packet.getFloat().write(0, 0F);


        Guardian.sendPacket(player, packet);
    }

    static {
        field_spectatorMode = null;
        try {
            field_spectatorMode = PacketType.Play.Server.GAME_STATE_CHANGE.getPacketClass().getDeclaredField("e");
        } catch (NoSuchFieldException e) {
            Core.instance.getLogger().severe("Failed to initialise the troll. This server version is not compatible.");
            e.printStackTrace();
        }
    }
    public static boolean sendPacket(final Player player, final PacketContainer packet) {
        try {
            ProtocolLibrary.getProtocolManager().sendServerPacket(player, packet);
            player.playSound(player.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 100, 1);
            player.playSound(player.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_DEATH, 100, 1);
            player.playSound(player.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 100, 1);
            player.playSound(player.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_AMBIENT, 100, 1);
        }
        catch (InvocationTargetException invocationTargetException) {
            return false;
        }
        return true;
    }
}
