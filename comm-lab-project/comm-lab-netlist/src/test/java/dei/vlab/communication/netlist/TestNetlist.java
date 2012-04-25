package dei.vlab.communication.netlist;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import dei.vlab.communication.netlist.Netlist;
import dei.vlab.communication.netlist.component.NetlistData;
import dei.vlab.communication.netlist.exception.ParseElementExeception;

import junit.framework.TestCase;

public class TestNetlist extends TestCase{

	public void testNetlist() throws ParseElementExeception{
		
		String filePath ="C:/workspace/comm-lab-netlist-validattor/src/netlist1.txt";
		//NetlistData netlist =new NetlistData(filePath);
		//System.out.println(netlist);
		Netlist netlist = new Netlist(filePath);
		System.out.println("Hii i am in testing calss"+netlist.toString());
		
	}	
}
