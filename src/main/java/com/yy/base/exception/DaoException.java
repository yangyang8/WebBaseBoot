package com.yy.base.exception;

/**
 * 表示数据访问过程遇到的异常
 *
 * @author DENG YURONG
 */
public class DaoException extends RuntimeException {

    private static final long serialVersionUID = 3056433382558602272L;

    public DaoException() {
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }

    public DaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
