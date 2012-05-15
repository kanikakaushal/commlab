package dei.vlab.communication.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SubmitButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class LoginView extends Composite {

	private static LoginViewUiBinder uiBinder = GWT
			.create(LoginViewUiBinder.class);

	interface LoginViewUiBinder extends UiBinder<Widget, LoginView> {
	}

	@UiField
	FormPanel formPanel;
	@UiField
	TextBox userName;
	@UiField
	PasswordTextBox password;
	@UiField
	SubmitButton submit_button;
	@UiField
	Button register_button;
	@UiField
	Label message;
	@UiField
	Anchor forgotPass;
	private boolean failed;
	private boolean authenticated;

	public boolean isFailed() {

		return failed;
	}

	public boolean isAuthenticated() {

		return authenticated;
	}

	public LoginView() {
		initWidget(uiBinder.createAndBindUi(this));
		submit_button.setText("Login");
		register_button.setText("Register");
		forgotPass.addClickHandler(new ClickHandler() {
			
			
			public void onClick(ClickEvent arg0) {
				if(getUserNameValue()!=null){
					
					RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
							URL.encode(GWT.getHostPageBaseURL() + "/app/resetpass?username="+getUserNameValue()));
					String requestData = null;
					try {
						builder.sendRequest(requestData, new RequestCallback() {
							
							
						
							public void onResponseReceived(Request request,
									Response response) {
							if (200 == response.getStatusCode()) {
									
									String result =response.getText();
									
									if(result.contains("success")){
										showForgotPass("Dear User "+getUserNameValue()+",<br/> Password have been reset and e-mailed to you");
																
									}else{
										showForgotPass("Sorry, Your request could not be completed. please try later.");
															
									}

								} else {
									showForgotPass("Sorry, Your request could not be completed. please try later.");
									
								}

							}

							
							public void onError(Request arg0, Throwable arg1) {
								showForgotPass("Sorry, Your request could not be completed. please try later.");
								
							}
						});
					} catch (RequestException e) {
						showForgotPass("Sorry, Your request could not be completed. please try later.");
					}
					
				}
				else{
					Window.alert("User Name is required");
				}
			}
		});
	}

	public void showForgotPass(String message) {
		String htmlText = "<table width='200'><tr><td colspan='2'>"
				+ "<p><span id='registMsg'>"
				+ message
				+ "</span></p></td></tr>"
				+ "<tr><td></td><td><Button value='Ok' onClick=\"window.location='login.html'\">Ok</button></td></tr></table>";
		RootPanel.get("info").setVisible(false);
		HTML html = new HTML(htmlText);
		RootPanel.get("message").add(html);

	}

	public String getUserNameValue() {
		String userNameValue = userName.getValue();
		return userNameValue != null && userNameValue.trim().length() > 0 ? userName
				.getValue() : null;
	}

	public String getPasswordValue() {
		return password.getValue();
	}

	public SubmitButton getSubmitButton() {
		return submit_button;
	}

	public Anchor getForgotPassAnchor() {
		return forgotPass;
	}

	public Button getRegisterButton() {
		return register_button;
	}

	public FormPanel getFormPanel() {
		return formPanel;
	}

	public TextBox getUserNameBox() {
		return userName;
	}

	public PasswordTextBox getPasswordBox() {
		return password;
	}

	public Label getMessage() {
		return message;
	}

	@UiHandler("formPanel")
	public void onSubmitComplete(FormPanel.SubmitCompleteEvent event) {
		disableLogin();
		String message = event.getResults();
		if (message.contains("error")) {
			enableLogin();
			this.getMessage().setText("Invalid username or password!");
		} else {
			Window.Location.assign("application.html");
			this.authenticated = true;
		}

	}

	public void disableLogin() {
		this.getMessage().setText("");
		this.getMessage().setTitle("Checking...");
		this.getSubmitButton().setText("Checking...");
		this.getSubmitButton().setEnabled(false);
		this.getUserNameBox().setEnabled(false);
		this.getPasswordBox().setEnabled(false);
		this.getRegisterButton().setEnabled(false);
	}

	public void enableLogin() {
		this.getSubmitButton().setText("Login");
		this.getSubmitButton().setEnabled(true);
		this.getUserNameBox().setEnabled(true);
		this.getPasswordBox().setEnabled(true);
		this.getRegisterButton().setEnabled(true);
	}

}
