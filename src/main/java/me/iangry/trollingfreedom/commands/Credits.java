package me.iangry.trollingfreedom.commands;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import me.iangry.trollingfreedom.main.Core;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import com.comphenix.protocol.events.PacketContainer;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Credits implements Listener {


    static Field field_spectatorMode;

    public void Credits(Player player) {
        if (field_spectatorMode == null) {
            Core.instance.getLogger().severe("Failed to show credits screen to player. This server version is not compatible.");
            return;
        }
        final PacketContainer packet = new PacketContainer(PacketType.Play.Server.GAME_STATE_CHANGE);
        try {
            final Object spectatorMode = field_spectatorMode.get(null);
            packet.getModifier().write(0, spectatorMode);
            packet.getFloat().write(0, 1.0F);
            Credits.sendPacket(player, packet);
        }
        catch (IllegalAccessException e) {
            Core.instance.getLogger().severe("Failed to show credits screen to player:");
            e.printStackTrace();
        }
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
            }
            catch (InvocationTargetException invocationTargetException) {
                return false;
            }
            return true;
        }
}
