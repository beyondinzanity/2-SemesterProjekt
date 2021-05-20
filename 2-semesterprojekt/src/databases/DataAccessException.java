package databases;

public class DataAccessException extends Exception {
/**
 * 
 * @author knol
 * @version 2018-08-30
 */

	private static final long serialVersionUID = 1L;

	public DataAccessException(String message, Throwable e) {
		super(message, e);
	}
}



