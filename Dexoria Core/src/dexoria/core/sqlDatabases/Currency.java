package dexoria.core.sqlDatabases;

import dexoria.core.DexCore;
import dexoria.core.currency.CurrencySystem;

public class Currency 
{

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

  public static CurrencySystem getCurrencySystem() {
    return DexCore.getCurrencySystem();
  }
}