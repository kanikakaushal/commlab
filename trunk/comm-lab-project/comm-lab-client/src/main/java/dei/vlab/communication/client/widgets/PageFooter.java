package dei.vlab.communication.client.widgets;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

public class PageFooter extends ToolStrip {
	public static String STAUTS_READY = "Status : Ready";
	public static String STAUTS_WAIT = "Status : Please wait...";
	public static String FIREBUG_WARNING = "Firebug can make the Showcase run slow."
		+ " For the best performance, we suggest disabling Firebug for this site.";
	public static String CSS_FOOTER_TITLE = "commlabFoolterTitle ";
	public static String BLANK = "";
	private Label message;
	private Label status;

	public PageFooter() {
		this.status = new Label(STAUTS_WAIT);
		this.message = new Label(BLANK);
		init();
	}

	private void init() {
		this.setWidth100();
		this.setHeight(20);
		this.addSpacer(6);
		this.status.setStyleName(CSS_FOOTER_TITLE);
		this.status.setWidth(150);
		this.addMember(status);
		this.addSeparator();
		this.message.setStyleName(CSS_FOOTER_TITLE);
		this.message.setWidth100();
		this.addMember(message);
		if (SC.hasFirebug()) {
			this.setMessage(FIREBUG_WARNING);
		}

	}

	public void setMessage(String message) {
		this.message.setContents(message);
	}

	public void setStatus(String status) {
		this.status.setContents(status);
	}
}
