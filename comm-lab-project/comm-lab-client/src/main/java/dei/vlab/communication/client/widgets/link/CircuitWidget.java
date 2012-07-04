package dei.vlab.communication.client.widgets.link;

import java.util.ArrayList;
import java.util.List;

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
	private List<CNode> cNodes=new ArrayList<CNode>();
	private int nodeCount =0;
	

	public CircuitWidget(final DiagramController controller,PickupDragController dragController,String imageFile) {
		super(imageFile);
		this.controller = controller;
		this.dragController=dragController;
		controller.addWidgetToBackgound(this, 150,50);
		
		this.getElement().getStyle().setZIndex(2);
		/*this.addMouseListener(new MouseListener() {
			
			
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
		});*/

		initMenu();
	}

	protected void initMenu() {

		contextMenu = new ContextMenu();
		contextMenu.addItem(new MenuItem("Add", new Command() {
			
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
	
	public void setNodeData(String data){
		cNodes.clear();
		 List<CNodeData> datas= praseData(data);
		 for(CNodeData cNodeData :datas){
			 	nodeCount++;
			 	
				CNode cNode =new CNode(nodeCount,cNodeData.getName(),cNodeData.getDescription());
				cNodes.add(cNode);
  				controller.addWidgetAtMousePoint(cNode,this.getAbsoluteLeft()+cNodeData.getLeft(),this.getAbsoluteTop()+cNodeData.getTop());
				
				dragController.makeDraggable(cNode);
		 }
		}
	
	private List<CNodeData> praseData(String datas) {
		List<CNodeData> cNodeDatas = new ArrayList<CNodeData>();
		datas=datas.replace("[", "");
		datas=datas.replace("]", "");
		datas=datas.replace("CNodeData", "");
		datas=datas.trim();
		for(String data :datas.split(",")){
			cNodeDatas.add(CNodeData.create(data));
		}
		return cNodeDatas;
		
		
	}


	
}
