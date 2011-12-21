package com.commlab.gwt.client.ui.common.component;

import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class Header extends ToolStrip{
	public static String COMMUNICATION_LAB_TITLE="Communication Lab";
	public static String CSS_HEADER_TITLE="commlabHeaderTitle";
	 
	
	public Header() {
		final Img image = new Img("others/wave.jpg", 100,40);
        this.setHeight(75);
        this.setWidth100();
        this.addSpacer(6);
        this.addSpacer(6);
        Label title = new Label(COMMUNICATION_LAB_TITLE);
        title.setStyleName(CSS_HEADER_TITLE);
        title.setWidth(300);
        this.addMember(title);
        this.addFill();
        this.addSpacer(6);
        this.addMember(image);
        this.addSpacer(6);
	}
}
