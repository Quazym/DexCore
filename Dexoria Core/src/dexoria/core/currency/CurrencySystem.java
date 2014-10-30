package dexoria.core.currency;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;

import dexoria.core.DexCore;
import dexoria.core.sqlDatabases.Currency;

public class CurrencySystem
{

  public boolean playerExists(String playerUUID)
  {
    try
    {
      ResultSet res = DexCore.getSQLStaticly().querySQL("SELECT * FROM Currency WHERE playerUUID = '" + playerUUID + "';");

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

  public void addPlayer(String playerUUID)
  {
    try {
      DexCore.getSQLStaticly().updateSQL("INSERT INTO Currency (`ID`, `playerUUID`, `GC`, `CC`) VALUES (NULL, '" + playerUUID + "', '1000' , '0');");
    }
    catch (SQLException|ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public void addPlayerIfMissing(final String playerUUID) {
    Bukkit.getScheduler().runTaskAsynchronously(DexCore.instance, new Runnable()
    {
      public void run() {
        if (!Currency.getCurrencySystem().playerExists(playerUUID))
          Currency.getCurrencySystem().addPlayer(playerUUID);
      }
    });
  }

  public int getPlayerGC(String playerUUID)
  {
    try {
      ResultSet res =  DexCore.getSQLStaticly().querySQL("SELECT * FROM Currency WHERE playerUUID = '" + playerUUID + "';");
      res.next();
      return res.getInt("GC");
    }
    catch (SQLException|ClassNotFoundException e) {
      e.printStackTrace();
    }
    return 0;
  }

  public void setPlayerGC(String playerUUID, int score)
  {
    try {
    	 DexCore.getSQLStaticly().updateSQL("UPDATE Currency SET GC='" + score + "' WHERE playerUUID='" + playerUUID + "';");
    }
    catch (SQLException|ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public int getPlayerCC(String playerUUID)
  {
    try {
      ResultSet res =  DexCore.getSQLStaticly().querySQL("SELECT * FROM Currency WHERE playerUUID = '" + playerUUID + "';");
      res.next();
      return res.getInt("CC");
    }
    catch (SQLException|ClassNotFoundException e) {
      e.printStackTrace();
    }
    return 0;
  }

  public void setPlayerCC(String playerUUID, int score)
  {
    try {
    	 DexCore.getSQLStaticly().updateSQL("UPDATE Currency SET CC='" + score + "' WHERE playerUUID='" + playerUUID + "';");
    }
    catch (SQLException|ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
