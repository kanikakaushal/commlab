package dei.vlab.communication.client.image.utils;

import com.google.gwt.event.shared.EventHandler;

public interface ImageLoadHandler extends EventHandler {
	public void imageLoaded(ImageLoadEvent event);
}