package dexoria.core.accountManager;

import java.util.List;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import dexoria.core.accountManager.customItems.CustomItems;

public class BorderItemLoop {

	public static void doBorderItem(Inventory i, ItemStack s, List<Integer> slots){
		for(int slot : slots){
			i.setItem(slot, CustomItems.borderItem());
		}
	}
	
}
