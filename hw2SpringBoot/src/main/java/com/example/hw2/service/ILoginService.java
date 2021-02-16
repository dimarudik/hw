package com.example.hw2.service;

import com.example.hw2.exception.AccountExistsException;

public interface ILoginService<T> {

    void registerNewUserAccount(T t) throws AccountExistsException;
}
