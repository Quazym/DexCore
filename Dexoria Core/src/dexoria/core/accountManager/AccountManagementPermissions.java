package dexoria.core.accountManager;

public class AccountManagementPermissions {
	
	/*
	 * Can do everything in the AccountGUI.
	 */
	public static final String ALL = "accountgui.*";
	
	/*
	 * Open HubGUI
	 */
	public static final String OPEN_MAIN_GUI = "accountgui.open";
	
	/*
	 * Punishment Permissions
	 */
	public static final String PUNISH_OPEN = "accountgui.punish.open";
	
	public static final String INTERN_PUNISH = "accountgui.punish.intern";
	public static final String FULL_PUNISH = "accountgui.punish.full";
	
	/*
	 * RankSet Permissions
	 */
	public static final String RANK_OPEN = "accountgui.rank.open";
	
	public static final String RANK_SET_ANY = "accountgui.rank.*";
	
	public static final String RANK_SET_DEFAULT = "accountgui.rank.default";
	
	public static final String RANK_SET_ULTIMATE = "accountgui.rank.ultimate";
	public static final String RANK_SET_PLATINUM = "accountgui.rank.platinum";
	
	public static final String RANK_SET_BUILDER = "accountgui.rank.builder";
	public static final String RANK_SET_INTERN = "accountgui.rank.intern";
	public static final String RANK_SET_MOD = "accountgui.rank.mod";
	public static final String RANK_SET_ADMIN = "accountgui.rank.admin";
	
	public static final String RANK_SET_OWNER = "accountgui.rank.owner";
	
	/*
	 * Currency Permissions
	 */
	
	public static final String CURRENCY_OPEN = "accountgui.currency.open";
	
	public static final String CURRENCY_SET = "accountgui.currency.set";
}
