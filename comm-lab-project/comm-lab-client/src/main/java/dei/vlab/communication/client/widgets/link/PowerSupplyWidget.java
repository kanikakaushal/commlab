package dei.vlab.communication.client.widgets.link;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.FontStyle;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

import dei.vlab.communication.client.contoller.DiagramController;

public class PowerSupplyWidget extends AbsolutePanel {
	private static String pinImg = "images/tools/pin.png";
	private String name;
	private DiagramController controller;
	private int pinCount;
	private int inContainerLeft;
	private int intConatinerTop;

	private Map<Image, CNode> pinMap = new HashMap<Image, CNode>();

	public PowerSupplyWidget(String name, DiagramController controller,
			int left, int top) {
		this.name = name;
		this.controller = controller;
		this.pinCount = 0;
		this.inContainerLeft = left;
		this.intConatinerTop = top;

		AbsolutePanel psPanel = new AbsolutePanel();
		setFgPanelCss(psPanel);

		Label psLable = new Label("Power Supply");
		applyStyle(psLable);

		Label ps25PlusLable = new Label("+25v");
		Label ps25MinLable = new Label("-25v");
		Label ps6PlusLable = new Label("+6v");
		Label ps6MinLable = new Label("-6v");
		Label psGND1Lable = new Label("GND");
		Label psGND2Lable = new Label("GND");
		Image psPin1 = new Image(pinImg);
		Image psPin2 = new Image(pinImg);
		Image psPin3 = new Image(pinImg);
		Image psPin4 = new Image(pinImg);
		Image psPin5 = new Image(pinImg);
		Image psPin6 = new Image(pinImg);
		applyStyle(psLable);
		psPanel.add(psLable, 0, 0);

		psPanel.add(ps25PlusLable, 2, 42);
		psPanel.add(psPin1, 35, 42);
		addControls(psPin1, "+25v", "Power Supply +ve 25 volt", 35, 42);

		psPanel.add(ps25MinLable, 2, 72);
		psPanel.add(psPin2, 35, 72);
		addControls(psPin2, "-25v", "Power Supply -ve 25 volt", 35, 72);

		psPanel.add(psGND1Lable, 2, 102);
		psPanel.add(psPin3, 35, 102);
		addControls(psPin3, "GND25", "Power Supply Ground 25 volt", 35, 102);

		psPanel.add(ps6PlusLable, 2, 142);
		psPanel.add(psPin4, 35, 142);
		addControls(psPin4, "+6v", "Power Supply +ve 6 volt", 35, 142);

		psPanel.add(ps6MinLable, 2, 172);
		psPanel.add(psPin5, 35, 172);
		addControls(psPin5, "-6v", "Power Supply -ve 6 volt", 35, 172);

		psPanel.add(psGND2Lable, 2, 202);
		psPanel.add(psPin6, 35, 202);
		addControls(psPin6, "GND6", "Power Supply Ground 6 volt", 35, 202);
		add(psPanel);

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

	private void addControls(Image fgPin, String name, String desc, int left,
			int top) {
		pinCount++;
		CNode cNode = new CNode(pinCount, name, desc);
		cNode.setLeft(left);
		cNode.setTop(top);
		pinMap.put(fgPin, cNode);
		/*
		 * controller.addWidget(cNode, left+6, intConatinerTop+ top+6);
		 */
	}

	public int getInContainerLeft() {
		return inContainerLeft;
	}

	public int getIntConatinerTop() {
		return intConatinerTop;
	}

	public void registerControl() {

		Set<Image> fgPins = pinMap.keySet();
		for (Image fgPin : fgPins) {
			CNode cNode = pinMap.get(fgPin);
			controller.addWidget(cNode, cNode.getLeft() + 6, intConatinerTop
					+ cNode.getTop() + 6);
		}
	}

}
