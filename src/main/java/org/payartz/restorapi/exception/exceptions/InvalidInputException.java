package org.payartz.restorapi.exception.exceptions;

import org.payartz.restorapi.exception.ErrorCode;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }

    public ErrorCode getErrorCode() {
        return ErrorCode.INVALID_INPUT;
    }
}
