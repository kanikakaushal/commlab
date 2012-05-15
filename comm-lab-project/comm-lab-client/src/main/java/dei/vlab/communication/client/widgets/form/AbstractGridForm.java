package dei.vlab.communication.client.widgets.form;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;

public abstract class AbstractGridForm extends HLayout {

	final DynamicForm _form = new DynamicForm();
	private ListGrid _listGrid = new ListGrid(){
		 protected Canvas createRecordComponent(final ListGridRecord record, Integer colNum) {
	         String fieldName = this.getFieldName(colNum);  
	         if (fieldName.equals("actions")){  
	        	 HLayout recordCanvas = new HLayout(3);  
	        	 recordCanvas.setHeight(16);  
                 recordCanvas.setAlign(Alignment.CENTER);  
                 ImgButton editImg = new ImgButton();  
                 editImg.setShowDown(false);  
                 editImg.setShowRollOver(false);  
                 editImg.setLayoutAlign(Alignment.CENTER);  
                 editImg.setSrc("icons/16/update.png");  
                 editImg.setPrompt("Update");  
                 editImg.setTitle("Update");
                 editImg.setHeight(16);  
                 editImg.setWidth(16);  
                 editImg.addClickHandler(new ClickHandler() {  
                     public void onClick(ClickEvent event) {  
                    	 showForm("update");  
                     }

                });  

                 ImgButton deleteImg = new ImgButton();  
                 deleteImg.setShowDown(false);  
                 deleteImg.setShowRollOver(false);  
                 deleteImg.setAlign(Alignment.CENTER);  
                 deleteImg.setSrc("icons/16/delete.png");  
                 deleteImg.setPrompt("Delete");  
                 deleteImg.setTitle("Delete");
                 deleteImg.setHeight(16);  
                 deleteImg.setWidth(16);  
                 deleteImg.addClickHandler(new ClickHandler() {  
                     public void onClick(ClickEvent event) {  
                         SC.say("Chart Icon Clicked for country : " + record.getAttribute("countryName"));  
                     }  
                 });  

                 recordCanvas.addMember(editImg);  
                 recordCanvas.addMember(deleteImg);  
                 return recordCanvas;  
	   
	         } else {  
	             return null;  
	         }  

			
			
		};
	};
	private HLayout _buttonLayout = new HLayout();
	private VLayout _formLayout = new VLayout();
	private VLayout _gridLayout = new VLayout();
	private VLayout addlFormLayout = new VLayout();
	private ToolStrip menuStripBar = new ToolStrip();
	private CoorinateMapperForm coorinateMapperForm;

	public AbstractGridForm(DataSource dataSource) {
		super();
		setMargin(15);
		_listGrid.setMargin(15);
		_listGrid.setAutoFetchData(true);
		_listGrid.setDataSource(dataSource);
		_listGrid.setShowRecordComponents(true);
		_listGrid.setShowRecordComponentsByCell(true);
		_listGrid.setCanRemoveRecords(false);
		_listGrid.setWidth100();
		_listGrid.setHeight100();
		_listGrid.setShowAllRecords(true);
		_listGrid.setMargin(5);

		menuStripBar.setHeight(20);
		menuStripBar.setWidth100();
		_gridLayout.addMember(menuStripBar);
		_gridLayout.addMember(_listGrid);
		coorinateMapperForm= new CoorinateMapperForm();

	/*	_form.setMargin(15);
		_form.setDataSource(dataSource);
		_buttonLayout.setMargin(15);
		
		_formLayout.addMember(_form);
		_formLayout.addMember(addlFormLayout);
		_formLayout.addMember(_buttonLayout);
		_formLayout.setMargin(15);
		_formLayout.setBorder("1px solid gray");
		setMembers(_gridLayout, _formLayout);
		_form.setMethod(FormMethod.POST);
*/		setMembers(_gridLayout);

	}

	public void fetchData() {
		this._listGrid.fetchData();
		this.fetchData();
	}

	public void setUseAllDataSourceFields(boolean value) {
		this._form.setUseAllDataSourceFields(value);
	}

	public void setFields(FormItem... fields) {
		this._form.setFields(fields);
	}

	public void validate(boolean value) {
		this._form.validate(value);
	}

	public void setFormIsGroup(boolean isGroup) {
		this._form.setIsGroup(isGroup);
	}

	public void setFormGroupTitle(String groupTitle) {
		this._form.setGroupTitle(groupTitle);
		
	}

	public void setFormNumCols(int cols) {
		_form.setNumCols(cols);
	}

	public void addButton(IButton button) {
		this._buttonLayout.addMember(button);
	}

	public void setGridHeight(int height) {
		_listGrid.setHeight(height);
	}

	public void setGridHeight100() {
		_listGrid.setHeight100();
	}

	public void setGridWidth(int width) {
		_listGrid.setWidth(width);
	}

	public void setGridWidth100() {
		_listGrid.setWidth100();
	}

	public void saveFormData() {
		_form.saveData();
	}

	public void resetForm() {
		_form.clearValues();
		_form.reset();
	}

	public void setGridEditable(boolean isEditable) {
		if (isEditable) {
			_listGrid.addClickHandler(new ClickHandler() {

				public void onClick(ClickEvent event) {
					_form.reset();
					_form.editSelectedData(_listGrid);
				}
			});
		}
	}

	public void addForm(Canvas... component) {
		addlFormLayout.setMembers(component);
	}

	public FormItem getFormField(String name) {
		return _form.getField(name);

	}
	public void refreshGrid(){
		_listGrid.fetchData();
	}
	public void addMenu(ToolStripButton menuButton){
		this.menuStripBar.addButton(menuButton);
	}
	public void setFields(ListGridField... fields){
		_listGrid.setFields(fields);
	}
	public void setGroupByField(String field){
		_listGrid.setGroupByField(field);
	}
	public void showForm(String key) {
		if("update".equalsIgnoreCase(key)){
		coorinateMapperForm.setWindowTitle("Update Circuit");
		}else{
			coorinateMapperForm.setWindowTitle("New Circuit");
		}
		coorinateMapperForm.show();
	}  

}
