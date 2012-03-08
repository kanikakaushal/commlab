package dei.vlab.communication.client.data;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceEnumField;
import com.smartgwt.client.data.fields.DataSourceImageFileField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
  
public class CircuitItemDS extends DataSource {  
  
    private static CircuitItemDS instance = null;  
  
    public static CircuitItemDS getInstance() {  
        if (instance == null) {  
            instance = new CircuitItemDS("CircuitDataDS");  
        }  
        return instance;  
    }  
  
    public CircuitItemDS(String id) {  
  
        setID(id);  
        DataSourceIntegerField pkField = new DataSourceIntegerField("itemID");  
        pkField.setHidden(true);  
        pkField.setPrimaryKey(true);  
  
        DataSourceTextField nameField = new DataSourceTextField("name", "Name", 228, true);  
        DataSourceEnumField typeField = new DataSourceEnumField("type", "Type", 100);  
        typeField.setValueMap("Circuit");  
   
        DataSourceTextField descriptionField = new DataSourceTextField("description", "Description", 2000);  
        DataSourceImageFileField imageField = new DataSourceImageFileField("image","Image");
        setFields(pkField, nameField, typeField, descriptionField, imageField);  
  
        setClientOnly(true);  
        setTestData(CircuitItemData.getRecords());  
    }  
}  