package dei.vlab.communication.client.widgets.tab;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceSequenceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.docs.CalendarEvent;
import com.smartgwt.client.widgets.calendar.Calendar;
import com.smartgwt.client.widgets.calendar.events.CalendarEventAdded;
import com.smartgwt.client.widgets.calendar.events.EventAddedHandler;


import dei.vlab.communication.client.widgets.calendar.CalendarWFCalendarAction;

public class CalendarTab extends AbstractTab {

	
	public static String CALENDER_TAB_ID = "CALENDER_TAB_ID";
	public static String CALENDER_TITLE = "Calander Manager &nbsp;&nbsp;";
	public static String CALENDER_ICON = "tools/CALANDER.png";
	
	private Calendar calendar = new Calendar();
        private CalendarWFCalendarAction calendarWFCalendarAction;

    

	public CalendarTab() {
		super(CALENDER_TAB_ID);
		setTabTitle(CALENDER_TITLE);
		setIcon(CALENDER_ICON, 16);
		setTabHeight100();
		setTabWidth100();
		this.calendarWFCalendarAction = new CalendarWFCalendarAction();
		addTabMember(calendarWFCalendarAction);

	}
	 public CalendarWFCalendarAction getCalendarWFCalendarAction() {
            return calendarWFCalendarAction;
         }
      

}
