package dexoria.core.sqlDatabases;

import dexoria.core.DexCore;

public class DatabaseManager {
	
	public static void onPlayerFirstLogin(String UUID){
		DexCore.getCurrencySystem().addPlayerIfMissing(UUID);
	}
	
}
