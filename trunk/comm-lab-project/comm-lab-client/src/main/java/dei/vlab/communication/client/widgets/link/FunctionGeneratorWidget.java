package dei.vlab.communication.client.widgets.link;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.FontStyle;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

import dei.vlab.communication.client.contoller.DiagramController;

public class FunctionGeneratorWidget extends AbsolutePanel {
	private static String pinImg = "images/tools/pin.png";
	private String name;
	private DiagramController controller;
	private int pinCount;
	private int inContainerLeft;
	private int intConatinerTop;
	private Map<Image, CNode> pinMap = new HashMap<Image, CNode>();
	
	
	public FunctionGeneratorWidget(String name, DiagramController controller, int left,int top) {
		this.name = name;
		this.controller = controller;
		this.pinCount = 0;
		this.inContainerLeft=left;
		this.intConatinerTop=top;

		Label fgLabel = new Label("Function Generator");
		Label fsP1Lable = new Label("Signal");
		Label fsP2Lable = new Label("GND");

		Image fgPin1 = new Image(pinImg);
		Image fgPin2 = new Image(pinImg);

		AbsolutePanel fgPanel = new AbsolutePanel();
		add(fgPanel);
		setFgPanelCss(fgPanel);
		applyStyle(fgLabel);
		
		fgPanel.add(fgLabel, 0, 0);
		
		fgPanel.add(fsP1Lable, 2, 42);
		fgPanel.add(fgPin1, 35, 42);
		addControls(fgPin1, "Sin", "Signal",35,42);

		fgPanel.add(fsP2Lable, 2, 72);
		fgPanel.add(fgPin2, 35, 72);
		addControls(fgPin2, "GND", "Ground",35,72);
	}

	public void setFgPanelCss(AbsolutePanel fgPanel) {
		fgPanel.getElement().getStyle().setPadding(10, Unit.PX);
		fgPanel.getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
		fgPanel.getElement().getStyle().setBorderColor("#616D7E");
		fgPanel.getElement().getStyle().setBorderWidth(1, Unit.PX);
		fgPanel.getElement().getStyle().setWidth(40, Unit.PX);
		fgPanel.getElement().getStyle().setHeight(80, Unit.PX);
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
		lable.getElement().getStyle().setFontStyle(FontStyle.ITALIC);
		lable.getElement().getStyle().setProperty("textAlign", "center");
		lable.getElement().getStyle().setColor("#FFFFFF");
		lable.getElement().getStyle().setWidth(58, Unit.PX);
	}

	private void addControls(Image fgPin, String name, String desc,int left,int top) {
		pinCount++;
		CNode cNode = new CNode(pinCount, name, desc);
		cNode.setLeft(left);
		cNode.setTop(top);
		pinMap.put(fgPin, cNode);

		}

	
	public int getInContainerLeft() {
		return inContainerLeft;
	}

	public int getIntConatinerTop() {
		return intConatinerTop;
	}

	/*public void registerControl(){
		controller.addWidget(cNode, left+6,
				intConatinerTop+ top+6);
	
	}
	
	private void addControls(Image fgPin, String name, String desc) {
		pinCount++;
		CNode cNode = new CNode(pinCount, name, desc);
		pinMap.put(fgPin, cNode);

	}*/
	public void registerControl() {
		
		Set<Image> fgPins=pinMap.keySet();
		for(Image fgPin :fgPins){
			CNode cNode =pinMap.get(fgPin);
		controller.addWidget(cNode, cNode.getLeft()+6,
				intConatinerTop+ cNode.getTop()+6);
		}
	}
}
