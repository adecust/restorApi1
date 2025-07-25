package org.payartz.restorapi.exception.exceptions;

import org.payartz.restorapi.exception.ErrorCode;
import java.util.Map;

public class ValidationException extends RuntimeException {
    private final Map<String, String> errors;

    public ValidationException(String message, Map<String, String> errors) {
        super(message);
        this.errors = errors;
    }

    public ErrorCode getErrorCode() {
        return ErrorCode.VALIDATION_ERROR;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
