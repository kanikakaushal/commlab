package dei.vlab.communication.client.data;

import com.smartgwt.client.widgets.grid.ListGridRecord;

public class CircuitNodeRecord extends ListGridRecord {  
  
    public CircuitNodeRecord() {  
    }  
  
    public CircuitNodeRecord( String name,  String description,String top,String left) {  
         setName(name);  
        setDescription(description);  
        setTop(top);  
        setLeft(left);
    }  
  
   
  
    /** 
     * Set the name. 
     * 
     * @param name the name 
     */  
    public void setName(String name) {  
        setAttribute("name", name);  
    }  
  
    /** 
     * Return the name. 
     * 
     * @return the name 
     */  
    public String getName() {  
        return getAttribute("name");  
    }  
  
    /** 
     * Set the description. 
     * 
     * @param description the description 
     */  
    public void setDescription(String description) {  
        setAttribute("description", description);  
    }  
  
    /** 
     * Return the description. 
     * 
     * @return the description 
     */  
    public String getDescription() {  
        return getAttribute("description");  
    }  
  
    /** 
     * Set the top. 
     * 
     * @param name the top 
     */  
    public void setTop(String top) {  
        setAttribute("top", top);  
    }  
  
    /** 
     * Return the top. 
     * 
     * @return the top 
     */  
    public String getTop() {  
        return getAttribute("top");  
    }  
  
    
    /** 
     * Set the left. 
     * 
     * @param name the left 
     */  
    public void setLeft(String left) {  
        setAttribute("left", left);  
    }  
  
    /** 
     * Return the left. 
     * 
     * @return the left 
     */  
    public String getLeft() {  
        return getAttribute("left");  
    }  
   
  
}  