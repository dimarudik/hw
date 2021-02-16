package com.example.hw2.exception;

public class AccountExistsException extends Exception {

    private final String message;

    public AccountExistsException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
