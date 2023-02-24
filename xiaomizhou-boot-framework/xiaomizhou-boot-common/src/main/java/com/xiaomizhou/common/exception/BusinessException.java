package com.xiaomizhou.common.exception;

/**
 * @author xiaomizhou
 * @date 2023/2/20
 * @email 521jx123@gmail.com
 */
public class BusinessException extends RuntimeException {
    public BusinessException(final String message) {
        super(message);
    }

    public BusinessException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
