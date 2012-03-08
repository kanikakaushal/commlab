package dei.vlab.communication.client.widgets.tab;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceSequenceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.widgets.calendar.Calendar;

import dei.vlab.communication.client.data.CalendarData;

public class CalendarTab extends AbstractTab {

	
	public static String CALENDER_TAB_ID = "CALENDER_TAB_ID";
	public static String CALENDER_TITLE = "Calander Manager &nbsp;&nbsp;";
	public static String CALENDER_ICON = "tools/CALANDER.png";
	
	private Calendar calendar = new Calendar();

	public CalendarTab() {
		super(CALENDER_TAB_ID);
		setTabTitle(CALENDER_TITLE);
		setIcon(CALENDER_ICON, 16);
		setTabHeight100();
		setTabWidth100();
		init();
		addTabMember(calendar);

	}
	private void init() {
		calendar.setMargin(15);
		DataSource eventDS = new DataSource();
		DataSourceSequenceField eventIdField = new DataSourceSequenceField(
				"eventId");
		eventIdField.setPrimaryKey(true);
		DataSourceTextField nameField = new DataSourceTextField("name");
		DataSourceTextField descField = new DataSourceTextField("description");
		DataSourceDateTimeField startDateField = new DataSourceDateTimeField(
				"startDate");
		DataSourceDateTimeField endDateField = new DataSourceDateTimeField(
				"endDate");
		eventDS.setFields(eventIdField, nameField, descField, startDateField,
				endDateField);
		eventDS.setClientOnly(true);
		eventDS.setTestData(CalendarData.getRecords());
		calendar.setDataSource(eventDS);
		calendar.setAutoFetchData(true);
	}

}
