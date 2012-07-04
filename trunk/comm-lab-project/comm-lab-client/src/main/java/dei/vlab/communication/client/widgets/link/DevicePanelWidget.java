package dei.vlab.communication.client.widgets.link;

import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Widget;

import dei.vlab.communication.client.contoller.DiagramController;

public class DevicePanelWidget extends AbsolutePanel {
	DiagramController controller;

	public DevicePanelWidget(DiagramController controller) {
		this.controller = controller;
		setStyle(controller);
		setBGColor();
	}

	public void setBGColor() {
		getElement().getStyle().setBorderColor("#cccccc");
		getElement().getStyle().setBackgroundColor("#cccccc");
	}

	public void setStyle(DiagramController controller) {
		getElement().getStyle().setWidth(44, Unit.PX);
		getElement().getStyle()
				.setHeight(controller.getCanvasHeight(), Unit.PX);
		getElement().getStyle().setPadding(10, Unit.PX);
		getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
		getElement().getStyle().setBorderWidth(1, Unit.PX);
	}

	public void addDevice(Widget w, int left, int top) {
		add(w, left, top);

	}

}
