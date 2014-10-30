package dexoria.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import dexoria.core.DexCore;

public class Commands implements CommandExecutor {
 
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("hub")){
			
		}
		
		 if((cmd.getName().equalsIgnoreCase("currency") || (cmd.getName().equalsIgnoreCase("c")) && 
			      (sender.hasPermission("points.use"))))
			    {
			      if (args.length < 3) {
			        sender.sendMessage(ChatColor.RED + "Not enough args! /currency <add | remove> <game | cosmetic> <PlayerName> <amount>");
			        return false;
			      }

			      if (args[0].equalsIgnoreCase("add"))
			      {
			    	  
			    	  if(args[1].equalsIgnoreCase("cosmetic") || (args[1].equalsIgnoreCase("c"))){
			    		  	String playername = args[2];
			    		  	
			    		  	try{
			    		  		Integer.parseInt(args[3]);
			    		  	}catch(Exception e){
			    		  		sender.sendMessage("Amount must be a int!");
			    		  		return false;
			    		  	}
			    		  	int amount = Integer.parseInt(args[3]);
			    			DexCore.getCurrencySystem().setPlayerCC(Bukkit.getPlayer(playername).getUniqueId().toString(), 	DexCore.getCurrencySystem().getPlayerCC(Bukkit.getPlayer(playername).getUniqueId().toString()) + amount);
			    		  	sender.sendMessage(ChatColor.GREEN + "" + amount + "CC has been added to " + playername);
			    		  	return true;
			    	  }
			    	  
			    	  if(args[1].equalsIgnoreCase("game") || (args[1].equalsIgnoreCase("g"))){
			  		  	String playername = args[2];
			  		  	
			  		  	try{
			  		  		Integer.parseInt(args[3]);
			  		  	}catch(Exception e){
			  		  		sender.sendMessage("Amount must be a int!");
			  		  		return false;
			  		  	}
			  		  	int amount = Integer.parseInt(args[3]);
			  		  	DexCore.getCurrencySystem().setPlayerGC(Bukkit.getPlayer(playername).getUniqueId().toString(), DexCore.getCurrencySystem().getPlayerGC(Bukkit.getPlayer(playername).getUniqueId().toString()) + amount);
			  		  	sender.sendMessage(ChatColor.GREEN + "" + amount + "GC has been added to " + playername);
			  		  	return true;
			  	  }  	  
			  }
			      
			      if(args[0].equalsIgnoreCase("remove"))
			      {
			      	  if(args[1].equalsIgnoreCase("cosmetic") || (args[1].equalsIgnoreCase("c"))){
			  		  	String playername = args[2];
			  		  	
			  		  	try{
			  		  		Integer.parseInt(args[3]);
			  		  	}catch(Exception e){
			  		  		sender.sendMessage("Amount must be a int!");
			  		  		return false;
			  		  	}
			  		  	int amount = Integer.parseInt(args[3]);
			  			DexCore.getCurrencySystem().setPlayerCC(Bukkit.getPlayer(playername).getUniqueId().toString(), 	DexCore.getCurrencySystem().getPlayerCC(Bukkit.getPlayer(playername).getUniqueId().toString()) - amount);
			  		  	sender.sendMessage(ChatColor.GREEN + "" + amount + "CC has been removed from " + playername);
			  		  	return true;
			  	  }
			  	  
			  	  if(args[1].equalsIgnoreCase("game") || (args[1].equalsIgnoreCase("g"))){
					  	String playername = args[2];
					  	
					  	try{
					  		Integer.parseInt(args[3]);
					  	}catch(Exception e){
					  		sender.sendMessage("Amount must be a int!");
					  		return false;
					  	}
					  	int amount = Integer.parseInt(args[3]);
						DexCore.getCurrencySystem().setPlayerGC(Bukkit.getPlayer(playername).getUniqueId().toString(), DexCore.getCurrencySystem().getPlayerGC(Bukkit.getPlayer(playername).getUniqueId().toString()) - amount);
					  	sender.sendMessage(ChatColor.GREEN + "" + amount + "GC has been removed from " + playername);
					  	return true;
				  } 
			   }
			}
			  
		
		if(cmd.getName().equalsIgnoreCase("a") || 
				cmd.getName().equalsIgnoreCase("account")){
			
		}
		
		
		return false;
	}
}
