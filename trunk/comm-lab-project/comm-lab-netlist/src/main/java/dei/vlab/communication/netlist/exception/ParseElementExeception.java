package dei.vlab.communication.netlist.exception;

public class ParseElementExeception  extends Exception{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParseElementExeception() {
	        super();
	    }

	    public ParseElementExeception(String message, Throwable cause) {
	        super(message, cause);
	    }

	    public ParseElementExeception(String message) {
	        super(message);
	    }

	    public ParseElementExeception(Throwable cause) {
	        super(cause);
	    }
}
