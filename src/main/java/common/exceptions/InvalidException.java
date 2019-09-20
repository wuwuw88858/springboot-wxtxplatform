package common.exceptions;

public class InvalidException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InvalidException(){}
    public InvalidException(String message) {
        super(message);
    }
    public InvalidException(Throwable throwable) {
        super(throwable);
    }
    public InvalidException(String message, Throwable throwable) {
        super(message, throwable);
    }
    public InvalidException(String message, Throwable throwable, boolean enableSuppression,
                            boolean writeableStackTrace) {
        super(message, throwable, enableSuppression, writeableStackTrace);
    }
}
