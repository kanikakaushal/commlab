package dei.vlab.communication.validator.logger;

import java.io.Serializable;

public class ValidationLog implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String level;
	private String message;
	private String clazz;

	
	public ValidationLog(String level, String clazz, String message) {
		super();
		this.level=level;
		this.clazz=clazz;
		this.message=message;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return level+"["+clazz+"]"+message+"\n";
	}
	
}

