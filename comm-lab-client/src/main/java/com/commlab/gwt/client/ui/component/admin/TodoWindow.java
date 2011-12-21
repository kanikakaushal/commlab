package com.commlab.gwt.client.ui.component.admin;

import com.smartgwt.client.widgets.Window;

public class TodoWindow extends Window{
	public static final String  TITLE="Todo Actvivity";
	
	public TodoWindow() {
		
	        this.setTitle(TITLE);  
	        this.setWidth(295);  
	        this.setHeight100();
	        this.setCanDragReposition(false);  
	        this.setCanDragResize(false);
	        this.setShowMinimizeButton(false);
	        this.setShowMaximizeButton(false);
	        this.setShowCloseButton(false);
	}

}
