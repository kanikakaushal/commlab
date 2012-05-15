package dei.vlab.communication.client.util;

import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.smartgwt.client.util.SC;

public class HttpRequestUtil {

	private static String responseText;
	public static String doGetRequest(String url) {
		responseText = null;
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				URL.encode(GWT.getHostPageBaseURL() + url));
		String requestData = null;
		try {
			builder.sendRequest(requestData, new RequestCallback() {

				public void onResponseReceived(Request request,
						Response response) {
						responseText = response.getText();
					if (200 != response.getStatusCode()) {
						SC.say("Sorry, we could not complete your request at this time.");
					}

				}

				public void onError(Request request, Throwable exception) {
					SC.say("Sorry, we could not complete your request at this time.");
				}

			});
		} catch (RequestException e) {
			SC.say("Sorry, we could not complete your request at this time.");
			return "error";
		}
		return responseText;
	}
}
