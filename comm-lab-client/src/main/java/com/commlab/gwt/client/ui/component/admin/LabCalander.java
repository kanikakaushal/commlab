package com.commlab.gwt.client.ui.component.admin;

import com.smartgwt.client.widgets.DateChooser;
import com.smartgwt.client.widgets.events.DataChangedEvent;
import com.smartgwt.client.widgets.events.DataChangedHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.BlurbItem;
import com.smartgwt.client.widgets.layout.VLayout;
public class LabCalander extends VLayout{
	
	public LabCalander() {
		 
		DynamicForm form = new DynamicForm();  
		form.setWidth(300);  

	    final DateChooser dateChooser = new DateChooser();  
	    dateChooser.setWidth(295);  
	    dateChooser.addDataChangedHandler(new DataChangedHandler() {  
	        @Override  
	        public void onDataChanged(DataChangedEvent event) {  
	           // blurbItem.setValue("Selected date : " + dateChooser.getData());  
	        }  
	    });  

	    this.addMember(dateChooser); 
	    this.addMember(form);
	}
	
}
