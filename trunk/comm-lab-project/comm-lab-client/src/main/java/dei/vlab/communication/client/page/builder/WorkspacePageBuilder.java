package dei.vlab.communication.client.page.builder;

import com.google.gwt.user.client.ui.Widget;
import com.smartgwt.client.widgets.layout.VLayout;

import dei.vlab.communication.client.handler.SignOutClickHandler;
import dei.vlab.communication.client.handler.WSMenuClickHander;
import dei.vlab.communication.client.widgets.PageBody;
import dei.vlab.communication.client.widgets.PageFooter;
import dei.vlab.communication.client.widgets.PageHeader;
import dei.vlab.communication.client.widgets.tools.CircuitPalette;
import dei.vlab.communication.client.widgets.tools.WorkspaceMenu;

public class WorkspacePageBuilder implements PageBuilder {

	private PageHeader header;
	private PageFooter footer;
	private PageBody body;
	private WorkspaceMenu menu;

	public WorkspacePageBuilder() {
		this.header = new PageHeader(false);
		this.footer = new PageFooter();
		this.body = new PageBody();
		this.menu = new WorkspaceMenu();
	}

	public Widget buildHeader() {
		this.header.addSignOutClickHandler(new SignOutClickHandler());
		return this.header;
	}

	public Widget buildBody() {
		WSMenuClickHander clickHander= new WSMenuClickHander(this.body.getTabSet());
		this.body.addMenu(this.menu.createMenu(clickHander));
		this.body.addNavigationWidget(new CircuitPalette());
		return this.body;
	}

	@Override
	public Widget buildFooter() {
		// TODO Auto-generated method stub
		return this.footer;
	}

}
