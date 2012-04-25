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
public class Terminal {

    private String terminalName;

    public Terminal(String value) {
        this.terminalName = value;
        // TODO Auto-generated constructor stub
    }

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "" + terminalName + "";
    }
}
