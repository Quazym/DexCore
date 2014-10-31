package dexoria.core.punish;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PastPunishment {

	PunishmentType type;
	
	Player player;
	String UUID = player.getUniqueId().toString();
	
	String reason;
	String staffname;
	
	int id;
	
	String removeReason;
	
	boolean Activated;
	
	Timestamp start;
	Timestamp end;
	
	Timestamp now;
	
	Date date;
	
	PunishmentSev severity;
	
	/**
	 * 
	 * @param ID
	 * @param p
	 * @param type
	 * @param reason
	 * @param staffName
	 * @param remove
	 * @param Active
	 */
	@SuppressWarnings("deprecation")
	public PastPunishment(int ID, Player p, PunishmentType type, String reason, 
			String staffName, String remove, boolean Active, Timestamp active, 
				Timestamp ends, PunishmentSev sev){
		
		if(remove != null)
			this.removeReason = remove;
		
		this.severity = sev;
		this.date = new Date();
		this.start = active;
		this.end = ends;
		this.Activated = Active;
		this.id = ID;
		this.type = type;
		this.player = p;
		this.reason = reason;
		this.staffname = staffName;
		
		now = new Timestamp(date.getDate());
	}
	public boolean isActive(){
		
		hasExpired();
		
		return Activated;
		
	}
	public boolean hasExpired(){
		if(now.after(end)){
			Activated = false;
			return true;
		}
		
		Activated = true;
		return false;
	}
	
	public ItemStack buildItem(){
		ItemStack i = null;
		switch(type){
		case CHAT: i = new ItemStack(Material.BOOK_AND_QUILL);
			break;
		case GAMEPLAY: i = new ItemStack(Material.DIAMOND_BOOTS);
			break;
		case HACKING: i = new ItemStack(Material.ENCHANTMENT_TABLE);
			break;
		}
		
		hasExpired();
		
		if(this.Activated == true)
			i.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		
		ItemMeta meta = i.getItemMeta();
		
		meta.setDisplayName(ChatColor.GRAY + "Type " + ChatColor.GREEN + type.toString().toLowerCase());
		
		List<String> lore = new ArrayList<String>();
		
		lore.add(ChatColor.GRAY + "Reason: " + ChatColor.GREEN + reason);
		lore.add(ChatColor.GRAY + "Sev: " + ChatColor.RED + severity.toString());
		lore.add(ChatColor.GRAY + "Time: " + ChatColor.GREEN + this.start);
		lore.add(ChatColor.GRAY + "Punisher: " + ChatColor.GREEN + this.staffname);
		if(this.Activated == true)
		lore.add(ChatColor.GRAY + "Ends: " + end.toString());
		
		return i;
	}
}
