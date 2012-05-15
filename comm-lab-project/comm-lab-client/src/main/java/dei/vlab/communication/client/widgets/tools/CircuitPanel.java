package dei.vlab.communication.client.widgets.tools;

import com.allen_sauer.gwt.dnd.client.PickupDragController;
import com.google.gwt.user.client.ui.Widget;

import dei.vlab.communication.client.contoller.DiagramController;

public class CircuitPanel {
	protected DiagramController controller;

	public void draw() {

		PickupDragController dragController = new PickupDragController(
				controller.getView(), true);

		controller.registerDragController(dragController);

	}

	public Widget asWidget() {
		return controller.getView();
	}

	public void setDiagramController(DiagramController controller) {
		this.controller = controller;
	}

}
