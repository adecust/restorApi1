package org.payartz.restorapi.exception.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.payartz.restorapi.exception.ErrorCode;
import org.payartz.restorapi.exception.ErrorResponse;
import org.payartz.restorapi.exception.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex, HttpServletRequest req) {
        ErrorCode ec = ex.getErrorCode();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                ErrorResponse.builder()
                        .status(HttpStatus.NOT_FOUND.value())
                        .errorCode(ec.getCode())
                        .message(ec.getMessage())
                        .detail(ex.getMessage())
                        .path(req.getRequestURI())
                        .timestamp(now())
                        .errorType("Resource Not Found")
                        .build()
        );
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ErrorResponse> handleDuplicate(DuplicateResourceException ex, HttpServletRequest req) {
        ErrorCode ec = ex.getErrorCode();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                ErrorResponse.builder()
                        .status(HttpStatus.CONFLICT.value())
                        .errorCode(ec.getCode())
                        .message(ec.getMessage())
                        .detail(ex.getMessage())
                        .path(req.getRequestURI())
                        .timestamp(now())
                        .errorType("Duplicate Resource")
                        .build()
        );
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ErrorResponse> handleInvalidInput(InvalidInputException ex, HttpServletRequest req) {
        ErrorCode ec = ex.getErrorCode();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ErrorResponse.builder()
                        .status(HttpStatus.BAD_REQUEST.value())
                        .errorCode(ec.getCode())
                        .message(ec.getMessage())
                        .detail(ex.getMessage())
                        .path(req.getRequestURI())
                        .timestamp(now())
                        .errorType("Invalid Input")
                        .build()
        );
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorResponse> handleUnauthorized(UnauthorizedException ex, HttpServletRequest req) {
        ErrorCode ec = ex.getErrorCode();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                ErrorResponse.builder()
                        .status(HttpStatus.UNAUTHORIZED.value())
                        .errorCode(ec.getCode())
                        .message(ec.getMessage())
                        .detail(ex.getMessage())
                        .path(req.getRequestURI())
                        .timestamp(now())
                        .errorType("Unauthorized")
                        .build()
        );
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidation(ValidationException ex, HttpServletRequest req) {
        ErrorCode ec = ex.getErrorCode();
        String errors = String.join("; ", ex.getErrors().values());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ErrorResponse.builder()
                        .status(HttpStatus.BAD_REQUEST.value())
                        .errorCode(ec.getCode())
                        .message(ec.getMessage())
                        .detail(errors)
                        .path(req.getRequestURI())
                        .timestamp(now())
                        .errorType("Validation Error")
                        .build()
        );
    }

    // Son çare: generic error
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(Exception ex, HttpServletRequest req) {
        ErrorCode ec = ErrorCode.GENERIC_ERROR;
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ErrorResponse.builder()
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .errorCode(ec.getCode())
                        .message(ec.getMessage())
                        .detail(ex.getMessage())
                        .path(req.getRequestURI())
                        .timestamp(now())
                        .errorType("Generic Error")
                        .build()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest req) {
        StringBuilder errorMessages = new StringBuilder();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errorMessages.append(fieldError.getField())
                    .append(": ")
                    .append(fieldError.getDefaultMessage())
                    .append("; ");
        }
        String errors = errorMessages.toString();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ErrorResponse.builder()
                        .status(HttpStatus.BAD_REQUEST.value())
                        .errorCode(ErrorCode.VALIDATION_ERROR.getCode())
                        .message(ErrorCode.VALIDATION_ERROR.getMessage())
                        .detail(errors)
                        .path(req.getRequestURI())
                        .timestamp(now())
                        .errorType("Validation Error")
                        .build()
        );
    }
}
