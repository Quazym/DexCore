package dexoria.core.messageFormat;

import org.bukkit.ChatColor;

public class Format {

	MessageType mt;
	
	public Format(MessageType type){
		this.mt = type;
	}
	
	public String getMessage(){
		String message = "";
		
		switch(mt){
		case DEATH: message = ChatColor.BLUE + "Death > ";
			break;
		case JOIN:  message = ChatColor.BLUE + "Join >";
			break;
		case KILLED:  message = ChatColor.BLUE + "Kill > ";
			break;
		case LEAVE:  message = ChatColor.BLUE + "Leave > ";
			break;
		case PUNISHED:  message = ChatColor.BLUE + "Punished > ";
			break;
		case ABILITY:  message = ChatColor.BLUE + "Ability > "
		        break;
                case DONATION:  message = ChatColor.BLUE + "Donation > "
                        break;
                case RANK:  message = ChatColor.BLUE + "Rank > "
                        break;
		}
		
		return message;
	}
	
	public String getCustomPrefix(String prefix){
		String message = ChatColor.BLUE + prefix + " >"; 
		
		return message;
	}
}
