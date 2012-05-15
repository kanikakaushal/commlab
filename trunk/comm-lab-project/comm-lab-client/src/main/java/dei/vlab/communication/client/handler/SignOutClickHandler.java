package dei.vlab.communication.client.handler;

import com.google.gwt.user.client.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;


public class SignOutClickHandler implements ClickHandler{
	public static final String SIGNOUT_URL="app/logout";

	
	public void onClick(ClickEvent event) {
		Window.Location
		.assign(SIGNOUT_URL);
	}

}
