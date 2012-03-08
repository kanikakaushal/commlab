package dei.vlab.communication.client.widgets.tools;

import com.allen_sauer.gwt.dnd.client.PickupDragController;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Widget;

public class CircuitImage extends AbstractImageController{
   private String imgPath;
	public CircuitImage(String imgPath) {
		this.imgPath=imgPath;
	}
	@Override
	public void draw() {
		PickupDragController dragController = new PickupDragController(controller.getView(), true);
		controller.registerDragController(dragController);
			
	}
	
	public Integer getImgHeight(){
		return 400;
	}
	public Integer getImgWidth(){
		return 400;
	}
	
	@Override
	public Widget asWidget() {
		Widget widgetPanel = controller.getView();
		
		widgetPanel.getElement().getStyle().setMargin(0, Unit.PX);
		widgetPanel.getElement().getStyle().setProperty("border", "0px");
		
		controller.setFrameSize(300, 300);
		return controller.getViewAsScrollPanel();
	}

}
