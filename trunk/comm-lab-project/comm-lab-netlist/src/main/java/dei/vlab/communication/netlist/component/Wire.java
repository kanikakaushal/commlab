/*
 * $Id: codetemplate.xml 35 2011-12-28 11:06:40Z kanikakaushal@gmail.com $
 * Copyright (c) Dayalbagh Educational Institute.
 * All Rights Reserved.
 * This software and documentation is the confidential and proprietary 
 * information of Dayalbagh Educational Institute ("Confidential Information").
 * 
 */

package dei.vlab.communication.netlist.component;

/**
 * @version $Revision: 35 $ $Date: 2011-12-28 16:36:40 +0530 (Wed, 28 Dec 2011) $
 * @author server
 */
public class Wire {

    private String wireName;
    private Terminal leftsideTerminal;
    private Terminal rightsideTerminal;
    private Element deviceConnectedTo;

    public Wire(String value) {
        this.wireName = value;
    }

    public String getWireName() {
        return wireName;
    }

    public void setWireName(String wireName) {
        this.wireName = wireName;
    }

    public Terminal getLeftsideTerminal() {
        return leftsideTerminal;
    }

    public void setLeftsideTerminal(Terminal leftsideTerminal) {
        this.leftsideTerminal = leftsideTerminal;
    }

    public Terminal getRightsideTerminal() {
        return rightsideTerminal;
    }

    public void setRightsideTerminal(Terminal rightsideTerminal) {
        this.rightsideTerminal = rightsideTerminal;
    }

    public Element getDeviceConnectedTo() {
        return deviceConnectedTo;
    }

    public void setDeviceConnectedTo(Element deviceConnectedTo) {
        this.deviceConnectedTo = deviceConnectedTo;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "" + wireName + "";
    }
}
