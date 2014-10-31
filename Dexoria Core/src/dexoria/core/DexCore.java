package dexoria.core;

import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import dexoria.core.account.AccountSystem;
import dexoria.core.commands.Commands;
import dexoria.core.currency.CurrencySystem;
import dexoria.core.eventManager.EventManager;
import dexoria.core.mysql.MySQL;
import dexoria.core.utils.Config;

public class DexCore extends JavaPlugin {
	
	public static DexCore instance;
	/*
	 * Dexoria currency system
	 */
	public static CurrencySystem cs;
	
	private MySQL sql;
	
	private Config config;
	
	public static AccountSystem as;
	
	public void onEnable() {
		instance = this;
		
		EventManager.registerEvents();
		
		this.getCommand("currency").setExecutor(new Commands());
		this.getCommand("c").setExecutor(new Commands());
		
		cs = new CurrencySystem();
		as = new AccountSystem();
		
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
		
		try {
			sql.openConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void onDisable() {
		instance = null;
		
		try {
			sql.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.config.onDisable();
		
		cs = null;
		as = null;
	}
	
	public static DexCore getInstance(){
		return instance;
	}
	
	public static CurrencySystem getCurrencySystem() {
		return cs;
	}
	
    public Config getConfigInstannce() {
    	return this.config;
	}

    public static Config getConfigStaticly() {
		return instance.getConfigInstannce();
    }	
    
    public MySQL getSQL(){
    	return sql;
    }
    
    public static MySQL getSQLStaticly(){
    	return instance.getSQL();
    }
    
    public static AccountSystem getAccountSystem(){
    	return as;
    }
}
