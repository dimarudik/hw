package com.example.hw2.exception;

//TODO добавьте описание класса что делает
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
