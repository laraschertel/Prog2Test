package exceptions;

/**
 * Used if methods are called in wrong status
 */

public class StatusException extends Exception {
    public StatusException() {super (); }
    public StatusException(String message) {super (message); }


}
