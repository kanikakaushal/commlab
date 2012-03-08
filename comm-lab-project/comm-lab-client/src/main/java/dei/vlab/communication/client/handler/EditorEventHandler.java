package dei.vlab.communication.client.handler;

import com.google.gwt.event.shared.EventHandler;

import dei.vlab.communication.client.event.EditorEvent;

public interface EditorEventHandler extends EventHandler {
	 void openTab(EditorEvent event);
}
