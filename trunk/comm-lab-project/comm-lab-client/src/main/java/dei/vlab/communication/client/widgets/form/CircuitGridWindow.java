package dei.vlab.communication.client.widgets.form;

import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;

import dei.vlab.communication.client.data.CircuitDataSource;

public class CircuitGridWindow extends AbstractGridForm {
	

	public CircuitGridWindow() {
		super(CircuitDataSource.getInstance());
		this.setMargin(15);
		setGridWidth100();
		setGridHeight100();
		addMenu(createNewButton("icons/16/document_plain_new.png","Add New Circuit"));
		setListGridField();
	}


	private ToolStripButton createNewButton(String img,String name) {
		ToolStripButton button = new ToolStripButton();
		button.setIcon(img); 
		button.setTitle(name);
		button.addClickHandler(new ClickHandler() {  
            public void onClick(ClickEvent event) {  
           	 showForm("new");  
            }

       }); 
		return button;
	}

	
	private void setListGridField() {
		ListGridField imageField = new ListGridField("image", "Image");
		imageField.setType(ListGridFieldType.IMAGE);  
		imageField.setImageURLPrefix("resources/");  
		
		
	
		ListGridField nameField = new ListGridField("name", "Name");
		ListGridField typeField = new ListGridField("type", "Level");
		ListGridField descField = new ListGridField("description", "Description");
		ListGridField actionField = new ListGridField("actions", "Actions");
		ListGridField nodeDataField = new ListGridField("nodeData", "NodeData");
			setFields(imageField,nameField, typeField, descField, actionField,nodeDataField);
		setGroupByField("description");
		
		hideGridField("nodeData");
	}


	
	
}
