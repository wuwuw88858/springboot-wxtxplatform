package common.exceptions;

/**
 * @program: Wxplatform
 * @description: 禁止操作
 * @author: zhijie
 * @create: 2019-03-28 17:43
 **/
public class ForbidException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ForbidException(){}
    public ForbidException(String message) {
        super(message);
    }
    public ForbidException(Throwable throwable) {
        super(throwable);
    }
    public ForbidException(String message, Throwable throwable) {
        super(message, throwable);
    }
    public ForbidException(String message, Throwable throwable, boolean enableSuppression,
                            boolean writeableStackTrace) {
        super(message, throwable, enableSuppression, writeableStackTrace);
    }
}
