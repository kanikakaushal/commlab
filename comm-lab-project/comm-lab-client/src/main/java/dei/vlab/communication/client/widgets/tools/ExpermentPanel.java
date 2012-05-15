package dei.vlab.communication.client.widgets.tools;

import com.allen_sauer.gwt.dnd.client.PickupDragController;
import com.google.gwt.user.client.ui.Widget;

import dei.vlab.communication.client.contoller.DiagramController;
import dei.vlab.communication.client.widgets.link.CircuitWidget;
import dei.vlab.communication.client.widgets.link.LeftControlWidget;
import dei.vlab.communication.client.widgets.link.RightControlWidget;

public class ExpermentPanel{
protected DiagramController controller;

	public  void draw(){
		
		LeftControlWidget lcWidget = new LeftControlWidget(controller);
		RightControlWidget rcWidget = new RightControlWidget(controller);
		PickupDragController dragController = new PickupDragController(controller.getView(), true);

		CircuitWidget w1 = new CircuitWidget(controller,dragController,"images/circuit2.png");
   	  //  controller.addWidget(w1, 150,50);
	/*	controller.addWidget(new CNode(1),157,158);
		controller.addWidget(new CNode(2),255,82);
		controller.addWidget(new CNode(3),167,27);
*/	 //  CircuitWidget w2 = new CircuitWidget(controller,dragController,"images/circuit3.png");
	  // controller.addWidgetToBackgound(w2, 200, 300);
/*	   controller.addWidget(new CNode(2),325,38);
	   controller.addWidget(new CNode(1),127,165);
*/	   controller.addWidgetToBackgoundStatic(lcWidget,0,0);
	   controller.addWidgetToBackgoundStatic(rcWidget,controller.getCanvasWidth()-65,0);
	   
	    // dragController.makeDraggable(w1);
	    // dragController.makeDraggable(w2);
		   
       controller.registerDragController(dragController);

		
	}
	public  Widget asWidget(){
		return controller.getView();
	}
	
	public void setDiagramController(DiagramController controller){
		this.controller = controller;
	}


}
