/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dei.vlab.communication.client.data;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.HandlerRegistration;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.events.HandleErrorHandler;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceSequenceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.calendar.Calendar;
import com.smartgwt.client.widgets.calendar.CalendarEvent;

/**
 *
 * @author server
 */
public class CalendarWFActionDataSource extends AbstractRestDataSource{

    public static  CalendarWFActionDataSource instance=null;
    public static CalendarWFActionDataSource getInstance(){
        if(instance ==null){
            instance = new CalendarWFActionDataSource("calendarDS");
        }
        return instance;
    }
    
    public CalendarWFActionDataSource(String id) {
        super(id);
    }
  
   @Override
    protected void init() {
        
                setDataFormat(DSDataFormat.JSON);
                setJsonRecordXPath("/");
 
                DataSourceSequenceField eventIdField = new DataSourceSequenceField("eventId");
                eventIdField.setPrimaryKey(true);
             
              
                DataSourceTextField nameField = new DataSourceTextField("name");  
                DataSourceTextField descField = new DataSourceTextField("description");  
                DataSourceDateTimeField startDateField = new DataSourceDateTimeField("startDate");  
                DataSourceDateTimeField endDateField = new DataSourceDateTimeField("endDate");  

                setFields(eventIdField, nameField, descField, startDateField, endDateField);  
               // eventDS.setClientOnly(true);  
                setTestData(CalendarData.getRecords());  

                
               //calendar.setDataSource(eventDS);  
               //calendar.setAutoFetchData(true);  
		
                
	}
   
    
    @Override
    protected String getServiceRoot() {
        return  GWT.getHostPageBaseURL() + "app/calendar";
    }
    @Override
    protected Object transformRequest(DSRequest request) {
    	// TODO Auto-generated method stub'
    	//JavaScriptObject[] data=(JavaScriptObject[])request.getData().cast();
    	 super.transformRequest(request);
    	SC.say(""+request.getAttributeAsMap("data"));
    	//Object obj = super.transformRequest(request);
    	//SC.say(""+obj);
    	return CalendarData.getNewRecords();
    }

    
}
