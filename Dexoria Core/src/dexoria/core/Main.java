package dexoria.core;

import dexoria.core.eventManager.EventManager;

public class Main {
	
	public static Main instance;
	
	public void onEnable() {
		instance = this;
		
		EventManager.registerEvents();
	}
	
	public void onDisable() {
		instance = null;
	}
	
	public static Main getInstance(){
		return instance;
	}
}
