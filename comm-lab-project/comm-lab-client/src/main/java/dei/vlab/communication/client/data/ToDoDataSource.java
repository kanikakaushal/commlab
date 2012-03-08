package dei.vlab.communication.client.data;

import com.google.gwt.core.client.GWT;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.FieldType;

public class ToDoDataSource extends AbstractRestDataSource {
	 private static ToDoDataSource instance = null;

	 public static ToDoDataSource getInstance() {
	  if(instance == null) {
	   instance = new ToDoDataSource("todoDS");
	  }

	  return instance;
	 }

	 private ToDoDataSource(String id) {
	  super(id);
	 }

	 protected void init() {
	  setDataFormat(DSDataFormat.JSON);
	  setJsonRecordXPath("/");

	  DataSourceField idField = new DataSourceField("id", FieldType.INTEGER, "ID");
	  idField.setPrimaryKey(true);
	  idField.setCanEdit(false);
	  DataSourceField taskField = new DataSourceField("task", FieldType.TEXT, "Task");

	  setFields(idField, taskField);
	 }

	 @Override
	 protected String getServiceRoot() {
	  return GWT.getHostPageBaseURL() +"app/todolist";
	 }
	}
