package com.xiaomizhou.common.exception;

/**
 * @author xiaomizhou
 * @date 2023/2/22
 * @email 521jx123@gmail.com
 */
public class BadRequestException extends BusinessException {

    public BadRequestException(final String message) {
        super(message);
    }

    public BadRequestException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
