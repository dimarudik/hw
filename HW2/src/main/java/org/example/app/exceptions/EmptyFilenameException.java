package org.example.app.exceptions;

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
