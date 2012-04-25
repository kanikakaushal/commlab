package dei.vlab.communication.netlist;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


import dei.vlab.communication.netlist.component.NetlistData;
import dei.vlab.communication.netlist.exception.*;



public class Netlist {
	
	private String filepath;
		public Netlist(String filePath) throws ParseElementExeception {
			this.filepath=filePath;
			//String filePath ="C:/workspace/comm-lab-netlist-validattor/src/netlist1.txt";
			//NetlistData netlist =new NetlistData(filePath);
			//System.out.println(netlist);
			
			
			 File file = new File(filePath);
		     FileInputStream fStream1;
		     try {		    	 
		         fStream1 = new FileInputStream(file);
		         NetlistData circuit1 = new NetlistData(fStream1);
		         System.out.println(circuit1);
		     } catch (FileNotFoundException e) {
		         
		         e.printStackTrace();
		     } catch (IOException e) {
		        
		         e.printStackTrace();
		     } catch (ParseElementExeception e) {
		        
		         e.printStackTrace();
		     }	
		}			
}
