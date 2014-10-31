package dexoria.core.punish;

import org.bukkit.entity.Player;

public class Punishment {
	
	PunishmentType type;
	
	Player player;
	String UUID = player.getUniqueId().toString();
	
	String reason;
	String staffname;
	
	public Punishment(Player p, PunishmentType type, String reason, String staffName){
		this.type = type;
		this.player = p;
		this.reason = reason;
		this.staffname = staffName;
	}
	
	public void activate(){
		
	}
	
	public void isActive(){
		
	}
	
	public void hasExpired(){
		
	}
}
