package com.commlab.gwt.client;

import com.commlab.gwt.client.ui.common.component.Footer;
import com.commlab.gwt.client.ui.common.component.Header;
import com.commlab.gwt.client.ui.component.LabLeftPanel;
import com.commlab.gwt.client.ui.component.LabMenu;
import com.commlab.gwt.client.ui.component.LabRightPanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.HistoryListener;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.VLayout;

public class Dashboard implements EntryPoint, HistoryListener {
   private LabLeftPanel mainTabSet;

    public void onModuleLoad() {
    	  LabMenu labMenu = new LabMenu();
    	  Header header = new Header();
    	  Footer footer = new Footer();
    	  LabRightPanel labRightPanel = new LabRightPanel();
          final String initToken = History.getToken();
          VLayout main = setupOverallLayout(initToken);
	      main.addMember(header);
	      main.addMember(labMenu.createMenu());
	      main.setWidth100();
	      main.setHeight100();
	      main.setStyleName("tabSetContainer");
          mainTabSet = new LabLeftPanel();
	        Canvas canvas = new Canvas();
	        canvas.setWidth100();
	        canvas.setHeight100();
	        canvas.addChild(mainTabSet);
        labRightPanel.addMember(canvas);
        main.addMember(labRightPanel);

        if (SC.hasFirebug()) {
        	footer.setNotification("Firebug can make the Showcase run slow. For the best performance, we suggest disabling Firebug for this site.");
        }
        main.addMember(footer);
        main.draw();

        // Add history listener
        History.addHistoryListener(this);

        RootPanel p = RootPanel.get("loadingWrapper");
        if (p != null) RootPanel.getBodyElement().removeChild(p.getElement());
    }


	private VLayout setupOverallLayout(final String initToken) {
		VLayout main = new VLayout() {
            @Override
            protected void onInit() {
                super.onInit();
                if (initToken.length() != 0) {
                    onHistoryChanged(initToken);
                }
            }
        };
		return main;
	}

 
   
    public void onHistoryChanged(String historyToken) {
        if (historyToken == null || historyToken.equals("")) {
            mainTabSet.selectTab(0);
        } 
    }
}
