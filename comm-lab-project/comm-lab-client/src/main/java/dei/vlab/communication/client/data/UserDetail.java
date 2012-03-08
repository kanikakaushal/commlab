package dei.vlab.communication.client.data;

import com.google.gwt.core.client.JavaScriptObject;

public class UserDetail extends JavaScriptObject {

	protected UserDetail() {}

	public final native String getUserName() /*-{ return this.userName; }-*/;

	public final native String getFirstName() /*-{ return this.firstName; }-*/;

	public final native String getLastName() /*-{ return this.lastName; }-*/;

	public final native String getRole() /*-{ return this.role; }-*/;

	public final native String getError() /*-{ return this.error; }-*/;

}
