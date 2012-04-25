/*
 * $Id: codetemplate.xml 35 2011-12-28 11:06:40Z kanikakaushal@gmail.com $
 * Copyright (c) Dayalbagh Educational Institute.
 * All Rights Reserved.
 * This software and documentation is the confidential and proprietary 
 * information of Dayalbagh Educational Institute ("Confidential Information").
 * 
 */

package dei.vlab.communication.netlist.alldevice.util;

import java.util.HashMap;
import java.util.Map;


import dei.vlab.communication.netlist.component.Element;
import dei.vlab.communication.netlist.component.Terminal;
import dei.vlab.communication.netlist.component.Wire;
import dei.vlab.communication.netlist.exception.ParseElementExeception;



/**
 * @version $Revision: 35 $ $Date: 2011-12-28 16:36:40 +0530 (Wed, 28 Dec 2011) $
 * @author server
 */
public class DeviceWireUtil {

    public static Map<String, Object> getConvertLineInToWireInfo(String line) throws ParseElementExeception {
        Map<String, Object> elementInfoMap = null;

        if (line.length() <= 0) {
            throw new ParseElementExeception("No Data to parase " + line);
        }

        elementInfoMap = new HashMap<String, Object>();
        // Component type is the first element in array
        String[] elementInfo = line.split(" ");
        if (elementInfo.length < 0) {
            throw new ParseElementExeception("No Data to parase " + elementInfo);
        }
        elementInfoMap.put(Element.TYPE, elementInfo[0]);

        // Component Name
        String[] nameInfo = elementInfo[5].split("=");
        if (elementInfo.length >= 1) {
            elementInfoMap.put(Element.NAME, nameInfo[1]);
        }

        // Component Terminal Wire Mapping
        if (elementInfo.length > 1) {
            Map<Terminal, Wire> terminalWireMap = new HashMap<Terminal, Wire>();
            for (int i = 2; i < elementInfo.length; i++) {
                String[] terminalWire = elementInfo[i].split("=");
                if (terminalWire.length >= 2) {
                    if (terminalWire[1].startsWith("wire")) {
                        Terminal terminal = new Terminal(terminalWire[0]);
                        Wire wire = new Wire(terminalWire[1]);
                        terminalWireMap.put(terminal, wire);

                    }
                }
            }
            elementInfoMap.put(Element.TERMINAL_WIRE_MAP, terminalWireMap);
        }
        return elementInfoMap;
    }

}
