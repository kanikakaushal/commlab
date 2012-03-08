package dei.vlab.communication.client.handler;

import com.google.gwt.user.client.Window;
import com.smartgwt.client.widgets.menu.events.ClickHandler;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;

import dei.vlab.communication.client.widgets.tools.Editor;
import dei.vlab.communication.client.widgets.tools.WorkspaceMenu;

public class WSMenuClickHander implements  ClickHandler {

	private Editor tabSet;
	private int tabCount=01;

	public WSMenuClickHander(Editor tabSet) {
		this.tabSet=tabSet;
	}
	public void onClick(MenuItemClickEvent event) {
		String clickedItem = event.getItem().getTitle();
	
		/* File Menu Items*/
		if(WorkspaceMenu.NEW.equalsIgnoreCase(clickedItem)){
			this.tabSet.createTab("noname"+tabCount);
			tabCount++;
		}
		if(WorkspaceMenu.OPEN.equalsIgnoreCase(clickedItem)){
			Window.alert(event.getItem().getTitle());
		}
		if(WorkspaceMenu.SAVE.equalsIgnoreCase(clickedItem)){
			Window.alert(event.getItem().getTitle());
		}
		if(WorkspaceMenu.SAVE_AS.equalsIgnoreCase(clickedItem)){
			Window.alert(event.getItem().getTitle());
		}
		if(WorkspaceMenu.RECENT.equalsIgnoreCase(clickedItem)){
			Window.alert(event.getItem().getTitle());
		}
	
		
	}

}
