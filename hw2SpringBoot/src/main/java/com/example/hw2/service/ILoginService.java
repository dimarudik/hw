package com.example.hw2.service;

import com.example.hw2.exception.AccountExistsException;

//TODO комментарии к методам внутри интерфейса,
// уберите неиспользуемый иморт
public interface ILoginService<T> {

    boolean registerNewUserAccount(T t);
}
