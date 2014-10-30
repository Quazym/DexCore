package dexoria.core.sqlDatabases;

import java.sql.SQLException;

import org.bukkit.Bukkit;

import dexoria.core.DexCore;
import dexoria.core.currency.CurrencySystem;
import dexoria.core.mysql.MySQL;
import dexoria.core.utils.Config;

public class Currency 
{
  private Config config;
  private MySQL sql;
  public static Currency instance;
  private CurrencySystem ss;

  public void onEnable()
  {
    instance = this;

    this.config = new Config();
    this.config.onEnable();
    
    Bukkit.getLogger().info("Oppining MySQL connection on:" +
    		   "\n" + getConfigStaticly().getDBDatabase() +
    		   "\n" + getConfigStaticly().getDBPort() +
    		   "\n" + getConfigStaticly().getDBDatabase() +
    	      "\n" +getConfigStaticly().getDBUsername() + 
    	      "\n" + getConfigStaticly().getDBPassword() );
    
    
    this.sql = new MySQL(DexCore.instance, 
      getConfigStaticly().getDBHostName(), 
      getConfigStaticly().getDBPort(), 
      getConfigStaticly().getDBDatabase(), 
      getConfigStaticly().getDBUsername(), 
      getConfigStaticly().getDBPassword());

    this.ss = new CurrencySystem();
    this.ss.onEnable();
  }

  public void onDisable()
  {
    instance = null;
    try
    {
      this.sql.closeConnection();
    }
    catch (SQLException localSQLException)
    {
    }

    this.sql = null;

    this.config.onDisable();
    this.ss.onDisable();
  }

  public static boolean hasEnoughGC(String playerUUID, int amount)
  {
    if (getGC(playerUUID) >= amount)
      return true;
    return false;
  }

  public static boolean hasEnoughCC(String playerUUID, int amount)
  {
    if (getCC(playerUUID) >= amount)
      return true;
    return false;
  }

  public static void addGC(String playerUUID, int amount)
  {
    getCurrencySystem().setPlayerGC(playerUUID, getCurrencySystem().getPlayerGC(playerUUID) + amount);
  }

  public static void addCC(String playerUUID, int amount) {
    getCurrencySystem().setPlayerCC(playerUUID, getCurrencySystem().getPlayerCC(playerUUID) + amount);
  }

  public static void removeGC(String playerUUID, int amount)
  {
    getCurrencySystem().setPlayerGC(playerUUID, getCurrencySystem().getPlayerGC(playerUUID) - amount);
  }

  public static void removeCC(String playerUUID, int amount) {
    getCurrencySystem().setPlayerCC(playerUUID, getCurrencySystem().getPlayerCC(playerUUID) - amount);
  }

  public static int getGC(String playerUUID) {
    return getCurrencySystem().getPlayerGC(playerUUID);
  }

  public static int getCC(String playerUUID) {
    return getCurrencySystem().getPlayerCC(playerUUID);
  }

  public Config getConfigInstannce() {
    return this.config;
  }

  public static Config getConfigStaticly() {
    return instance.getConfigInstannce();
  }

  public static CurrencySystem getCurrencySystem() {
    return instance.ss;
  }
  public static MySQL getMySQL() {
    return instance.sql;
  }
}