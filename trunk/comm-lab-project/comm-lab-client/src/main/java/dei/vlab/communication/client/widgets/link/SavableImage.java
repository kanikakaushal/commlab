package dei.vlab.communication.client.widgets.link;

import com.google.gwt.user.client.ui.Image;

import dei.vlab.communication.client.save.IsDiagramSerializable;

public class SavableImage extends Image implements IsDiagramSerializable{

	public static  String identifier = "image";
	private String content;
	
	public SavableImage(String url){
		super(url);
		this.content = url;
	}
	
	
	public String getType() {
		return this.identifier;
	}

	
	public String getContentRepresentation() {
		return this.content;
	}

	
	public void setContentRepresentation(String contentRepresentation) {
		this.content = contentRepresentation;
	}

	
	
}
