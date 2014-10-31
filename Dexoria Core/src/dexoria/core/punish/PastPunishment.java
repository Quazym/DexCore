package dexoria.core.punish;

import org.bukkit.entity.Player;

public class PastPunishment {

	PunishmentType type;
	
	Player player;
	String UUID = player.getUniqueId().toString();
	
	String reason;
	String staffname;
	
	int id;
	
	String removeReason;
	
	boolean Activated;
	
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
	public PastPunishment(int ID, Player p, PunishmentType type, String reason, String staffName, String remove, boolean Active){
		if(remove != null)
			this.removeReason = remove;
		
		this.Activated = Active;
		this.id = ID;
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
