package org.amalitechtraining.todoapplication.exception;

import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

public record ExceptionResponse(
        HttpStatus status,
        String message,
        Timestamp timestamp
) {
}
