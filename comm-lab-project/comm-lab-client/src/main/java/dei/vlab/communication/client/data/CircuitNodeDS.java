package dei.vlab.communication.client.data;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceEnumField;
import com.smartgwt.client.data.fields.DataSourceImageFileField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
  
public class CircuitNodeDS extends DataSource {  
  
    private static CircuitNodeDS instance = null;  
  
    public static CircuitNodeDS getInstance() {  
        if (instance == null) {  
            instance = new CircuitNodeDS("CircuitNodeDS");  
        }  
        return instance;  
    }  
  
    public CircuitNodeDS(String id) {  
  
        setID(id);  
    
        DataSourceTextField nameField = new DataSourceTextField("name", "Name", 200, true);  
        nameField.setPrimaryKey(true); 
        DataSourceTextField descriptionField = new DataSourceTextField("description", "Description", 200);  
              setFields(nameField,descriptionField);  
  
        setClientOnly(true);  
      //  setTestData(CircuitNodeData.getRecords());  
    }  
}  