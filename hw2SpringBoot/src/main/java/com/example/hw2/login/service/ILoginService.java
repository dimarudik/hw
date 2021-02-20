package com.example.hw2.login.service;

//TODO комментарии к методам внутри интерфейса,
// уберите неиспользуемый иморт
public interface ILoginService<T> {

    boolean registerNewUserAccount(T t);
}
