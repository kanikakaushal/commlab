package dei.vlab.communication.client.widgets;

import com.smartgwt.client.types.SelectionType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;
import com.smartgwt.client.widgets.toolbar.ToolStripSeparator;

import dei.vlab.communication.client.data.AccountDataSource;
import dei.vlab.communication.client.widgets.form.AccountForm;

public class PageHeader extends ToolStrip {
	private static String COMMUNICATION_LAB_TITLE = "<p style=\"text-shadow:1px 1px 0 #071705,2px 2px 0 #071705,3px 3px 0 #444,3px 3px 0 #444,2px 2px 0 #444,3px 3px 0 #444;\">" +
			"<span style=\"color: #E0E0E0; letter-spacing: 23px; font-family: 'Times New Roman',Times,serif; font-style: italic; font-variant: normal; font-weight: bold; font-size: 32px; line-height: 28px; font-size-adjust: none; font-stretch: normal\">RT-ACE</span>" +
			"<span style=\"color: #66CC99; letter-spacing: 1px; font-family: Georgia,'Times New Roman',Times,serif; font-style: italic; font-variant: normal; font-weight: bold; font-size: 32px; line-height: 28px; font-size-adjust: none; font-stretch: normal\">Lab</span>" +
			"<br/><span style=\"text-decoration:overline;text-shadow:none;color: #000000; letter-spacing: 1px; font-family: Arial,Helvetica,sans-serif; font-style: normal; font-variant: small-caps; font-weight: bold; font-size: 12px; line-height: 14px; font-size-adjust: none; font-stretch: normal\">Remote Trigger Analog Communication Electronics Lab</span>"+
			"</p>";
	private static String CSS_HEADER_TITLE = "commlabHeaderTitle";
	private static String CSS_USER = "commlabUserTitle";
	public static final String ICON_SIGNOUT = "icons/16/logout.png";
	public static final String ICON_WORKSPACE = "icons/16/workspace.png";
	public static final String ICON_ADMIN = "icons/16/admin.gif";
	public static final String ICON_PERSION_LOGIN = "icons/16/person.png";
	public static final String IMG_lOGO = "others/logo.png";
	
	public static final String ADMIN_TB_ID = "ADMIN_TB_ID";
	public static final String WS_TB_ID = "WS_TB_ID";
	public static final String AC_TB_ID="AC_TB_ID";

	private Label userNameLabel;
	private ToolStripSeparator separator;
	//private Img loginIcon;
	private HTMLPane title;
	private ToolStripButton signOutButton;
	private ToolStripButton wsButton;
	private ToolStripButton adminButton;
	private ToolStripButton accountButton;
	private AccountForm accountForm;

	public PageHeader(boolean isAdmin) {

		this.separator = new ToolStripSeparator();
		//this.loginIcon = new Img(ICON_PERSION_LOGIN, 16, 16);
		this.title = new HTMLPane();
		this.userNameLabel = new Label();
		this.adminButton = new ToolStripButton();
		this.wsButton = new ToolStripButton();
		this.signOutButton = new ToolStripButton();
		this.accountButton = new ToolStripButton();
		accountForm= new AccountForm(AccountDataSource.getInstance());

		prepareLayout(isAdmin);

	}

	private void prepareLayout(boolean isAdmin) {
		
		this.setBackgroundImage(IMG_lOGO);
		this.setHeight(70);
		this.setWidth100();
		this.addSpacer(6);
		this.addSpacer(6);
		this.separator.setHeight(20);
		this.title.setContents(COMMUNICATION_LAB_TITLE);
		this.title.setWidth(600);
		this.title.setHeight100();
		this.addMember(title);
		this.addFill();
		this.addSpacer(1);
		//this.addMember(loginIcon);
		this.accountButton.setIcon(ICON_PERSION_LOGIN);
		this.accountButton.setID(AC_TB_ID);
		this.addMember(this.accountButton);
		
		this.userNameLabel.setWidth(100);
		userNameLabel.setStyleName(CSS_USER);
		this.addMember(userNameLabel);
		this.addMember(separator);
		if (isAdmin) {
			this.addMember(separator);
			this.adminButton.setIcon(ICON_ADMIN);
			this.adminButton.setActionType(SelectionType.RADIO);
			this.adminButton.setRadioGroup("AdminGroup");
			this.adminButton.setID(ADMIN_TB_ID);
			this.adminButton.select();
			this.addMember(this.adminButton);
			this.wsButton.setIcon(ICON_WORKSPACE);
			this.wsButton.setActionType(SelectionType.RADIO);
			this.wsButton.setRadioGroup("AdminGroup");
			this.wsButton.setID(WS_TB_ID);
			this.addMember(this.wsButton);
			this.addMember(this.separator);
		}
		this.signOutButton.setIcon(ICON_SIGNOUT);
		this.addMember(this.signOutButton);
		this.accountButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				accountForm.fetchData();
				accountForm.show();
				
			}
		});
		
	}

	public void setUserName(String userName) {
		this.userNameLabel.setContents(userName);
	}

	public void addSignOutClickHandler(ClickHandler clickHandler) {
		this.signOutButton.addClickHandler(clickHandler);
	}


	public void addToggleBodyClickHandler(ClickHandler clickHandler){
	this.adminButton.addClickHandler(clickHandler);
	this.wsButton.addClickHandler(clickHandler);
	}

}
