package dexoria.core.punish;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Punishment {
	
	PunishmentType punishment;
	PunishmentType type;
	
	Player player;
	
	String reason;
	
	public Punishment(Player p, PunishmentType type, PunishmentType muteOrBan, String reason){
		this.punishment = muteOrBan;
		this.type = type;
		this.player = p;
		this.reason = reason;
	}
	
	public void mutePlayer(){
		
		if(punishment != PunishmentType.MUTE)
			Bukkit.getLogger().info("ERROR: Punishment type should of been ban. Punishment Canceled.");
		
		
	}
	
	public void banPlayer(){

		if(punishment != PunishmentType.BAN)
			Bukkit.getLogger().info("ERROR: Punishment type should of been mute. Punishment Canceled.");
		
		
	}
}
