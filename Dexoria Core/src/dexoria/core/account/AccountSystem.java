package dexoria.core.account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;

import dexoria.core.DexCore;
import dexoria.core.rank.Ranks;

public class AccountSystem {

	
    public boolean playerExists(String playerUUID)
    {
	  try
	  {
	    ResultSet res = DexCore.getSQLStaticly().querySQL("SELECT * FROM Account WHERE UUID = '" + playerUUID + "';");

	    if (!res.next()) {
	      return false;
	    }
	    return true;
	  }
	  catch (SQLException|ClassNotFoundException e)
	  {
	    e.printStackTrace();
	  }

	  return false;
	}
	
	public void addPlayer(String playerUUID, String playerName)
	{
	  try {
	    DexCore.getSQLStaticly().updateSQL("INSERT INTO Account (`UUID`, `PlayerName`, `Rank`) VALUES ( '" + playerUUID + "', '" + playerName + "' , '0');");
	  }
	  catch (SQLException|ClassNotFoundException e) {
	    e.printStackTrace();
	  }
	}	
	  
	public void addPlayerIfMissing(final String playerUUID, final String playerName) {
		 Bukkit.getScheduler().runTaskAsynchronously(DexCore.instance, new Runnable()
		 {
		   public void run() {
		     if (!playerExists(playerUUID))
		       addPlayer(playerUUID, playerName);
		   }
		 });
	}
	
    public Ranks getRank(String playerUUID) {
		try
		   {
		     ResultSet res = DexCore.getSQLStaticly().querySQL("SELECT * FROM Account WHERE UUID = '" + playerUUID + "';");
		      
		     return getRankFromID(res.getInt("Rank"));
		   }
		   catch (SQLException|ClassNotFoundException e)
		   {
		     e.printStackTrace();
		   }
		 
		 return Ranks.DEFAULT;
	}
    
    public void setRank(Ranks rank, String UUID){
    	int ranks = 0;
    	
    	switch(rank){
		case ADMIN: ranks = 6;
			break;
		case BUILDER: ranks = 3;
			break;
		case DEFAULT: ranks = 0;
			break;
		case INTERN: ranks = 4;
			break;
		case MOD: ranks = 5;
			break;
		case OWNER: ranks = 7;
			break;
		case PLATINUM: ranks = 2;
			break;
		case ULTIMATE: ranks = 1;
			break;
		default:
			break;
    	}
        try {
       	 DexCore.getSQLStaticly().updateSQL("UPDATE Account SET Rank='" + ranks + "' WHERE UUID='" + UUID + "';");
       }
       catch (SQLException|ClassNotFoundException e) {
         e.printStackTrace();
       }
     }
    
    /*
     * Needs testing !!!
     */
	public boolean hasPermission(Ranks needed, String UUID){
		Ranks r = getRank(UUID);
		
		int rank = 0;
		int need = 0;
		
		List<Ranks> l = new ArrayList<Ranks>();
		l.add(Ranks.DEFAULT); l.add(Ranks.ULTIMATE); l.add(Ranks.PLATINUM);
		l.add(Ranks.BUILDER); l.add(Ranks.INTERN); l.add(Ranks.MOD);
		l.add(Ranks.ADMIN); l.add(Ranks.OWNER);
		
		int place = 0;
		
		for(Ranks g : Ranks.values()){
			if(r.equals(l.get(place))){
				rank = place;
			}
			
			if(needed.equals(l.get(place))){
				need = place;
			}
			place ++;
		}
		
		if(rank >= need){
			return true;
		}
		
		return false;
	}
	
	public Ranks getRankFromID(int ID){
		
		Ranks rank = Ranks.DEFAULT;
		
		switch(ID){
		
		case 0: rank = Ranks.DEFAULT;
			break;
		case 1: rank = Ranks.ULTIMATE;
			break;
		case 2: rank = Ranks.PLATINUM;
			break;
		case 3: rank = Ranks.BUILDER;
			break;
		case 4: rank = Ranks.INTERN;
			break;
		case 5: rank = Ranks.MOD;
			break;
		case 6: rank = Ranks.ADMIN;
			break;
		case 7: rank = Ranks.OWNER;
			break;
		default: rank = Ranks.DEFAULT;
			break;
		}
		
		return rank;
	}
}
