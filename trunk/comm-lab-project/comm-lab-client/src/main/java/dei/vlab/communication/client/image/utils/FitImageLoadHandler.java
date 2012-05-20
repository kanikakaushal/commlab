package dei.vlab.communication.client.image.utils;

import com.google.gwt.event.shared.EventHandler;

public interface FitImageLoadHandler extends EventHandler {
	public void imageLoaded(FitImageLoadEvent event);
}