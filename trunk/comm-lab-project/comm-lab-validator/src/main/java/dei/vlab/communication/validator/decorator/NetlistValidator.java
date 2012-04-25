package dei.vlab.communication.validator.decorator;

import dei.vlab.communication.validated.netlist.ValidatedNetlistData;
import dei.vlab.communication.validator.logger.LogData;

public interface NetlistValidator {

    public void doValidation();
    public LogData getLogData();
    public ValidatedNetlistData getNetlist();
}