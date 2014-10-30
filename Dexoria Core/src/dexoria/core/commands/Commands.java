package dexoria.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor {
 
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("hub")){
			
		}
		
		if(cmd.getName().equalsIgnoreCase("currency")){
			
		}
		
		if(cmd.getName().equalsIgnoreCase("a") || 
				cmd.getName().equalsIgnoreCase("account")){
			
		}
		
		
		return false;
	}
}
