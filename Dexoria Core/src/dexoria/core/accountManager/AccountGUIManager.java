package dexoria.core.accountManager;

import java.util.HashMap;
import java.util.Map;

public class AccountGUIManager {
	
	public AccountGUIManager(){
	}
	/**
	 * String: Players name
	 * AccountGUI instance.
	 */
	public Map<String, AccountGUI> openGUIs = new HashMap<String, AccountGUI>();
	
	
	public AccountGUI getGUI(String whoclicked){
		return openGUIs.get(whoclicked);
	}
	
	public boolean contains(String staffName){
		return openGUIs.containsKey(staffName);
	}
	
	public void removeGUI(String staffName){
		openGUIs.remove(staffName);
	}
}
