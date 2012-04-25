/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dei.vlab.communication.client.widgets.calendar;

import com.google.gwt.core.client.GWT;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceSequenceField;
import com.smartgwt.client.data.fields.DataSourceTextField;

import com.smartgwt.client.types.FormMethod;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.calendar.Calendar;
import com.smartgwt.client.widgets.calendar.CalendarEvent;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;

import dei.vlab.communication.client.data.CalendarData;
import dei.vlab.communication.client.data.CalendarWFActionDataSource;
import dei.vlab.communication.client.util.HttpRequestUtil;
import java.util.Date;

/**
 *
 * @author server
 */
public class CalendarWFCalendarAction extends Calendar{

    private CalendarEvent calendarEvents;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private Integer eventId;
    private  DataSource eventDS;
   
  
    public CalendarWFCalendarAction() {
                
                this.setMargin(15);
		
		//eventDS.setFields(eventIdField, nameField, descField, startDateField,
				//endDateField);
		//eventDS.setClientOnly(true);
		//eventDS.setTestData(CalendarData.getRecords());
                //doRequestWrapper();
                this.addEventAddedHandler(new EventAddedHandler() {
                public void onEventAdded(CalendarEventAdded event) {      
                    calendarEvents =  event.getEvent();
                    name = calendarEvents.getName();
                    description = calendarEvents.getDescription();
                    startDate = calendarEvents.getStartDate();
                    endDate = calendarEvents.getEndDate();
                    eventId = calendarEvents.getEventId();
                    }
                 });
                
                this.addEventMovedHandler(new EventMovedHandler() {

            public void onEventMoved(CalendarEventMoved event) {
                  calendarEvents =  event.getEvent();
                    name = calendarEvents.getName();
                    description = calendarEvents.getDescription();
                    startDate = calendarEvents.getStartDate();
                    endDate = calendarEvents.getEndDate();
                    eventId = calendarEvents.getEventId();
                }
            });
                this.addEventResizedHandler(new EventResizedHandler() {

            public void onEventResized(CalendarEventResized event) {
                calendarEvents =  event.getEvent();
                    name = calendarEvents.getName();
                    description = calendarEvents.getDescription();
                    startDate = calendarEvents.getStartDate();
                    endDate = calendarEvents.getEndDate();
                    eventId = calendarEvents.getEventId();
            }
        });
                this.addEventRemoveClickHandler(new EventRemoveClickHandler() {

            public void onEventRemoveClick(CalendarEventRemoveClick event) {
                calendarEvents =  event.getEvent();
                    name = calendarEvents.getName();
                    description = calendarEvents.getDescription();
                    startDate = calendarEvents.getStartDate();
                    endDate = calendarEvents.getEndDate();
                    eventId = calendarEvents.getEventId();
            }
        });
                this.addEventRemovedHandler(new EventRemovedHandler() {

            public void onEventRemoved(CalendarEventRemoved event) {
                calendarEvents =  event.getEvent();
                    name = calendarEvents.getName();
                    description = calendarEvents.getDescription();
                    startDate = calendarEvents.getStartDate();
                    endDate = calendarEvents.getEndDate();
                    eventId = calendarEvents.getEventId();
                    SC.say("messge name "+name+"");
                   
            }
        });
		this.setDataSource(CalendarWFActionDataSource.getInstance());
		this.setAutoFetchData(true);
    }
	 public void doRequestWrapper(){
		 		String url ="/app/calendar";
                                String response =HttpRequestUtil.doGetRequest(url);
                                eventDS.fetchData();                             
	 }      	
}
