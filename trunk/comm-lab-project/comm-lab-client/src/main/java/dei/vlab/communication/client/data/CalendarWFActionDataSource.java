/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dei.vlab.communication.client.data;

import com.google.gwt.core.client.GWT;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceSequenceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.widgets.calendar.Calendar;

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
                
                DataSource eventDS = new DataSource();  
                DataSourceSequenceField eventIdField = new DataSourceSequenceField("eventId");  
                eventIdField.setPrimaryKey(true);  

                DataSourceTextField nameField = new DataSourceTextField("name");  
                DataSourceTextField descField = new DataSourceTextField("description");  
                DataSourceDateTimeField startDateField = new DataSourceDateTimeField("startDate");  
                DataSourceDateTimeField endDateField = new DataSourceDateTimeField("endDate");  

                eventDS.setFields(eventIdField, nameField, descField, startDateField, endDateField);  
                eventDS.setClientOnly(true);  
                eventDS.setTestData(CalendarData.getRecords());  

                Calendar calendar = new Calendar();  
                calendar.setDataSource(eventDS);  
                calendar.setAutoFetchData(true);  
		
                
	}
   
    
    @Override
    protected String getServiceRoot() {
        return  GWT.getHostPageBaseURL() + "app/calendar";
    }

    
}
