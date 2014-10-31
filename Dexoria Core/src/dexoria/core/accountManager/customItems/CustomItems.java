package dexoria.core.accountManager.customItems;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomItems {
	
	/*
	 * Border Items
	 */
	
	public static ItemStack borderItem(){
		ItemStack i = createItem(Material.SKULL, 
				"", 
					null);
		
		return i;
	}
	
	/*
	 * HubGUI Items
	 */
	
	public static ItemStack head(String name){
		ItemStack i = createItem(Material.SKULL, 
				name, 
					null);
		
		return i;
	}
	
	public static ItemStack punish_sword() {
		
		List<String> lore = new ArrayList<String>();
		
		lore.add(ChatColor.GRAY + "Click to open the PunishmentGUI");
		
		ItemStack i = createItem(Material.IRON_SWORD, 
				ChatColor.RED + "" + ChatColor.BOLD + "Punish", 
					lore);
		
		return i;
	}
	
	public static ItemStack rank() {
		
		List<String> lore = new ArrayList<String>();
		
		lore.add(ChatColor.GRAY + "Click to open the RankGUI");
		
		ItemStack i = createItem(Material.DIAMOND_HELMET, 
				ChatColor.BLUE + "" + ChatColor.BOLD + "Rank Management", 
					lore);
		
		return i;
	}
	
	public static ItemStack currency(){
		List<String> lore = new ArrayList<String>();
		
		lore.add(ChatColor.GRAY + "Click to open the CurrencyGUI");
		
		ItemStack i = createItem(Material.DIAMOND_HELMET, 
				ChatColor.BLUE + "" + ChatColor.BOLD + "Currency Management", 
					lore);
		
		return i;
	}
	
	/*
	 * RankGUI Items
	 */
	
	/*
	 * CurrencyGUI Items
	 */
	
	public static ItemStack createItem(Material m, String name, List<String> lore){
		ItemStack i = new ItemStack(m);
		
		ItemMeta im = i.getItemMeta();
		
		im.setDisplayName(name);
		
		if(lore != null)
			im.setLore(lore);

		i.setItemMeta(im);
		
		return i;
	}
}
