package dei.vlab.communication.client.data;

import com.google.gwt.core.client.GWT;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.FieldType;

public class UserWFActionDataSource extends AbstractRestDataSource {
	 private static UserWFActionDataSource instance = null;

	 public static UserWFActionDataSource getInstance() {
	  if(instance == null) {
	   instance = new UserWFActionDataSource("userWSactionDS");
	  }

	  return instance;
	 }

	 private UserWFActionDataSource(String id) {
	  super(id);
	 }

	 protected void init() {
	  setDataFormat(DSDataFormat.JSON);
	  setJsonRecordXPath("/");

	  DataSourceField idField = new DataSourceField("id", FieldType.INTEGER, "ID");
	  idField.setPrimaryKey(true);
	  idField.setCanEdit(false);
	  DataSourceField snoField = new DataSourceField("sno", FieldType.TEXT, "S.No.");
	  DataSourceField fullNameField = new DataSourceField("fullName", FieldType.TEXT, "Full Name");
	  DataSourceField emailField = new DataSourceField("email", FieldType.TEXT, "email");
	  DataSourceField contactNoField = new DataSourceField("contactNo", FieldType.TEXT, "Contact No");
	  DataSourceField collegeField = new DataSourceField("college", FieldType.TEXT, "College");
	  DataSourceField statusField = new DataSourceField("status", FieldType.TEXT, "Status");

	  setFields(idField, snoField,fullNameField,emailField,contactNoField,collegeField,statusField);
	 }

	 @Override
	 protected String getServiceRoot() {
	  return GWT.getHostPageBaseURL() +"app/userwfaction";
	 }
	}
