package dei.vlab.communication.client.data;
import com.smartgwt.client.widgets.grid.ListGridRecord;  

import java.util.Date;  
  
public class CircuitItemRecord extends ListGridRecord {  
  
    public CircuitItemRecord() {  
    }  
  
    public CircuitItemRecord(int itemID, String name, String type, String description, String image, String nodeCoordinate) {  
        setItemID(itemID);  
        setName(name);  
        setType(type);  
        setDescription(description);  
        setImage(image);  
        setNodeCoordinate(nodeCoordinate);  
   }  
  
    /** 
     * Set the itemID. 
     * 
     * @param itemID the itemID 
     */  
    public void setItemID(int itemID) {  
        setAttribute("itemID", itemID);  
    }  
  
    /** 
     * Return the itemID. 
     * 
     * @return the itemID 
     */  
    public int getItemID() {  
        return getAttributeAsInt("itemID");  
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
     * Set the type. 
     * 
     * @param type the type 
     */  
    public void setType(String type) {  
        setAttribute("type", type);  
    }  
  
    /** 
     * Return the type. 
     * 
     * @return the type 
     */  
    public String getType() {  
        return getAttribute("type");  
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
     * Set the category. 
     * 
     * @param category the category 
     */  
    public void setImage(String image) {  
        setAttribute("image", image);  
    }  
  
    /** 
     * Return the image. 
     * 
     * @return the image 
     */  
    public String getImage() {  
        return getAttribute("image");  
    }  


    /** 
     * Set the nodeCoordinate. 
     * 
     * @param nodeCoordinate the nodeCoordinate 
     */  
    public void setNodeCoordinate(String nodeCoordinate) {  
        setAttribute("nodeCoordinate", nodeCoordinate);  
    }  
  
    /** 
     * Return the nodeCoordinate. 
     * 
     * @return the nodeCoordinate 
     */  
    public Date getNodeCoordinate() {  
        return getAttributeAsDate("nodeCoordinate");  
    }  
  
  
}  