package dei.vlab.communication.client.data;

public class CircuitItemData {  
  
    private static CircuitItemRecord[] records;  
  
    public static CircuitItemRecord[] getRecords() {  
        if (records == null) {  
            records = getNewRecords();  
        }  
        return records;  
    }  
    public static CircuitItemRecord[] getNewRecords() {  
        return new CircuitItemRecord[]{  
                new CircuitItemRecord(1, "Function Generator", "Circuit", "description", "image", "x,y"),  
                new CircuitItemRecord(2, "De-Modulator", "Circuit", "description", "image", "x,y"),  
                new CircuitItemRecord(3, "Detector", "Circuit", "description", "image", "x,y"),  
                new CircuitItemRecord(4, "Amplifier/Mixer", "Circuit", "description", "image", "x,y"),  
                new CircuitItemRecord(5, "Amplitude Limiter", "Circuit", "description", "image", "x,y"),  
                new CircuitItemRecord(6, "Low Pass Filter", "Circuit", "description", "image", "x,y")
        };  
    }  
}  