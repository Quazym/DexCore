package dexoria.core.punish.customItems;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PunishCustomItems {
	
	/*
	 * Column headers
	 */
	
	public static ItemStack mute(){
		List<String> lore = new ArrayList<String>();
		
		lore.add(ChatColor.GRAY + "Mutes the player");
		
		ItemStack i = createItem(Material.DIAMOND_HELMET,1,(byte)0, 
				ChatColor.RED + "" + ChatColor.BOLD + "Chat Offences", 
					lore);
		
		return i;
	}
	
	public static ItemStack game(){
		List<String> lore = new ArrayList<String>();
		
		lore.add(ChatColor.GRAY + "Bans the player");
		
		ItemStack i = createItem(Material.DIAMOND_HELMET,1,(byte)0, 
				ChatColor.RED + "" + ChatColor.BOLD + "Gameplay Offences", 
					lore);
		
		return i;
	}
	
	public static ItemStack hacking(){
		List<String> lore = new ArrayList<String>();
		
		lore.add(ChatColor.GRAY + "Bans the player");
		
		ItemStack i = createItem(Material.DIAMOND_HELMET,1,(byte)0, 
				ChatColor.RED + "" + ChatColor.BOLD + "Hacking Offences", 
					lore);
		
		return i;
	}
	
	/*
	 * Sev dies
	 */
	
	public static ItemStack mute_sev1(){
		List<String> lore = new ArrayList<String>();
		
		lore.add(ChatColor.GRAY + "30 Minute mute");
		lore.add(ChatColor.LIGHT_PURPLE+ "		Some Example uses:");
		lore.add(ChatColor.GRAY + "		- Extreme Caps after warning");
		lore.add(ChatColor.GRAY + "		- Light spamming");
		lore.add(ChatColor.GRAY + "		- Chat Trolling");
		lore.add(ChatColor.GRAY + "		- Light swearing eg: COCKadoodledo HAHA");
		lore.add(ChatColor.GRAY + "		- Light disrespect eg: U So Stupid");
		lore.add(ChatColor.DARK_AQUA + "			More in punishment Guidelines!");
		
		ItemStack i = createItem(Material.getMaterial(355),1,(byte)0, 
				ChatColor.GREEN + "" + ChatColor.BOLD + "Sev 1", 
					lore);
		
		return i;
	}

	public static ItemStack mute_sev2(){
		List<String> lore = new ArrayList<String>();
		
		lore.add(ChatColor.GRAY + "2 hour mute");
		lore.add(ChatColor.LIGHT_PURPLE+ "		Some Example uses:");
		lore.add(ChatColor.GRAY + "		- 3rd & 4th Light offences");
		lore.add(ChatColor.GRAY + "		- Major spam");
		lore.add(ChatColor.GRAY + "		- 1st & 2nd Heavy swearing eg: FUCK YOU BITCH");
		lore.add(ChatColor.GRAY + "		- Heavy disrespect eg: UR MOM HATES U PLEASE DIE");
		lore.add(ChatColor.GRAY + "		- Generaly being a massive ass and annoying");
		lore.add(ChatColor.DARK_AQUA + "			More in punishment Guidelines!");
		
		ItemStack i = createItem(Material.INK_SACK,1,(byte) 11, 
				ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Sev 2", 
					lore);
		
		return i;
	}
	
	public static ItemStack mute_sev3(){
		List<String> lore = new ArrayList<String>();
		
		lore.add(ChatColor.GRAY + "1 day mute");
		lore.add(ChatColor.LIGHT_PURPLE+ "		Some Example uses:");
		lore.add(ChatColor.GRAY + "		- 5th & 6th offence");
		lore.add(ChatColor.GRAY + "		- 1st offence Advertising URL / IP");
		lore.add(ChatColor.GRAY + "		- 3rd sev 2 offence");
		lore.add(ChatColor.GRAY + "		- 1st & 2nd offence Any ism eg: Nigga");
		lore.add(ChatColor.GRAY + "		- 1st & second Staff disrespect");
		lore.add(ChatColor.DARK_AQUA + "			More in punishment Guidelines!");
		
		ItemStack i = createItem(Material.getMaterial(356),1, (byte) 0, 
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Sev 3", 
					lore);
		
		return i;
	}
	
	public static ItemStack mute_sev4(){
		List<String> lore = new ArrayList<String>();
		
		lore.add(ChatColor.GRAY + "Perm mute");
		lore.add(ChatColor.LIGHT_PURPLE+ "		Some Example uses:");
		lore.add(ChatColor.GRAY + "		- 7th offence");
		lore.add(ChatColor.GRAY + "		- 2nd offence Advertising URL / IP");
		lore.add(ChatColor.GRAY + "		- Extreme racism eg: KILL THE NIGGAS");
		lore.add(ChatColor.GRAY + "		- Advertising extreme URL eg: www.pornhub.com or scam");
		lore.add(ChatColor.GRAY + "		- DDOS Threat");
		lore.add(ChatColor.DARK_AQUA + "			More in punishment Guidelines!");
		
		ItemStack i = createItem(Material.INK_SACK,1, (byte) 10, 
				ChatColor.RED + "" + ChatColor.BOLD + "Sev 4", 
					lore);
		
		return i;
	}
	
	
	public static ItemStack game_sev1(){
		List<String> lore = new ArrayList<String>();
		
		lore.add(ChatColor.GRAY + "1 hour ban");
		lore.add(ChatColor.LIGHT_PURPLE+ "		Some Example uses:");
		lore.add(ChatColor.GRAY + "		- 1st & 2nd Map exploit");
		lore.add(ChatColor.GRAY + "		- Exploiting bugs / glitches");
		lore.add(ChatColor.GRAY + "		- Team killing");
		lore.add(ChatColor.GRAY + "		- Game trolling");
		lore.add(ChatColor.DARK_AQUA + "			More in punishment Guidelines!");
		
		ItemStack i = createItem(Material.getMaterial(355),1,(byte)0, 
				ChatColor.GREEN + "" + ChatColor.BOLD + "Sev 1", 
					lore);
		
		return i;
	}

	public static ItemStack game_sev2(){
		List<String> lore = new ArrayList<String>();
		
		lore.add(ChatColor.GRAY + "3 hour ban");
		lore.add(ChatColor.LIGHT_PURPLE+ "		Some Example uses:");
		lore.add(ChatColor.GRAY + "		- 3rd & 4th offence");
		lore.add(ChatColor.DARK_AQUA + "			More in punishment Guidelines!");
		
		ItemStack i = createItem(Material.INK_SACK,1,(byte) 11, 
				ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Sev 2", 
					lore);
		
		return i;
	}
	
	public static ItemStack game_sev3(){
		List<String> lore = new ArrayList<String>();
		
		lore.add(ChatColor.GRAY + "2 day ban");
		lore.add(ChatColor.LIGHT_PURPLE+ "		Some Example uses:");
		lore.add(ChatColor.GRAY + "		- 5th offence");
		lore.add(ChatColor.DARK_AQUA + "			More in punishment Guidelines!");
		
		ItemStack i = createItem(Material.getMaterial(356),1, (byte) 0, 
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Sev 3", 
					lore);
		
		return i;
	}
	
	public static ItemStack game_sev4(){
		List<String> lore = new ArrayList<String>();
		
		lore.add(ChatColor.GRAY + "Perm ban");
		lore.add(ChatColor.LIGHT_PURPLE+ "		Some Example uses:");
		lore.add(ChatColor.GRAY + "		- 6th offence");
		lore.add(ChatColor.GRAY + "		- Innapropriate skin [MUST SAY WHERE TO APPEAL!]");
		lore.add(ChatColor.DARK_AQUA + "			More in punishment Guidelines!");
		
		ItemStack i = createItem(Material.INK_SACK,1, (byte) 10, 
				ChatColor.RED + "" + ChatColor.BOLD + "Sev 4", 
					lore);
		
		return i;
	}
	
	
	public static ItemStack hacking_sev1(){
		List<String> lore = new ArrayList<String>();
		
		lore.add(ChatColor.GRAY + "1 day");
		lore.add(ChatColor.LIGHT_PURPLE+ "		Some Example uses:");
		lore.add(ChatColor.GRAY + "		- Using un-approved mod");
		lore.add(ChatColor.DARK_AQUA + "			More in punishment Guidelines!");
		
		ItemStack i = createItem(Material.getMaterial(355),1,(byte)0, 
				ChatColor.GREEN + "" + ChatColor.BOLD + "Sev 1", 
					lore);
		
		return i;
	}

	public static ItemStack hacking_sev2(){
		List<String> lore = new ArrayList<String>();
		
		lore.add(ChatColor.GRAY + "5 day ban");
		lore.add(ChatColor.LIGHT_PURPLE+ "		Some Example uses:");
		lore.add(ChatColor.GRAY + "		- 2nd un approved mod offence");
		lore.add(ChatColor.DARK_AQUA + "			More in punishment Guidelines!");
		
		ItemStack i = createItem(Material.INK_SACK,1,(byte) 11, 
				ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Sev 2", 
					lore);
		
		return i;
	}
	
	public static ItemStack hacking_sev3(){
		List<String> lore = new ArrayList<String>();
		
		lore.add(ChatColor.GRAY + "1 week ban");
		lore.add(ChatColor.LIGHT_PURPLE+ "		Some Example uses:");
		lore.add(ChatColor.GRAY + "		- 3rd un approved mod offence");
		lore.add(ChatColor.GRAY + "		- 1st Client hack offence");
		lore.add(ChatColor.DARK_AQUA + "			More in punishment Guidelines!");
		
		ItemStack i = createItem(Material.getMaterial(356),1, (byte) 0, 
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Sev 3", 
					lore);
		
		return i;
	}
	
	public static ItemStack hacking_sev4(){
		List<String> lore = new ArrayList<String>();
		
		lore.add(ChatColor.GRAY + "Perm ban");
		lore.add(ChatColor.LIGHT_PURPLE+ "		Some Example uses:");
		lore.add(ChatColor.GRAY + "		- 4th un approved mod offence");
		lore.add(ChatColor.GRAY + "		- 2nd hacking offence");
		lore.add(ChatColor.DARK_AQUA + "			More in punishment Guidelines!");
		
		ItemStack i = createItem(Material.INK_SACK,1, (byte) 10, 
				ChatColor.RED + "" + ChatColor.BOLD + "Sev 4", 
					lore);
		
		return i;
	}
	/*
	 * Other
	 */

	public static ItemStack createItem(Material m, int amount, byte data, String name, List<String> lore){
		ItemStack i = new ItemStack(m,amount,data);
		ItemMeta im = i.getItemMeta();
		
		im.setDisplayName(name);
		
		if(lore != null)
			im.setLore(lore);

		i.setItemMeta(im);
		
		return i;
	}
	
}
