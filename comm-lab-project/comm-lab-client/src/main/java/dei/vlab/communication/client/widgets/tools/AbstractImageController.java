package dei.vlab.communication.client.widgets.tools;

import com.google.gwt.user.client.ui.Widget;

import dei.vlab.communication.client.contoller.DiagramController;

public abstract class AbstractImageController {
protected DiagramController controller;
	
public AbstractImageController() {
	/*super(imgPath);
	setWidth(400);
	setHeight(400);
	setMargin(30);
	setShowEdges(true);
	setEdgeSize(2);*/
}

	public abstract void draw();
	public void setDiagramController(DiagramController controller){
		this.controller = controller;
	}
	
	public abstract Widget asWidget();
	
}
