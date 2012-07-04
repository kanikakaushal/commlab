package dei.vlab.communication.client.widgets.tools;

import com.allen_sauer.gwt.dnd.client.PickupDragController;
import com.google.gwt.user.client.ui.Widget;

import dei.vlab.communication.client.contoller.DiagramController;
import dei.vlab.communication.client.widgets.link.CircuitWidget;
import dei.vlab.communication.client.widgets.link.DSOWidget;
import dei.vlab.communication.client.widgets.link.DevicePanelWidget;
import dei.vlab.communication.client.widgets.link.FunctionGeneratorWidget;
import dei.vlab.communication.client.widgets.link.PowerSupplyWidget;

public class ExpermentPanel {
	protected DiagramController controller;
	private PickupDragController dragController;
	private FunctionGeneratorWidget fnWidget1;
	private FunctionGeneratorWidget fnWidget2;
	private PowerSupplyWidget psWidget;
	private DSOWidget dsoWidget;
	public ExpermentPanel(DiagramController controller) {
	this.controller=controller;
	}

	public void draw() {

		DevicePanelWidget leftDeviceWidget = new DevicePanelWidget(controller);
		DevicePanelWidget rightDeviceWidget = new DevicePanelWidget(controller);

		 fnWidget1 = new FunctionGeneratorWidget("fn1",
				controller,0,10);
		 fnWidget2 = new FunctionGeneratorWidget("fn2",
				controller,0,120);
		 psWidget = new PowerSupplyWidget("ps", controller,0,230);
		 dsoWidget = new DSOWidget("dso", controller,controller.getCanvasWidth() - 65,80);

		leftDeviceWidget.addDevice(fnWidget1, fnWidget1.getInContainerLeft(), fnWidget1.getIntConatinerTop());
		leftDeviceWidget.addDevice(fnWidget2, fnWidget2.getInContainerLeft(), fnWidget2.getIntConatinerTop());
		leftDeviceWidget.addDevice(psWidget,psWidget.getInContainerLeft(), psWidget.getIntConatinerTop());

		rightDeviceWidget.addDevice(dsoWidget, 0, dsoWidget.getIntConatinerTop());

		controller.addWidgetToBackgoundStatic(leftDeviceWidget, 0, 0);
		controller.addWidgetToBackgoundStatic(rightDeviceWidget,
				controller.getCanvasWidth() - 65, 0);

	
		
		PickupDragController dragController = new PickupDragController(
				controller.getView(), true);
		
		controller.registerDragController(dragController);
		

	}

	public Widget asWidget() {
		return controller.getView();
	}
	
	public void registerConroller() {
		fnWidget1.registerControl();
		fnWidget2.registerControl();
		psWidget.registerControl();
		dsoWidget.registerControl();
	}

	public void addCircuit(String name, String nodeData) {
		CircuitWidget w = new
		CircuitWidget(controller,dragController,"images/resources/"+name);
		w.setNodeData(nodeData);
		controller.addWidgetToBackgound(w, 100, 100);
		dragController.makeDraggable(w);
	}

	public void removeCircuit(String name, String nodeData) {
		// CircuitWidget w1 = new
		// CircuitWidget(controller,dragController,"images/circuit2.png");

	}

}
