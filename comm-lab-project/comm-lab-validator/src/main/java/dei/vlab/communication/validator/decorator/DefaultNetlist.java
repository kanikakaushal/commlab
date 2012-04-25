package dei.vlab.communication.validator.decorator;



import dei.vlab.communication.validated.netlist.ValidatedNetlistData;
import dei.vlab.communication.validator.logger.LogData;
import dei.vlab.communication.validator.logger.ValidationLogger;

public class DefaultNetlist implements NetlistValidator {
    private ValidatedNetlistData netlist;
    private ValidationLogger _log = ValidationLogger.getInstance("Default");

    public DefaultNetlist(ValidatedNetlistData netlist) {
        this.netlist = netlist;
        _log.flush();
    }

    public void doValidation() {

        _log.debug("Default validation netlis");
    }

    public LogData getLogData() {
        // TODO Auto-generated method stub
        return _log;
    }

    public ValidatedNetlistData getNetlist() {
        // TODO Auto-generated method stub
        return this.netlist;
    }

}
