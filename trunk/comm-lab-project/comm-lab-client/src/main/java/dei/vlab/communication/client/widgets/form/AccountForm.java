package dei.vlab.communication.client.widgets.form;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.SectionItem;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.client.widgets.form.validator.MatchesFieldValidator;

public class AccountForm extends AbstractFormWindow {
	public AccountForm(DataSource dataSource) {
		super(dataSource);
		setUseAllDataSourceFields(true);
		setWindowTitle("Account Information");
		setWindowWidth(360);
		setWindowHeight(450);
		setWindowIsModal(true);
		setWindowShowModalMask(true);
		setWindowAlignCenter();
		addFormFields();

	}

	private void addFormFields() {
		PasswordItem passwordItem = new PasswordItem();
		passwordItem.setName("password");

		PasswordItem passwordItem2 = new PasswordItem();
		passwordItem2.setName("password2");
		passwordItem2.setTitle("Confirm Password");
		passwordItem2.setRequired(true);
		passwordItem2.setLength(20);

		MatchesFieldValidator matchesValidator = new MatchesFieldValidator();
		matchesValidator.setOtherField("password");
		matchesValidator.setErrorMessage("Passwords do not match");
		passwordItem2.setValidators(matchesValidator);

		CheckboxItem acceptItem = new CheckboxItem();
		acceptItem.setName("changePassword");
		acceptItem.setTitle("Do you want to change password?");
		acceptItem.setWidth(150);

		ButtonItem savaBtnItem = new ButtonItem();
		savaBtnItem.setTitle("Save");
		savaBtnItem.setAlign(Alignment.CENTER);
		savaBtnItem.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				validate(false);
			}
		});

		ButtonItem cancelBtnItem = new ButtonItem();
		cancelBtnItem.setTitle("Cancel");
		cancelBtnItem.setAlign(Alignment.CENTER);
		cancelBtnItem.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				hide();
			}
		});

		setFields(passwordItem, passwordItem2, acceptItem, savaBtnItem,
				cancelBtnItem);
	}

}
