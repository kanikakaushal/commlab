package dei.vlab.communication.client.widgets.tools;

import java.util.LinkedHashMap;

import org.apache.cxf.tools.common.toolspec.ToolSpec;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.TabBarControls;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.WidgetCanvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.LayoutSpacer;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.tab.events.TabSelectedEvent;
import com.smartgwt.client.widgets.tab.events.TabSelectedHandler;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

import dei.vlab.communication.client.contoller.ExpermentController;
import dei.vlab.communication.client.event.EditorEvent;
import dei.vlab.communication.client.handler.AddCircuitHander;
import dei.vlab.communication.client.handler.EditorEventHandler;

public class Editor extends TabSet implements EditorEventHandler {
	public HLayout mainPanel;
	public CircuitPalette circuitPalette;

	public void setCircuitPalette(CircuitPalette circuitPalette) {
		this.circuitPalette = circuitPalette;
	}

	public Editor() {

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
		this.setTabBarControls(TabBarControls.TAB_SCROLLER,
				TabBarControls.TAB_PICKER, layoutSpacer, form);

		this.mainPanel = new HLayout();
		mainPanel.setHeight100();
		mainPanel.setWidth100();

	}

	private SelectItem getSkinSection() {
		SelectItem selectItem = new SelectItem();
		selectItem.setHeight(21);
		selectItem.setWidth(130);
		LinkedHashMap<String, String> valueMap = new LinkedHashMap<String, String>();
		valueMap.put("EnterpriseBlue", "Enterprise Blue");
		valueMap.put("Enterprise", "Enterprise Gray");
		valueMap.put("Graphite", "Graphite");
		valueMap.put("Simplicity", "Simplicity");

		selectItem.setValueMap(valueMap);

		final String skinCookieName = "skin_name_2_4";
		String currentSkin = Cookies.getCookie(skinCookieName);
		if (currentSkin == null) {
			currentSkin = "EnterpriseBlue";
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

	public void createTab(String name) {
		Tab tab = new Tab();
		tab.setTitle(name + "&nbsp;&nbsp;");
		tab.setID(name);
		tab.setIcon("icons/16/workspace.png", 16);
		tab.setWidth(80);
		Canvas tabPanel = new Canvas();
		tabPanel.setWidth100();
	    tabPanel.setHeight100();
	    VerticalPanel drwLayout = new VerticalPanel();
		ExpermentPanel expermentPanel = createExpermantPanel();
		Widget w = expermentPanel.asWidget();
		w.getElement().getStyle().setMargin(10, Unit.PX);
		w.getElement().getStyle().setProperty("border", "1px solid #cccccc");
		drwLayout.add(w);
		tabPanel.addChild(drwLayout);
		tab.setPane(tabPanel);
		this.addTab(tab);
		this.selectTab(name);
		expermentPanel.draw();
		expermentPanel.registerConroller();

	}

	public void createTab(String name, String icon) {
		Tab tab = new Tab();
		tab.setTitle(name);
		tab.setIcon(icon, 16);
		tab.setWidth(80);
		tab.setID(name);
		tab.setPane(mainPanel);
		this.addTab(tab);
		this.selectTab(name);

	}

	public void addEditorTab(Tab tab) {
		if (tab != null) {
			if (this.getTab(tab.getID()) == null) {
				this.addTab(tab);
			}
			this.selectTab(tab.getID());
		} else {
			SC.warn("Can't set blank tab");
		}

	}

	public void openTab(EditorEvent event) {
		addEditorTab(event.getTab());

	}

	private ExpermentPanel createExpermantPanel() {
		
		ExpermentController currentController = null;
		
		if (currentController != null) {
			currentController.clearDiagram();
		} else {
			currentController = new ExpermentController(400,200);
		}
		ExpermentPanel expermentPanel = new ExpermentPanel(currentController);
		AddCircuitHander circuitHander = new AddCircuitHander(expermentPanel);
		circuitPalette.setAddCircuitHander(circuitHander);
		return expermentPanel;
		
		
	/*	SimplePanel expermentLayout = new SimplePanel();
		expermentLayout.setHeight("100%");
		expermentLayout.setWidth("100%");
		expermentLayout.setVisible(true);
		
		
		
		
	expermentLayout.addAttachHandler(new AttachEvent.Handler() {

			  public void onAttachOrDetach(AttachEvent event) {
				  try{
					    SimplePanel panel = (SimplePanel)event.getSource();
					  	ExpermentController currentController = null;
						
						if (currentController != null) {
							currentController.clearDiagram();
						} else {
							currentController = new ExpermentController(panel.getOffsetWidth(),panel.getOffsetHeight());
						}
						ExpermentPanel expermentPanel = new ExpermentPanel(currentController);
						AddCircuitHander circuitHander = new AddCircuitHander(expermentPanel);
						circuitPalette.setAddCircuitHander(circuitHander);
						Widget w = expermentPanel.asWidget();
						//w.getElement().getStyle().setMargin(10, Unit.PX);
						//w.getElement().getStyle().setProperty("border", "1px solid #cccccc");
						panel.setWidget(new WidgetCanvas(w));
						
						expermentPanel.draw();
						expermentPanel.registerConroller();
						}
					catch (Exception e) {
						SC.say(e.getLocalizedMessage());
					}
					
			  }
			});
		return expermentLayout;*/
		
	}

}
