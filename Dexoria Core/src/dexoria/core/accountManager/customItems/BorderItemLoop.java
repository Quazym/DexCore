package dexoria.core.accountManager.customItems;

import java.util.List;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BorderItemLoop {

	public static void doBorderItem(Inventory i, ItemStack s, List<Integer> slots){
		for(int slot : slots){
			i.setItem(slot, CustomItems.borderItem());
		}
	}
	
}
