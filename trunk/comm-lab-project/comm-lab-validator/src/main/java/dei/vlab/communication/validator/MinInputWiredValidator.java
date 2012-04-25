package dei.vlab.communication.validator;



import dei.vlab.communication.netlist.Netlist;
import dei.vlab.communication.validated.netlist.ValidatedNetlistData;
import dei.vlab.communication.validator.decorator.NetlistValidator;
import dei.vlab.communication.validator.logger.LogData;
import dei.vlab.communication.validator.logger.ValidationLogger;



public class MinInputWiredValidator implements NetlistValidator {

    private NetlistValidator netlistValidator;
    private ValidationLogger _log = ValidationLogger.getInstance("MinInputWiredValidator");

    public MinInputWiredValidator(NetlistValidator netlistValidator) {
        this.netlistValidator = netlistValidator;
        // TODO Auto-generated constructor stub
    }

    public void doValidation() {
        _log.debug("Min input Wire validation ");

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
