package dei.vlab.communication.client.widgets.form;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.FormMethod;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public abstract class AbstractGridForm extends HLayout {

	final DynamicForm _form = new DynamicForm();
	private ListGrid _listGrid = new ListGrid();
	private HLayout _buttonLayout = new HLayout();
	private VLayout _formLayout = new VLayout();
	private VLayout _gridLayout = new VLayout();
	private VLayout addlFormLayout = new VLayout();

	public AbstractGridForm(DataSource dataSource) {
		super();
		setMargin(15);
		_listGrid.setMargin(15);
		_listGrid.setAutoFetchData(true);
		_listGrid.setDataSource(dataSource);
		_form.setMargin(15);
		_form.setDataSource(dataSource);
		_buttonLayout.setMargin(15);
		_gridLayout.addMember(_listGrid);
		_formLayout.addMember(_form);
		_formLayout.addMember(addlFormLayout);
		_formLayout.addMember(_buttonLayout);
		_formLayout.setMargin(15);
		_formLayout.setBorder("1px solid gray");
		setMembers(_gridLayout, _formLayout);
		_form.setMethod(FormMethod.POST);
		

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

				@Override
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
}
