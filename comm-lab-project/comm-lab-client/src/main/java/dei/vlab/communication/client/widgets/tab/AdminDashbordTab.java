package dei.vlab.communication.client.widgets.tab;

import dei.vlab.communication.client.widgets.grid.UserWFGrid;
import dei.vlab.communication.client.widgets.tools.AdminToolBar;

public class AdminDashbordTab extends AbstractTab {
	public static String ADMIN_DASHBOARD_TAB_ID = "ADMIN_DASHBOARD_TAB_ID";
	public static String ADMIN_DASHBOARD_TITLE = "Dashboard&nbsp;&nbsp;";
	public static String ADMIN_DASHBOARD_ICON = "icons/16/admin.gif";

	private AdminToolBar toolSection;
	private UserWFGrid userList;

	public AdminDashbordTab() {
		super(ADMIN_DASHBOARD_TAB_ID);
		setCanClose(false);
		setTabTitle(ADMIN_DASHBOARD_TITLE);
		setIcon(ADMIN_DASHBOARD_ICON, 16);
		setTabHeight100();
		setTabWidth100();

		this.toolSection = new AdminToolBar();
		this.userList = new UserWFGrid();
		addTabMember(toolSection);
		addTabMember(userList);

	}

	public AdminToolBar getToolSection() {
		return toolSection;
	}

	public UserWFGrid getUserList() {
		return userList;
	}

}
