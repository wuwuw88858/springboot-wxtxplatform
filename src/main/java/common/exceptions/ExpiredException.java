package common.exceptions;

public class ExpiredException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExpiredException(){}
    public ExpiredException(String message) {
        super(message);
    }
    public ExpiredException(Throwable throwable) {
        super(throwable);
    }
    public ExpiredException(String message, Throwable throwable) {
        super(message, throwable);
    }
    public ExpiredException(String message, Throwable throwable, boolean enableSuppression,
                            boolean writeableStackTrace) {
        super(message, throwable, enableSuppression, writeableStackTrace);
    }
}
