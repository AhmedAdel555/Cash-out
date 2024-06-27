package com.ahlymomkn.cashout.exception;

import org.springframework.http.HttpStatus;

public class ConflictException extends RuntimeException {
    private final HttpStatus status;

    public ConflictException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
