package com.xiaomizhou.common.exception;

/**
 * @author xiaomizhou
 * @date 2023/2/20
 * @email 521jx123@gmail.com
 */
public class BusinessCodeException extends BusinessException {

    private String errorCode;

    public BusinessCodeException(String errorCode) {
        super(errorCode);
        this.errorCode = errorCode;
    }

    public BusinessCodeException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessCodeException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
