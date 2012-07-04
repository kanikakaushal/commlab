package dei.vlab.communication.client.handler;

import com.smartgwt.client.widgets.menu.events.ClickHandler;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;

import dei.vlab.communication.client.widgets.tools.ExpermentPanel;

public class AddCircuitHander implements  ClickHandler {

	private ExpermentPanel expermentPanel;

	public AddCircuitHander(ExpermentPanel expermentPanel) {
		this.expermentPanel=expermentPanel;
	}
	public void onClick(String name,String nodeData) {
		
		expermentPanel.addCircuit(name, nodeData);
	}
	public void onClick(MenuItemClickEvent event) {
		// TODO Auto-generated method stub
		
	}

}
