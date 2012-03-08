package dei.vlab.communication.client.entrypoint;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.HistoryListener;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

import dei.vlab.communication.client.data.User;
import dei.vlab.communication.client.page.decorator.ApplicationPageDecorator;
import dei.vlab.communication.client.page.decorator.PageDecorator;

public class Application implements EntryPoint, HistoryListener {
	private PageDecorator pageDecorator;
	private User user;
	public void onModuleLoad() {

		History.addHistoryListener(this);

		try {
			RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
					URL.encode(GWT.getHostPageBaseURL() + "/app/userinfo"));
			String requestData = null;
			builder.sendRequest(requestData, new RequestCallback() {
				@Override
				public void onResponseReceived(Request request,
						Response response) {
					if (200 == response.getStatusCode()) {
						user = new User(response.getText());
						pageDecorator = new ApplicationPageDecorator(user);
						pageDecorator.render();
						RootPanel p = RootPanel.get("loadingWrapper");
						if (p != null)
							RootPanel.getBodyElement().removeChild(
									p.getElement());
						

					} else {
						requestFailed(new Exception(response.getStatusText()
								+ response.getStatusText()));
					}

				}

				@Override
				public void onError(Request request, Throwable exception) {
					// TODO Auto-generated method stub
					requestFailed(exception);
				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void requestFailed(Throwable exception) {
		Window.alert("Failed to get login information");
	}

	@Override
	public void onHistoryChanged(String arg0) {
		// TODO Auto-generated method stub

	}
	


}
