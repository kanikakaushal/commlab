package dei.vlab.communication.client.widgets.grid;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;

import dei.vlab.communication.client.data.UserWFActionDataSource;
import dei.vlab.communication.client.util.HttpRequestUtil;

public class UserWFGrid extends ListGrid {

	public UserWFGrid() {
		this.setShowRecordComponents(true);
		this.setShowRecordComponentsByCell(true);
		this.setCanRemoveRecords(true);

		this.setWidth100();
		this.setHeight100();
		this.setShowAllRecords(true);
		setListGridField();
		this.setMargin(5);
		this.setTitle("User Details");
		
	}

	private void setListGridField() {
		ListGridField idField = new ListGridField("id", "Id");
		ListGridField noField = new ListGridField("sno", "No.");
		ListGridField statusField = new ListGridField("status", "Status");
		ListGridField emailField = new ListGridField("email", "Email");
		ListGridField fNameField = new ListGridField("fullName", "Full Name");
		ListGridField cNameField = new ListGridField("college", "College Name");
		ListGridField contactNoField = new ListGridField("contactNo", "Contact No");
		ListGridField actionField = new ListGridField("actions", "Actions");
		this.setFields(noField, statusField, emailField, fNameField,cNameField,contactNoField, actionField);
                this.setCanRemoveRecords(false);
		this.setDataSource(UserWFActionDataSource.getInstance());
		this.setAutoFetchData(true);
		this.setGroupByField("status");

	}

	
	 @Override  
     protected Canvas createRecordComponent(final ListGridRecord record, Integer colNum) {  

         String fieldName = this.getFieldName(colNum);  

         if (fieldName.equals("actions")){  
        	 ToolStrip toolStrip = new ToolStrip();  
             toolStrip.setHeight(15);  
             toolStrip.setWidth100();
             //toolStrip.addFill();  
             //toolStrip.addSeparator();  
       
             ToolStripButton approveButton = new ToolStripButton();  
             approveButton.setIcon("icons/16/approved.png");  
             approveButton.setTooltip("Approve"); 
             approveButton.addClickHandler(new ClickHandler() {  
                 public void onClick(ClickEvent event) {  
                 	 	 doRequestWrapper(record.getAttribute("id"), "Approved");
                   }  
             });
             toolStrip.addButton(approveButton);  
 
             ToolStripButton rejectButton = new ToolStripButton();  
             rejectButton.setIcon("icons/16/rejected.png");  
             rejectButton.setTooltip("Reject"); 
             rejectButton.addClickHandler(new ClickHandler() {  
                 public void onClick(ClickEvent event) {  
                	 doRequestWrapper(record.getAttribute("id"),"Rejected");
                 }  
             });
             toolStrip.addButton(rejectButton);  
   
             ToolStripButton deleteButton = new ToolStripButton();  
             deleteButton.setIcon("icons/16/close.png");  
             deleteButton.setTooltip("Delete"); 
             deleteButton.addClickHandler(new ClickHandler() {  
                 public void onClick(ClickEvent event) {  
                   	 doRequestWrapper(record.getAttribute("id"),"Deleted");
                }  
             });
             toolStrip.addButton(deleteButton);  
  
             ToolStripButton messageButton = new ToolStripButton();  
             messageButton.setIcon("icons/16/message.png");  
             messageButton.setTooltip("Send Message"); 
             messageButton.addClickHandler(new ClickHandler() {  
                 public void onClick(ClickEvent event) {  
                    SC.say("Message send to user "+record.getAttribute("id") +".");  
                    //SC.say("Message send to user "+record.getDetailDS().getID() +".");  
                 }  
             });
             toolStrip.addButton(messageButton);  
         return toolStrip;  
         } else {  
             return null;  
         }  

     }  
	
	 public void doRequestWrapper(String id, String status){
		 		String url ="/app/userwfactionupdate?id="+id+"&status="+status;
					String response =HttpRequestUtil.doGetRequest(url);
	 				this.fetchData();
	 }
	
}
