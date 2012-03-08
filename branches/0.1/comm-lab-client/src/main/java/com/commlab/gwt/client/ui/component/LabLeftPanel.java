package com.commlab.gwt.client.ui.component;

import java.util.LinkedHashMap;

import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;
import com.smartgwt.client.types.TabBarControls;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.LayoutSpacer;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.tab.events.TabSelectedEvent;
import com.smartgwt.client.widgets.tab.events.TabSelectedHandler;

public class LabLeftPanel extends TabSet {
	
	public LabLeftPanel() {

        Layout paneContainerProperties = new Layout();
        paneContainerProperties.setLayoutMargin(0);
        paneContainerProperties.setLayoutTopMargin(1);
        this.setPaneContainerProperties(paneContainerProperties);

        this.setWidth100();
        this.setHeight100();
        this.addTabSelectedHandler(new TabSelectedHandler() {
          public void onTabSelected(TabSelectedEvent event) {
              Tab selectedTab = event.getTab();
              String historyToken = selectedTab.getAttribute("historyToken");
              if (historyToken != null) {
                  History.newItem(historyToken, false);
              } else {
                  History.newItem("main", false);
              }
          }
      });
        

        SelectItem selectItem = getSkinSection();
        LayoutSpacer layoutSpacer = new LayoutSpacer();
        layoutSpacer.setWidth(5);

        DynamicForm form = new DynamicForm();
        form.setPadding(0);
        form.setMargin(0);
        form.setCellPadding(1);
        form.setNumCols(1);
        form.setFields(selectItem);
        this.setTabBarControls(TabBarControls.TAB_SCROLLER, TabBarControls.TAB_PICKER, layoutSpacer, form);
        
        
        Tab tab = new Tab();
        tab.setTitle("noname&nbsp;&nbsp;");
        //tab.setIcon("pieces/16/cube_green.png", 16);
        tab.setWidth(80);

        HLayout mainPanel = new HLayout();
        mainPanel.setHeight100();
        mainPanel.setWidth100();

        tab.setPane(mainPanel);

        this.addTab(tab);

        
	}
	private SelectItem getSkinSection() {
		SelectItem selectItem = new SelectItem();
        selectItem.setHeight(21);
        selectItem.setWidth(130);
        LinkedHashMap<String, String> valueMap = new LinkedHashMap<String, String>();
        valueMap.put("Enterprise Blue", "Enterprise Blue");
        valueMap.put("Enterprise Gray", "Enterprise Gray");
        valueMap.put("Graphite", "Graphite");
        valueMap.put("Simplicity", "Simplicity");


        selectItem.setValueMap(valueMap);

        final String skinCookieName = "comm_lab_skin";
        String currentSkin = Cookies.getCookie(skinCookieName);
        if (currentSkin == null) {
            currentSkin = "Enterprise Blue";
        }
        selectItem.setDefaultValue(currentSkin);
        selectItem.setShowTitle(false);
        selectItem.addChangeHandler(new ChangeHandler() {
            public void onChange(ChangeEvent event) {
                Cookies.setCookie(skinCookieName, (String) event.getValue());
                com.google.gwt.user.client.Window.Location.reload();
            }
        });
		return selectItem;
	}
}
