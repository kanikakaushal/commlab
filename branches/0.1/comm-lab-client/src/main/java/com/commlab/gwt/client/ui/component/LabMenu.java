package com.commlab.gwt.client.ui.component;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.MenuItemSeparator;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripMenuButton;

public class LabMenu {
	
	public static final String HELP="Help";
	public static final String WELCOME="Welcome";
	public static final String HELP_CONTENTS="Help Contents";
	public static final String SEARCH="Search";
	public static final String ABOUT_US="About Us";

	public static final String ICON_WELCOME="icons/16/welcome.jpg";
	public static final String ICON_HELP_CONTENTS="icons/16/help.png";
	public static final String ICON_SEARCH="icons/16/search.png";

	
	public static final String ACTIVITY="Activity";
	public static final String NEW="New";
	public static final String OPEN="Open";
	public static final String SAVE="Save";
	public static final String SAVE_AS="Save As";
	public static final String RECENT="Recent";
	
	public static final String ICON_NEW = "icons/16/document_plain_new.png";
	public static final String ICON_OPEN = "icons/16/folder_out.png";
	public static final String ICON_SAVE = "icons/16/disk_blue.png";
	public static final String ICON_SAVE_AS = "icons/16/save_as.png";
	

	public static final String EDIT="Edit";
	public static final String COPY="Copy";
	public static final String CUT="Cut";
	public static final String PASTE="Paste";
	public static final String UNDO="Undo";
	public static final String REDO="Redo";
	
	public static final String ICON_COPY = "icons/16/copy.png";
	public static final String ICON_CUT = "icons/16/cut.png";
	public static final String ICON_PASTE = "icons/16/paste.png";
	public static final String ICON_REDO = "icons/16/redo.png";
	public static final String ICON_UNDO = "icons/16/undo.png";

	public static final String RUN="Run";
	public static final String EXECUTE="Execute";
	public static final String SIMULATE="Simulate";
	public static final String VIEW_LOG="View Log";
	public static final String VERIFY_CIRCUIT="Verify Circuit";
	
	public static final String ICON_EXECUTE = "icons/16/execute.png";
	public static final String ICON_VIEW_LOG = "icons/16/log.png";

	
	public ToolStrip createMenu(){
		  	ToolStrip menuStripBar = new ToolStrip();  
		  	menuStripBar.setWidth100();
			MenuItemSeparator separator = new MenuItemSeparator();
			ToolStripMenuButton activityMenu = createActivityMenu(separator);
			ToolStripMenuButton editMenu = createEditMenu(separator);
			ToolStripMenuButton runMenu = getRunMenu();
			ToolStripMenuButton helpMenu = createHelpMenu(separator);
			menuStripBar.addMenuButton(activityMenu);  
			menuStripBar.addMenuButton(editMenu);  
			menuStripBar.addMenuButton(runMenu);  
			menuStripBar.addMenuButton(helpMenu);  
	        return menuStripBar;
	}

	private ToolStripMenuButton createHelpMenu(MenuItemSeparator separator) {
		Menu helpMenu = new Menu();
		helpMenu.setShowShadow(true);
		helpMenu.setShadowDepth(10);
		MenuItem welcomeItem = new MenuItem(WELCOME, ICON_WELCOME);
		MenuItem contentsItem = new MenuItem(HELP_CONTENTS,ICON_HELP_CONTENTS);
		MenuItem searchItem = new MenuItem(SEARCH, ICON_SEARCH);
		MenuItem aboutItem = new MenuItem(ABOUT_US);
		helpMenu.setItems(welcomeItem, separator, contentsItem, searchItem,separator, aboutItem);
		ToolStripMenuButton helpButton = new ToolStripMenuButton(HELP, helpMenu);  
		helpButton.setWidth(100);  
		return helpButton;
	}

	private ToolStripMenuButton getRunMenu() {
		Menu runMenu = new Menu();
		runMenu.setShowShadow(true);
		runMenu.setShadowDepth(10);
		MenuItem executeItem = new MenuItem(EXECUTE, ICON_EXECUTE);
		MenuItem simulateItem = new MenuItem(SIMULATE);
		MenuItem viewLogItem = new MenuItem(VIEW_LOG, ICON_VIEW_LOG);
		MenuItem verifyCircuitItem = new MenuItem(VERIFY_CIRCUIT);
		runMenu.setItems(executeItem, simulateItem, viewLogItem, verifyCircuitItem);
		ToolStripMenuButton runButton = new ToolStripMenuButton(RUN, runMenu);  
		runButton.setWidth(100);  
		return runButton;
	}

	private ToolStripMenuButton createEditMenu(MenuItemSeparator separator) {
		Menu editMenu = new Menu();
			editMenu.setShowShadow(true);
		editMenu.setShadowDepth(10);
		MenuItem copyItem = new MenuItem(COPY, ICON_COPY);
		MenuItem cutItem = new MenuItem(CUT, ICON_CUT);
		MenuItem pasteItem = new MenuItem(PASTE, ICON_PASTE);
		MenuItem undoItem = new MenuItem(UNDO, ICON_UNDO);
		MenuItem redoItem = new MenuItem(REDO, ICON_REDO);
		editMenu.setItems( undoItem, redoItem,separator,copyItem, cutItem,pasteItem );
		ToolStripMenuButton editButton = new ToolStripMenuButton(EDIT, editMenu);  
		editButton.setWidth(100);  
		return editButton;
	}

	private ToolStripMenuButton createActivityMenu(MenuItemSeparator separator) {
		Menu activityMenu = new Menu();
		activityMenu.setShowShadow(true);
		activityMenu.setShadowDepth(10);
		MenuItem newItem = new MenuItem(NEW, ICON_NEW);
		MenuItem openItem = new MenuItem(OPEN, ICON_OPEN);
		MenuItem saveItem = new MenuItem(SAVE, ICON_SAVE);
		MenuItem saveAsItem = new MenuItem(SAVE_AS, ICON_SAVE_AS);
		MenuItem recentItem = new MenuItem(RECENT);		
		activityMenu.setItems(newItem, openItem, separator, saveItem, saveAsItem,separator,recentItem);
		ToolStripMenuButton activityButton = new ToolStripMenuButton(ACTIVITY, activityMenu);  
		activityButton.setWidth(100);  
		return activityButton;
	}

}
