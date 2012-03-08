package dei.vlab.communication.client.widgets.tab;

import dei.vlab.communication.client.widgets.grid.UserWFGrid;

public class UserWFTab extends AbstractTab {

	public static String USER_WF_TAB_ID = "USER_WF_TAB_ID";
	public static String USER_WF_TITLE = "User Management&nbsp;&nbsp;";
	public static String USER_WF_ICON = "tools/users.png";

	private UserWFGrid userGrid;

	public UserWFTab() {
		super(USER_WF_TAB_ID);
		setTabTitle(USER_WF_TITLE);
		setIcon(USER_WF_ICON, 16);
		setTabHeight100();
		setTabWidth100();
		this.userGrid = new UserWFGrid();
		addTabMember(userGrid);
	}

	public UserWFGrid getUserGrid() {
		return userGrid;
	}

}
