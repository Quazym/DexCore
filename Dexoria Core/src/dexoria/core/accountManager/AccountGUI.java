package dexoria.core.accountManager;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;

import dexoria.core.accountManager.customItems.BorderItemLoop;
import dexoria.core.accountManager.customItems.CustomItems;

public class AccountGUI {

	String AccountsPlayerName;
	String staffname;
	
	public AccountGUI(String AccountplayerName, String Staffname){
		this.AccountsPlayerName = AccountplayerName;
		this.staffname = Staffname;
	}
	
	public Inventory HubGUI = Bukkit.createInventory(Bukkit.getPlayer(staffname), 6*9, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "AccountGUI");
	{
		
		/*
		 * Border items (so dayyyum many)
		 */
		List<Integer> b = new ArrayList<Integer>();
		b.add(0);b.add(1);b.add(2);b.add(3);b.add(4);b.add(5);b.add(6);b.add(7);b.add(8);

		b.add(9);b.add(10);b.add(11);                      b.add(15);b.add(16);b.add(17);
		b.add(18);b.add(19);										 b.add(25);b.add(26);
		b.add(27);															   b.add(35);
		b.add(36);		  b.add(38);     b.add(40); 		b.add(42);		   b.add(43);
	b.add(44);b.add(45);b.add(46);b.add(47);b.add(48);b.add(49);b.add(50);b.add(51);b.add(52);
	
	BorderItemLoop.doBorderItem(HubGUI, CustomItems.borderItem(), b);
	
	HubGUI.setItem(13, CustomItems.head(AccountsPlayerName));
	HubGUI.setItem(27, CustomItems.rank());
	HubGUI.setItem(30, CustomItems.currency());
	HubGUI.setItem(33, CustomItems.punish_sword());
	}
	
	public Inventory RankGUI = Bukkit.createInventory(Bukkit.getPlayer(staffname), 3*9, ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Rank Management");
	{
		//TODO add custom items
	}
	public Inventory CurrencyGUI = Bukkit.createInventory(Bukkit.getPlayer(staffname), 3*9, ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Currency Management");
	{
		//TODO add custom items
	}
	public Inventory PunishmentGUI = Bukkit.createInventory(Bukkit.getPlayer(staffname), 3*9, ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Rank Management");
	{
		//TODO add custom items
	}
	public Inventory getInventory(){
		return HubGUI;
	}
}
