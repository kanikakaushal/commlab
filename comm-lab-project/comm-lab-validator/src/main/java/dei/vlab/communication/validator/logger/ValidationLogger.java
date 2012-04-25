package dei.vlab.communication.validator.logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ValidationLogger implements LogData  {
	private static String clazz;
	private static ValidationLogger _log;
	
	public static String DEBUG = "[DEBUG]";
	public static String INFO  = "[INFO]";
	public static String WARN = "[WARN]";
	public static String ERROR = "[ERROR]";
	
	private Map<String ,List<ValidationLog>> _logLevelMap = new HashMap<String , List<ValidationLog>>();
	private List<ValidationLog> _logLeve = new ArrayList<ValidationLog>();
	
	// Default constructor..
	public ValidationLogger() {
		// TODO Auto-generated constructor stub
	}
	
	public static ValidationLogger getInstance(String cls){
		synchronized(ValidationLogger.class){
			if(null== _log){
				_log= new ValidationLogger();
			}
			clazz= cls;
			return _log;
		}
	}
	
	
	public void debug(String message){
		log(DEBUG,message);
	}
	public void info(String message){
		log(INFO,message);
	}
	public void warn(String message){
		log(WARN,message);
	}
	public void error(String message){
		log(ERROR,message);
	}

	public Map<String, List<ValidationLog>> getCataroziedLogs() {
		return _logLevelMap;
	}

	public List<ValidationLog> getLogs() {
		return _logLeve;
	}

	private void log(String level, String message) {
		ValidationLog _logData = new ValidationLog(level,clazz,message);
		_logLeve.add(_logData);
		if(_logLevelMap.get(level)==null){
			_logLevelMap.put(level,new ArrayList<ValidationLog>());
		}
		_logLevelMap.get(level).add(_logData);
	}
	public void flush(){
		this._logLeve.clear();
		this._logLevelMap.clear();
	}
}

