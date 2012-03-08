package dei.vlab.communication.client.handler;

import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;

import dei.vlab.communication.client.widgets.PageBody;
import dei.vlab.communication.client.widgets.PageHeader;

public class ToggleBodyClickHandler implements ClickHandler {
	private VLayout main;
	private PageBody adminPageBody;
	private PageBody wsPagebBody;

	public void setAdminPageBody(PageBody adminPageBody) {
		this.adminPageBody = adminPageBody;
	}

	public void setWsPagebBody(PageBody wsPagebBody) {
		this.wsPagebBody = wsPagebBody;
	}

	public ToggleBodyClickHandler(VLayout main) {
		this.main = main;
	}

	public void onClick(ClickEvent event) {
		ToolStripButton stripButton = (ToolStripButton)event.getSource();
		String id =stripButton.getID();
		switchTo(id);
	}

	private void switchTo(String id) {
		if(PageHeader.ADMIN_TB_ID.equalsIgnoreCase(id)){
			main.removeMember(wsPagebBody);
			main.addMember(adminPageBody, 1);
		}
		if(PageHeader.WS_TB_ID.equalsIgnoreCase(id)){
			main.removeMember(adminPageBody);
			main.addMember(wsPagebBody, 1);
		}
		
	}
}
