package dei.vlab.communication.client.page.decorator;

import com.smartgwt.client.widgets.layout.VLayout;

import dei.vlab.communication.client.data.User;
import dei.vlab.communication.client.handler.ToggleBodyClickHandler;
import dei.vlab.communication.client.page.builder.AdminPageBuilder;
import dei.vlab.communication.client.page.builder.PageBuilder;
import dei.vlab.communication.client.page.builder.WorkspacePageBuilder;
import dei.vlab.communication.client.widgets.PageBody;
import dei.vlab.communication.client.widgets.PageFooter;
import dei.vlab.communication.client.widgets.PageHeader;

public class ApplicationPageDecorator implements PageDecorator {

	public static String BODY_STYLE = "tabSetContainer";
	private PageBuilder pageBuilder;
	private VLayout main;

	PageBody pageBody;
	PageHeader header;
	PageFooter footer;

	private ToggleBodyClickHandler toggleBodyClickHandler;

	public ApplicationPageDecorator() {
		this(null);
	}

	public ApplicationPageDecorator(User user ) {
		this.main = new VLayout();

		if (null!=user && user.isAdmin()) {
			pageBuilder = new AdminPageBuilder();
			header = (PageHeader) pageBuilder.buildHeader();
			footer = (PageFooter) pageBuilder.buildFooter();
			pageBody = (PageBody) pageBuilder.buildBody();
			this.header.addToggleBodyClickHandler(configToggleBodyClickHandlerProp());
		} else {
			pageBuilder = new WorkspacePageBuilder();
			header = (PageHeader) pageBuilder.buildHeader();
			footer = (PageFooter) pageBuilder.buildFooter();
			pageBody = (PageBody) pageBuilder.buildBody();
		}
			header.setUserName(user.getUserName());
		}

	private ToggleBodyClickHandler configToggleBodyClickHandlerProp() {
		PageBody wsPageBody = (PageBody) new WorkspacePageBuilder().buildBody();
		ToggleBodyClickHandler tbClickHandler = new ToggleBodyClickHandler(this.main);
		tbClickHandler.setAdminPageBody(pageBody);
		tbClickHandler.setWsPagebBody(wsPageBody);
		return tbClickHandler;
	}

	public void render() {
		main.addMember(this.header);
		main.addMember(this.pageBody);
		main.addMember(this.footer);
		main.setWidth100();
		main.setHeight100();
		main.setStyleName(BODY_STYLE);
		main.draw();
	}

}
