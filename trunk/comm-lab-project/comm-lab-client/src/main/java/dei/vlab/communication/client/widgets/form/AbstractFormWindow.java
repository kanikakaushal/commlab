package dei.vlab.communication.client.widgets.form;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;

public abstract class AbstractFormWindow extends Window {
	final DynamicForm _form = new DynamicForm();

	public AbstractFormWindow(DataSource dataSource) {
		super();
		this.setShowMinimizeButton(false);
		if(dataSource!=null){
		_form.setMargin(15);
		_form.setDataSource(dataSource);
		this.addItem(_form);
		}
	}
	
	public void setWindowShowModalMask(boolean value){
		this.setShowModalMask(value);
	}
	public void setWindowAlignCenter(){
		this.centerInPage();
	}
	
	public void setWindowTitle(String title) {
		this.setTitle(title);
	}

	public void setWindowWidth(int w) {
		this.setWidth(w);
	}

	public void setWindowHeight(int h) {
		this.setHeight(450);
	}

	public void setWindowIsModal(boolean isModel) {
		this.setIsModal(isModel);
	}

	public void fetchData() {
		this._form.fetchData();
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
}
