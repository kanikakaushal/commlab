package dei.vlab.communication.client.widgets.arc;

import com.smartgwt.client.widgets.tile.TileRecord;

public class ToolRecord extends TileRecord {  
  
    public ToolRecord() {  
    }  
  
    public ToolRecord(String name, String picture) {  
        this(name, picture, null);  
    }  
  
    public ToolRecord(String name, String picture, String description) {  
        setName(name);  
        setPicture(picture);  
        setDescription(description);  
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
     * Return the price. 
     * 
     * @return the price 
     */  
    public String getPrice() {  
        return getAttribute("price");  
    }  
  
    /** 
     * Set the picture. 
     * 
     * @param picture the picture 
     */  
    public void setPicture(String picture) {  
        setAttribute("picture", picture);  
    }  
  
    /** 
     * Return the picture. 
     * 
     * @return the picture 
     */  
    public String getPicture() {  
        return getAttribute("picture");  
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
  
  
}  