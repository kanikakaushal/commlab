/*
 * $Id: codetemplate.xml 35 2011-12-28 11:06:40Z kanikakaushal@gmail.com $
 * Copyright (c) Dayalbagh Educational Institute.
 * All Rights Reserved.
 * This software and documentation is the confidential and proprietary 
 * information of Dayalbagh Educational Institute ("Confidential Information").
 * 
 */

package dei.vlab.communication.netlist.component;

import java.util.Map;

/**
 * @version $Revision: 35 $ $Date: 2011-12-28 16:36:40 +0530 (Wed, 28 Dec 2011) $
 * @author server
 */
public interface Element {

    /*
     * All element information in the netlist
     */
    // Device board left side panel
    public static final String FM = "fg";
    public static final String PSUPPLAY = "psupplay";
    public static final String GROUND = "ground";
    // Device board right side panel
    public static final String DSO = "dso";
    public static final String DMM = "dmm";
    // All circuit netlist file ....
    public static final String CIRCUIT = "circuit";
    // circuit netlist properties
    public static final String NAME = "name";
    public static final String TYPE = "type";
    public static final String TERMINAL_WIRE_MAP = "TerminalWireMap";

    // All function that extrate the information on the netlist .
    // get name od the device of the netlist .//
    public String getName();

    // get the type of device information on the netlist
    public String getType();

    // get all terminal wire information in the netlist
    public Map<Terminal, Wire> getTerminalWireMap();

    // get relay information (pin realy number which device connected in realy ) . on the database
    public Map<String, Integer> getRealyNumber();

}
