package dei.vlab.communication.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface NewFunctionHandler extends EventHandler{

	public void onNewFunction(NewFunctionEvent event);
	
}
