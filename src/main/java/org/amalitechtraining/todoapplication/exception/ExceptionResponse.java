package org.amalitechtraining.todoapplication.exception;

import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

public record ExceptionResponse(
        int status,
        HttpStatus error,
        String message,
        Timestamp timestamp
) {
}
