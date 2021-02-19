package com.example.hw2.service;

import com.example.hw2.exception.AccountExistsException;

public interface ILoginService<T> {

    boolean registerNewUserAccount(T t);
}
