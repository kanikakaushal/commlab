package com.commlab.gwt.client.ui.component.admin;

import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class AdminLabRightPanel extends HLayout{
	private  LabCalander calander;
	private TodoWindow todoWindow;
	public AdminLabRightPanel() {
        this.setLayoutMargin(5);
        this.setWidth100();
        this.setHeight100();
        VLayout sideNavLayout = new VLayout();
        sideNavLayout.setHeight100();
        sideNavLayout.setWidth(285);
        sideNavLayout.setShowResizeBar(true);
        this.calander = new LabCalander();
        sideNavLayout.addMember(calander);

        this.addMember(sideNavLayout);
        todoWindow= new TodoWindow();
        sideNavLayout.addMember(todoWindow);
	}
}
