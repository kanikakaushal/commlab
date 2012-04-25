package dei.vlab.communication.validator;


import dei.vlab.communication.validated.netlist.ValidatedNetlistData;
import dei.vlab.communication.validator.decorator.NetlistValidator;
import dei.vlab.communication.validator.logger.LogData;
import dei.vlab.communication.validator.logger.ValidationLogger;



public class MinOutputWiredValidator implements NetlistValidator {

    private NetlistValidator netlistValidator;
    private ValidationLogger _log = ValidationLogger.getInstance("MinInputWiredValidator");

    public MinOutputWiredValidator(NetlistValidator netlistValidator) {
        this.netlistValidator = netlistValidator;
    }

    public void doValidation() {
        _log.debug("Min Input Wired Validator ");
    }

    public LogData getLogData() {
        // TODO Auto-generated method stub
        return _log;
    }

    public ValidatedNetlistData getNetlist() {
        // TODO Auto-generated method stub
        return this.netlistValidator.getNetlist();
    }

}
