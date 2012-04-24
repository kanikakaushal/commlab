/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dei.vlab.communication.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.core.BaseClass;
import com.smartgwt.client.core.RefDataClass;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.util.JSOHelper;

/**
 *
 * @author server
 */
public class CalendarItemRecord extends  Record{

    public CalendarItemRecord() {
    }
    
    public static CalendarItemRecord getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null && obj instanceof CalendarItemRecord) {
            obj.setJsObj(jsObj);
            return (CalendarItemRecord) obj;
        } else {
            return new CalendarItemRecord(jsObj);
        }
    }

    

    public CalendarItemRecord(JavaScriptObject jsObj){
        super(jsObj);
    }

    public CalendarItemRecord(int eventId, String name, String description, java.util.Date startDate, java.util.Date endDate) {
                setEventId(eventId);
                setName(name);
                setDescription(description);
                setStartDate(startDate);
                setEndDate(endDate);
        
    }

    public CalendarItemRecord(int eventId, String name, String description, java.util.Date startDate, java.util.Date endDate, boolean canEdit) {
                setEventId(eventId);
                setName(name);
                setDescription(description);
                setStartDate(startDate);
                setEndDate(endDate);
                setCanEdit(canEdit);
        
    }

    public CalendarItemRecord(int eventId, String name, String description, java.util.Date startDate, java.util.Date endDate, boolean canEdit, String eventWindowStyle) {
                setEventId(eventId);
                setName(name);
                setDescription(description);
                setStartDate(startDate);
                setEndDate(endDate);
                setCanEdit(canEdit);
                setEventWindowStyle(eventWindowStyle);
        
    }


    public void setDescription(String description) {
        setAttribute("description", description);
    }

    
    public String getDescription()  {
        return getAttributeAsString("description");
    }

  
    public void setEndDate(java.util.Date endDate) {
        setAttribute("endDate", endDate);
    }

  
    public java.util.Date getEndDate()  {
        return getAttributeAsDate("endDate");
    }

   
    public void setEventWindowStyle(String eventWindowStyle) {
        setAttribute("eventWindowStyle", eventWindowStyle);
    }

   
    public String getEventWindowStyle()  {
        return getAttributeAsString("eventWindowStyle");
    }

    public void setName(String name) {
        setAttribute("name", name);
    }

   
    public String getName()  {
        return getAttributeAsString("name");
    }

   
    public void setStartDate(java.util.Date startDate) {
        setAttribute("startDate", startDate);
    }

  
    public java.util.Date getStartDate()  {
        return getAttributeAsDate("startDate");
    }


    public void setEventId(Integer eventId) {
        setAttribute("eventId", eventId);
    }

    public Integer getEventId() {
        return getAttributeAsInt("eventId");
    }

 
    public void setCanEdit(Boolean canEdit) {
        setAttribute("canEdit", canEdit);
    }

   
    public Boolean getCanEdit() {
        return getAttributeAsBoolean("canEdit");
    }

    private static CalendarItemRecord[] convertToCalendarEventArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new CalendarItemRecord[]{};
        }
        JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
        CalendarItemRecord[] objects = new CalendarItemRecord[componentsj.length];
        for (int i = 0; i < componentsj.length; i++) {
            JavaScriptObject componentJS = componentsj[i];
            CalendarItemRecord obj = (CalendarItemRecord) RefDataClass.getRef(componentJS);
            if (obj == null) obj = new CalendarItemRecord(componentJS);
            objects[i] = obj;
        }
        return objects;
    }

}


