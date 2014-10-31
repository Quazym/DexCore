package dexoria.core.punish;

import org.bukkit.entity.Player;

import dexoria.core.DexCore;

public class Punishment {
	
	PunishmentType type;
	
	Player player;
	String UUID = player.getUniqueId().toString();
	
	String reason;
	String staffname;
	
	PunishmentSev severity;
	
	public Punishment(Player p, PunishmentType type, PunishmentSev sev, String reason, String staffName){
		this.severity = sev;
		this.type = type;
		this.player = p;
		this.reason = reason;
		this.staffname = staffName;
	}
	
	public void activate(){
		DexCore.getPunishmentSystem().punishPlayer(UUID, staffname, severity, type, reason);
	}
}
