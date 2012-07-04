package dei.vlab.communication.client.widgets.link;

import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Widget;

import dei.vlab.communication.client.contoller.DiagramController;
import dei.vlab.communication.client.menu.ContextMenu;
import dei.vlab.communication.client.save.IsDiagramSerializable;
import dei.vlab.communication.client.shapes.FunctionShape;

public class RightControlWidget extends AbsolutePanel {
	public static String identifier = "dso";
	String content;

	DiagramController controller;
	public ContextMenu contextMenu;

	protected void initMenu() {

		contextMenu = new ContextMenu();
		contextMenu.addItem(new MenuItem("Move", new Command() {
			
			public void execute() {
				}
		}));
		contextMenu.addItem(new MenuItem("Delete", new Command() {
			
			public void execute() {
				}
		}));
	}

	public RightControlWidget(DiagramController controller) {
		this.controller = controller;
		getElement().getStyle().setWidth(44, Unit.PX);
		getElement().getStyle().setHeight(controller.getCanvasHeight(), Unit.PX);
		getElement().getStyle().setPadding(10, Unit.PX);
		getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
		getElement().getStyle().setBorderColor("#bbbbbb");
		getElement().getStyle().setBorderWidth(1, Unit.PX);
		getElement().getStyle().setBackgroundColor("#bbbbbb");
		
		AbsolutePanel dsoPanel = getDSOPanel();
		add(dsoPanel,0,200);
	

		
		
		
		initMenu();
	}

	private AbsolutePanel getDSOPanel() {
		Label dsoLabel= new Label("DSO");
		Image dsoPin1= new Image("images/pin.png");
		Image dsoPin2= new Image("images/pin.png");
		Image dsoPin3= new Image("images/pin.png");
		Image dsoPin4= new Image("images/pin.png");
		Image dsoPin5= new Image("images/pin.png");
		Image dsoPin6= new Image("images/pin.png");
		AbsolutePanel dsoPanel = new AbsolutePanel();
		dsoPanel.getElement().getStyle().setPadding(10, Unit.PX);
		dsoPanel.getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
		dsoPanel.getElement().getStyle().setBorderColor("#616D7E");
		dsoPanel.getElement().getStyle().setBorderWidth(1, Unit.PX);
		dsoPanel.getElement().getStyle().setWidth(40, Unit.PX);
		dsoPanel.getElement().getStyle().setHeight(210, Unit.PX);
		applyStyle(dsoLabel);
		dsoPanel.add(dsoLabel, 8, 2);
		dsoPanel.add(dsoPin1, 8, 42);
		dsoPanel.add(dsoPin2, 8, 72);
		dsoPanel.add(dsoPin3, 8, 102);
		dsoPanel.add(dsoPin4, 8, 132);
		dsoPanel.add(dsoPin5, 8, 162);
		dsoPanel.add(dsoPin6, 8, 192);
		return dsoPanel;
	}

	private void applyStyle(Label label) {
		label.getElement().getStyle().setPadding(10, Unit.PX);
		label.getElement().getStyle().setBackgroundColor("#616D7E");
		label.getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
		label.getElement().getStyle().setBorderColor("#463E41");
		label.getElement().getStyle().setBorderWidth(1, Unit.PX);
		label.getElement().getStyle().setMarginRight(1, Unit.PX);
		label.getElement().getStyle().setMarginLeft(0, Unit.PX);
		label.getElement().getStyle().setFontWeight(FontWeight.BOLDER);
		label.getElement().getStyle().setFontSize(10, Unit.PX);
		label.getElement().getStyle().setColor("#FFFFFF");
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

	public FunctionShape addWidget(final Widget w, int left, int top) {
		return controller.addWidget(w, left, top);
	}
}
