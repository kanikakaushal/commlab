package dei.vlab.communication.client.data;

import com.google.gwt.core.client.GWT;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.Encoding;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.widgets.form.fields.HiddenItem;
import com.smartgwt.client.widgets.form.fields.UploadItem;

public class CircuitDataSource extends AbstractRestDataSource {

	private static CircuitDataSource instance = null;

	public static CircuitDataSource getInstance() {
		if (instance == null) {
			instance = new CircuitDataSource("circuitDS");
		}

		return instance;
	}

	private CircuitDataSource(String id) {
		super(id);
	}

	protected void init() {
		setDataFormat(DSDataFormat.JSON);
		setJsonRecordXPath("/");

		DataSourceField idField = new DataSourceField("id", FieldType.INTEGER,
				"ID");
		idField.setPrimaryKey(true);
		idField.setCanEdit(false);

		DataSourceField nameField = getTextFieldRequired("name", "Name", 50);
		DataSourceField typeField = getTextFieldRequired("type", "Level", 50);
		DataSourceField descriptionField = getTextFieldRequired("description",
				"Description", 500);
		
		DataSourceField imageField = getTextFieldRequired("image", "Image", 50);
		DataSourceField nodeDataField = getTextFieldRequired("nodeData", "NodeData", 50);
					
		setFields(imageField,nameField, typeField, descriptionField,nodeDataField);

	}

	private DataSourceField getTextFieldRequired(String name, String title,
			int len) {
		return new DataSourceField(name, FieldType.TEXT, title, len, true);
	}

	@Override
	protected String getServiceRoot() {
		return GWT.getHostPageBaseURL() + "app/circuit";
	}

	
	
}
