package dei.vlab.communication.client.data;

public class CircuitNodeData {
	

    private static CircuitNodeRecord[] records;  
  
    public static CircuitNodeRecord[] getRecords() {  
        if (records == null) {  
            records = getNewRecords();  
        }  
        return records;  
    }  
    public static CircuitNodeRecord[] getNewRecords() {  
        return new CircuitNodeRecord[]{};  
    }  

}
