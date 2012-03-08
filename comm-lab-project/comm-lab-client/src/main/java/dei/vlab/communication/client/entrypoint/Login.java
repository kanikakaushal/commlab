package dei.vlab.communication.client.entrypoint;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.HistoryListener;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;

import dei.vlab.communication.client.view.LoginView;
import dei.vlab.communication.client.view.RegistrationView;

public class Login implements EntryPoint, HistoryListener {
	private LoginView view = GWT.create(LoginView.class);
	private RegistrationView rview = GWT.create(RegistrationView.class);
	 final String initToken = History.getToken();
	public void onModuleLoad(){
	        RootPanel p = RootPanel.get("loadingWrapper");
	        if (p != null) RootPanel.getBodyElement().removeChild(p.getElement());
	        
	        setRegistationViewCancelBtnHander();
			setLoginViewRegisterBtnHander();
			showLogin();
	}
	
	public void showLogin(){
		
		
		RootLayoutPanel.get().clear();
		RootLayoutPanel.get().add(view);
	}

	private void setLoginViewRegisterBtnHander() {
		view.getRegisterButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				RootLayoutPanel.get().clear();
				RootLayoutPanel.get().add(rview);
			}
		});
	}
	private void setRegistationViewCancelBtnHander() {
		rview.getCancelButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				showLogin();
			}
		});
	}
	


	@Override
	public void onHistoryChanged(String arg0) {
		//do nothings
		
	}
}