package dei.vlab.communication.client.widgets.link;

import com.allen_sauer.gwt.dnd.client.PickupDragController;
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
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.MouseListener;
import com.google.gwt.user.client.ui.Widget;

import dei.vlab.communication.client.contoller.DiagramController;
import dei.vlab.communication.client.handler.HasNoConnection;
import dei.vlab.communication.client.menu.ContextMenu;
import dei.vlab.communication.client.menu.HasContextMenu;
import dei.vlab.communication.client.save.IsDiagramSerializable;

public class CircuitWidget extends Image implements HasContextMenu,HasAllTouchHandlers,HasNoConnection,
		IsDiagramSerializable {
	public static String identifier = "circuit";
	String content;
	DiagramController controller;
	public ContextMenu contextMenu;
	public PickupDragController dragController;
	private CNode n1;

	protected void initMenu() {

		contextMenu = new ContextMenu();
		contextMenu.addItem(new MenuItem("Move", new Command() {
			
			public void execute() {
				try{
				enableDraggable();
				contextMenu.hide();
				}catch (Exception e) {
					Window.alert(e.getLocalizedMessage());
				}
				}
		}));
		contextMenu.addItem(new MenuItem("Delete", new Command() {
			
			public void execute() {
				removeMe();
				contextMenu.hide();
				}
		}));
		
		
	}

	public void setRelativeCoordinates(int left,int top){
		controller.addWidget(n1,left+this.getAbsoluteLeft(),top+this.getAbsoluteTop());
		
	}
	public CircuitWidget(final DiagramController controller,PickupDragController dragController,String imageFile) {
		super(imageFile);
		this.controller = controller;
		this.dragController=dragController;
		 n1= new CNode(1);
		controller.addWidgetToBackgound(this, 150,50);
		setRelativeCoordinates(157,158);
		
		this.getElement().getStyle().setZIndex(2);
		n1.getElement().getStyle().setZIndex(15);
		
		this.addMouseListener(new MouseListener() {
			
			
			public void onMouseUp(Widget arg0, int arg1, int arg2) {
				setRelativeCoordinates(157, 158);
			}
			
			
			public void onMouseMove(Widget arg0, int arg1, int arg2) {
				setRelativeCoordinates(157, 158);
				
			}
			
			
			public void onMouseLeave(Widget arg0) {
				
				controller.runRefresh();
				desableDraggable();
			}
			
			
			public void onMouseEnter(Widget arg0) {
				setRelativeCoordinates(157, 158);
				
			}
			
			
			public void onMouseDown(Widget arg0, int arg1, int arg2) {
				setRelativeCoordinates(157, 158);
				
			}
		});

		initMenu();
	}


	
	public HandlerRegistration addTouchStartHandler(TouchStartHandler handler) {
		return addDomHandler(handler, TouchStartEvent.getType());
	}

	
	public HandlerRegistration addTouchEndHandler(TouchEndHandler handler) {
		return addDomHandler(handler, TouchEndEvent.getType());
	}

	
	public HandlerRegistration addTouchMoveHandler(TouchMoveHandler handler) {
		return addDomHandler(handler, TouchMoveEvent.getType());
	}

	
	public HandlerRegistration addTouchCancelHandler(TouchCancelHandler handler) {
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


	
	public ContextMenu getContextMenu() {
		// TODO Auto-generated method stub
		return contextMenu;
	}
	
	protected void enableDraggable(){
		dragController.makeDraggable(this);
	}
	protected void desableDraggable(){
	
		dragController.makeNotDraggable(this);
	}
	protected void removeMe(){
		controller.deleteWidget(this);
	}
	

	
}
