package exception;

public class NotFoundSouceException extends Exception {

    /**
     * 
     * class định nghĩa một exception
     */
    private static final long serialVersionUID = 1L;

    private String message;

    public NotFoundSouceException(String message) {
	super();
	this.message = message;
    }

    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

}
