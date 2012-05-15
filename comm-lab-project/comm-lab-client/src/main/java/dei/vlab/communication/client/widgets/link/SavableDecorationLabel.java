package dei.vlab.communication.client.widgets.link;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Label;

import dei.vlab.communication.client.save.IsDiagramSerializable;

public class SavableDecorationLabel extends Label implements IsDiagramSerializable{
	
	public static String identifier = "savabledecorationlabel";
	public String content;
	
	public SavableDecorationLabel(String content){
		super(content);
		this.content = content;
		getElement().getStyle().setBackgroundColor("#FFFFFF");
		getElement().getStyle().setPadding(5, Unit.PX);
		getElement().getStyle().setProperty("border", "1px solid black");
	}
	
	
	public String getType() {
		return identifier;
	}

	
	public String getContentRepresentation() {
		return content;
	}

	
	public void setContentRepresentation(String contentRepresentation) {
		this.content = contentRepresentation;
	}

}
