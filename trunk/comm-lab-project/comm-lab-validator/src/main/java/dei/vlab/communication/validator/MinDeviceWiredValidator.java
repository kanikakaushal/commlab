package dei.vlab.communication.validator;




import dei.vlab.communication.netlist.Netlist;
import dei.vlab.communication.validated.netlist.ValidatedNetlistData;
import dei.vlab.communication.validator.decorator.NetlistValidator;
import dei.vlab.communication.validator.logger.LogData;
import dei.vlab.communication.validator.logger.ValidationLogger;



public class MinDeviceWiredValidator implements NetlistValidator  {

    private NetlistValidator netlistValidator;
    private ValidationLogger _log = ValidationLogger.getInstance("MinDeviceWiredValidator");

    public MinDeviceWiredValidator(NetlistValidator netlistValidator) {
        this.netlistValidator = netlistValidator;
    }

    public void doValidation() {
        _log.debug("min . device wire validation ");
        /*
         * Wire validation of the circuit
         */
    }

    public LogData getLogData() {
        return _log;
    }

    public ValidatedNetlistData getNetlist() {
        return this.netlistValidator.getNetlist();
    }

}
