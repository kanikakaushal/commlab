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

public class DSOWidget extends AbsolutePanel {
	private static String pinImg = "images/tools/pin.png";
	private String name;
	private DiagramController controller;
	private int pinCount;
	private Map<Image,CNode> pinMap = new  HashMap<Image, CNode>();
	private int inContainerLeft;
	private int intConatinerTop;



	public DSOWidget(String name, DiagramController controller, int left,int top) {
		this.name = name;
		this.controller = controller;
		this.pinCount = 0;
		this.inContainerLeft=left;
		this.intConatinerTop=top;
		
		AbsolutePanel dsoPanel = new AbsolutePanel();
		setFgPanelCss(dsoPanel);
		
		Label dsoLabel= new Label("DSO");
		Image dsoPin1= new Image(pinImg);
		Image dsoPin2= new Image(pinImg);
		Image dsoPin3= new Image(pinImg);
		Image dsoPin4= new Image(pinImg);
		Image dsoPin5= new Image(pinImg);
		Image dsoPin6= new Image(pinImg); 
		
		
		applyStyle(dsoLabel);
		dsoPanel.add(dsoLabel, 0, 0);
		
		dsoPanel.add(dsoPin1, 8, 42);
		addControls(dsoPin1, "dsoPin1", "dsoPin1", 8, 42);
		
		dsoPanel.add(dsoPin2, 8, 72);
		addControls(dsoPin2, "dsoPin2", "dsoPin2", 8, 72);
		
		dsoPanel.add(dsoPin3, 8, 102);
		addControls(dsoPin3, "dsoPin3", "dsoPin3", 8, 102);
		
		dsoPanel.add(dsoPin4, 8, 132);
		addControls(dsoPin4, "dsoPin4", "dsoPin4", 8, 132);
		
		dsoPanel.add(dsoPin5, 8, 162);
		addControls(dsoPin5, "dsoPin5", "dsoPin5", 8, 162);
		
		dsoPanel.add(dsoPin6, 8, 192);
		addControls(dsoPin6, "dsoPin6", "dsoPin6", 8, 192);

		add(dsoPanel);
	}
	
	private void setFgPanelCss(AbsolutePanel fgPanel) {
		fgPanel.getElement().getStyle().setPadding(10, Unit.PX);
		fgPanel.getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
		fgPanel.getElement().getStyle().setBorderColor("#616D7E");
		fgPanel.getElement().getStyle().setBorderWidth(1, Unit.PX);
		fgPanel.getElement().getStyle().setWidth(40, Unit.PX);
		fgPanel.getElement().getStyle().setHeight(210, Unit.PX);
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
		
			/*	controller.addWidget(cNode, inContainerLeft+left+6,
				intConatinerTop+top+6);*/
		}

	
	public int getInContainerLeft() {
		return inContainerLeft;
	}

	public int getIntConatinerTop() {
		return intConatinerTop;
	}
	
public void registerControl() {
		
		Set<Image> fgPins=pinMap.keySet();
		for(Image fgPin :fgPins){
			CNode cNode =pinMap.get(fgPin);
		controller.addWidget(cNode, inContainerLeft+cNode.getLeft()+6,
				intConatinerTop+ cNode.getTop()+6);
		}
	}
}
