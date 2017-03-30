package home.elitej.exception;


public class InjectHandlerException extends RuntimeException{

    public InjectHandlerException(String message) {
        super(message);
    }

    public InjectHandlerException(String message, Throwable cause) {
        super(message, cause);
    }
}
