package dei.vlab.communication.client.widgets.link;

import com.google.gwt.event.dom.client.HasAllTouchHandlers;
import com.google.gwt.event.dom.client.TouchCancelEvent;
import com.google.gwt.event.dom.client.TouchCancelHandler;
import com.google.gwt.event.dom.client.TouchEndEvent;
import com.google.gwt.event.dom.client.TouchEndHandler;
import com.google.gwt.event.dom.client.TouchMoveEvent;
import com.google.gwt.event.dom.client.TouchMoveHandler;
import com.google.gwt.event.dom.client.TouchStartEvent;
import com.google.gwt.event.dom.client.TouchStartHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Image;

import dei.vlab.communication.client.save.IsDiagramSerializable;

public class CNode extends Image implements HasAllTouchHandlers,IsDiagramSerializable{
	
	public static String RED="images/red-dot.png";
	public static String BLUE="images/blue-dot.png";
	public static String GREEN="images/green-dot.png";
	public static String ORANGE="images/orange-dot.png";
	public static String YELLOW="images/yellow-dot.png";
	public static String GRAY="images/gray-dot.png";
	public static String ROSE="images/rose-dot.png";

	public static String identifier = "boxlabel";
	String content="node";
	int id;
	
	
	public CNode(int id){
		super("images/dot.png");
		this.id=id;
		setPixelSize(9,9);
	}

	public CNode(int id,String color){
		super(color);
		this.id=id;
		setPixelSize(9,9);
	}

	public int getId() {
		return id;
	}

	
	public HandlerRegistration addTouchStartHandler(TouchStartHandler handler){
		return addDomHandler(handler, TouchStartEvent.getType());
	}
	
	
	public HandlerRegistration addTouchEndHandler(TouchEndHandler handler){
		return addDomHandler(handler, TouchEndEvent.getType());
	}
	
	
	public HandlerRegistration addTouchMoveHandler(TouchMoveHandler handler){
		return addDomHandler(handler, TouchMoveEvent.getType());
	}
	
	
	public HandlerRegistration addTouchCancelHandler(TouchCancelHandler handler){
		return addDomHandler(handler, TouchCancelEvent.getType());
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
}
