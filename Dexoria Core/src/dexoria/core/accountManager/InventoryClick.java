package dexoria.core.accountManager;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import dexoria.core.DexCore;

public class InventoryClick implements Listener{

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e){
		//Check the person is in a account GUI.
		if(DexCore.getAccountGUIManager().contains(e.getWhoClicked().getName())){
			AccountGUI agui = DexCore.getAccountGUIManager().getGUI(e.getWhoClicked().getName());
			
			if(e.getInventory().equals(agui.HubGUI)){
				
				e.setCancelled(true);
				e.setCursor(new ItemStack(Material.AIR));
				
				if(e.getCurrentItem().getType() != null 
						&& e.getCurrentItem().getType() != Material.THIN_GLASS
							&& e.getCurrentItem().getType() != Material.SKULL){
					
					if(e.getCurrentItem().getType() == Material.DIAMOND_HELMET){
						e.getWhoClicked().closeInventory();
						e.getWhoClicked().openInventory(agui.RankGUI);
						return;
					}
					if(e.getCurrentItem().getType() == Material.GOLD_INGOT){
						e.getWhoClicked().closeInventory();
						e.getWhoClicked().openInventory(agui.CurrencyGUI);
						return;
					}
					if(e.getCurrentItem().getType() == Material.IRON_SWORD){
						e.getWhoClicked().closeInventory();
						e.getWhoClicked().openInventory(agui.PunishmentGUI);
						return;
					}
					e.getWhoClicked().closeInventory();
				}
			}
			
			if(e.getInventory().equals(agui.RankGUI)){
				
			}
		}
	}
}
