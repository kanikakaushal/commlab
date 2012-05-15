package dei.vlab.communication.client.widgets.form;

import com.smartgwt.client.types.Encoding;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.HiddenItem;
import com.smartgwt.client.widgets.form.fields.UploadItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;

import dei.vlab.communication.client.data.CircuitDataSource;

public class CircuitGridWindow extends AbstractGridForm {
	private static String TITLE_SAVE_BUTTON="Save and Define Node Coordinates";
	private static String TITLE_NEW_BUTTON="New";
	private final DynamicForm uploadForm = new DynamicForm();	
	private IButton saveButton;
	private IButton newButton;
	private HiddenItem propertyIdItem ;
	private UploadItem fileItem;
	

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


	private void addButtons() {
		saveButton = new IButton(TITLE_SAVE_BUTTON);
		saveButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				propertyIdItem.setValue(getFormField("name").getDisplayValue());
				uploadForm.submitForm();
				saveFormData();
				saveButton.disable();
				newButton.enable();
				String imgPath=fileItem.getDisplayValue();
				if(imgPath!=null && imgPath.length()>0){
				imgPath= imgPath.substring(imgPath.lastIndexOf("\\")+1, imgPath.length());
				}
				SC.say("imagePath "+imgPath );
			}
		});
		 newButton = new IButton(TITLE_NEW_BUTTON);
		newButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				saveButton.enable();
				newButton.disable();
			}
		});
		saveButton.disable();
		
		addButton(newButton);
		addButton(saveButton);
	}
    
	public void  addUploadForm(){
		uploadForm.setEncoding(Encoding.MULTIPART);
		fileItem = new UploadItem("image");
		propertyIdItem = new HiddenItem("circuitName");
		uploadForm.setTarget("hidden_frame");
		uploadForm.setAction("app/imageUploadRest");		
		uploadForm.setItems(fileItem, propertyIdItem);
		addForm(uploadForm);
			
	  }
	
	private void setListGridField() {
		ListGridField imageField = new ListGridField("image", "Image");
		ListGridField nameField = new ListGridField("name", "Name");
		ListGridField typeField = new ListGridField("type", "Level");
		ListGridField descField = new ListGridField("description", "Description");
		ListGridField actionField = new ListGridField("actions", "Actions");
		setFields(imageField,nameField, typeField, descField, actionField);
		setGroupByField("description");
	}


	
	
}
