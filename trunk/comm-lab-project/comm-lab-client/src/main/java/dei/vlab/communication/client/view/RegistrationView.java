package dei.vlab.communication.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.SubmitButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;


public class RegistrationView extends Composite {
	
	private static RegistrationViewUiBinder uiBinder = GWT
			.create(RegistrationViewUiBinder.class);


	interface RegistrationViewUiBinder extends UiBinder<Widget, RegistrationView> {
	}

	@UiField
	FormPanel formPanel;
	@UiField
	TextBox firstName;
	@UiField
	TextBox lastName;
	@UiField
	TextBox college;
	@UiField
	TextBox address1;
	@UiField
	TextBox address2;
	@UiField
	TextBox street;
	@UiField
	TextBox city;
	@UiField
	TextBox country;
	@UiField
	TextBox email;
	@UiField
	TextBox contactNo;
	
	@UiField
	PasswordTextBox password;
	@UiField
	PasswordTextBox cpassword;
	@UiField
	SubmitButton submit_button;
	@UiField
	Button cancel_button;
	@UiField
	Label message;
	
		public RegistrationView() {
		initWidget(uiBinder.createAndBindUi(this));
		submit_button.setText("Signup");
		cancel_button.setText("Cancel");
	}

	public String getFirstNameValue() {
		return firstName.getValue();
	}
	public String getLastNameValue() {
		return lastName.getValue();
	}
	public String getCollegeValue() {
		return college.getValue();
	}
	public String getAddress1Value() {
		return address1.getValue();
	}
	public String getAddress2Value() {
		return address2.getValue();
	}
	public String getStreetValue() {
		return street.getValue();
	}
	public String getCityValue() {
		return city.getValue();
	}
	public String getCountryValue() {
		return country.getValue();
	}
	public String getContactNoValue() {
		return contactNo.getValue();
	}

	public String getEmailValue() {
		return email.getValue();
	}



	public String getPasswordValue() {
		return password.getValue();
	}
	public String getCpasswordValue() {
		return cpassword.getValue();
	}

	public SubmitButton getSubmitButton() {
		return submit_button;
	}

	public Button getCancelButton() {
		return cancel_button;
	}

	public FormPanel getFormPanel() {
		return formPanel;
	}

	public TextBox getFirstNameBox() {
		return firstName;
	}
	public TextBox getLastNameBox() {
		return lastName;
	}
	public TextBox getCollegeBox() {
		return college;
	}
	public TextBox getAddress1Box() {
		return address1;
	}
	public TextBox getAddress2Box() {
		return address2;
	}
	public TextBox getStreetBox() {
		return street;
	}
	public TextBox getCityBox() {
		return city;
	}
	public TextBox getCountryBox() {
		return country;
	}
	public TextBox getContactNoBox() {
		return contactNo;
	}
	public TextBox getEmailBox() {
		return email;
	}

	public PasswordTextBox getPasswordBox() {
		return password;
	}
	public PasswordTextBox getCpasswordBox() {
		return cpassword;
	}

	public Label getMessage() {
		return message;
	}

	@UiHandler("formPanel")
	public void onSubmitComplete(FormPanel.SubmitCompleteEvent event) {
		disableSignUp();
		String message = event.getResults();
		String info="";
		if(message!=null && message.indexOf(":")>0 &&message.indexOf("}")>0){
		 info=message.substring(message.indexOf("{")+1,message.indexOf("}")-1);
		 info=info.substring(info.indexOf(":")+2,info.length());
		}
		if (message.contains("error")) {
			enableSignUp();
			this.getMessage().setText(info);
			
			
		} else {
			signUpSuccessView(info);
		}

	}
	
	public void disableSignUp(){
		this.getMessage().setText("");

		this.getPasswordBox().setEnabled(false);
		this.getCpasswordBox().setEnabled(false);
		this.getFirstNameBox().setEnabled(false);
		this.getLastNameBox().setEnabled(false);
		this.getCollegeBox().setEnabled(false);
		this.getAddress1Box().setEnabled(false);
		this.getAddress2Box().setEnabled(false);
		this.getStreetBox().setEnabled(false);
		this.getCityBox().setEnabled(false);
		this.getCountryBox().setEnabled(false);
		this.getContactNoBox().setEnabled(false);
		this.getEmailBox().setEnabled(false);

		this.getSubmitButton().setText("Registering...");
		this.getSubmitButton().setEnabled(false);
		this.getCancelButton().setEnabled(false);
	}
	
	public void enableSignUp(){
		this.getPasswordBox().setEnabled(true);
		this.getCpasswordBox().setEnabled(true);
		this.getFirstNameBox().setEnabled(true);
		this.getLastNameBox().setEnabled(true);
		this.getCollegeBox().setEnabled(true);
		this.getAddress1Box().setEnabled(true);
		this.getAddress2Box().setEnabled(true);
		this.getStreetBox().setEnabled(true);
		this.getCityBox().setEnabled(true);
		this.getCountryBox().setEnabled(true);
		this.getContactNoBox().setEnabled(true);
		this.getEmailBox().setEnabled(true);

		this.getSubmitButton().setText("Signup");
		this.getSubmitButton().setEnabled(true);
		this.getCancelButton().setEnabled(true);
	}

	public void signUpSuccessView(String messageTxT){
		    // Create a panel and add it to the screen
		
		String htmlText="<table width='200'><tr><td colspan='2'>" +
		"<p><span id='registMsg'>"+messageTxT+"</span></p></td></tr>" +
		"<tr><td></td><td><Button value='Ok' onClick=\"window.location='login.html'\">Ok</button></td></tr></table>";
			 RootPanel.get("info").setVisible(false);
			 HTML html = new HTML(htmlText);
			 RootPanel.get("regist").add(html);

	}
}
