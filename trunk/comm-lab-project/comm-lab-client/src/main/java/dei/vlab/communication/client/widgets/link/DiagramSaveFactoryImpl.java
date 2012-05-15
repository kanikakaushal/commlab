package dei.vlab.communication.client.widgets.link;

import com.google.gwt.user.client.ui.Widget;

import dei.vlab.communication.client.save.DiagramWidgetFactory;

public class DiagramSaveFactoryImpl implements DiagramWidgetFactory{

	
	public Widget getFunctionByType(String type, String content) {
		if(type.equals(BoxLabel.identifier)){
			return new BoxLabel(content);
		} else if(type.equals(SavableImage.identifier)){
			return new SavableImage(content);
		}
		return null;
	}

	
	public Widget getDecorationByType(String type, String content) {
		if(type.equals(SavableDecorationLabel.identifier)){
			return new SavableDecorationLabel(content);
		}
		return null;
	}

}
