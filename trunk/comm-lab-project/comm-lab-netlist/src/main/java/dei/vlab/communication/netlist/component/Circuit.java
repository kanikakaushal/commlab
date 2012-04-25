/*
 * $Id: codetemplate.xml 35 2011-12-28 11:06:40Z kanikakaushal@gmail.com $
 * Copyright (c) Dayalbagh Educational Institute.
 * All Rights Reserved.
 * This software and documentation is the confidential and proprietary 
 * information of Dayalbagh Educational Institute ("Confidential Information").
 * 
 */

package dei.vlab.communication.netlist.component;

import java.util.HashMap;
import java.util.Map;


import dei.vlab.communication.netlist.alldevice.util.CircuitWireUtil;
import dei.vlab.communication.netlist.exception.ParseElementExeception;



/**
 * @version $Revision: 35 $ $Date: 2011-12-28 16:36:40 +0530 (Wed, 28 Dec 2011) $
 * @author server
 */
public class Circuit implements Element {

    public static final String wire2 = "wire2";

    private Map<String, Object> elementInfo;

    public Circuit(String line) throws ParseElementExeception {
        this.elementInfo = CircuitWireUtil.getConvertLineInToWireInfo(line);
    }

    @Override
    public String getName() {
        return (String) this.elementInfo.get(NAME);
    }

    @Override
    public String getType() {

        return (String) this.elementInfo.get(TYPE);
    }

    @Override
    public Map<Terminal, Wire> getTerminalWireMap() {

        return (Map<Terminal, Wire>) this.elementInfo.get(TERMINAL_WIRE_MAP);
    }

    @Override
    public Map<String, Integer> getRealyNumber() {

        Map<String, Integer> realyNumber = new HashMap<String, Integer>();
        // all relay number access in database..

        return realyNumber;
    }

    @Override
    public String toString() {

        return "[" + "Netlist Information" + elementInfo + "]";
    }

}
