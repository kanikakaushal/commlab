package dei.vlab.communication.client.contoller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.MenuItem;

import dei.vlab.communication.client.menu.ContextMenu;
import dei.vlab.communication.client.widgets.link.CNode;

public class CircuitMapperContoller extends DiagramController {
	
	private List<CNode> cNodes=new ArrayList<CNode>();
	private int nodeCount =0;
	public CircuitMapperContoller(int canvasWidth, int canvasHeight) {
		super(canvasWidth, canvasHeight);
	}

	
	protected void initMenu() {
		
		canvasMenu = new ContextMenu();
		canvasMenu.addItem(new MenuItem("Add Node", new Command() {
			
			public void execute() {
				nodeCount++;
				CNode cNode =new CNode(nodeCount);
				cNodes.add(cNode);
				
				addWidgetAtMousePoint(cNode);
				dragController.makeDraggable(cNode);
				canvasMenu.hide();
			}
		}));
	}
	
	public String getSaveData(){
	Map<String,Object> data = new HashMap<String, Object>();
	data.put("backgroungImg",getBackgroundImage() );
	data.put("node", getCnodeSavableData());
	return data.toString();
		
	}
	public String getCnodeSavableData(){
		StringBuffer data= new StringBuffer();
		data.append("{");
		for(CNode cNode:cNodes){
			data.append("id:{").append(cNode.getId()).append(",");
			data.append("left:").append(cNode.getAbsoluteLeft()).append(",");
			data.append("top:").append(cNode.getAbsoluteTop());
			data.append("}");
	
		}
		data.append("}");
		return data.toString();
			
		}
}
