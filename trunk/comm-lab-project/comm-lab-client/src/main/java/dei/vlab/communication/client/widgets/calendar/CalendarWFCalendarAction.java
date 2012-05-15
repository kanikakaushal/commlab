/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dei.vlab.communication.client.widgets.calendar;

import java.util.Date;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.calendar.Calendar;
import com.smartgwt.client.widgets.calendar.CalendarEvent;

import dei.vlab.communication.client.data.CalendarWFActionDataSource;

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
		this.setDataSource(CalendarWFActionDataSource.getInstance());
		this.setAutoFetchData(true);
    }
/*	 public void doRequestWrapper(){
		 SC.say("do request");
		 		String url ="app/calendar";
                                //String response =HttpRequestUtil.doGetRequest(url);
                                eventDS.fetchData();                             
	 }      */	
}
