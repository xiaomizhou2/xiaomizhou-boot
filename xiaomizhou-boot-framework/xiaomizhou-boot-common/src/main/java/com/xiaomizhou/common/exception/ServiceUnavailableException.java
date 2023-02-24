package com.xiaomizhou.common.exception;
/**
 * @author xiaomizhou
 * @date 2023/2/20 21:42
 * @email 521jx123@gmail.com
 */
public class ServiceUnavailableException extends RuntimeException {
    public ServiceUnavailableException(final String message) {
        super(message);
    }

    public ServiceUnavailableException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
