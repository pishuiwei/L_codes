package exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class LoggingException extends Exception{
	private static final long serialVersionUID = 1L;
	
	private static Logger looger = Logger.getLogger("LoggingException");

	public LoggingException() {
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		looger.severe(trace.toString());
	}
	
}
