package com.example.hw2.fileobject.exception;

//TODO добавьте описание класса что делает
// Исключение на пустое имя загружаемого файла
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
