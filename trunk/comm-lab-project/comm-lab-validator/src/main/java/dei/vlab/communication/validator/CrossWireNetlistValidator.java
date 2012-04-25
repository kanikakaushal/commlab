package dei.vlab.communication.validator;




import dei.vlab.communication.netlist.Netlist;
import dei.vlab.communication.netlist.component.NetlistData;
import dei.vlab.communication.validated.netlist.ValidatedNetlistData;
import dei.vlab.communication.validator.decorator.NetlistValidator;
import dei.vlab.communication.validator.logger.LogData;
import dei.vlab.communication.validator.logger.ValidationLogger;

public class CrossWireNetlistValidator implements NetlistValidator {
    private NetlistValidator netlistValidator;
    private NetlistData netlistData;
    private ValidationLogger _log = ValidationLogger.getInstance("Cross Wirer");

    public CrossWireNetlistValidator(NetlistValidator netlistValidator) {
        this.netlistValidator = netlistValidator;
    }

    public LogData getLogData() {

        return _log;
    }

    public ValidatedNetlistData getNetlist() {

        return this.netlistValidator.getNetlist();
    }

    public void doValidation() {
    	
    	//netlistData.getElementOfTheCircuit();
    	
        _log.debug("Cross Wire Validation " + netlistData);
        // Component type is the first element in array
       // String[] elementInfo = line.split(" ");

        // Component Wire Mapping

       // if (elementInfo.length > 1) {
            /*
             * All wire ArryList deceleration
             */
          /*  String wireWithNumber = null;
            String wire1 = null;
            String wire2 = null;

            for (int i = 2; i < elementInfo.length; i++) {
                String[] terminalWire = elementInfo[i].split("=");
                if (terminalWire.length >= 2) {
                    if (terminalWire[1].startsWith("wire")) {
                        wireWithNumber = terminalWire[1].toString();
                        if (i == 2) {
                            wire1 = wireWithNumber;
                        } else {
                            wire2 = wireWithNumber;
                        }
                    }
                }
            }*/
            // Compare two wire Array list to fined the same wire number
            // if the wire number same then return false
            // else return true..
          /*  if (wire1.equals(wire2)) {
                // System.out.println("false");
                _log.debug("Short Connection wire1" + wire1 + "wire2" + wire2);
                // b = false;
            } else {
                // System.out.println("true");
                _log.debug("No Short Connection wire1 " + wire1 + " wire2 " + wire2);
                // b = true;
            }

        }
        // return b;

    }
*/
}
}