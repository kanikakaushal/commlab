/*
 * $Id: codetemplate.xml 35 2011-12-28 11:06:40Z kanikakaushal@gmail.com $
 * Copyright (c) Dayalbagh Educational Institute.
 * All Rights Reserved.
 * This software and documentation is the confidential and proprietary 
 * information of Dayalbagh Educational Institute ("Confidential Information").
 * 
 */

package dei.vlab.communication.netlist.component;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import dei.vlab.communication.netlist.exception.ParseElementExeception;



/**
 * @version $Revision: 35 $ $Date: 2011-12-28 16:36:40 +0530 (Wed, 28 Dec 2011) $
 * @author server
 */
public class NetlistData {

    private ArrayList<Element> elementOfTheCircuit;

    public List<Element> getElementOfTheCircuit() {
        return elementOfTheCircuit;
    }

    public NetlistData(FileInputStream fStream) throws IOException, ParseElementExeception {
        elementOfTheCircuit = new ArrayList<Element>();
        DataInputStream in = new DataInputStream(fStream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
        while ((strLine = br.readLine()) != null) {

            strLine = strLine.trim();
            String[] switc = strLine.split(" ");
            switch (switc[0]) {

            case "circuit":
                Circuit circuit = new Circuit(strLine);
                elementOfTheCircuit.add(circuit);
                break;

            case "fg":
                FunctionGenerator functionGenerator = new FunctionGenerator(strLine);
                elementOfTheCircuit.add(functionGenerator);
                break;

            case "psupply":
                PowerSupplay powerSupplay = new PowerSupplay(strLine);
                elementOfTheCircuit.add(powerSupplay);
                break;

            case "dso":
                DigitalStorageOscilloscope digitalStorageOscilloscope = new DigitalStorageOscilloscope(strLine);
                elementOfTheCircuit.add(digitalStorageOscilloscope);
                break;

            case "dmm":
                DigitalMultiM digitalMultiM = new DigitalMultiM(strLine);
                elementOfTheCircuit.add(digitalMultiM);
                break;
            }
            // System.out.println(strLine);
        }
    }

    @Override
    public String toString() {
        StringBuffer tostr = new StringBuffer();
        tostr.append("Circuit ");
        for (Element element : elementOfTheCircuit) {
            tostr.append("\n[");
            tostr.append(element.getType());
            tostr.append("Name=");
            tostr.append(element.getName());
           // tostr.append(",\n");
            tostr.append(element.getTerminalWireMap());
           // tostr.append(element.getRealyNumber());
            tostr.append("]");
        }

        return tostr.toString();
    }
}
