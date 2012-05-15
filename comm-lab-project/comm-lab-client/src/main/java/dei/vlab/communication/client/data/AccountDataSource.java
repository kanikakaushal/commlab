package dei.vlab.communication.client.data;

import com.google.gwt.core.client.GWT;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourcePasswordField;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.widgets.form.validator.MaskValidator;
import com.smartgwt.client.widgets.form.validator.RegExpValidator;

public class AccountDataSource extends AbstractRestDataSource {
	private static AccountDataSource instance = null;

	public static AccountDataSource getInstance() {
		if (instance == null) {
			instance = new AccountDataSource("accountDS");
		}

		return instance;
	}

	private AccountDataSource(String id) {
		super(id);
	}

	protected void init() {
		setDataFormat(DSDataFormat.JSON);
		setJsonRecordXPath("/");

		DataSourceField idField = new DataSourceField("id", FieldType.INTEGER,
				"ID");
		idField.setPrimaryKey(true);
		idField.setCanEdit(false);
		
		DataSourceField firstNameField = getTextFieldRequired("firstName","First Name", 50);
		DataSourceField lastNameField =	getTextFieldRequired("lastName","Last Name", 50);
		DataSourceField collegeField = getTextFieldRequired("college", "College", 100);
		DataSourceField address1Field = getTextFieldRequired("address1","Address", 100);
		DataSourceField address2Field = getTextFieldRequired("adress2", "", 100);
		DataSourceField streetField = getTextFieldRequired("street", "Street", 50);
		DataSourceField cityField = getTextFieldRequired("city","City", 50);
		DataSourceField countryField = getTextFieldRequired("country", "Country", 15);
		DataSourceField contactNoField = getTextFieldRequired("contactNo", "Contact No", 12);
		DataSourceField emailField = getTextFieldRequired("email", "Email", 100);
		
		 MaskValidator maskValidator = new MaskValidator();  
	        maskValidator.setMask("^\\s*(1?)\\s*\\(?\\s*(\\d{3})\\s*\\)?\\s*-?\\s*(\\d{3})\\s*-?\\s*(\\d{4})\\s*$");  
	        maskValidator.setTransformTo("$1($2) $3 - $4");  
	        contactNoField.setValidators(maskValidator);
	        
		RegExpValidator emailValidator = new RegExpValidator();
		emailValidator.setErrorMessage("Invalid email address");
		emailValidator.setExpression(
				"^([a-zA-Z0-9_.\\-+])+@(([a-zA-Z0-9\\-])+\\.)+[a-zA-Z0-9]{2,4}$"
				);

		emailField.setValidators(emailValidator);

		DataSourcePasswordField passwordField = new DataSourcePasswordField(
				"password", "Password", 20, true);

		setFields(firstNameField, lastNameField, collegeField, address1Field,
				address2Field, streetField, cityField, countryField,
				contactNoField, emailField, passwordField);

	}

	private DataSourceField getTextFieldRequired(String name,String title,int len ) {
		return new DataSourceField(name,FieldType.TEXT, title,len, true);
	}

	@Override
	protected String getServiceRoot() {
		return GWT.getHostPageBaseURL() + "/app/accountinfo";
	}

	
}
