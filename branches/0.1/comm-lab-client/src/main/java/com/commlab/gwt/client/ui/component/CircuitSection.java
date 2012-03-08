package com.commlab.gwt.client.ui.component;
import java.util.ArrayList;
import java.util.List;

import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.widgets.HTMLFlow;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;

public class CircuitSection {
	
	private List<String> getCircuitSectionDetail(){
		 List<String> sectionName = new ArrayList<String>();
		 sectionName.add("Function Generator");
		 sectionName.add("De-Modulator");
		 sectionName.add("Detector");
		 sectionName.add("Amplifier/Mixer");
		 sectionName.add("Amplitude Limiter");
		 sectionName.add("Low Pass Filter");
		 sectionName.add("Function Generator");
		 sectionName.add("Function Generator");
		 sectionName.add("Function Generator"); 
		 return sectionName;
	}
	
	 public HLayout createSection() { 
		 final SectionStack sectionStack = new SectionStack(); 
		 List<String> sectionNameList = getCircuitSectionDetail();
		 sectionStack.setVisibilityMode(VisibilityMode.MULTIPLE);  
	     sectionStack.setWidth(300); 
	     sectionStack.setHeight100();
		 for(String sectionName :sectionNameList){
			 HTMLFlow htmlFlow = new HTMLFlow();  
		     htmlFlow.setOverflow(Overflow.AUTO);  
		     htmlFlow.setPadding(10);  
		     String contents = "<b>Section Description</b>" +
		     		"<br><br>No description avaliable<br><br><br>" +
		     		"<b>Section Configuration</b>" +
		     		"<br><br>No configuration avaliable<br><br><br>";  
		     	htmlFlow.setContents(contents);
			    SectionStackSection section = new SectionStackSection(sectionName);  
		        section.setExpanded(false); 
		        section.addItem(htmlFlow);
		        sectionStack.addSection(section); 
		 }    	  
	     HLayout layout = new HLayout();   
	     layout.addMember(sectionStack);  
	     layout.setHeight100();
	     return layout;   
	    }  
	
}
