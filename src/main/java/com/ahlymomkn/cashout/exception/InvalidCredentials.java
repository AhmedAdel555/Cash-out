package com.ahlymomkn.cashout.exception;

public class InvalidCredentials extends RuntimeException{
    public InvalidCredentials(String message) {
        super(message);
    }
}
