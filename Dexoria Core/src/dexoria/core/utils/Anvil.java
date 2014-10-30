package dexoria.core.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.AnvilInventory;

public class Anvil {
	
	 public void openAnvil(Player p) {
	      /*  try {
	            PacketPlayOutOpenWindow window = new PacketPlayOutOpenWindow(13337, 8, "Anvil", 0, true);
	            ((CraftPlayer)p).getHandle().playerConnection.sendPacket(window);
	        } catch(Exception e) {}*/
		 
		 AnvilInventory ai = (AnvilInventory) Bukkit.createInventory(null, InventoryType.ANVIL);
	 }
}
