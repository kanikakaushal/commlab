package dei.vlab.communication.validator.logger;

import java.util.List;
import java.util.Map;

public interface LogData {
	public Map<String, List<ValidationLog>> getCataroziedLogs();
	public List<ValidationLog> getLogs();
}

