package dexoria.core.sqlDatabases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
		
		Timestamp end = null;
		Timestamp start = new Timestamp(System.currentTimeMillis());
		
		int pType = 1;
		
		int severity = 0;
		
		switch(sev){
		case SEV_1: severity = 1; if(type.equals(PunishmentType.CHAT)){
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
		case SEV_2: severity = 2; if(type.equals(PunishmentType.CHAT)){
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
		case SEV_3: severity = 3; if(type.equals(PunishmentType.CHAT)){
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
		case SEV_4: severity = 4; if(type.equals(PunishmentType.CHAT)){
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
	      DexCore.getSQLStaticly().updateSQL("INSERT INTO Punishment (`ID`, `UUID`, `PlayerName`, `StaffName`, `Sev`, `pType`, `Reason`, `Activated`, `Ends`, `Active`, `RemoveReason`, `RemovedBy`) VALUES (NULL, '" + playerUUID + "', '" + Bukkit.getPlayer(playerUUID).getName() + "', '" + staffName + "' , '" + severity + "', '" + pType +"', '" + reason + "','" + start + "','" + end + "', '1', NULL, NULL );");
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
	      String removedby = res.getString("RemovedReason");
	      
	      boolean activate;
	      if(res.getInt("Active") == 1)
	    	  activate = true;
	      else{
	    	  activate = false;
	      }
	      
	      int sev = res.getInt("Sev");
	      
	      PunishmentSev severity = null;
	      
	      switch(sev){
	      case 1: severity = PunishmentSev.SEV_1;
	      	break;
	      case 2: severity = PunishmentSev.SEV_2;
	      	break;
	      case 3: severity = PunishmentSev.SEV_3;
	      	break;
	      case 4: severity = PunishmentSev.SEV_4;
	      	break;
	      default: severity = PunishmentSev.SEV_1;
	      	break;
	      }
	      Timestamp start = res.getTimestamp("Activated");
	      
	      Timestamp end = res.getTimestamp("Ends");
	      
	      PastPunishment p = new PastPunishment(id, player, 
	    		  type, reason, staff, 
	    		  		remove, removedby ,activate, start, end, severity);
	      return p;
	    }
	    catch (SQLException|ClassNotFoundException e) {
	      e.printStackTrace();
	    }
	    return null;
	  }

	  public List<PastPunishment> getAllPunishments(int ID){
		  List<PastPunishment> pp = new ArrayList<>();
		  try {
			ResultSet res =  DexCore.getSQLStaticly().querySQL("SELECT * FROM Punishment WHERE ID = '" + ID + "';");
			
			pp.add(this.getPunishment(res.getInt("ID")));
			while(res.next()){
				pp.add(this.getPunishment(res.getInt("ID")));
			}
		  } catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  return pp;
	  }
	  
	  public void removePunishment(int id, boolean natural, String reason, String staff) {
		  try {
			int not = 0;
			DexCore.getSQLStaticly().updateSQL("UPDATE Punishment SET Active='" + not + "' WHERE ID='" + id + "';");
		  
			if(natural == false){
				 DexCore.getSQLStaticly().updateSQL("UPDATE Punishment SET RemoveReason='" + reason + "' WHERE ID='" + id + "';");
				 DexCore.getSQLStaticly().updateSQL("UPDATE Punishment SET RemovedBy='" + staff + "' WHERE ID='" + id + "';");
			}
		  
		  } catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	  }
	  
	  public boolean isActive(int id){
		  try {
			ResultSet res =  DexCore.getSQLStaticly().querySQL("SELECT * FROM Punishment WHERE ID = '" + id + "';");
			
			int active = res.getInt("Active");
			
			if(active == 1)
				return true;
			
			if(active == 0)
				return false;
		  
		  
		  
		  } catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		  
		  return false;
	}
	  
}
