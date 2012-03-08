package dei.vlab.communication.client.widgets.tab;

import com.google.gwt.user.client.ui.Widget;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;

public abstract class AbstractTab extends Tab {
	private VLayout tabLayoutPanel = new VLayout();

	public AbstractTab(String ID) {
		super(ID);
		this.setID(ID);
		this.setWidth(150);
		this.setPane(tabLayoutPanel);
		this.setCanClose(true);
	}

	public void addTabMember(Canvas canvas) {
		this.tabLayoutPanel.addMember(canvas);
	}

	public void addTabMember(Widget widget) {
		this.tabLayoutPanel.addMember(widget);
	}

	public void setTabHeight100() {
		this.tabLayoutPanel.setHeight100();

	}

	public void setTabHeight(int height) {
		this.tabLayoutPanel.setHeight(height);
	}

	public void setTabWidth100() {
		this.tabLayoutPanel.setWidth100();
	}

	public void setTabWidth(int width) {
		this.tabLayoutPanel.setWidth(width);
	}

	public void setTabTitle(String title) {
		this.setTitle(title);
	}

	public void setTabIcon(String icon) {
		this.setIcon(icon);

	}


}
