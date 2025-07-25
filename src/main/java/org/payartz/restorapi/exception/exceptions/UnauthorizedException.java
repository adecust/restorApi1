package org.payartz.restorapi.exception.exceptions;

import org.payartz.restorapi.exception.ErrorCode;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }

    public ErrorCode getErrorCode() {
        return ErrorCode.UNAUTHORIZED;
    }
}
