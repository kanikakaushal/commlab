package dei.vlab.communication.client.widgets.form;

import java.util.LinkedHashMap;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Widget;
import com.smartgwt.client.types.Encoding;
import com.smartgwt.client.types.FormMethod;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.HiddenItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.UploadItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import dei.vlab.communication.client.data.CircuitDataSource;
import dei.vlab.communication.client.data.CircuitImageMapData;
import dei.vlab.communication.client.widgets.tools.CircuitPanel;

public class CoorinateMapperForm extends Window {
	private ListGrid _listGrid;
	private VLayout formLayout = new VLayout();
	private final DynamicForm uploadForm = new DynamicForm();	
	private HiddenItem propertyIdItem ;
	private UploadItem fileItem;
	private final DynamicForm form = new DynamicForm();
 

	public CoorinateMapperForm( ListGrid _listGrid) {
		this._listGrid=_listGrid;
		config();
		addForm();
		addButtons();
	}
	public void  addUploadForm(){
		uploadForm.setEncoding(Encoding.MULTIPART);
		fileItem = new UploadItem("image");
		fileItem.setRequired(true);
		fileItem.setRequiredMessage("Circuit Image is required");
		fileItem.setDisplayField("Image");
		propertyIdItem = new HiddenItem("circuitName");
		uploadForm.setTarget("hidden_frame");
		uploadForm.setAction("app/imageUploadRest");		
		uploadForm.setItems(fileItem, propertyIdItem);
		formLayout.addMember(uploadForm);
			
	  }
	
	private void config() { 
		
		addItem(formLayout);
	
			
		
		this.setTitle("Circuit");
		this.setWidth(450);
		this.setHeight(430);
		this.setIsModal(true);
		this.setShowModalMask(true);
		this.centerInPage();
		this.setMargin(20);
		formLayout.setHeight100();
		formLayout.setWidth100();
		formLayout.setVisible(true);
	}


	public void setWindowTitle(String title) {
		this.setTitle(title);
	}

	private void addForm() {
		form.setWidth(250);
		form.setMethod(FormMethod.POST);
		form.setDataSource(CircuitDataSource.getInstance());
		form.setAction("app/circuit");
		TextItem circuitNameItem = new TextItem("name");
		circuitNameItem.setTitle("Name");
		circuitNameItem.setRequired(true);
		circuitNameItem.setWidth(260);
		circuitNameItem.setRequired(true);
		circuitNameItem.setRequiredMessage("Name is required.");
	
		LinkedHashMap<String, String> valueMap = new LinkedHashMap<String, String>();
		valueMap.put("Beginner", "Beginner");
		valueMap.put("Moderate ", "Moderate ");
		valueMap.put("Expert", "Expert");

		SelectItem levelItem = new SelectItem("type");
		levelItem.setTitle("Level");
		levelItem.setRequired(true);
		levelItem.setValueMap(valueMap);
		levelItem.setWidth(260);
		levelItem.setRequired(true);
		levelItem.setRequiredMessage("Level is required.");
		
		TextAreaItem descriptionItem = new TextAreaItem("description");
		descriptionItem.setTitle("Description");
		descriptionItem.setRequired(true);
		descriptionItem.setWidth(260);
		descriptionItem.setRequired(true);
		descriptionItem.setRequiredMessage("Should provide description.");
		
		
		
		form.setMargin(20);
		form.setFields(new FormItem[] { circuitNameItem, levelItem,
				descriptionItem});
		formLayout.addMember(form);
		addUploadForm();
		
	}
	public FormItem getFormField(String name) {
		return form.getField(name);

	}
	private void addButtons() {
		HLayout buttonLayout = new HLayout();
		buttonLayout.setWidth100();
		buttonLayout.setMargin(50);
		IButton saveButton = new IButton("Save");
		saveButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (validate()) {
					String imageName="";
					try{
					propertyIdItem.setValue(getFormField("name").getDisplayValue());
					imageName=fileItem.getDisplayValue();
					imageName=imageName.substring(imageName.lastIndexOf("\\")+1,imageName.length());
						// 
						form.saveData();
						uploadForm.submitForm();
						hideForm();
					}
					catch (Exception e) {
					SC.say(e.getLocalizedMessage());
					}
					//TODO: need to get the uploaded file path
						// after uploaded on server to display image 
						// for coordinate mapping
					//initCiruitMapper("images/resources/"+imageName);
				}
			}
		});
		IButton cancelButton = new IButton("Cancel");
		cancelButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				hide();
			}

		});

		buttonLayout.addMember(cancelButton);
		buttonLayout.addMember(saveButton);
		formLayout.addMember(buttonLayout);
	}

	public void hideForm() {
		this.hide();
		this._listGrid.invalidateCache();
		this._listGrid.getDataSource().fetchData();
		
	}
	

	private boolean validate() {
		return form.validate() && uploadForm.validate();
	}
	
	public void load() {
		form.clear();
		uploadForm.clear();
		config();
		show();

	}



	/*private void initCiruitMapper(String image) {
		drwLayout = new Window();
		drwLayout.setTitle("Circuit");
		drwLayout.setWidth(450);
		drwLayout.setHeight(430);
		drwLayout.setIsModal(true);
		drwLayout.setShowModalMask(true);
		drwLayout.centerInPage();
		drwLayout.setMargin(20);
		this.hide();
		circuitPanel = new CircuitPanel(image);
		drwLayout.addItem(circuitPanel.asWidget());
		drwLayout.show();
		mapperLayout.addMember(circuitPanel.asWidget());
		circuitPanel.draw();
		mainPanel.setVisible(true);
	}
	
*/
}
