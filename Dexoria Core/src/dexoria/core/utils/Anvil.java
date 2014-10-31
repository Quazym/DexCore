package dexoria.core.utils;

import net.minecraft.server.v1_7_R3.PacketPlayOutOpenWindow;

import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Anvil {
	
	 public void openAnvilInventory(Player p ) {
	       try {
	            PacketPlayOutOpenWindow window = new PacketPlayOutOpenWindow(13337, 8, "Anvil", 0, true);
	            ((CraftPlayer)p).getHandle().playerConnection.sendPacket(window);
	        } catch(Exception e) {}
	 }
}
