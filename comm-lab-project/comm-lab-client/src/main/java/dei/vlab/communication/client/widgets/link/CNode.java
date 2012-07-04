package dei.vlab.communication.client.widgets.link;

import java.util.Map;

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

public class CNode extends Image implements HasAllTouchHandlers{
	
	public static String RED="images/tools/red-dot.png";
	public static String BLUE="images/tools/blue-dot.png";
	public static String GREEN="images/tools/green-dot.png";
	public static String ORANGE="images/tools/orange-dot.png";
	public static String YELLOW="images/tools/yellow-dot.png";
	public static String GRAY="images/tools/gray-dot.png";
	public static String ROSE="images/tools/rose-dot.png";
	private int id;
	private String name;
	private String description;
	private CNodeData cNodeData = new CNodeData();
	
	
	public CNode(int id){
		this(id,"","");
	}
	
	public CNode(int id,String name,String desc){
		super("images/tools/dot.png");
		this.id=id;
		this.name=name;
		this.description=desc;
		this.setAltText(name+" : "+desc);
		setPixelSize(9,9);
	}

	public CNode(CNodeData cNodeData){
		super("images/tools/dot.png");
		this.id=cNodeData.getId();
		this.name=cNodeData.getName();
		this.description=cNodeData.getDescription();
		this.setAltText(name+" : "+description);
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
	
	public CNodeData getSaveData(int absoluteLeft, int absoluteTop){
		cNodeData.setId(id);
		cNodeData.setName(name);
		cNodeData.setDescription(description);
		cNodeData.setLeft(this.getAbsoluteLeft()-absoluteLeft);
		cNodeData.setTop(this.getAbsoluteTop()-absoluteTop);
		return cNodeData;
		
	}
	public void setLeft(int l){
		cNodeData.setLeft(l);
	}
	public void setTop(int t){
		cNodeData.setTop(t);
	}
	
	public int getLeft(){
		return cNodeData.getLeft();
	}
	public int getTop(){
		return cNodeData.getTop();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}
