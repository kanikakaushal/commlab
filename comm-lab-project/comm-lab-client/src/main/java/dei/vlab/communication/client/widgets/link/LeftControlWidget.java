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

public class LeftControlWidget extends AbsolutePanel implements IsDiagramSerializable {
	public static String identifier = "functionGenerator";
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

	public LeftControlWidget(DiagramController controller) {
		this.controller = controller;
		getElement().getStyle().setWidth(44, Unit.PX);
		getElement().getStyle().setHeight(controller.getCanvasHeight(), Unit.PX);
		getElement().getStyle().setPadding(10, Unit.PX);
		getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
		getElement().getStyle().setBorderColor("#bbbbbb");
		getElement().getStyle().setBorderWidth(1, Unit.PX);
		getElement().getStyle().setBackgroundColor("#bbbbbb");
		
		AbsolutePanel fgPanel = getFunctionGeneratorPanel();
		add(fgPanel,0,100);
		AbsolutePanel psPanel = getPowerSupplyPanel();
		add(psPanel,0,300);
		// function generator
		CNode cNode1= new CNode(31);
		controller.addWidget(cNode1, 39, 149);

		CNode cNode2= new CNode(32);
		controller.addWidget(cNode2, 39, 179);

		CNode cNode3= new CNode(33);
		controller.addWidget(cNode3, 39, 209);

		CNode cNode4= new CNode(34);
		controller.addWidget(cNode4, 39, 239);

		// power supply

		CNode psNode1= new CNode(41);
		controller.addWidget(psNode1, 39, 349);

		CNode psNode2= new CNode(42);
		controller.addWidget(psNode2, 39, 379);

		CNode psNode3= new CNode(43);
		controller.addWidget(psNode3, 39, 409);

		CNode psNode4= new CNode(44);
		controller.addWidget(psNode4, 39, 449);


		CNode psNode5= new CNode(45);
		controller.addWidget(psNode5, 39, 479);

		CNode psNode6= new CNode(46);
		controller.addWidget(psNode6, 39, 509);


		
		
		
		initMenu();
	}

	private AbsolutePanel getPowerSupplyPanel() {
		AbsolutePanel psPanel = new AbsolutePanel();
		psPanel.getElement().getStyle().setPadding(10, Unit.PX);
		psPanel.getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
		psPanel.getElement().getStyle().setBorderColor("#463E41");
		psPanel.getElement().getStyle().setBorderWidth(1, Unit.PX);
		psPanel.getElement().getStyle().setWidth(40, Unit.PX);
		psPanel.getElement().getStyle().setHeight(210, Unit.PX);
		Label psLable= new Label("Power Supply");
		Label ps25PlusLable= new Label("+25v");
		Label ps25MinLable= new Label("-25v");
		Label ps6PlusLable= new Label("+6v");
		Label ps6MinLable= new Label("-6v");
		Label psGND1Lable= new Label("GND");
		Label psGND2Lable= new Label("GND");
		Image psPin1= new Image("images/pin.png");
		Image psPin2= new Image("images/pin.png");
		Image psPin3= new Image("images/pin.png");
		Image psPin4= new Image("images/pin.png");
		Image psPin5= new Image("images/pin.png");
		Image psPin6= new Image("images/pin.png");
		applyStyle(psLable);
		psPanel.add(psLable, 2, 2);
		psPanel.add(ps25PlusLable, 2, 42);
		psPanel.add(psPin1, 32, 42);
		psPanel.add(ps25MinLable, 2, 72);
		psPanel.add(psPin2, 32, 72);
		psPanel.add(psGND1Lable, 2, 102);
		psPanel.add(psPin3, 32, 102);
	psPanel.add(ps6PlusLable, 2, 142);
		psPanel.add(psPin4, 32, 142);
		psPanel.add(ps6MinLable, 2, 172);
		psPanel.add(psPin5, 32, 172);
		psPanel.add(psGND2Lable, 2, 202);
		psPanel.add(psPin6, 32, 202);
		return psPanel;
	}

	private AbsolutePanel getFunctionGeneratorPanel() {
		Label fgLabel= new Label("Function Generator");
		Label fsP1Lable= new Label("1");
		Label fsP2Lable= new Label("2");
		Label fsP3Lable= new Label("3");
		Label fsP4Lable= new Label("4");
		Image fgPin1= new Image("images/pin.png");
		Image fgPin2= new Image("images/pin.png");
		Image fgPin3= new Image("images/pin.png");
		Image fgPin4= new Image("images/pin.png");
		AbsolutePanel fgPanel = new AbsolutePanel();
		fgPanel.getElement().getStyle().setPadding(10, Unit.PX);
		fgPanel.getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
		fgPanel.getElement().getStyle().setBorderColor("#616D7E");
		fgPanel.getElement().getStyle().setBorderWidth(1, Unit.PX);
		fgPanel.getElement().getStyle().setWidth(40, Unit.PX);
		fgPanel.getElement().getStyle().setHeight(140, Unit.PX);
		applyStyle(fgLabel);
		fgPanel.add(fgLabel, 2, 2);
		fgPanel.add(fsP1Lable, 2, 42);
		fgPanel.add(fgPin1, 32, 42);
		fgPanel.add(fsP2Lable, 2, 72);
		fgPanel.add(fgPin2, 32, 72);
		fgPanel.add(fsP3Lable, 2, 102);
		fgPanel.add(fgPin3, 32, 102);
		fgPanel.add(fsP4Lable, 2, 132);
		fgPanel.add(fgPin4, 32, 132);
		return fgPanel;
	}

	private void applyStyle(Label lable) {
		lable.getElement().getStyle().setBackgroundColor("#616D7E");
		lable.getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
		lable.getElement().getStyle().setBorderColor("#463E41");
		lable.getElement().getStyle().setBorderWidth(1, Unit.PX);
		lable.getElement().getStyle().setMarginRight(1, Unit.PX);
		lable.getElement().getStyle().setMarginLeft(0, Unit.PX);
		lable.getElement().getStyle().setFontWeight(FontWeight.BOLDER);
		lable.getElement().getStyle().setFontSize(10, Unit.PX);
		lable.getElement().getStyle().setColor("#FFFFFF");
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
