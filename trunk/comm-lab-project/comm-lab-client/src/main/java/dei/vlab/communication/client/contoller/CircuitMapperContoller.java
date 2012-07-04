package dei.vlab.communication.client.contoller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.DragLeaveEvent;
import com.google.gwt.event.dom.client.DragLeaveHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.smartgwt.client.util.JSON;
import com.smartgwt.client.util.SC;

import dei.vlab.communication.client.menu.HasContextMenu;
import dei.vlab.communication.client.util.JsonConverter;
import dei.vlab.communication.client.widgets.link.CNode;
import dei.vlab.communication.client.widgets.link.CNodeData;

public class CircuitMapperContoller extends DiagramController {
	
	private List<CNode> cNodes=new ArrayList<CNode>();
	private int nodeCount =0;
	public CircuitMapperContoller(int canvasWidth, int canvasHeight) {
		super(canvasWidth, canvasHeight);
	}

	

	public void addNode(String name, String desc) {
       
		nodeCount++;
		CNode cNode =new CNode(nodeCount,name,desc);
		cNodes.add(cNode);
     	addWidgetAtMousePoint(cNode,20,20);
		
		dragController.makeDraggable(cNode);
	}
	
	public void removeNode(String name) {
		CNode toRemovecNode=null;
		nodeCount++;
		for(CNode cNode:cNodes){
			if(cNode.getName().equalsIgnoreCase(name)){
				toRemovecNode=cNode;
				break;
			}
	
		}
		cNodes.remove(toRemovecNode);
		deleteWidget(toRemovecNode);
		dragController.makeNotDraggable(toRemovecNode);

	}
	
	
	public List<CNodeData> getSavableData(){
		List<CNodeData> data = new ArrayList<CNodeData>();
		for(CNode cNode:cNodes){
			data.add(cNode.getSaveData(this.getDiagramCanvas().asWidget().getAbsoluteLeft(), this.getDiagramCanvas().asWidget().getAbsoluteTop()));
		}
		return data;
			
		}
	
	public String getSavableDatainString(){
		List<CNodeData> data = getSavableData();
		return data.toString();
			
		}
	
	
	public void setNodeData(String data){
		cNodes.clear();
		 List<CNodeData> datas= praseData(data);
		 for(CNodeData cNodeData :datas){
			 	nodeCount++;
			 	
				CNode cNode =new CNode(nodeCount,cNodeData.getName(),cNodeData.getDescription());
				cNodes.add(cNode);
                //Window.alert("left [" +cNodeData.getLeft()+"] top ["+cNodeData.getTop()+"]");
				addWidgetAtMousePoint(cNode,cNodeData.getLeft(),cNodeData.getTop());
				
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



	public void setCount(int c){
		this.nodeCount=c;
	}
	
	
}
