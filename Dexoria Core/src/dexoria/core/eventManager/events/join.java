package dexoria.core.eventManager.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import dexoria.core.sqlDatabases.DatabaseManager;

public class join implements Listener{

	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		if(!(e.getPlayer().hasPlayedBefore()))
			DatabaseManager.onPlayerFirstLogin(e.getPlayer().getUniqueId().toString());
	}
}
