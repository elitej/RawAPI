package home.elitej.exception;


public class XmlConfigurationParseException extends RuntimeException {
    public XmlConfigurationParseException(String message) {
        super(message);
    }

    public XmlConfigurationParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
