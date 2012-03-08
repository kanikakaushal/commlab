package dei.vlab.communication.client.widgets.form;

import com.smartgwt.client.types.Encoding;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.HiddenItem;
import com.smartgwt.client.widgets.form.fields.UploadItem;

import dei.vlab.communication.client.data.CircuitDataSource;

public class CircuitForm extends AbstractGridForm {
	private static String TITLE_FORM="New / Update";
	private static String TITLE_SAVE_BUTTON="Save";
	private static String TITLE_NEW_BUTTON="New";
	private static String TITLE_DEFINECOORDINATES="Define Node Coordinates";
	private final DynamicForm uploadForm = new DynamicForm();	
	private IButton saveButton;
	private IButton newButton;
	private HiddenItem propertyIdItem ;
	private UploadItem fileItem;
	private CoorinateMapperForm coorinateMapperForm;

	public CircuitForm() {
		super(CircuitDataSource.getInstance());
		this.setMargin(15);
		setIsGroup(true);
		setFormGroupTitle(TITLE_FORM);
		setFormNumCols(2);
		setGridWidth100();
		setGridHeight100();
		addButtons();
		setGridEditable(true);
		addUploadForm();
		coorinateMapperForm= new CoorinateMapperForm();
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
				coorinateMapperForm.setImageName(imgPath);
				//coorinateMapperForm.showImage();
				coorinateMapperForm.show();
				//refreshGrid();
			}
		});
		 newButton = new IButton(TITLE_NEW_BUTTON);
		newButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				saveButton.enable();
				newButton.disable();
			}
		});
	/*	IButton xyButton = new IButton(TITLE_DEFINECOORDINATES);
		xyButton.setWidth(200);
		xyButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//listGrid.getSelectedRecord();
				//dialog.setImage((DataSourceImageFileField)listGrid.getDataSource().getField("image"));
				//dialog.showDialog();
			}
		});
	*/	
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
	

	
	
}
