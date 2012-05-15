package dei.vlab.communication.client.page.builder;

import com.google.gwt.user.client.ui.Widget;

import dei.vlab.communication.client.handler.SignOutClickHandler;
import dei.vlab.communication.client.widgets.PageBody;
import dei.vlab.communication.client.widgets.PageFooter;
import dei.vlab.communication.client.widgets.PageHeader;
import dei.vlab.communication.client.widgets.navigation.TodoNavigator;
import dei.vlab.communication.client.widgets.tab.AdminDashbordTab;
import dei.vlab.communication.client.widgets.tools.Editor;

public class AdminPageBuilder  implements PageBuilder{
	private PageHeader header;
	private PageFooter footer;
	private PageBody body;

	public AdminPageBuilder() {
		this.header = new PageHeader(true);
		this.footer = new PageFooter();
		this.body = new PageBody();
	}


	public Widget buildHeader() {
		this.header.addSignOutClickHandler(new SignOutClickHandler());
		return this.header;
	}

	public Widget buildBody() {
		this.body.addNavigationWidget(new TodoNavigator());
		Editor editor = (Editor) this.body.getTabSet();
		AdminDashbordTab dashbordTab = new AdminDashbordTab();
		dashbordTab.getToolSection().addEditorEventHandler(editor);
		editor.addEditorTab(dashbordTab);
		return this.body;
	}

	public Widget buildFooter() {
		// TODO Auto-generated method stub
		return this.footer;
	}

}
