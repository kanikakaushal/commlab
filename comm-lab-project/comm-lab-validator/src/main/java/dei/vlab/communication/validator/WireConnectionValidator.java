package dei.vlab.communication.validator;


import dei.vlab.communication.validated.netlist.ValidatedNetlistData;
import dei.vlab.communication.validator.decorator.NetlistValidator;
import dei.vlab.communication.validator.logger.LogData;
import dei.vlab.communication.validator.logger.ValidationLogger;



public class WireConnectionValidator implements NetlistValidator {

    private NetlistValidator netlistValidator;
    private ValidationLogger _log = ValidationLogger.getInstance("WireConnectionValidator");

    public WireConnectionValidator(NetlistValidator netlistValidator) {
        this.netlistValidator = netlistValidator;
    }

    public void doValidation() {
        _log.debug("Wire Connection Validator  " );

        // Component type is the first element in array
      //  String[] elementInfo = line.split(" ");

        // Component Wire Mapping
      //  if (elementInfo.length > 1) {
            /*
             * All wire ArryList deceleration
             */
         /*   String wireWithNumber = null;
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
            }
            if (wire1 == null) {
                _log.debug("Wire not Connected  " + wire1 + "  wire2" + wire2);
            } else {
                _log.debug("Wire Connected  pin 1 " + wire1 + " pin2 " + wire2);
            }
        }*/
    }

    public LogData getLogData() {
        return _log;
    }

    public ValidatedNetlistData getNetlist() {
        return this.netlistValidator.getNetlist();
    }
}
