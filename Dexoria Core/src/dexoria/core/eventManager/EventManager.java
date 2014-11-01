package dexoria.core.eventManager;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import dexoria.core.DexCore;
import dexoria.core.eventManager.events.join;

public class EventManager {
	
	/*
	 * In this class we will register all events from the core
	 * to keep the onEnable method clean
	 */
	public static void registerEvents(){
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new join(), DexCore.instance);
	}
	
}
