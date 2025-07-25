package org.payartz.restorapi.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {
    private final int status;
    private final int errorCode;
    private final String message;
    private final String detail;
    private final String path;
    private final String errorType;
    private final String timestamp; // ISO-8601
}
