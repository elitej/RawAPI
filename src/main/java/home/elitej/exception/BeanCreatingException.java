package home.elitej.exception;


public class BeanCreatingException extends RuntimeException {

    public BeanCreatingException(String message) {
        super(message);
    }

    public BeanCreatingException(String message, Throwable cause) {
        super(message, cause);
    }
}
