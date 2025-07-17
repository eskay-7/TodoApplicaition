package org.amalitechtraining.todoapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleException (ResourceNotFoundException e) {
        var error = new ExceptionResponse(
                HttpStatus.NOT_FOUND,
                e.getMessage(),
                Timestamp.valueOf(LocalDateTime.now())
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponse> handleException (IllegalArgumentException e) {
        var error = new ExceptionResponse(
                HttpStatus.BAD_REQUEST,
                e.getMessage(),
                Timestamp.valueOf(LocalDateTime.now())
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
