package com.commlab.gwt.client.ui.common.component;

import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class Footer extends ToolStrip{
	public static String STAUTS = "Status : Ready";
	public static String CSS_FOOTER_TITLE = "commlabFoolterTitle ";
	public static String BLANK = "";
	private Label message;
	public Footer() {
		this.setWidth100();
		this.addSpacer(6);
		Label status = new Label(STAUTS);
		status.setStyleName(CSS_FOOTER_TITLE);
		status.setWidth(100);
		this.addMember(status);
		this.addSeparator();  
		message= new Label(BLANK);
		message.setStyleName(CSS_FOOTER_TITLE);
		message.setWidth(700);
		this.addMember(message);
		this.addSeparator();  
	}
	
	public void setNotification(String Message){
		message.setContents(Message);
	}
}
