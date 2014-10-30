package dexoria.core;

import org.bukkit.plugin.java.JavaPlugin;

import dexoria.core.commands.Commands;
import dexoria.core.currency.CurrencySystem;
import dexoria.core.eventManager.EventManager;

public class DexCore extends JavaPlugin {
	
	public static DexCore instance;
	public static CurrencySystem cs;
	
	public void onEnable() {
		instance = this;
		
		EventManager.registerEvents();
		
		this.getCommand("currency").setExecutor(new Commands());
		this.getCommand("c").setExecutor(new Commands());
	}
	
	public void onDisable() {
		instance = null;
	}
	
	public static DexCore getInstance(){
		return instance;
	}
	
	public static CurrencySystem getCurrencySystem() {
		return cs;
		
	}
}
