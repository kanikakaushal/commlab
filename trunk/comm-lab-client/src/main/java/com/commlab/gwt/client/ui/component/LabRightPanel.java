package com.commlab.gwt.client.ui.component;

import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class LabRightPanel extends HLayout{
	private  CircuitSection circuitSection;
	public LabRightPanel() {
        this.setLayoutMargin(5);
        this.setWidth100();
        this.setHeight100();
        VLayout sideNavLayout = new VLayout();
        sideNavLayout.setHeight100();
        sideNavLayout.setWidth(185);
        sideNavLayout.setShowResizeBar(true);
        this.circuitSection = new CircuitSection();
        sideNavLayout.addMember(circuitSection.createSection());
        this.addMember(sideNavLayout);
	}
}
