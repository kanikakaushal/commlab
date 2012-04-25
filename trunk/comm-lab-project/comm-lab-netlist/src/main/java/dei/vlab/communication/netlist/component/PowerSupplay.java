

package dei.vlab.communication.netlist.component;

import java.util.HashMap;
import java.util.Map;


import dei.vlab.communication.netlist.alldevice.util.DeviceWireUtil;
import dei.vlab.communication.netlist.exception.ParseElementExeception;


public class PowerSupplay implements Element {

    private Map<String, Object> elementInfo;

    public PowerSupplay(String line) throws ParseElementExeception {
        this.elementInfo = DeviceWireUtil.getConvertLineInToWireInfo(line);
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
