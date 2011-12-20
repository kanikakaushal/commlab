package com.commlab.gwt.client.ui.component;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuBar;
import com.smartgwt.client.widgets.menu.MenuButton;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.menu.MenuItemSeparator;

public class LabMenu {

	
	public MenuBar createMenu(){
	        Menu activityMenu = new Menu();
	        activityMenu.setTitle("Activity");
	        activityMenu.setShowShadow(true);
	        activityMenu.setShadowDepth(10);
	        MenuItem newItem = new MenuItem("New", "icons/16/document_plain_new.png", "Ctrl+N");
	        MenuItem openItem = new MenuItem("Open", "icons/16/folder_out.png", "Ctrl+O");
	        MenuItem saveItem = new MenuItem("Save", "icons/16/disk_blue.png", "Ctrl+S");
	        MenuItem saveAsItem = new MenuItem("Save As", "icons/16/save_as.png");
	        MenuItem recentItem = new MenuItem("Recent", "icons/16/save_as.png");
	        MenuItemSeparator separator = new MenuItemSeparator();
	        activityMenu.setItems(newItem, openItem, separator, saveItem, saveAsItem,separator,recentItem);
	        
	        Menu editMenu = new Menu();
	        editMenu.setTitle("Edit");
	        editMenu.setShowShadow(true);
	        editMenu.setShadowDepth(10);
	        MenuItem copyItem = new MenuItem("Copy", "icons/16/document_plain_new.png", "Ctrl+N");
	        MenuItem cutItem = new MenuItem("Cut", "icons/16/folder_out.png", "Ctrl+O");
	        MenuItem undoItem = new MenuItem("Undo", "icons/16/disk_blue.png", "Ctrl+S");
	        MenuItem redoItem = new MenuItem("Redo", "icons/16/save_as.png");
	        editMenu.setItems(copyItem, cutItem, separator, undoItem, redoItem);


	        Menu runMenu = new Menu();
	        runMenu.setTitle("Run");
	        runMenu.setShowShadow(true);
	        runMenu.setShadowDepth(10);
	        MenuItem executeItem = new MenuItem("Execute", "icons/16/document_plain_new.png", "Ctrl+N");
	        MenuItem simulateItem = new MenuItem("Simulate", "icons/16/folder_out.png", "Ctrl+O");
	        MenuItem viewLogItem = new MenuItem("View Log", "icons/16/disk_blue.png", "Ctrl+S");
	        MenuItem verifyCircuitItem = new MenuItem("Verify Circuit", "icons/16/save_as.png");
	        runMenu.setItems(executeItem, simulateItem, viewLogItem, verifyCircuitItem);


	        
	        Menu helpMenu = new Menu();
	        helpMenu.setTitle("Help");
	        helpMenu.setShowShadow(true);
	        helpMenu.setShadowDepth(10);
	        MenuItem welcomeItem = new MenuItem("Welcome", "icons/16/document_plain_new.png", "Ctrl+N");
	        MenuItem contentsItem = new MenuItem("Help Contnets", "icons/16/folder_out.png", "Ctrl+O");
	        MenuItem searchItem = new MenuItem("Search", "icons/16/disk_blue.png", "Ctrl+S");
	        MenuItem aboutItem = new MenuItem("About Us", "icons/16/save_as.png");
	        helpMenu.setItems(welcomeItem, separator, contentsItem, searchItem,separator, aboutItem);
	        
	        com.smartgwt.client.widgets.menu.MenuBar menuBar = new com.smartgwt.client.widgets.menu.MenuBar();
	        menuBar.setMenus(activityMenu,editMenu,runMenu,helpMenu);
	        menuBar.setWidth100();
	       
	        return menuBar;


	}

}
