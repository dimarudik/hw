package com.example.hw2.exception;

//TODO добавьте описание класса что делает
public class EmptyFilenameException extends Exception{

    private final String message;

    public EmptyFilenameException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
