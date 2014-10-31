package dexoria.core.sqlDatabases;

import org.bukkit.Bukkit;

import dexoria.core.DexCore;

public class DatabaseManager {
	
	public static void onPlayerFirstLogin(String UUID){
		DexCore.getCurrencySystem().addPlayerIfMissing(UUID);
		DexCore.getAccountSystem().addPlayerIfMissing(UUID, Bukkit.getPlayer(UUID).getName());
	}
	
}
