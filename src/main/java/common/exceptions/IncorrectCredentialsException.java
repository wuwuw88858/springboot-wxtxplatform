package common.exceptions;

public class IncorrectCredentialsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public IncorrectCredentialsException(){}
    public IncorrectCredentialsException(String message) {
        super(message);
    }
    public IncorrectCredentialsException(Throwable throwable) {
        super(throwable);
    }
    public IncorrectCredentialsException(String message, Throwable throwable) {
        super(message, throwable);
    }
    public IncorrectCredentialsException(String message, Throwable throwable, boolean enableSuppression,
                                         boolean writeableStackTrace) {
        super(message, throwable, enableSuppression, writeableStackTrace);
    }
}
