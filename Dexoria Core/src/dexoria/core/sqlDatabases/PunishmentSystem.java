package dexoria.core.sqlDatabases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import dexoria.core.DexCore;
import dexoria.core.punish.PastPunishment;
import dexoria.core.punish.PunishmentSev;
import dexoria.core.punish.PunishmentType;

public class PunishmentSystem {


	  @SuppressWarnings("deprecation")
	public void punishPlayer(String playerUUID, String staffName, PunishmentSev sev, PunishmentType type, String reason)
	  {
		Date date = new Date();
		
		Timestamp end = null;
		Timestamp start = new Timestamp(date.getDate());
		
		int pType = 1;
		
		switch(sev){
		case SEV_1: if(type.equals(PunishmentType.CHAT)){
			end = start;
			end.setMinutes(end.getMinutes() + 30);
			
			pType = 1;
		}else if(type.equals(PunishmentType.GAMEPLAY)){
			end = start;
			end.setHours(end.getHours() + 1);
			
			pType = 2;
		}else if(type.equals(PunishmentType.HACKING)){
			end = start;
			end.setHours(end.getHours() + 24);
			
			pType = 3;
		}
			break;
		case SEV_2: if(type.equals(PunishmentType.CHAT)){
			end = start;
			end.setHours(end.getHours()+ 2);
			
			pType = 1;
		}else if(type.equals(PunishmentType.GAMEPLAY)){
			end = start;
			end.setHours(end.getHours() + 3);
			
			pType = 2;
		}else if(type.equals(PunishmentType.HACKING)){
			end = start;
			end.setHours(end.getHours() + 24 * 5);
			
			pType = 3;
		}
			break;
		case SEV_3: if(type.equals(PunishmentType.CHAT)){
			end = start;
			end.setHours(end.getHours()+ 24);
			
			pType = 1;
		}else if(type.equals(PunishmentType.GAMEPLAY)){
			end = start;
			end.setHours(end.getHours() + 3);
			
			pType = 2;
		}else if(type.equals(PunishmentType.HACKING)){
			end = start;
			end.setHours(end.getHours() + 24 * 7);
			
			pType = 3;
		}
			break;
		case SEV_4: if(type.equals(PunishmentType.CHAT)){
			end = start;
			
			pType = 1;
		}else if(type.equals(PunishmentType.GAMEPLAY)){
			end = start;
			
			pType = 2;
		}else if(type.equals(PunishmentType.HACKING)){
			end = start;
			
			pType = 3;
		}
			break;
	}
		  
	    try {
	      DexCore.getSQLStaticly().updateSQL("INSERT INTO Punishment (`ID`, `UUID`, `PlayerName`, `StaffName`, `pType`, `Reason`, `Activated`, `Ends`, `Active`, RemoveReason`) VALUES (NULL, '" + playerUUID + "', '" + Bukkit.getPlayer(playerUUID).getName() + "', '" + staffName + "' , '" + pType +"', '" + reason + "','" + start + "','" + end + "', '1', '' );");
	    }
	    catch (SQLException|ClassNotFoundException e) {
	      e.printStackTrace();
	    }
	  }


	  public PastPunishment getPunishment(int ID)
	  {
	    try {
	      ResultSet res =  DexCore.getSQLStaticly().querySQL("SELECT * FROM Punishment WHERE ID = '" + ID + "';");
	      Player player = Bukkit.getPlayer(res.getString("PlayerName"));
	      int pType = res.getInt("pType");
	      
	      PunishmentType type = null;
	      switch(pType){
	      case 1: type = PunishmentType.CHAT;
	      	break;
	      case 2: type = PunishmentType.GAMEPLAY;
	      	break;
	      case 3: type = PunishmentType.HACKING;
	      	break;
	      }
	      int id = res.getInt(ID);
	      
	      String staff = res.getString("StaffName");
	      String reason = res.getString("reason");
	      String remove = res.getString("RemoveReason");
	      
	      boolean activate;
	      if(res.getInt("Active") == 1)
	    	  activate = true;
	      else{
	    	  activate = false;
	      }
	      
	      PastPunishment p = new PastPunishment(id, player, 
	    		  type, reason, staff, 
	    		  		remove, activate);
	      
	      return p;
	    }
	    catch (SQLException|ClassNotFoundException e) {
	      e.printStackTrace();
	    }
	    
	    return null;
	  }

	  
	  
}
