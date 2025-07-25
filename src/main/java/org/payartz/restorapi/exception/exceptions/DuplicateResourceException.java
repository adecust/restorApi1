package org.payartz.restorapi.exception.exceptions;

import org.payartz.restorapi.exception.ErrorCode;

public class DuplicateResourceException extends RuntimeException {
    public DuplicateResourceException(String message) {
        super(message);
    }

    public ErrorCode getErrorCode() {
        return ErrorCode.DUPLICATE_RESOURCE;
    }
}
