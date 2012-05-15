package dei.vlab.communication.client.widgets.form;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;

public class CircuitGrid extends ListGrid {

	public CircuitGrid() {
		this.setShowRecordComponents(true);
		this.setShowRecordComponentsByCell(true);
		this.setCanRemoveRecords(true);
		this.setWidth100();
		this.setHeight100();
		this.setShowAllRecords(true);
		this.setMargin(5);
		
	}

	
	
	 @Override  
     protected Canvas createRecordComponent(final ListGridRecord record, Integer colNum) { 
		 
         SC.say("hhh");
     	
         String fieldName = this.getFieldName(colNum);  
         if (fieldName.equals("actions")){  
        	 ToolStrip toolStrip = new ToolStrip();  
             toolStrip.setHeight(15);  
             toolStrip.setWidth100();
             //toolStrip.addFill();  
             //toolStrip.addSeparator();  
       
             ToolStripButton approveButton = new ToolStripButton();  
             approveButton.setIcon("icons/16/approved.png");  
            approveButton.setTooltip("Update"); 
             approveButton.addClickHandler(new ClickHandler() {  
                 public void onClick(ClickEvent event) {  
                   }  
             });
             toolStrip.addButton(approveButton);  
 
             ToolStripButton rejectButton = new ToolStripButton();  
             rejectButton.setIcon("icons/16/rejected.png");  
             rejectButton.setTooltip("Delete"); 
             rejectButton.addClickHandler(new ClickHandler() {  
                 public void onClick(ClickEvent event) {  
                 }  
             });
             toolStrip.addButton(rejectButton);  
   
       return toolStrip;  
         } else {  
             return null;  
         }  

		
		
     }  

	
}
