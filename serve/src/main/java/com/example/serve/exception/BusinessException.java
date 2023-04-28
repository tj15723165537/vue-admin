package com.example.serve.exception;

import org.springframework.http.HttpStatus;

/**
 * @author chenliang
 * @since 2022-10-31
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String message;
    private int code = HttpStatus.INTERNAL_SERVER_ERROR.value();

    public BusinessException(String message, Object... args) {
        super(String.format(message, args));
        this.message = String.format(message, args);
    }

    public BusinessException(Throwable e, String message, Object... args) {
        super(String.format(message, args), e);
        this.message = String.format(message, args);
    }

    public BusinessException(int code, String message, Object... args) {
        super(String.format(message, args));
        this.message = String.format(message, args);
        this.code = code;
    }

    public BusinessException(int code, Throwable e, String message, Object... args) {
        super(String.format(message, args), e);
        this.message = String.format(message, args);
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
